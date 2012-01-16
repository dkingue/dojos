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
		this.size = 5;
	}

}
