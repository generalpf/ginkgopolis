package com.kwyjibo.ginkgopolis.model;

public class UrbanizationTile extends Tile {
	protected char letter;

	public UrbanizationTile(char letter) {
		super();
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}
}
