package com.vuclip.battleship.domain;

import java.util.Set;

import com.vuclip.battleship.util.GameUtils;

/**
 * 
 * Represents a standard shot.
 * 
 * @author SatinderS
 *
 */
public class StandardShot extends Shot {

	private String targetCell;

	public StandardShot(String targetCell) {
		this.targetCell = targetCell;
	}

	public ShotResponse attack(GamePanel gamePanel) {

		ShotResponse shotResult = null;

		/*
		 * LOGIC:-
		 * 
		 * Apply the shot to the passed GamePanel object.
		 * 
		 * Change the char based on Hit (X) or Miss.
		 */

		Coordinates coordinates = getCoordinates(targetCell);
		int beforeShotCount = getShipsCount(gamePanel);

		// Hit case
		if (gamePanel.getGrid()[coordinates.getX()][coordinates.getY()] == '*') {
			gamePanel.getGrid()[coordinates.getX()][coordinates.getY()] = 'X';
			shotResult = ShotResponse.HIT;
		} else {
			// Miss, do nothing.
			shotResult = ShotResponse.MISS;
		}
		int afterShotCount = getShipsCount(gamePanel);

		// SUNK case
		if (afterShotCount < beforeShotCount) {
			shotResult = ShotResponse.SUNK;
		}

		// Check for WIN case
		if (GameUtils.isGameOver(gamePanel)) {
			shotResult = ShotResponse.WIN;
		}
		return shotResult;

	}

	private int getShipsCount(GamePanel gamePanel) {
		int totalActiveSpaceShips = 0;
		/*
		 * Count total no. of active spaceships. GamePanel maintains a map of
		 * Coordinate -> Ship. Here coordinate represent where the ship is
		 * placed.
		 */
		Set<Coordinates> spaceShipsCoordinates = gamePanel.getSpaceShips().keySet();

		for (Coordinates coordinates : spaceShipsCoordinates) {
			Ship spaceShip = gamePanel.getSpaceShips().get(coordinates);
			if (isActive(gamePanel, spaceShip, coordinates)) {
				totalActiveSpaceShips++;
			}
		}

		return (totalActiveSpaceShips);

	}

	private boolean isActive(GamePanel gamePanel, Ship spaceShip, Coordinates coordinates) {
		/**
		 * Check if any char is '*' in the grid region starting from coordinates
		 * to size of the spaceship.
		 */
		char[][] spaceShipGrid = spaceShip.getGrid();
		char[][] gameGrid = gamePanel.getGrid();

		int rows = spaceShipGrid.length;
		int cols = spaceShipGrid[0].length;

		int iMax = coordinates.getX() + rows;
		int jMax = coordinates.getY() + cols;
		for (int i = coordinates.getX(); i < iMax; i++) {
			for (int j = coordinates.getY(); j < jMax; j++) {
				if (gameGrid[i][j] == '*')
					return true;
			}
		}
		return false;
	}

	private Coordinates getCoordinates(String shot) {
		return new Coordinates(shot.charAt(1) - '1', shot.charAt(0) - 'A');
	}
}
