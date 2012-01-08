package org.dojo.battleship;

import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.dojo.battleship.Player;
import org.dojo.battleship.Position;
import org.dojo.battleship.model.Carrier;
import org.dojo.battleship.model.Ship;
import org.junit.runner.RunWith;

/**
 * Player Specification class
 *
 */
@RunWith(JDaveRunner.class)
public class PlayerSpec extends Specification<Player> {

	/*
	 * New Player behavior
	 */
	public class NewPlayer {
		private Player player;
		
		/*
		 * Board factory
		 */
		public void create() {
			player = new Player();
		}
		
		/*
		 * Every player has a board
		 */
		public void hasBoard() {
			specify(player.getBoard(), must.isNotNull());
		}
		
		/*
		 * Board should be 10x10 of size
		 */
		public void unitArea() {
			specify(player.getBoard().getSize(), must.equal(100));
		}
		
		public void validateArea() {
			specify(player.getBoard().getRows(), must.equal(10));
			specify(player.getBoard().getCols(), must.equal(10));
		}
		
		/*
		 * Player should be able to place a piece in the board with no exception
		 */
		public void placePiece() throws Throwable {
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					//when
					player.placePiece(new Carrier(new Position()));
				} //then
			}, must.not().raiseAnyException());
		}
		
		/*
		 * Player should be able to place all pieces in the board with no 
		 * exception
		 */
		public void placeAllPieces() throws Throwable {
			//when
			player.placeAll(new Ship[]{ new Carrier(new Position(0,0))});
			//then
			specify(player.getBoard().getPieces().size(), 1);
			
			//when
			Ship[] ships = {new Carrier(new Position(1,0)),
					new Carrier(new Position(2,0)),
					new Carrier(new Position(3,0)),
					new Carrier(new Position(4,0)),
					new Carrier(new Position(5,0)),
					new Carrier(new Position(6,0))};
			player.placeAll(ships);
			//then
			specify(player.getBoard().getPieces().size(), 5);
		}
	}
}
