package com.vuclip.battleship.domain;

/**
 * Class representing a game.
 * 
 * @author SatinderS
 *
 */
public class Game {

	private Player playerA;

	private Player playerB;

	private String gameId;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Game(Player playerA, Player playerB, String gameId) {
		this.playerA = playerA;
		this.playerB = playerB;
		this.gameId = gameId;
	}

	public void display() {
		/*
		 * Display the current grid contents on the console.
		 */
		System.out.println("Player A game panel :: ");
		this.playerA.getGamePanel().display();
		System.out.println("Player B game panel :: ");
		this.playerB.getGamePanel().display();
	}

	public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

}
