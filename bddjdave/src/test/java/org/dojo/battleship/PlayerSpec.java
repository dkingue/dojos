package org.dojo.battleship;

import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.dojo.battleship.Player;
import org.dojo.battleship.Position;
import org.dojo.battleship.model.Carrier;
import org.dojo.battleship.model.Ship;
import org.junit.runner.RunWith;


@RunWith(JDaveRunner.class)
public class PlayerSpec extends Specification<Player> {

	public class NewPlayer {
		private Player player;
		
		public void create() {
			//given
			player = new Player();
		}
		public void hasBoard() {
			//when create a new player
			//then an empty board is created
			specify(player.getBoard(), must.isNotNull());
		}
		public void unitArea() {
			specify(player.getBoard().getSize(), must.equal(100));
		}
		public void validateArea() {
			specify(player.getBoard().getRows(), must.equal(10));
			specify(player.getBoard().getCols(), must.equal(10));
		}
	}
	
	public class Game {
		private Player player;
		
		public void create() {
			//given
			player = new Player("Player 1");
		}
		
		public void placePiece() throws Throwable {
			specify(new Block() {
				@Override
				public void run() throws Throwable {
					//when
					player.placePiece(new Carrier(new Position()));
				} //then
			}, must.not().raiseAnyException());
		}
		
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
