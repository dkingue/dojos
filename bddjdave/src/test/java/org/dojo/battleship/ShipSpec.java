package org.dojo.battleship;

import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.dojo.battleship.Position;
import org.dojo.battleship.model.Carrier;
import org.dojo.battleship.model.Battleship;
import org.dojo.battleship.model.Destroyer;
import org.dojo.battleship.model.Patrol;
import org.dojo.battleship.model.Ship;
import org.dojo.battleship.model.Submarine;
import org.junit.runner.RunWith;

/**
 * Ship Specification class
 *
 */
@RunWith(JDaveRunner.class)
public class ShipSpec extends Specification<Ship> {

	/*
	 * Defines a Ship in the Board
	 */
	public class ShipInPosition {
		private Ship aircraft;
		
		public void checkPosition() {
			aircraft = new Carrier(new Position(0,0));
			specify(aircraft.getPosition(), must.isNotNull());
		}
	}
	
	/*
	 * Defines a Carrier in the Board
	 */
	public class CarrierShip {
		private Ship carrier;
		
		public void create() {
			carrier = new Carrier(new Position());
		}
		
		public void ensureSize() {
			specify(carrier.getSize(), must.equal(5));
		}
	}
	
	/*
	 * Defines a BattleShip in the Board
	 */
	public class BattleShip {
		private Ship battleship;
		
		public void create() {
			battleship = new Battleship(new Position());
		}
		
		public void ensureSize() {
			specify(battleship.getSize(), must.equal(4));
		}
	}
	
	/*
	 * Defines a Submarine and a Destroyer in the Board
	 */
	public class SubmarineAndDestroyerShip {
		private Ship submarine;
		private Ship destroyer;
		
		public void create() {
			submarine = new Submarine(new Position());
			destroyer = new Destroyer(new Position());
		}
		
		public void ensureSize() {
			specify(submarine.getSize(), must.equal(3));
			specify(destroyer.getSize(), must.equal(3));
		}
	}
	
	/*
	 * Defines a Patrol in the Board
	 */
	public class PatrolShip {
		private Ship patrol;
		
		public void create() {
			patrol = new Patrol(new Position());
		}
		
		public void ensureSize() {
			specify(patrol.getSize(), must.equal(2));
		}
	}
}
