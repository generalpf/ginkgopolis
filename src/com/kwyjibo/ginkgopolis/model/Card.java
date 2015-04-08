package com.kwyjibo.ginkgopolis.model;

public class Card {
	protected int rank;
	protected TileType type;
	protected Benefit startingBenefit;
	protected CardActions cardActions;
	
	public Card(int rank, TileType type, Benefit startingBenefit, CardActions cardActions) {
		super();
		this.rank = rank;
		this.type = type;
		this.startingBenefit = startingBenefit;
		this.cardActions = cardActions;
	}

	public int getRank() {
		return rank;
	}

	public TileType getType() {
		return type;
	}
	
	public Benefit getStartingBenefit() {
		return startingBenefit;
	}
	
	public CardActions getCardActions() {
		return cardActions;
	}
}
