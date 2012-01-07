package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * The generalization of a piece in the battleship game. There are different
 * pieces of different sizes which are sub-classes and specializations of a
 * Ship.
 * 
 * Navy arsenal:</p>
 * <ul>
 * 		- <li>Carrier (length 5)</li>
 * 		- <li>Battleship (length 4)</li>
 * 		- <li>Submarine (length 3</li>
 * 		- <li>Destroyer (length 3)</li>
 * 		- <li>Patrol (length 2)</li>
 * </ul
 *
 */
public abstract class Ship {
	
	/**
	 * Ship coordinates
	 */
	protected Position position;
	
	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Ship(Position position) {
		this.position = position;
	}
	
	/**
	 * Set ship position
	 * 
	 * @param position	Ship position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Get ship position
	 * 
	 * @return	Ship position
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Return the length of the ship
	 * 
	 * @return ship length
	 */
	public abstract int getSize();
}
