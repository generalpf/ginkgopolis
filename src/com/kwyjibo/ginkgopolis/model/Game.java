package com.kwyjibo.ginkgopolis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.kwyjibo.ginkgopolis.model.PlayerAction.ActionType;

public class Game {
	protected Player[] players;
	protected Board board;
	// TODO: hands
	protected List<Card> cardReadyPile;
	protected List<Card> cardDrawPile;
	protected List<Card> cardDiscardPile;
	protected Stack<BuildingTile> tileDrawPile;
	
	public Game(Player[] players, Board board) {
		super();
		this.players = players;
		this.board = board;
		this.cardReadyPile = new ArrayList<Card>();
		this.cardDrawPile = new ArrayList<Card>();
		this.cardDiscardPile = new ArrayList<Card>();
		this.tileDrawPile = new Stack<BuildingTile>();
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}
	
	public void prepareGame() {
		this.seedDeck();
	}
	
	public BuildingTile[] drawTiles(int count) {
		BuildingTile[] tiles = new BuildingTile[Math.min(count, tileDrawPile.size())];
		for (int i = 0; i < count; i++) {
			if (!tileDrawPile.isEmpty()) {
				tiles[i] = tileDrawPile.pop();
			}
		}
		return tiles;
	}
	
	protected void seedDeck() {
		// working off https://www.boardgamegeek.com/image/1469867/ginkgopolis?size=large
		this.cardReadyPile.add(
			new Card(
				4,
				TileType.RED,
				new Benefit(1, 1, 1),
				new CardActions() {
					@Override
					public void onPlayerAction(PlayerAction action, Player player, Game game) {
						if (action.equals(ActionType.URBANIZE)) {
							player.applyBenefit(new Benefit(1, 0, 0), null);
						}
					}
					@Override
					public void onScoring(Player player, Board board) {
					}
				}
			)
		);
		this.cardReadyPile.add(
			new Card(
				4,
				TileType.YELLOW,
				new Benefit(2, 2, 1),
				new CardActions() {
					@Override
					public void onPlayerAction(PlayerAction action, Player player, Game game) {
						if (action.equals(ActionType.URBANIZE)) {
							player.applyBenefit(new Benefit(0, 1, 0), null);
						}
					}
					@Override
					public void onScoring(Player player, Board board) {
					}
				}
			)
		);
		this.cardReadyPile.add(
			new Card(
				4,
				TileType.BLUE,
				new Benefit(1, 0, 0),
				new CardActions() {
					@Override
					public void onPlayerAction(PlayerAction action, Player player, Game game) {
						if (action.equals(ActionType.CONSTRUCT)) {
							player.applyBenefit(new Benefit(0, 0, 1), game.drawTiles(1));
						}
					}
					@Override
					public void onScoring(Player player, Board board) {
					}
				}
			)
		);
		
		// ...
		
		this.cardReadyPile.add(
			new Card(
				20,
				TileType.RED,
				null,	// these cards don't have starting benefits.
				new CardActions() {
					@Override
					public void onPlayerAction(PlayerAction action, Player player, Game game) {
					}
					@Override
					public void onScoring(Player player, Board board) {
						// 9 points!
						player.applyBenefit(new Benefit(0, 9, 0), null);
					}
				}
			)
		);
		
	}
}
