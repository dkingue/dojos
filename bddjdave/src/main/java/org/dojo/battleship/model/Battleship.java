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
	}

	/**
	 * @see org.dojo.battleship.model.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return 4;
	}

}
