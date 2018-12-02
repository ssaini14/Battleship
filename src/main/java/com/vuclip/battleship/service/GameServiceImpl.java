package com.vuclip.battleship.service;

import com.vuclip.battleship.domain.Game;
import com.vuclip.battleship.domain.Player;
import com.vuclip.battleship.domain.Shot;
import com.vuclip.battleship.domain.ShotResponse;
import com.vuclip.battleship.util.GameUtils;

/**
 * Service Class to provide all the services for a given game.
 * 
 * @author SatinderS
 *
 */
public class GameServiceImpl implements GameService {

	private Game game;

	private int nextTurn;

	public void initialize(Player playerA, Player playerB) {
		this.game = new Game(playerA, playerB, "Game-1");
		nextTurn = 1;
	}

	public ShotResponse takeShot(Player player, Shot shot) {

		ShotResponse shotResponse;
		Player opponentPlayer = getOponent(player);

		shotResponse = shot.attack(opponentPlayer.getGamePanel());

		// Toggle turn
		if (nextTurn == 1) {
			nextTurn = 2;
		} else {
			nextTurn = 1;
		}
		return shotResponse;
	}

	private Player getOponent(Player player) {
		if (this.game.getPlayerA().getId() == player.getId()) {
			return this.game.getPlayerB();
		} else {
			return this.game.getPlayerA();
		}
	}

	public void displayCurrentState() {
		this.game.display();
	}

	public boolean isGameOver() {
		return (GameUtils.isGameOver(this.game.getPlayerA().getGamePanel())
				|| GameUtils.isGameOver(this.game.getPlayerB().getGamePanel()));
	}

}
