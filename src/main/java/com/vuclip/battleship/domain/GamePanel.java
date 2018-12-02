package com.vuclip.battleship.domain;

import java.util.HashMap;
import java.util.Map;

import com.vuclip.battleship.util.GameUtils;

/**
 * Class representing the 10 X 10 grid.
 * 
 * @author SatinderS
 *
 */
public class GamePanel {

	private char[][] currentGrid;

	/*
	 * Map that will be used to check how many ships are left.
	 */
	Map<Coordinates, Ship> spaceShips = new HashMap<Coordinates, Ship>();

	public GamePanel(char[][] grid) {
		this.currentGrid = grid;
	}

	public Map<Coordinates, Ship> getSpaceShips() {
		return spaceShips;
	}

	public void setSpaceShips(Map<Coordinates, Ship> spaceShips) {
		this.spaceShips = spaceShips;
	}

	public void display() {
		/*
		 * Display the current grid contents on the console.
		 */
		for (int i = 0; i < currentGrid.length; i++) {
			for (int j = 0; j < currentGrid[0].length; j++) {
				System.out.print(currentGrid[i][j] + " ");

			}
			System.out.println();
		}

	}

	public char[][] getGrid() {
		return currentGrid;
	}

	public void setGrid(char[][] grid) {
		this.currentGrid = grid;
	}
}
