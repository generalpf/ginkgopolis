package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.BuildingTile;

public class TileTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetRank() {
		// derpiest test possible
		BuildingTile blueTile = new BuildingTile(4, BuildingTile.TileType.BLUE);
		assertEquals(BuildingTile.TileType.BLUE, blueTile.getType());
	}

}
