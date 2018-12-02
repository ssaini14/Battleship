package com.vuclip.battleship.domain;

/**
 * Class representing a coordinate (rowXcol).
 * 
 * @author SatinderS
 *
 */
public class Coordinates {
	private int x;
	private int y;

	public Coordinates(int r, int c) {
		this.x = r;
		this.y = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coordinates) {
			return ((this.x == ((Coordinates) obj).getX()) && (this.y == ((Coordinates) obj).getY()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 11 * this.x + this.y;
	}

}
