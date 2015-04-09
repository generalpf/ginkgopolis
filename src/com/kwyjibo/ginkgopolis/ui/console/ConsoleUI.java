package com.kwyjibo.ginkgopolis.ui.console;

import java.io.PrintStream;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.BuildingTileSlot;
import com.kwyjibo.ginkgopolis.model.TileSlot;
import com.kwyjibo.ginkgopolis.model.UrbanizationTile;
import com.kwyjibo.ginkgopolis.model.UrbanizationTileSlot;
import com.kwyjibo.ginkgopolis.ui.GameUI;

public class ConsoleUI extends GameUI {
	protected PrintStream ps;

	public ConsoleUI() {
		super();
		
		this.ps = System.out;
	}
	
	public ConsoleUI(PrintStream os) {
		super();
		
		this.ps = os;
	}
	
	@Override
	public void renderBoard(Board board) {
		TileSlot[][] tileSlots = board.getSmallestTileBox();
		
		for (int y = 0; y < tileSlots.length; y++) {
			for (int x = 0; x < tileSlots[y].length; x++) {
				TileSlot tileSlot = tileSlots[y][x];
				if (tileSlot == null) {
					ps.print("    ");
				}
				else if (tileSlot instanceof UrbanizationTileSlot) {
					UrbanizationTile urbTile = (UrbanizationTile) tileSlot.getTile();
					ps.print("[" + urbTile.getLetter() + "] ");
				}
				else if (tileSlot instanceof BuildingTileSlot) {
					BuildingTile buildingTile = (BuildingTile) tileSlot.getTile();
					ps.print(buildingTile.getType().toString().charAt(0) + new Integer(buildingTile.getRank()).toString() + "  ");
				}
				if (x == tileSlots[y].length - 1) {
					ps.println();
				}
			}
		}

	}

}
