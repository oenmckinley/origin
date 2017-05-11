package Rooms;

import java.util.ArrayList;

import Things.Item;
import Things.Key;
import Things.Monster;
import Things.PickUp;

public class HouseInt extends Room{
	public HouseInt(HouseExt h){
		this.locked = true;
		this.info = "The room is extremely rundown. There are signs that something unhuman was here recently. There are some torn clothes on the ground.";
		this.n = null;
		this.s = h;
		this.e = null;
		this.w = null;
		this.items = new ArrayList<PickUp>();
		items.add(new Item("Torn Clothes", "These are tattered old clothes that were ripped to shreds. Better go show Bobby!"));
		this.friendlies = null;
		this.enemies = null;
		waits = 0;
	}
	
	public void unlock(Key k) {
		if (k.getName().equals("Hairpin")) {
			locked = false;
			System.out.println("You pick the lock with your hairpin. The door is now open.");
		} else {
			System.out.println("You need some way to open the door.");
		}
	}

	@Override
	public void waitTurn() {
		waits++;
		switch (waits) {
		case 1:
			info = "You hear a strange noise in the house...";
			break;
		case 2:
			info = "The noise is getting louder. You are not alone.";
			break;
		case 3:
			info = "Why are you looking around? There is a monster!";
			enemies = new ArrayList<Monster>();
			enemies.add(new Monster("Ghoul", "A terrifying humanoid figure. This thing is crazy strong.", "Congratulations! Go tell Bobby about your success!", 20, 1000));
		}
	}
	
	
	
}
