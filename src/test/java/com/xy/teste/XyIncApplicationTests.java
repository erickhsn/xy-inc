package com.xy.teste;

import com.xy.teste.dao.IPlaceDAO;
import com.xy.teste.service.PointOfInterest;
import com.xy.teste.dto.*;
import com.xy.teste.entities.Place;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class XyIncApplicationTests {

	@InjectMocks
	private PointOfInterest interestPoint;

	@Mock
	private IPlaceDAO placeDAO;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void pointsOfInterest() {
		PositionDto position = new PositionDto(20, 10, 10);
		ArrayList<PointOfInterestResultDto> expected = new ArrayList<PointOfInterestResultDto>();
		expected.add(new PointOfInterestResultDto("Lanchonete"));
		expected.add(new PointOfInterestResultDto("Joalheria"));
		expected.add(new PointOfInterestResultDto("Pub"));
		expected.add(new PointOfInterestResultDto("Supermercado"));

		List<Place> places = mockPlaces();

		when(placeDAO.getPlaces()).thenReturn(places);

		List<PointOfInterestResultDto> result = interestPoint.getPointsOfInterest(position);
		assertEquals(4, result.size());

	}
	
	@Test
	public void pointOfInterestEmpty()
	{
		PositionDto position = new PositionDto(0, 0, 1);
		List<Place> places = mockPlaces();
		when(placeDAO.getPlaces()).thenReturn(places);
		
		List<PointOfInterestResultDto> result = interestPoint.getPointsOfInterest(position);
		assertEquals(0, result.size());
	}
	
	@Test
	public void shouldReturnErro()
	{
		PositionDto position = new PositionDto(0, -1, 1);
		List<Place> places = mockPlaces();
		when(placeDAO.getPlaces()).thenReturn(places);
		
		List<PointOfInterestResultDto> result = interestPoint.getPointsOfInterest(position);
		assertEquals(0, result.size());
	}

	private List<Place> mockPlaces() {
		return Arrays.asList(new Place(1, "Lanchonete", 27, 12), new Place(2, "Posto", 31, 18),
				new Place(3, "Joalheria", 15, 12), new Place(4, "Floricultura", 19, 21), new Place(5, "Pub", 12, 8),
				new Place(6, "Supermercado", 23, 6), new Place(7, "Churrascaria", 28, 2));
	}

}
