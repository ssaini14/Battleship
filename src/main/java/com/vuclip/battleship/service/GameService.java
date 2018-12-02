package com.vuclip.battleship.service;

import com.vuclip.battleship.domain.Player;
import com.vuclip.battleship.domain.Shot;
import com.vuclip.battleship.domain.ShotResponse;

/**
 * Service interface to provide all the services for a given game.
 * 
 * @author SatinderS
 *
 */
public interface GameService {

	public void initialize(Player playerA, Player playerB);

	public ShotResponse takeShot(Player player, Shot shot);

	public void displayCurrentState();

	public boolean isGameOver();

}
