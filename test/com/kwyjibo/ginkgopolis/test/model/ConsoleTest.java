package com.kwyjibo.ginkgopolis.test.model;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.kwyjibo.ginkgopolis.model.Board;
import com.kwyjibo.ginkgopolis.model.SparseArrayBoardImpl;
import com.kwyjibo.ginkgopolis.ui.GameUI;
import com.kwyjibo.ginkgopolis.ui.console.ConsoleUI;

public class ConsoleTest {
	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void testRenderBoard() {
		Board board = new SparseArrayBoardImpl();
		board.seedBoard();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GameUI ui = new ConsoleUI(new PrintStream(baos));
	
		ui.renderBoard(board);

		String content = baos.toString();

		assertEquals(
				content,
				"    [a] [b] [c]     \n" +
				"[l] B1  Y1  R1  [d] \n" +
				"[k] Y2  B2  B3  [e] \n" +
				"[j] R3  Y3  R2  [f] \n" +
				"    [i] [h] [g]     \n"
		);
		
	}

}
