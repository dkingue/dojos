package org.dojo.battleship;

import org.dojo.battleship.model.Ship;

/**
 * A BattleShip game with two players trying to bomb the opponent's ships.
 *
 */
public class Game {
	
	/**
	 * Players
	 */
	private Player player1;
	private Player player2;
	private Attack winner = null;
	
	/**
	 * Controller
	 *
	 */
	public enum Play {
		ONE,
		TWO
	}
	
	/**
	 * Action response
	 * 
	 */
	public enum Attack {
		HIT, //"hit" if the attack hit a ship but did not sink it
		MISS, //"miss" if the attack didn't hit anything
		SUNK, //A ship sinks when every point it occupies has been hit
		P1WIN, //Game Over - Player 1 wins
		P2WIN //Game Over - Player 2 wins
	}
	
	/**
	 * Create a new game.
	 * 
	 * @param player1	Player 1
	 * @param player2	Player 2
	 */
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Make an attack action.
	 * 
	 * @param player		Player under attack
	 * @param position		Attack position
	 * @return				Attack result (@see Game.Attack)
	 */
	public Attack action(Game.Play player, Position position) {
		if (winner != null) return winner;
		Attack resp;
		Player p = (player.equals(Game.Play.ONE)) ? player1 : player2;
		Ship s = p.getBoard().dropBomb(position);
		if (s != null) {
			if (p.getBoard().getPieces().size() <= 0) {
				winner = (player.equals(Game.Play.ONE)) ? Attack.P2WIN : Attack.P1WIN;
				resp = winner;
			} else if (s.getSize() <= 0) {
				resp = Attack.SUNK;
			} else {
				resp = Attack.HIT;
			}
		} else {
			resp = Attack.MISS;
		}
		return resp;
	}
}
