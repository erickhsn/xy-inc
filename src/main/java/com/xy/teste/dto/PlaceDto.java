package com.xy.teste.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PlaceDto {
	private int id;
	
	@NotBlank
	private String name;
	
	@NotNull
	@Min(0)
	private int x;
	
	@NotNull
	@Min(0)
	private int y;

		
	public PlaceDto(int id, String name, int x, int y) {
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public PlaceDto() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
