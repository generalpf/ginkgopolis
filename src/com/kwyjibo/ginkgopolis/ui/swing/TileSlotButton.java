package com.kwyjibo.ginkgopolis.ui.swing;

import javax.swing.JButton;

import com.kwyjibo.ginkgopolis.model.BuildingTile;
import com.kwyjibo.ginkgopolis.model.BuildingTileSlot;
import com.kwyjibo.ginkgopolis.model.TileSlot;
import com.kwyjibo.ginkgopolis.model.UrbanizationTile;
import com.kwyjibo.ginkgopolis.model.UrbanizationTileSlot;

public class TileSlotButton extends JButton {
	private static final long serialVersionUID = 1L;
	
	protected TileSlot tileSlot;
	
	public TileSlotButton(TileSlot tileSlot) {
		super();
		
		this.tileSlot = tileSlot;
	}
	
	protected void decorate() {
		if (tileSlot == null) {
			this.setVisible(false);
		} else if (tileSlot instanceof UrbanizationTileSlot) {
			UrbanizationTile urbTile = (UrbanizationTile) tileSlot.getTile();
			this.setText("" + urbTile.getLetter());
		} else if (tileSlot instanceof BuildingTileSlot) {
			BuildingTile buildingTile = (BuildingTile) tileSlot.getTile();
			this.setText(buildingTile.getType().toString() + (new Integer(buildingTile.getRank()).toString()));
		}
	}
}
