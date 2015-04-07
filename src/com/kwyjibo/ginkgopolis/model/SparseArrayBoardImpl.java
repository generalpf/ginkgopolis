package com.kwyjibo.ginkgopolis.model;

import java.util.HashMap;
import java.util.Map;

import com.kwyjibo.ginkgopolis.model.Tile.TileType;

public class SparseArrayBoardImpl implements Board {
	private class Coordinate {
		public short x;
		public short y;
		
		public Coordinate(short x, short y) {
			this.x = x;
			this.y = y;
		}
	}
	
	protected final short WIDTH = 255;
	protected final short HEIGHT = 255;
	
	/**
	 * a sparse array that will contain even the widest/tallest possible configuration
	 * of the board
	 */
	protected Tile[][] tiles;
	/**
	 * shortcut pointers to the coordinates of the letters
	 */
	protected HashMap letterCoordinates;
	
	public SparseArrayBoardImpl() {
		this.tiles = new Tile[HEIGHT][WIDTH];
		this.letterCoordinates = new HashMap<Character, Coordinate>(12);
		
		this.seedBoard();
	}
	
	@Override
	public void expandOnLetter(Tile tile, char letter) {
		// TODO Auto-generated method stub
	}

	@Override
	public Map<Player, Integer> scoreDistricts(Player[] players) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile[][] getSmallestTileBox() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void seedBoard() {
		// remember that (0,0) is the top left corner
		Coordinate centre = new Coordinate((short) (WIDTH / 2), (short) (HEIGHT / 2));
		
		// top row
		this.tiles[centre.y - 1][centre.x - 1]		= new Tile(1, TileType.BLUE);
		this.tiles[centre.y - 1][centre.x]			= new Tile(1, TileType.YELLOW);
		this.tiles[centre.y - 1][centre.x + 1]		= new Tile(1, TileType.RED);
		
		// middle row
		this.tiles[centre.y][centre.x - 1]			= new Tile(2, TileType.YELLOW);
		this.tiles[centre.y][centre.x]				= new Tile(2, TileType.BLUE);
		this.tiles[centre.y][centre.x + 1]			= new Tile(3, TileType.BLUE);
		
		// bottom row
		this.tiles[centre.y + 1][centre.x - 1]		= new Tile(3, TileType.RED);
		this.tiles[centre.y + 1][centre.x]			= new Tile(3, TileType.YELLOW);
		this.tiles[centre.y + 1][centre.x + 1]		= new Tile(2, TileType.RED);
	}
}
