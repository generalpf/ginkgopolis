package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.SparseArrayBoardImpl;
import com.kwyjibo.ginkgopolis.model.Tile;
import com.kwyjibo.ginkgopolis.model.UrbanizationTile;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSparseArrayBoardImpl() {
		Board board = new SparseArrayBoardImpl();
		board.seedBoard();
	}
	
	@Test
	public void testGetSmallestTileBox() {
		Board board = new SparseArrayBoardImpl();
		board.seedBoard();
		
		Tile[][] tiles = board.getSmallestTileBox();
		assertEquals(5, tiles.length);
		assertEquals(5, tiles[0].length);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Tile tile = tiles[i][j];
				if (tile == null) {
					System.out.print("    ");
				}
				else if (tile instanceof UrbanizationTile) {
					System.out.print("[" + ((UrbanizationTile) tile).getLetter() + "] ");
				}
				else if (tile instanceof BuildingTile) {
					BuildingTile buildingTile = (BuildingTile) tile;
					System.out.print(buildingTile.getType().toString().charAt(0) + new Integer(buildingTile.getRank()).toString() + "  ");
				}
				if (j == 4) {
					System.out.println();
				}
			}
		}
	}

}
