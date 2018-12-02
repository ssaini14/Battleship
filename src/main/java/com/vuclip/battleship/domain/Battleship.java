package com.vuclip.battleship.domain;

/**
 * Class representing a Battleship ship.
 * 
 * @author SatinderS
 *
 */
public class Battleship extends Ship {
	
	private Alignment alignment;
	
	public Battleship(Alignment alignment) {
		this.alignment = alignment;
	}
	private char[][] horizontalGrid = { 
							{'*', '*', '*', '*'},
							{' ',' ',' ',' '}
							};

	
	private char[][] verticalGrid = { 
			{'*', ' ', },
			{'*', ' ', },
			{'*', ' ', },
			{'*', ' ', }
	};

	
	public char[][] getGrid() {
		if(Alignment.VERTICAL.equals(alignment)){
			return verticalGrid;
		}else{
			return horizontalGrid;
		}
	}
}
