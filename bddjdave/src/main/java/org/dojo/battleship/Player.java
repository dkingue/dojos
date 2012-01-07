package org.dojo.battleship;

import org.dojo.battleship.model.Ship;


public class Player {

	private Board board;
	private String name;
	
	/**
	 * Default constructor. Creates an empty Board for the player 
	 */
	public Player() {
		board = new Board(10, 10);
	}
	
	/**
	 * Defines an empty Board and player name
	 * 
	 * @param name	Player name
	 */
	public Player(String name) {
		this();
		this.name = name;
	}
	
	/**
	 * Player Board getter
	 * 
	 * @return	Player Board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void placeAll(Ship[] ship) throws InvalidMove {
		for(Ship s: ship) {
			placePiece(s);
		}
	}
	
	public void placePiece(Ship ship) throws InvalidMove {
		try {
			board.add(ship);
		} catch (RuntimeException e) {
			throw new InvalidMove("Invalid Position", e);
		}
	}
}
