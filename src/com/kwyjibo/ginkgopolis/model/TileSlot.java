package com.kwyjibo.ginkgopolis.model;

public abstract class TileSlot {
	protected Tile tile;
	
	public TileSlot(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return tile;
	}
}
