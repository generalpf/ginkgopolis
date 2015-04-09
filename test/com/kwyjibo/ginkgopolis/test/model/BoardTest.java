package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.BuildingTileSlot;
import com.kwyjibo.ginkgopolis.model.Coordinate;
import com.kwyjibo.ginkgopolis.model.SparseArrayBoardImpl;
import com.kwyjibo.ginkgopolis.model.TileSlot;
import com.kwyjibo.ginkgopolis.model.TileType;
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
		
		Coordinate[] expectedUrbanization = new Coordinate[] {
			new Coordinate(1, 0), new Coordinate(2, 0), new Coordinate(3, 0),
			new Coordinate(0, 1), new Coordinate(0, 4),
			new Coordinate(0, 1), new Coordinate(0, 4),
			new Coordinate(0, 1), new Coordinate(0, 4),
			new Coordinate(1, 4), new Coordinate(2, 4), new Coordinate(3, 4),
		};
		for (Coordinate c : expectedUrbanization) {
			assert(tileSlots[c.y][c.x] instanceof UrbanizationTileSlot);
		}
		
		BuildingTile expectedBlue2 = (BuildingTile) tileSlots[2][2].getTile();
		assertEquals(TileType.BLUE, expectedBlue2.getType());
		assertEquals(2, expectedBlue2.getRank());
	}

}
