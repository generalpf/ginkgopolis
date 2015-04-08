package com.kwyjibo.ginkgopolis.model;

import java.util.HashMap;
import java.util.Map;

public class SparseArrayBoardImpl implements Board {
	private class Coordinate {
		public int x;
		public int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	protected final int WIDTH = 255;
	protected final int HEIGHT = 255;
	
	/*
	 * if we always keep track of the bounds of our tiles as we expand,
	 * getSmallestTileBox() will be a snap!
	 * includes letter "tiles".
	 */
	protected Coordinate topLeft;
	protected Coordinate bottomRight;
	
	/**
	 * a sparse array that will contain even the widest/tallest possible configuration
	 * of the board
	 */
	protected Tile[][] tiles;
	/**
	 * shortcut pointers to the coordinates of the letters
	 */
	protected HashMap<Character, Coordinate> letterCoordinates;
	
	public SparseArrayBoardImpl() {
		this.tiles = new Tile[HEIGHT][WIDTH];
		this.letterCoordinates = new HashMap<Character, Coordinate>(12);
	}
	
	@Override
	public Benefit urbanize(BuildingTile tile, char letter) {
		// TODO Auto-generated method stub
		return new Benefit(0, 0, 0);
	}

	@Override
	public Map<Player, Integer> scoreDistricts(Player[] players) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile[][] getSmallestTileBox() {
		// extract the rectangular region of this.tiles bounded by this.topLeft and this.bottomRight
		Tile[][] tiles = new Tile[this.bottomRight.y - this.topLeft.y + 1][this.bottomRight.x - this.topLeft.x + 1];
		for (int i = this.topLeft.y; i <= this.bottomRight.y; i++) {
			for (int j = this.topLeft.x; j <= this.bottomRight.x; j++) {
				tiles[i - this.topLeft.y][j - this.topLeft.x] = this.tiles[i][j];
			}
		}
		return tiles;
	}
	
	@Override
	public void seedBoard() {
		// remember that (0,0) is the top left corner
		Coordinate centre = new Coordinate(WIDTH / 2, HEIGHT / 2);
		
		// top row
		this.tiles[centre.y - 1][centre.x - 1]		= new BuildingTile(1, TileType.BLUE);
		this.tiles[centre.y - 1][centre.x]			= new BuildingTile(1, TileType.YELLOW);
		this.tiles[centre.y - 1][centre.x + 1]		= new BuildingTile(1, TileType.RED);
		
		// middle row
		this.tiles[centre.y][centre.x - 1]			= new BuildingTile(2, TileType.YELLOW);
		this.tiles[centre.y][centre.x]				= new BuildingTile(2, TileType.BLUE);
		this.tiles[centre.y][centre.x + 1]			= new BuildingTile(3, TileType.BLUE);
		
		// bottom row
		this.tiles[centre.y + 1][centre.x - 1]		= new BuildingTile(3, TileType.RED);
		this.tiles[centre.y + 1][centre.x]			= new BuildingTile(3, TileType.YELLOW);
		this.tiles[centre.y + 1][centre.x + 1]		= new BuildingTile(2, TileType.RED);
		
		// build the urbanization tile coordinates
		this.letterCoordinates.put('a', new Coordinate(centre.y - 2, centre.x - 1));
		this.letterCoordinates.put('b', new Coordinate(centre.y - 2, centre.x));
		this.letterCoordinates.put('c', new Coordinate(centre.y - 2, centre.x + 1));
		this.letterCoordinates.put('d', new Coordinate(centre.y - 1, centre.x + 2));
		this.letterCoordinates.put('e', new Coordinate(centre.y, centre.x + 2));
		this.letterCoordinates.put('f', new Coordinate(centre.y + 1, centre.x + 2));
		this.letterCoordinates.put('g', new Coordinate(centre.y + 2, centre.x + 1));
		this.letterCoordinates.put('h', new Coordinate(centre.y + 2, centre.x));
		this.letterCoordinates.put('i', new Coordinate(centre.y + 2, centre.x - 1));
		this.letterCoordinates.put('j', new Coordinate(centre.y + 1, centre.x - 2));
		this.letterCoordinates.put('k', new Coordinate(centre.y, centre.x - 2));
		this.letterCoordinates.put('l', new Coordinate(centre.y - 1, centre.x - 2));
		
		// put them on the board
		for (Character c : this.letterCoordinates.keySet()) {
			Coordinate co = this.letterCoordinates.get(c);
			this.tiles[co.y][co.x] = new UrbanizationTile(c);
		}
		
		this.topLeft = new Coordinate(centre.y - 2, centre.x - 2);
		this.bottomRight = new Coordinate(centre.y + 2, centre.x + 2);
	}
}
