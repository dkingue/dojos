package org.dojo.battleship;

import java.util.ArrayList;
import java.util.List;

import org.dojo.battleship.model.Ship;

/**
 * Board where pieces are placed during the game. Each player is given a 10x10
 * unit area in which to place 5 ships of different size.
 * 
 * @see Ship
 */
public class Board {

	/**
	 * Maximum number of pieces for each player
	 */
	private static final int MAX_NUM_SHIPS = 5;
	
	/**
	 * Bi-dimensional board
	 */
	private Ship[][] board;
	
	/**
	 * List of pieces
	 */
	private List<Ship> pieces = new ArrayList<Ship>(MAX_NUM_SHIPS);
	
	/**
	 * Board dimensions
	 */
	private int rows;
	private int cols;
	
	/**
	 * Default constructor for a board and its dimensions
	 * 
	 * @param rows	Number of rows
	 * @param cols	Number of columns
	 */
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new Ship[rows][cols];
	}

	/**
	 * Get the board size
	 * 
	 * @return	Board size
	 */
	public int getSize() {
		return board.length * board[0].length;
	}
	
	/**
	 * Get the list of pieces
	 * 
	 * @return	List of Ships
	 */
	public List<Ship> getPieces() {
		return pieces;
	}
	
	/**
	 * Add a new Ship on the board. Every Ship will have its coordinates and
	 * they should be valid for the Board.
	 * 
	 * Vital to the game is that players keep the placements they have chosen 
	 * secret from the other player. Players place their pieces anywhere on the 
	 * board such that the endpoints of each piece reside at integer coordinates 
	 * on the board, and each piece resides either completely within a single 
	 * row or within a single column. Row and column indices are zero-based, so 
	 * all legal values for each are integers in [0,9]. Ships owned by a single 
	 * player are not allowed to overlap and ships must be contained entirely 
	 * within the legal boundaries of the board. 
	 * 
	 * @param ship
	 * @return
	 */
	public boolean add(Ship ship) {
		int x = ship.getPosition().getX();
		int y = ship.getPosition().getY();
		
		if(pieces.size() >= MAX_NUM_SHIPS) {
			return false;
		}
		
		if((x < 0 || x >= rows) || (y < 0 || y >= cols))
			throw new IllegalArgumentException("Position is out of bounds!");
		
		board[x][y] = ship;
		pieces.add(ship);
		for(int i = 0; i < ship.getSize(); i++) {
			if (ship.getPosition().getOrientation() == Position.Orientation.HORIZONTAL) {
				if (y + ship.getSize() >= cols) {
					throw new IllegalStateException("Ship cannot be contained here!");
				} else if(board[x][++y] == null) {
					board[x][y] = ship;
				} else {
					throw new IllegalStateException("Overlapping position!");
				}
			} else if (ship.getPosition().getOrientation() == Position.Orientation.VERTICAL) {
				if (x + ship.getSize() >= rows) {
					throw new IllegalStateException("Ship cannot be contained here!");
				} else if(board[++x][y] == null) {
					board[x][y] = ship;
				} else {
					throw new IllegalStateException("Overlapping position!");
				}
			}
		}
		return true;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}
	
}
