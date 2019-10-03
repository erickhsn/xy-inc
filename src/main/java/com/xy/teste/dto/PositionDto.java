package com.xy.teste.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionDto {
	
	@NotNull
	private int x;
	
	@NotNull
	private int y;
	
	@NotNull
	@JsonProperty("max_distance")
	private int maxDistance;

	
	public PositionDto(@NotNull int x, @NotNull int y, @NotNull int maxDistance) {
		this.x = x;
		this.y = y;
		this.maxDistance = maxDistance;
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

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	
	
}
