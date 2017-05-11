package Rooms;

import java.util.ArrayList;

import Things.Item;
import Things.Key;
import Things.PickUp;

public class HouseExt extends Room{
	public HouseExt(Lake l){
		this.locked = true;
		this.info = "There is a house to the north. It looks very run down, but the door is still locked. There is a fang lying on the ground. ";
		this.n = new HouseInt(this);
		this.s = null;
		this.e = null;
		this.w = l;
		this.items = new ArrayList<PickUp>();
		items.add(new Item("Fang", "It is an extremely sharp fang. Better show this to Bobby!"));
		this.friendlies = null;
		this.enemies = null;
		waits = 0;
	}
	
	public void unlock(Key k) {
		if (k.getName().equals("Directions")) {
			locked = false;
			System.out.println("The directions help you find your way.");
		} else {
			System.out.println("There is no road here! You could get lost!");
		}
	}

	@Override
	public void waitTurn() {
		waits++;
	}
}
