package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Tile;

public class TileTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetRank() {
		// derpiest test possible
		Tile blueTile = new Tile(4, Tile.TileType.BLUE);
		assertEquals(Tile.TileType.BLUE, blueTile.getType());
	}

}
