package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Benefit;
import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.Player;
import com.kwyjibo.ginkgopolis.model.TileType;
import com.kwyjibo.ginkgopolis.player.HumanPlayer;

public class PlayerTest {
	protected Player player;
	
	@Before
	public void setUp() throws Exception {
		this.player = new HumanPlayer("Test Player", 3, 5, 15);
	}

	@Test
	public void testApplyBenefit() {
		BuildingTile[] drawThese = {
			new BuildingTile(1, TileType.RED),
			new BuildingTile(2, TileType.RED),
			new BuildingTile(3, TileType.RED),
		};
		this.player.applyBenefit(new Benefit(1, 8, 3), drawThese);
		
		assertEquals(6, this.player.getResourcesReady());
		assertEquals(14, this.player.getResourcesLeft());
		
		assertEquals(11, this.player.getPoints());
		
		assertEquals(3, this.player.getTileList().size());
	}

}
