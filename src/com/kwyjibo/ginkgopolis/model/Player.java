package com.kwyjibo.ginkgopolis.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
	protected String name;
	protected int points;
	protected int newHandTokens;
	protected List<BuildingTile> tileList;
	protected int resourcesReady;
	protected int resourcesLeft;
	protected List<Card> cards;
	
	public Player(String name, int points, int resourcesReady, int resourcesLeft) {
		super();
		this.name = name;
		this.points = points;
		this.newHandTokens = 2;
		this.tileList = new ArrayList<BuildingTile>();
		this.resourcesReady = resourcesReady;
		this.resourcesLeft = resourcesLeft;
		this.cards = new ArrayList<Card>();
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	/**
	 * @param benefit - the number of resources, points and tiles to gain
	 * @param tiles - if benefit.tiles > 0, the actual BuildingTile objects to acquire
	 */
	public void applyBenefit(Benefit benefit, BuildingTile[] tiles) {
		if (benefit.resources > 0) {
			int takeThisMany = Math.min(benefit.resources, this.resourcesLeft);
			this.resourcesReady += takeThisMany;
			this.resourcesLeft -= takeThisMany;
		}
		this.points += benefit.points;
		if (benefit.tiles > 0) {
			this.tileList.addAll(Arrays.asList(tiles));
		}
	}

	public int getNewHandTokens() {
		return newHandTokens;
	}
	
	public boolean spendNewHandToken() {
		if (this.newHandTokens < 1) {
			return false;
		}
		else {
			--this.newHandTokens;
			return true;
		}
	}

	public List<BuildingTile> getTileList() {
		return tileList;
	}
	
	public void addTile(BuildingTile tile) {
		this.tileList.add(tile);
	}
	
	public void scoreCards(Board board) {
		for (Card card : this.cards) {
			card.getCardActions().onScoring(this, board);
		}
	}

	public int getResourcesReady() {
		return resourcesReady;
	}

	public int getResourcesLeft() {
		return resourcesLeft;
	}
}
