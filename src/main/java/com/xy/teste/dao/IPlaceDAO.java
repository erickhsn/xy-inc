package com.xy.teste.dao;

import java.util.Collection;

import com.xy.teste.entities.Place;

public interface IPlaceDAO {
	public Collection<Place> getPlaces();
	
	public void insertPlace(Place place);
}
