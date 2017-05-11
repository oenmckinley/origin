package Rooms;

import DriverEtc.Player;

public class Scrapyard extends Room{

	public Scrapyard(BobbyHouse b){
		this.locked = false;
		this.info = "The old scrapyard outside of Bobby's place. Your Impala is parked to the south, and you can drive to Springfield with it.";
		this.n = b;
		this.s = new Street(this);
		this.e = null;
		this.w = null;
		this.items = null;
		this.friendlies = null;
		this.enemies = null;
		waits = 0;
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
