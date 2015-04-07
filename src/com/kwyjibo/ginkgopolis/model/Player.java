package com.kwyjibo.ginkgopolis.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected int points;
	protected int newHandTokens;
	protected List<BuildingTile> tileList;
	protected int resourcesReady;
	protected int resourcesLeft;
	
	public Player(String name, int points, int newHandTokens) {
		super();
		this.name = name;
		this.points = points;
		this.newHandTokens = newHandTokens;
		this.tileList = new ArrayList<BuildingTile>();
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	/**
	 * @param pointChange - how many points to add (negative to subtract)
	 */
	public void addPoints(int pointChange) {
		this.points += pointChange;
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
}
