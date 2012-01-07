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
	}

	/**
	 * @see org.dojo.battleship.model.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return 3;
	}

}
