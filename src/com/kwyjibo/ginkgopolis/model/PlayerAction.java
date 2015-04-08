package com.kwyjibo.ginkgopolis.model;

public class PlayerAction {
	public enum ActionType { EXPLOIT, URBANIZE, CONSTRUCT };

	protected Card card;
	protected Tile tile;
	protected ActionType action;
	
	public PlayerAction(Card card, Tile tile, ActionType action) {
		super();
		this.card = card;
		this.tile = tile;
		this.action = action;
	}

	public Card getCard() {
		return card;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public ActionType getAction() {
		return action;
	}
}
