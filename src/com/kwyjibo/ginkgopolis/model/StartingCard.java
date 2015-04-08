package com.kwyjibo.ginkgopolis.model;

public class StartingCard extends Card {
	protected Benefit startingBenefit;
	
	public StartingCard(int rank, TileType type, Benefit startingBenefit, PlayerActionHandler playerActionHandler) {
		super(rank, type, playerActionHandler);
		
		this.startingBenefit = startingBenefit;
	}
	
	public Benefit getStartingBenefit() {
		return startingBenefit;
	}
}
