package org.dojo.battleship;

import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.dojo.battleship.Board;
import org.dojo.battleship.Position;
import org.dojo.battleship.model.Carrier;
import org.dojo.battleship.model.Battleship;
import org.junit.runner.RunWith;

/**
 * Board Specification class
 *
 */
@RunWith(JDaveRunner.class)
public class BoardSpec extends Specification<Board> {

	/*
	 * Empty Board behavior
	 */
	public class EmptyBoard {
		private Board board;
		
		/*
		 * Board factory
		 */
		public void create() {
			board = new Board(10,10);
		}
		
		/*
		 * Board must have a unit area of rows x columns
		 */
		public void unitArea() {
			specify(board.getSize(), must.equal(100));
		}
	}
	
	/*
	 * Board setup behavior
	 *
	 */
	public class PlayableBoard {
		private Board board;
		
		/*
		 * Board factory
		 */
		public void create() {
			board = new Board(10,10);
		}
		
		/*
		 * Players place their pieces anywhere on the board such that the 
		 * end points of each piece reside at integer coordinates on the board
		 * 
		 * @throws Throwable
		 */
		public void setPieces() throws Throwable {
			/*
			 * Given a new board, when we add a new piece it must not throw any
			 * exception
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(0,0)));
				}
			}, must.not().raiseAnyException());
		}
		
		/*
		 *  Row and column indices are zero-based, so all legal values for each 
		 *  are integers in [0,9]
		 *  
		 * @throws Throwable
		 */
		public void setOutOfBoundPieces() {
			
			/*
			 * Given a new board, when we add a new piece in a negative position,
			 * an exact exception must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(-1,0)));
				}
			}, must.raiseExactly(IllegalArgumentException.class));
			
			/*
			 * Given a new board, when we add a new piece in a negative position,
			 * an exact exception must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(0,-1)));
				}
			}, must.raiseExactly(IllegalArgumentException.class));
			
			/*
			 * Given a new board, when we add a new piece out of the board size,
			 * an exact exception with a message must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(11,0)));
				}
			}, must.raiseExactly(IllegalArgumentException.class, "Position is out of bounds!"));
			
			/*
			 * Given a new board, when we add a new piece out of the board size,
			 * an exact exception with a message must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(0,11)));
				}
			}, must.raiseExactly(IllegalArgumentException.class, "Position is out of bounds!"));
		}
		
		/*
		 *  Ships owned by a single player are not allowed to overlap and ships 
		 *  must be contained entirely within the legal boundaries of the board
		 */
		public void setBigPieces() {
			
			/*
			 * Given a new board, when we add a new piece close to the edge of
			 * the board an exact exception with a message must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(5,0, Position.Orientation.VERTICAL)));
				}
			}, must.raiseExactly(IllegalStateException.class, "Ship cannot be contained here!"));
			/*
			 * Given a new board, when we add a new piece close to the edge of
			 * the board an exact exception with a message must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(5,5)));
				}
			}, must.raiseExactly(IllegalStateException.class, "Ship cannot be contained here!"));
		}
		
		/*
		 *  Ships owned by a single player are not allowed to overlap and ships 
		 *  must be contained entirely within the legal boundaries of the board
		 */
		public void setOverlapingPieces() {
			
			/*
			 * Given a new board, when we add two pieces in a overlapping
			 * position, an exact exception with a message must be thrown.
			 */
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					board.add(new Carrier(new Position(5,0, Position.Orientation.HORIZONTAL)));
					board.add(new Battleship(new Position(5,4, Position.Orientation.HORIZONTAL)));
				}
			}, must.raiseExactly(IllegalStateException.class, "Overlapping position!"));
		}
		
	}
	
}
