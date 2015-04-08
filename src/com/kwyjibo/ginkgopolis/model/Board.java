package com.kwyjibo.ginkgopolis.model;

import java.util.Map;

public interface Board {
	/**
	 * @param tile - the tile to put on top of the letter
	 * @param letter - which letter to place on
	 * @return - the benefit gained by the player
	 * 
	 * TODO: this will need a callback to ask the player/AI where to move the letter to
	 */
	public Benefit urbanize(BuildingTile tile, char letter);
	
	/**
	 * @param players - the players in the game
	 * @return - a mapping of Player to points-scored-for-districts
	 */
	public Map<Player, Integer> scoreDistricts(Player[] players);
	
	/**
	 * @return - a 2D array of tiles that is the smallest box that can contain the board
	 * 				(i.e. no empty columns or rows)
	 */
	public Tile[][] getSmallestTileBox();
	
	/**
	 * prepares the board by creating and placing the nine starting tiles and the letters
	 */
	public void seedBoard();
}
