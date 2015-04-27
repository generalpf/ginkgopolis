package com.kwyjibo.ginkgopolis.player;

import com.kwyjibo.ginkgopolis.model.Player;
import com.kwyjibo.ginkgopolis.model.TileSlot;

public class DumbAIPlayer extends Player {

	public DumbAIPlayer(String name, int points, int resourcesReady, int resourcesLeft) {
		super(name, points, resourcesReady, resourcesLeft);
	}
	
	@Override
	public TileSlot chooseNewUrbanizeTileLocation(TileSlot[] candidates) {
		return candidates[0];
	}

}
