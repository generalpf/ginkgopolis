package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.TileType;

public class TileTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetRank() {
		// derpiest test possible
		BuildingTile blueTile = new BuildingTile(4, TileType.BLUE);
		assertEquals(TileType.BLUE, blueTile.getType());
	}

}
