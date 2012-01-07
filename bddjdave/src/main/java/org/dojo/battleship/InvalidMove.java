package org.dojo.battleship;

/**
 * Exception thrown when an invalid move is detected in the board.
 *
 */
@SuppressWarnings("serial")
public class InvalidMove extends Exception {

	/**
	 * Default constructor with violation message and cause.
	 */
	public InvalidMove(String message, Throwable cause) {
		super(message, cause);
	}
}
