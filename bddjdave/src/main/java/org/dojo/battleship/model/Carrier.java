package org.dojo.battleship.model;

import org.dojo.battleship.Position;

/**
 * Specialized ship: Carrier
 * Ship Length: 5
 *
 */
public class Carrier extends Ship {

	/**
	 * Default constructor requires a position
	 * 
	 * @param position	Ship coordinates
	 */
	public Carrier(Position position) {
		super(position);
	}

	/**
	 * @see org.dojo.battleship.model.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return 5;
	}

}
