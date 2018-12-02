package com.vuclip.battleship.service;

public class GameFactory {
	public static GameService getGameService() {
		return new GameServiceImpl();
	}
}
