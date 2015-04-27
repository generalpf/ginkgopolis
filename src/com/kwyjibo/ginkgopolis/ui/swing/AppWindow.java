package com.kwyjibo.ginkgopolis.ui.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kwyjibo.ginkgopolis.model.Game;
import com.kwyjibo.ginkgopolis.model.Player;
import com.kwyjibo.ginkgopolis.player.HumanPlayer;

public class AppWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ginkgopolis by Xavier Georges");
		frame.setBounds(100, 100, 525, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel);
		
		Game game = new Game(
			new Player[] {
				new HumanPlayer("Ryan", 3, 5, 15),
				new HumanPlayer("Adam", 3, 5, 15)
			}
		);
		game.prepareGame();
		(new SwingUI(mainPanel)).renderBoard(game.getBoard());
	}

}
