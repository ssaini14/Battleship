package com.vuclip.battleship.domain;

/**
 * Class representing a Cruiser ship.
 * 
 * @author SatinderS
 *
 */
public class Cruiser extends Ship {

	private Alignment alignment;
	
	public Cruiser(Alignment alignment) {
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
