package org.dojo.battleship;

/**
 * Position will hold position and orientation of pieces in the board.
 * 
 * @see Board
 */
public class Position {

	/**
	 * Coordinates
	 */
	private int x;
	private int y;
	
	/**
	 * Orientation
	 */
	private Orientation orientation;  
	
	/**
	 * Orientation enumeration: VERTICAL or HORIZONTAL
	 *
	 */
	public enum Orientation {
		VERTICAL,
		HORIZONTAL
	}
	
	/**
	 * Default constructor will set coordinates to (0,0) and orientation to
	 * HORIZONTAL.
	 */
	public Position() {
		x = y = 0;
		orientation = Orientation.HORIZONTAL;
	}
	
	/**
	 * Defines a position with default orientation (HORIZONTAL).
	 * 
	 * @param x		X coordinate
	 * @param y		Y coordinate
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		orientation = Orientation.HORIZONTAL;
	}
	
	/**
	 * Defines a custom position.
	 *  
	 * @param x				X coordinate
	 * @param y				Y coordinate
	 * @param orientation	orientation
	 */
	public Position(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}
	
	/**
	 * Set position orientation
	 * 
	 * @param orientation	HORIZONTAL or VERTICAL
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
