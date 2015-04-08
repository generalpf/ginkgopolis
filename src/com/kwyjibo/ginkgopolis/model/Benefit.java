package com.kwyjibo.ginkgopolis.model;

public class Benefit {
	protected int resources;
	protected int points;
	protected int tiles;
	
	public Benefit(int resources, int points, int tiles) {
		super();
		this.resources = resources;
		this.points = points;
		this.tiles = tiles;
	}

	public int getResources() {
		return resources;
	}

	public int getPoints() {
		return points;
	}
	
	public int getTiles() {
		return tiles;
	}
}
