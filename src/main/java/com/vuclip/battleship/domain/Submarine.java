package com.vuclip.battleship.domain;

/**
 * Class representing a Submarine ship.
 * 
 * @author SatinderS
 *
 */
public class Submarine extends Ship {

	private Alignment alignment;
	
	public Submarine(Alignment alignment) {
		this.alignment = alignment;
	}
	private char[][] horizontalGrid = { 
							{'*', '*', '*'},
							{' ',' ',' '}
							};

	
	private char[][] verticalGrid = { 
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
