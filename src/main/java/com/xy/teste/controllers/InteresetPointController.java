package com.xy.teste.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy.teste.dto.PlaceDto;
import com.xy.teste.dto.PositionDto;
import com.xy.teste.service.IPointOfInterest;

@RestController
public class InteresetPointController {
	
	private IPointOfInterest pointOfInterest;
	
	public InteresetPointController(IPointOfInterest pointOfInterest)
	{
		this.pointOfInterest = pointOfInterest;
	}
	
	@RequestMapping(path = "/places")
	public ResponseEntity<List<PlaceDto>> getPlace()
	{
		List<PlaceDto> places = pointOfInterest.getPlaces();
		if(places != null)
			return new ResponseEntity<List<PlaceDto>>(places, HttpStatus.OK) ;

		return new ResponseEntity<List<PlaceDto>>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/point")
	public String insertPlace(@Valid @RequestBody PlaceDto placeDto)
	{
		pointOfInterest.insertPlace(placeDto);
		return "true";
		
	}
	
	@PostMapping("/pointsofinterest")
	public ResponseEntity<List<PlaceDto>> getPointsOfInterest(@RequestBody @Valid PositionDto positionDto)
	{
		List<PlaceDto> places = pointOfInterest.getPointsOfInterest(positionDto);
		if(places != null)
			return new ResponseEntity<List<PlaceDto>>(places, HttpStatus.OK) ;

		return new ResponseEntity<List<PlaceDto>>(HttpStatus.BAD_REQUEST);
	}
}
