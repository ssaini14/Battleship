package com.vuclip.battleship.domain;

/**
 * Class representing a Destroyer ship.
 * 
 * @author SatinderS
 *
 */
public class Destroyer extends Ship {
	private Alignment alignment;
	
	public Destroyer(Alignment alignment) {
		this.alignment = alignment;
	}
	private char[][] horizontalGrid = { 
							{'*', '*'},
							{' ',' ' }
							};

	
	private char[][] verticalGrid = { 
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
