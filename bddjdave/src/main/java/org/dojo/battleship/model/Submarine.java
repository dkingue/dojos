package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * Specialized Ship: Submarine
 * Ship length: 3
 *
 */
public class Submarine extends Ship {

	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Submarine(Position position) {
		super(position);
		this.size = 3;
	}

}
