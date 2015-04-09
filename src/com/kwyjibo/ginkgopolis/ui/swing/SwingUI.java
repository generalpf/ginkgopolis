package com.kwyjibo.ginkgopolis.ui.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.ui.GameUI;

public class SwingUI extends GameUI {
	protected JPanel gamePanel;

	public SwingUI(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void renderBoard(Board board) {
		gamePanel.add(new JLabel("hello world!"));
		
		BoardPanel boardPanel = new BoardPanel(board);
		gamePanel.add(boardPanel);
		boardPanel.decorate();
	}

}
