package com.vuclip.battleship.domain;

/**
 * Class representing a Aircraft ship.
 * 
 * @author SatinderS
 *
 */
public class Aircraft extends Ship {
	private Alignment alignment;
	
	public Aircraft(Alignment alignment) {
		this.alignment = alignment;
	}
	private char[][] horizontalGrid = { 
							{'*', '*', '*', '*', '*'},
							{' ',' ',' ',' ',' '}
							};

	
	private char[][] verticalGrid = { 
			{'*', ' ', },
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
