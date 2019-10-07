package com.xy.teste.service;


import java.util.List;

import com.xy.teste.dto.*;

public interface IPointOfInterest {
	List<PlaceDto> getPlaces();
	
	void insertPlace(PlaceDto placeDto);
	
	List<PointOfInterestResultDto> getPointsOfInterest(PositionDto positionDto);
}
