package com.kwyjibo.ginkgopolis.model;

public class Card {
	protected int rank;
	protected TileType type;
	protected PlayerActionHandler playerActionHandler;
	
	public Card(int rank, TileType type, PlayerActionHandler playerActionHandler) {
		super();
		this.rank = rank;
		this.type = type;
		this.playerActionHandler = playerActionHandler;
	}

	public int getRank() {
		return rank;
	}

	public TileType getType() {
		return type;
	}
	
	public PlayerActionHandler getPlayerActionHandler() {
		return playerActionHandler;
	}
}
