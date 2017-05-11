package Rooms;

import DriverEtc.Player;
import Things.Key;

public class Street extends Room {

	public Street(Scrapyard s){
		this.locked = true;
		this.info = "It's the main street in Springfield. There is a bar to the south, a lake to the east, and a town square to the west. You parked your Impala to the north, so you can get back to Bobby's scrapyard.";
		this.n = s;
		this.s = new Bar(this);
		this.e = new Lake(this);
		this.w = new Square(this);
		this.items = null;
		this.friendlies = null;
		this.enemies = null;
		waits = 0;
	}
	
	public void unlock(Key k) {
		if (k.getName().equals("Car Keys")) {
			locked = false;
			System.out.println("The Impala is running smoothly.");
		} else {
			System.out.println("You need to start up the Impala.");
		}
	}

	@Override
	public void waitTurn() {
		waits++;
	}
	
	@Override
	public void unlock(Player p) {
		locked = false;
	}
	
}
