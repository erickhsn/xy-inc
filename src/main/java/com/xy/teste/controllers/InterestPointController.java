package com.xy.teste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xy.teste.dto.PlaceDto;
import com.xy.teste.dto.PointOfInterestResultDto;
import com.xy.teste.dto.PositionDto;
import com.xy.teste.service.IPointOfInterest;

@RestController
public class InterestPointController {
	
	private IPointOfInterest pointOfInterest;
	
	public InterestPointController(IPointOfInterest pointOfInterest)
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
	public String insertPlace(@RequestBody @Valid PlaceDto placeDto)
	{
		pointOfInterest.insertPlace(placeDto);
		return "true";
		
	}
	
	@PostMapping("/pointsofinterest")
	public ResponseEntity<List<PointOfInterestResultDto>> getPointsOfInterest(@RequestBody @Valid PositionDto positionDto)
	{
		List<PointOfInterestResultDto> places = pointOfInterest.getPointsOfInterest(positionDto);
		if(places != null)
			return new ResponseEntity<List<PointOfInterestResultDto>>(places, HttpStatus.OK) ;

		return new ResponseEntity<List<PointOfInterestResultDto>>(HttpStatus.BAD_REQUEST);
	}
}
