package com.vuclip.battleship.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vuclip.battleship.domain.Aircraft;
import com.vuclip.battleship.domain.Alignment;
import com.vuclip.battleship.domain.Battleship;
import com.vuclip.battleship.domain.Coordinates;
import com.vuclip.battleship.domain.Cruiser;
import com.vuclip.battleship.domain.Destroyer;
import com.vuclip.battleship.domain.GamePanel;
import com.vuclip.battleship.domain.Ship;
import com.vuclip.battleship.domain.Submarine;

/**
 * 
 * Utility class
 * 
 * @author SatinderS
 *
 */
public class GameUtils {
	public static GamePanel initializeGamePanel() {

		/*
		 * LOGIC:-
		 * 
		 * Fix a set of 5 coordinates since we have to place 5 spaceships.
		 * Choose the coordinates so that spaceship do no overlap.
		 * 
		 * Then randomly place the spaceships at those 5 coordinates. In order
		 * to randomize further, we can have multiple sets of such coordinates.
		 * 
		 * 
		 */
		List<Coordinates> randomCoordinates = new ArrayList<Coordinates>();
		List<Ship> allShips = new ArrayList<Ship>();

		allShips.add(new Destroyer(Alignment.HORIZONTAL));
		allShips.add(new Submarine(Alignment.HORIZONTAL));
		allShips.add(new Cruiser(Alignment.HORIZONTAL));
		allShips.add(new Battleship(Alignment.HORIZONTAL));
		allShips.add(new Aircraft(Alignment.HORIZONTAL));

		Coordinates coordinate1 = new Coordinates(0, 0);
		Coordinates coordinate2 = new Coordinates(2, 3);
		Coordinates coordinate3 = new Coordinates(4, 1);
		Coordinates coordinate4 = new Coordinates(6, 3);
		Coordinates coordinate5 = new Coordinates(8, 1);

		randomCoordinates.add(coordinate1);
		randomCoordinates.add(coordinate2);
		randomCoordinates.add(coordinate3);
		randomCoordinates.add(coordinate4);
		randomCoordinates.add(coordinate5);

		char[][] grid = new char[10][10];
		GamePanel gamePanel = new GamePanel(grid);
		for (Coordinates coordinate : randomCoordinates) {
			int index = new Random().nextInt(allShips.size());
			Ship spaceShip = allShips.get(index);
			placeSpaceShip(grid, coordinate, spaceShip);
			gamePanel.getSpaceShips().put(coordinate, spaceShip);
			allShips.remove(index);
		}
		return gamePanel;
	}

	private static void placeSpaceShip(char[][] gameGrid, Coordinates coordinate, Ship spaceShip) {

		char[][] spaceShipGrid = spaceShip.getGrid();
		int rows = spaceShipGrid.length;
		int cols = spaceShipGrid[0].length;

		int iMax = coordinate.getX() + rows;
		int jMax = coordinate.getY() + cols;
		for (int i = coordinate.getX(), k = 0; i < iMax; i++, k++) {
			for (int j = coordinate.getY(), l = 0; j < jMax; j++, l++) {
				gameGrid[i][j] = spaceShipGrid[k][l];
			}
		}
	}

	private static void print(char[][] gameGrid) {
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[0].length; j++) {
				System.out.print(gameGrid[i][j] + " ");

			}
			System.out.println();
		}
	}

	public static boolean isGameOver(GamePanel gamePanel) {
		/*
		 * Check if any char '*' is existing then game is not over.
		 */
		char[][] gameGrid = gamePanel.getGrid();

		int rows = gameGrid.length;
		int cols = gameGrid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (gameGrid[i][j] == '*')
					return false;
			}
		}
		return true;
	}

}
