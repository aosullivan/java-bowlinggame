package org.adrian;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testAllZeros() {
		
		Game game = new Game1();
		manyZeroFrames(game, 10);
		assertEquals(0, game.score());
		
	}

	@Test
	public void testOneRoll() {
		
		Game game = new Game1();
		game.frame(5,4);
		manyZeroFrames(game, 9);
		assertEquals(9, game.score());
		
	}

	@Test
	public void testManyRolls() {
		
		Game game = new Game1();
		game.frame(5,4);
		game.frame(1,3);
		manyZeroFrames(game, 7);
		game.frame(6,3);
		assertEquals(22, game.score());
		
	}
	
	@Test
	public void testOneSpare() {
		
		Game game = new Game1();
		game.frame(5,5);
		game.frame(1,0);
		manyZeroFrames(game, 8);
		assertEquals(12, game.score());
		
	}
	
	@Test
	public void testTwoSpares() {
		
		Game game = new Game1();
		game.frame(5,5);
		game.frame(4,6);
		game.frame(2,0);
		manyZeroFrames(game, 7);
		assertEquals(28, game.score());
		
	}
	
	@Test
	public void testOneSpareWithZeroBonus() {
		
		Game game = new Game1();
		game.frame(5,5);
		game.frame(0,5);
		manyZeroFrames(game, 8);
		assertEquals(15, game.score());
		
	}

	@Test
	public void testOneStrikeWithZeroBonus() {
		
		Game game = new Game1();
		game.strike();
		manyZeroFrames(game, 9);
		assertEquals(10, game.score());
		
	}
	
	@Test
	public void testOneStrike() {
		
		Game game = new Game1();
		game.strike();
		game.frame(4,1);
		manyZeroFrames(game, 8);
		assertEquals(20, game.score());
		
	}
	
	@Test
	public void testTwoStrikes() {
		
		Game game = new Game1();
		game.strike();
		game.strike();
		game.frame(4,1);
		manyZeroFrames(game, 7);
		assertEquals(44, game.score());
		
	}

	@Test
	public void testFullGame() {
		
		Game game = new Game2();
		game.strike();
		game.frame(7,3);
		game.frame(7,2);
		game.frame(9,1);
		game.strike();
		game.strike();
		game.strike();
		game.frame(2,3);
		game.frame(6,4);
		game.frame(7,3,3);
		assertEquals(168, game.score());
		
	}
	
	
	
	private void manyZeroFrames(Game game, int numFrames) {
		for (int i = 0; i < numFrames; i++){
			game.frame(0,0);
		}
	}
	
}
