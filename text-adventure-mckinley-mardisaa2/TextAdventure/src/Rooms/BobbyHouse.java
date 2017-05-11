package Rooms;

import java.util.ArrayList;

import DriverEtc.Player;
import Things.Friendly;
import Things.Key;
import Things.PickUp;
import Things.Weapon;


public class BobbyHouse extends Room{
	
	public BobbyHouse(){
		this.locked = false;
		this.info = "You know this place well. You are in Bobby's home. The keys to your Impala are on the counter, and Bobby is waiting for you.";
		this.n = null;
		this.s = new Scrapyard(this);
		this.e = null;
		this.w = null;
		this.items = new ArrayList<PickUp>();
		items.add(new Key("Car Keys", "The keys to your beloved Impala."));
		this.friendlies = new ArrayList<Friendly>();
		friendlies.add(new Friendly("Bobby", "Hey, Dean. Your brother is off hunting, but we got word of some mass grave robbings in Springfield. I want you to check it out. Let me know if you find anything."));
		this.enemies = null;
		waits = 0;
	}
	
	public void talkTo(String s, Player p) {
		if (s.equals("Bobby")) {
			if (p.hasItem("Torn Clothes") && p.hasItem("Fang") && (!(hasItem("Shotgun") || p.hasItem("Shotgun")))) {
				friendlies.get(0).changeDialogue("This clinches it. The fang you found is from a ghoul, and the torn shirt is from a victim. Take this shotgun and blow the sunbich away.");
				items.add(new Weapon("Shotgun", "A stupidly OP weapon with more shells than you can count.", 900));
			}
			System.out.println(friendlies.get(0).getDialogue());
		} else {
			System.out.println("Are you talking to yourself again?");
		}
	}

	@Override
	public void waitTurn() {
		waits++;
	}
	
	
	
	
	
	
}
