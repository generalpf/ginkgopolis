package com.kwyjibo.ginkgopolis.model;

public class BuildingTileSlot extends TileSlot {
	protected Player owner;
	protected int height;
	protected boolean marked;
	
	public BuildingTileSlot(BuildingTile tile) {
		super(tile);
		
		this.owner = null;
		this.height = 1;
		this.marked = false;
	}
	
	public void replaceTile(BuildingTile tile, Player newOwner) {
		this.tile = tile;
		this.owner = newOwner;
		++this.height;
		this.marked = true;
	}
	
	public boolean isMarked() {
		return marked;
	}
	
	public void unmark() {
		this.marked = false;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BuildingTile getBuildingTile() {
		return (BuildingTile) this.tile;
	}
}
