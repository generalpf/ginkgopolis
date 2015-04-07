package com.kwyjibo.ginkgopolis.model;

public class Tile {
	public enum TileType { BLUE, RED, YELLOW };
	
	protected int rank;
	protected TileType type;
	
	public Tile(int rank, TileType type) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (rank != other.rank)
			return false;
		if (type != other.type)
			return false;
		return true;
	}	
}
