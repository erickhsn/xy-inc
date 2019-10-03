package com.xy.teste.dto;

import com.xy.teste.entities.Place;

public class ApiDTOBuilder {
	
	public static PlaceDto placesToPlacesDTO(Place place)
	{
		return new PlaceDto(place.getId(),place.getName(), 
				place.getX(), place.getY());
	}
	
	public static Place placeDtoToPlace(PlaceDto placeDto)
	{
		return new Place(placeDto.getId(),placeDto.getName(), 
				placeDto.getX(), placeDto.getY());
	}
}
