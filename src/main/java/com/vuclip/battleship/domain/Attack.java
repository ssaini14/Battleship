package com.vuclip.battleship.domain;

/**
 * Interface for attacking , All the Shot types will provide there own behavior
 * for attacking.
 * 
 * @author SatinderS
 *
 */
public interface Attack {
	ShotResponse attack(GamePanel input);
}
