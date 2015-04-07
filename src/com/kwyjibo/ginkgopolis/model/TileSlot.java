package com.kwyjibo.ginkgopolis.model;

public class TileSlot {
	protected Tile tile;
	protected Player player;
	protected int height;
	protected boolean marked;
	
	public TileSlot(Tile tile) {
		super();
		this.tile = tile;
		this.player = null;
		this.height = 1;
		this.marked = false;
	}
	
	public void replaceTile(Tile tile, Player player) {
		this.tile = tile;
		this.player = player;
		++this.height;
		this.marked = true;
	}
	
}
