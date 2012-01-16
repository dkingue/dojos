package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * Specialized Ship: Patrol
 * Ship length: 1
 *
 */
public class Patrol extends Ship {

	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Patrol(Position position) {
		super(position);
		this.size = 2;
	}

}
