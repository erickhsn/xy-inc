package com.xy.teste;

import com.xy.teste.controllers.*;
import com.xy.teste.service.IPointOfInterest;
import com.xy.teste.dto.*;

import static org.mockito.Mockito.when;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class XyIncApplicationTests {

	@Mock
	private InterestPointController interestPointController;
	
	@InjectMocks
	private IPointOfInterest pointOfInterest;
	
	
	@Test
	public void teste()
	{
        List<PointOfInterestResultDto> users = Arrays.asList(
                new PointOfInterestResultDto("Lanchonete "),
                new PointOfInterestResultDto("Joalheria "));

        when(pointOfInterest.getPointsOfInterest(new PositionDto(20, 10, 10))).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].username", is("John Snow")));

        verify(userService, times(1)).getAll();
        verifyNoMoreInteractions(userService);
	}
	
	
}
