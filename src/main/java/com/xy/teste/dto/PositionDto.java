package com.xy.teste.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionDto {
	
	@NotNull(message = "Insira um valor para x")
	@Min(0)
	private int x;
	
	@NotNull(message = "Insira um valor para y")
	@Min(0)
	private int y;
	
	@NotNull
	@JsonProperty("max_distance")
	@Min(0)
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
