package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.BuildingTileSlot;
import com.kwyjibo.ginkgopolis.model.Game;
import com.kwyjibo.ginkgopolis.model.Player;
import com.kwyjibo.ginkgopolis.model.RegularCard;
import com.kwyjibo.ginkgopolis.model.Tile;
import com.kwyjibo.ginkgopolis.model.TileSlot;
import com.kwyjibo.ginkgopolis.model.TileType;

public class GameTest {
	protected Game game;
	
	protected RegularCard findCard(Game game, int rank, TileType type) {
		for (RegularCard card : game.getCardReadyPile()) {
			if (card.getRank() == rank && card.getType().equals(type)) {
				return card;
			}
		}
		return null;
	}
	
	@Before
	public void setUp() throws Exception {
		game = new Game(new Player[] { new Player("Ryan", 3, 5, 15), new Player("Adam", 3, 5, 15) });
		game.prepareGame();
	}

	@Test
	public void testRed20() {
		RegularCard red20 = this.findCard(this.game, 20, TileType.RED);
		Player playerOne = game.getPlayers()[0];
		assertEquals(9, red20.getScoringHandler().onScoring(playerOne, game.getBoard()));
	}
	
	@Test
	public void testRed19() {
		RegularCard red19 = this.findCard(this.game, 19, TileType.RED);
		RegularCard red18 = this.findCard(this.game, 18, TileType.RED);
		RegularCard red13 = this.findCard(this.game, 13, TileType.RED);
		RegularCard red7 = this.findCard(this.game, 7, TileType.RED);
		RegularCard blue1 = this.findCard(this.game, 1, TileType.BLUE);
		RegularCard yellow2 = this.findCard(this.game, 2, TileType.YELLOW);
		Player playerOne = game.getPlayers()[0];
		playerOne.getCards().add(red19);
		playerOne.getCards().add(red18);
		playerOne.getCards().add(red13);
		playerOne.getCards().add(red7);
		playerOne.getCards().add(blue1);
		playerOne.getCards().add(yellow2);
		assertEquals(6, playerOne.getCards().size());
		assertEquals(8, red19.getScoringHandler().onScoring(playerOne, game.getBoard()));
	}
	
	@Test
	public void testRed15() {
		RegularCard red15 = this.findCard(this.game, 15, TileType.RED);
		Player playerOne = game.getPlayers()[0];
		TileSlot[][] slots = game.getBoard().getSmallestTileBox();
		
		BuildingTileSlot centre = (BuildingTileSlot) slots[2][2];
		assertEquals(0, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile blue6 = new BuildingTile(6, TileType.BLUE);
		centre.replaceTile(blue6, playerOne);
		assertEquals(0, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile blue12 = new BuildingTile(12, TileType.BLUE);
		centre.replaceTile(blue12, playerOne);
		assertEquals(3, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTileSlot neighbour = (BuildingTileSlot) slots[2][3];
		BuildingTile red7 = new BuildingTile(7, TileType.RED);
		neighbour.replaceTile(red7, playerOne);
		assertEquals(3, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile red19 = new BuildingTile(19, TileType.RED);
		neighbour.replaceTile(red19, playerOne);
		assertEquals(6, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile red20 = new BuildingTile(20, TileType.RED);
		neighbour.replaceTile(red20, game.getPlayers()[1]);
		assertEquals(3, red15.getScoringHandler().onScoring(playerOne, game.getBoard()));
	}
	
	@Test
	public void testRed14() {
		RegularCard red14 = this.findCard(this.game, 14, TileType.RED);
		Player playerOne = game.getPlayers()[0];
		TileSlot[][] slots = game.getBoard().getSmallestTileBox();
		
		BuildingTileSlot centre = (BuildingTileSlot) slots[2][2];
		assertEquals(0, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile blue6 = new BuildingTile(6, TileType.BLUE);
		centre.replaceTile(blue6, playerOne);
		assertEquals(1, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile blue12 = new BuildingTile(12, TileType.BLUE);
		centre.replaceTile(blue12, playerOne);
		assertEquals(0, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTileSlot neighbour = (BuildingTileSlot) slots[2][3];
		BuildingTile red7 = new BuildingTile(7, TileType.RED);
		neighbour.replaceTile(red7, playerOne);
		assertEquals(1, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile red19 = new BuildingTile(19, TileType.RED);
		neighbour.replaceTile(red19, playerOne);
		assertEquals(0, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
		
		BuildingTile red20 = new BuildingTile(20, TileType.RED);
		neighbour.replaceTile(red20, game.getPlayers()[1]);
		assertEquals(0, red14.getScoringHandler().onScoring(playerOne, game.getBoard()));
	}

}
