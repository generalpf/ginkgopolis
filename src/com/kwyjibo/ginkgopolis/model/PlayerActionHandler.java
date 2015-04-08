package com.kwyjibo.ginkgopolis.model;

public interface PlayerActionHandler {
	public void onPlayerAction(PlayerAction action, Player player, Game game);
}
