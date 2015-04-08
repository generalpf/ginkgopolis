package com.kwyjibo.ginkgopolis.model;

public class RegularCard extends Card {
	protected ScoringHandler scoringHandler;
	
	public RegularCard(int rank, TileType type, PlayerActionHandler playerActionHandler, ScoringHandler scoringHandler) {
		super(rank, type, playerActionHandler);
		
		this.scoringHandler = scoringHandler;
	}
	
	public ScoringHandler getScoringHandler() {
		return scoringHandler;
	}
}
