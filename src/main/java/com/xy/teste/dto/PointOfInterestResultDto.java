package com.xy.teste.dto;

public class PointOfInterestResultDto {
	private String name;
	
	

	public PointOfInterestResultDto(String name) {
		this.name = name;
	}
	
	public PointOfInterestResultDto()
	{
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
