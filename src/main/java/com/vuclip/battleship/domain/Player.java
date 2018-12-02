package com.vuclip.battleship.domain;

/**
 * Class representing a player .
 * 
 * @author SatinderS
 *
 */
public class Player {
	private int id;
	private String name;
	private GamePanel gamePanel;

	public Player(int id, String name, GamePanel panel) {
		this.id = id;
		this.name = name;
		this.gamePanel = panel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
