package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * Specialized Ship: Battleship
 * Ship length: 4
 *
 */
public class Battleship extends Ship {

	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Battleship(Position position) {
		super(position);
		this.size = 4;
	}
	
}
