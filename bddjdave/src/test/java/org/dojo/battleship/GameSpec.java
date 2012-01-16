package org.dojo.battleship;

import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.dojo.battleship.Position.Orientation;
import org.dojo.battleship.model.Carrier;
import org.dojo.battleship.model.Destroyer;
import org.dojo.battleship.model.Patrol;
import org.dojo.battleship.model.Ship;
import org.dojo.battleship.model.Submarine;
import org.junit.runner.RunWith;

/**
 * Game Specification class
 *
 */
@RunWith(JDaveRunner.class)
public class GameSpec extends Specification<Game> {

	/*
	 * New Game behavior
	 */
	public class NewGame {
		private Game game;
		
		/*
		 * A new game with two players
		 */
		public void create() throws InvalidMove {
			Player play1 = new Player("Bill Gates");
			Player play2 = new Player("Steve Jobs");
			
			play1.placePiece(new Submarine(new Position()));
			play2.placePiece(new Carrier(new Position()));
			
			game = new Game(play1, play2);
		}
		
		/*
		 * Once all pieces are placed, players take turns "bombing" each other's
		 * ships by specifying a coordinate they would like to attack. If any of
		 * the ships owned by the defending player occupies the position under 
		 * attack, and the same position has not been attacked before, it is 
		 * considered a hit. The player being bombed must truthfully indicate 
		 * the result of the attack, replying "hit" if the attack hit a ship but
		 * did not sink it, "miss" if the attack didn't hit anything, or stating
		 * the phrase "you sunk my <shipname>", with the name of the ship that 
		 * was sunk. A ship sinks when every point it occupies has been hit, so 
		 * for example the aircraft carrier requires five hits to sink while the
		 * patrol boat requires only two. 
		 */
		public void play() {
			//Player 1
			specify(game.action(Game.Play.ONE, new Position(0,0)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(0,0)), should.equal(Game.Attack.MISS));
			specify(game.action(Game.Play.ONE, new Position(0,1)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(0,1)), should.equal(Game.Attack.MISS));
			
			//Player 2
			specify(game.action(Game.Play.TWO, new Position(0,0)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,0)), should.equal(Game.Attack.MISS));
			specify(game.action(Game.Play.TWO, new Position(0,1)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,1)), should.equal(Game.Attack.MISS));
			specify(game.action(Game.Play.TWO, new Position(0,2)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,2)), should.equal(Game.Attack.MISS));
			specify(game.action(Game.Play.TWO, new Position(0,3)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,3)), should.equal(Game.Attack.MISS));
			
			//Player 1
			specify(game.action(Game.Play.ONE, new Position(0,2)), should.equal(Game.Attack.P2WIN));
			
			//Game Over
			specify(game.action(Game.Play.ONE, new Position(0,2)), should.equal(Game.Attack.P2WIN));
			specify(game.action(Game.Play.TWO, new Position(0,4)), should.equal(Game.Attack.P2WIN));
		}
	}
	
	public class SuperBowl {
		private Game game;
		
		/*
		 * A new game with two players
		 */
		public void create() throws InvalidMove {
			Player play1 = new Player("Chicago Bears");
			Player play2 = new Player("Dallas Cowboys");
			
			play1.placeAll(new Ship[] {new Submarine(new Position()), new Destroyer(new Position(1,1))});
			play2.placeAll(new Ship[] {new Carrier(new Position()), new Patrol(new Position(2,2, Orientation.VERTICAL))});
			
			game = new Game(play1, play2);
		}
		
		/*
		 * Once all pieces are placed, players take turns "bombing" each other's
		 * ships by specifying a coordinate they would like to attack. If any of
		 * the ships owned by the defending player occupies the position under 
		 * attack, and the same position has not been attacked before, it is 
		 * considered a hit. The player being bombed must truthfully indicate 
		 * the result of the attack, replying "hit" if the attack hit a ship but
		 * did not sink it, "miss" if the attack didn't hit anything, or stating
		 * the phrase "you sunk my <shipname>", with the name of the ship that 
		 * was sunk. A ship sinks when every point it occupies has been hit, so 
		 * for example the aircraft carrier requires five hits to sink while the
		 * patrol boat requires only two. 
		 */
		public void play() {
			//Player 1
			specify(game.action(Game.Play.ONE, new Position(0,0)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(0,1)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(0,2)), should.equal(Game.Attack.SUNK));
			
			//Player 2
			specify(game.action(Game.Play.TWO, new Position(0,0)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,1)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,2)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,3)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.TWO, new Position(0,4)), should.equal(Game.Attack.SUNK));
			
			//Player 1
			specify(game.action(Game.Play.ONE, new Position(1,1)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(1,2)), should.equal(Game.Attack.HIT));
			specify(game.action(Game.Play.ONE, new Position(1,3)), should.equal(Game.Attack.P2WIN));
		}
	}
}
