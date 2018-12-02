package com.vuclip.battleship.client;

import java.util.Scanner;

import com.vuclip.battleship.domain.GamePanel;
import com.vuclip.battleship.domain.Player;
import com.vuclip.battleship.domain.Shot;
import com.vuclip.battleship.domain.ShotResponse;
import com.vuclip.battleship.domain.StandardShot;
import com.vuclip.battleship.service.GameFactory;
import com.vuclip.battleship.service.GameService;
import com.vuclip.battleship.util.GameUtils;

/**
 * Client class to read User Input.
 * 
 * @author Satindra
 *
 */
public class GameClient {
	public static void main(String[] args) throws Exception {

		// Mock Player1 placement
		GamePanel panelA = GameUtils.initializeGamePanel();
		Player playerA = new Player(1, "Player1", panelA);

		// Mock Player2 placement
		GamePanel panelB = GameUtils.initializeGamePanel();
		Player playerB = new Player(2, "Player2", panelB);

		GameService gameService = GameFactory.getGameService();
		gameService.initialize(playerA, playerB);
		gameService.displayCurrentState();

		while (!gameService.isGameOver()) {

			System.out.println("Enter Shot to be fired - Player 1:");
			Scanner s = new Scanner(System.in);
			String cell = s.nextLine();
			// e.g. "F7";
			Shot shot = new StandardShot(cell);
			ShotResponse shotResponse = null;
			shotResponse = gameService.takeShot(playerA, shot);
			if (ShotResponse.WIN.equals(shotResponse)) {
				System.out.println("PlayerA wins");
			} else {
				System.out.println(shotResponse);
			}

			gameService.displayCurrentState();

			System.out.println("Enter Shot to be fired - Player 2:");
			s = new Scanner(System.in);
			cell = s.nextLine();
			// e.g. "F7";
			shot = new StandardShot(cell);
			shotResponse = gameService.takeShot(playerB, shot);

			if (ShotResponse.WIN.equals(shotResponse)) {
				System.out.println("PlayerB wins");
			} else {
				System.out.println(shotResponse);
			}

			gameService.displayCurrentState();

		}
		System.out.println("Game Over!!");
	}

}
