package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.BuildingTileSlot;
import com.kwyjibo.ginkgopolis.model.SparseArrayBoardImpl;
import com.kwyjibo.ginkgopolis.model.TileSlot;
import com.kwyjibo.ginkgopolis.model.UrbanizationTile;
import com.kwyjibo.ginkgopolis.model.UrbanizationTileSlot;

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
		
		TileSlot[][] tileSlots = board.getSmallestTileBox();
		assertEquals(5, tileSlots.length);
		assertEquals(5, tileSlots[0].length);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				TileSlot tileSlot = tileSlots[i][j];
				if (tileSlot == null) {
					System.out.print("    ");
				}
				else if (tileSlot instanceof UrbanizationTileSlot) {
					UrbanizationTile urbTile = (UrbanizationTile) tileSlot.getTile();
					System.out.print("[" + urbTile.getLetter() + "] ");
				}
				else if (tileSlot instanceof BuildingTileSlot) {
					BuildingTile buildingTile = (BuildingTile) tileSlot.getTile();
					System.out.print(buildingTile.getType().toString().charAt(0) + new Integer(buildingTile.getRank()).toString() + "  ");
				}
				if (j == 4) {
					System.out.println();
				}
			}
		}
	}

}
