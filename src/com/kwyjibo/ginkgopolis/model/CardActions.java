package com.kwyjibo.ginkgopolis.model;

public interface CardActions {
	public void onPlayerAction(PlayerAction action, Player player, Game game);
	public void onScoring(Player player, Board board);
}
