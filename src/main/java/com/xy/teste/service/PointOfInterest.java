package com.xy.teste.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xy.teste.dao.IPlaceDAO;
import com.xy.teste.dto.PlaceDto;
import com.xy.teste.dto.PointOfInterestResultDto;
import com.xy.teste.dto.PositionDto;
import com.xy.teste.entities.Place;
import com.xy.teste.utils.ObjectMapperUtils;

@Component
public class PointOfInterest implements IPointOfInterest {

	private IPlaceDAO placeDAO; 
	
	public PointOfInterest(IPlaceDAO placeDAO) {
		this.placeDAO = placeDAO;
	}
	
	@Override
	public List<PlaceDto> getPlaces() {
		// TODO Auto-generated method stub
		Collection<Place> places = placeDAO.getPlaces();
		List<PlaceDto> listOfPostDTO = ObjectMapperUtils.mapAll(places, PlaceDto.class);
		return listOfPostDTO;
	}

	@Override
	public void insertPlace(PlaceDto placeDto) {
		
		placeDAO.insertPlace(ObjectMapperUtils.map(placeDto, Place.class));		
	}

	@Override
	public List<PointOfInterestResultDto> getPointsOfInterest(PositionDto positionDto) {
		Collection<Place> places = placeDAO.getPlaces();
		
		ArrayList<PointOfInterestResultDto> pointsOfInterest = new ArrayList<PointOfInterestResultDto>();
		for (Place place : places) {
			double distance = Math.sqrt(Math.pow(positionDto.getX() - place.getX(), 2) + 
					Math.pow(positionDto.getY() - place.getY(), 2));
			if(distance < positionDto.getMaxDistance())
			{
				pointsOfInterest.add(ObjectMapperUtils.map(place, PointOfInterestResultDto.class));
			}
		}
		return pointsOfInterest;
	}

}
