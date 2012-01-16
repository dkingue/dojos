package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * Specialized Ship: Destroyer
 * Ship length: 3
 *
 */
public class Destroyer extends Ship {

	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Destroyer(Position position) {
		super(position);
		this.size = 3;
	}

}
