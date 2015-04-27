package com.kwyjibo.ginkgopolis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.kwyjibo.ginkgopolis.model.PlayerAction.ActionType;

public class Game {
	protected Player[] players;
	protected Board board;
	// TODO: hands
	protected List<StartingCard> startingCardPile;
	/**
	 * the cards that have not entered the game yet from building actions
	 */
	protected List<RegularCard> cardReadyPile;
	/**
	 * the cards that have entered the game from building actions but are face-down
	 */
	protected List<RegularCard> cardDrawPile;
	/**
	 * the cards that have entered the game and have been played
	 */
	protected List<RegularCard> cardDiscardPile;
	protected Stack<BuildingTile> tileDrawPile;
	
	public Game(Player[] players) {
		this.players = players;
		this.board = new SparseArrayBoardImpl();
		this.cardReadyPile = new ArrayList<RegularCard>();
		this.cardDrawPile = new ArrayList<RegularCard>();
		this.cardDiscardPile = new ArrayList<RegularCard>();
		this.tileDrawPile = new Stack<BuildingTile>();
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}
	
	public void prepareGame() {
		this.board.seedBoard();
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
	
	public List<RegularCard> getCardReadyPile() {
		return cardReadyPile;
	}
	
	protected void seedDeck() {
		// working off https://www.boardgamegeek.com/image/1469871/ginkgopolis
		this.cardReadyPile.add(
			this.buildRegularCard(1, TileType.RED, ActionType.EXPLOIT, new Benefit(1, 0, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(2, TileType.RED, ActionType.URBANIZE, new Benefit(1, 0, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(3, TileType.RED, ActionType.CONSTRUCT, new Benefit(1, 0, 0), null)
		);
		
		// ...
		
		this.cardReadyPile.add(
			this.buildRegularCard(1, TileType.YELLOW, ActionType.EXPLOIT, new Benefit(0, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(2, TileType.YELLOW, ActionType.URBANIZE, new Benefit(0, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(3, TileType.YELLOW, ActionType.CONSTRUCT, new Benefit(0, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(1, TileType.BLUE, ActionType.EXPLOIT, new Benefit(0, 0, 1), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(2, TileType.BLUE, ActionType.URBANIZE, new Benefit(0, 0, 1), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(3, TileType.BLUE, ActionType.CONSTRUCT, new Benefit(0, 0, 1), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(4, TileType.RED, ActionType.EXPLOIT, new Benefit(1, 0, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(5, TileType.RED, ActionType.URBANIZE, new Benefit(1, 0, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(6, TileType.RED, ActionType.CONSTRUCT, new Benefit(1, 0, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(7, TileType.RED, ActionType.EXPLOIT, new Benefit(1, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(8, TileType.RED, ActionType.URBANIZE, new Benefit(1, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(9, TileType.RED, ActionType.CONSTRUCT, new Benefit(1, 1, 0), null)
		);
		this.cardReadyPile.add(
			this.buildRegularCard(10, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getBuildingTile().getType().equals(TileType.RED)) {
									total += 1;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(11, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getBuildingTile().getType().equals(TileType.YELLOW)) {
									total += 1;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(12, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getBuildingTile().getType().equals(TileType.BLUE)) {
									total += 1;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(13, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getBuildingTile().getType().equals(TileType.RED)) {
									total += 1;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(14, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getHeight() <= 2) {
									total += 1;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(15, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					TileSlot[][] slots = board.getSmallestTileBox();
					for (int y = 0; y < slots.length - 1; y++) {
						for (int x = 0; x < slots[y].length - 1; x++) {
							TileSlot ts = slots[y][x];
							if (ts != null && ts instanceof BuildingTileSlot) {
								BuildingTileSlot bts = (BuildingTileSlot) ts;
								if (player.equals(bts.getOwner()) && bts.getHeight() >= 3) {
									total += 3;
								}
							}
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(16, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					for (Card card : player.getCards()) {
						if (card.getPlayerActionHandler().equals(ActionType.EXPLOIT)) {
							total += 2;
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(17, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					for (Card card : player.getCards()) {
						if (card.getPlayerActionHandler().equals(ActionType.URBANIZE)) {
							total += 2;
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(18, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					for (Card card : player.getCards()) {
						if (card.getPlayerActionHandler().equals(ActionType.CONSTRUCT)) {
							total += 2;
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(19, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					int total = 0;
					for (Card card : player.getCards()) {
						if (card.getType().equals(TileType.RED)) {
							total += 2;
						}
					}
					return total;
				}
			})
		);
		this.cardReadyPile.add(
			this.buildRegularCard(20, TileType.RED, null, null, new ScoringHandler() {
				@Override
				public int onScoring(Player player, Board board) {
					// 9 points!
					return 9;
				}
			})
		);
	}
	
	protected RegularCard buildRegularCard(int rank, TileType colour, final ActionType triggeringAction, final Benefit benefit, ScoringHandler scoringHandler) {
		return new RegularCard(
			rank,
			colour,
			new PlayerActionHandler() {
				@Override
				public void onPlayerAction(PlayerAction action, Player player, Game game) {
					if (action != null && benefit != null && action.action.equals(triggeringAction)) {
						BuildingTile[] drawTiles = null;
						if (benefit.tiles > 0) {
							 drawTiles = game.drawTiles(benefit.tiles);
						}
						player.applyBenefit(benefit, drawTiles);
					}
				}
			},
			scoringHandler
		);
	}
}
