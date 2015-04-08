package com.kwyjibo.ginkgopolis.model;

public class BuildingTile extends Tile {
	protected int rank;
	protected TileType type;
	
	public BuildingTile(int rank, TileType type) {
		super();
		this.rank = rank;
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public TileType getType() {
		return type;
	}
}
