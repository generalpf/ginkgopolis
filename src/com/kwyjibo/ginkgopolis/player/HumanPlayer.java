package com.kwyjibo.ginkgopolis.player;

import com.kwyjibo.ginkgopolis.model.Player;
import com.kwyjibo.ginkgopolis.model.TileSlot;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, int points, int resourcesReady, int resourcesLeft) {
		super(name, points, resourcesReady, resourcesLeft);
	}
	
	@Override
	public TileSlot chooseNewUrbanizeTileLocation(TileSlot[] candidates) {
		// TODO Auto-generated method stub
		return null;
	}

}
