package com.kwyjibo.ginkgopolis.ui.swing;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.TileSlot;

public class BoardPanel extends JPanel {
	protected Board board;
	
	public BoardPanel(Board board) {
		super();
		
		this.board = board;
	}
	
	public void decorate() {
		TileSlot[][] tileSlots = board.getSmallestTileBox();
		
		GridLayout grid = new GridLayout(tileSlots.length, tileSlots[0].length);
		this.setLayout(grid);
		
		for (int y = 0; y < tileSlots.length; y++) {
			for (int x = 0; x < tileSlots[y].length; x++) {
				TileSlotButton tsb = new TileSlotButton(tileSlots[y][x]);
				tsb.decorate();
				this.add(tsb);
			}
		}		
	}
}
