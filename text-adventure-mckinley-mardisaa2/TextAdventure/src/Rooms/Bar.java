package Rooms;

import java.util.ArrayList;

import DriverEtc.Player;
import Things.Friendly;
import Things.Item;
import Things.Key;
import Things.Medicine;
import Things.Monster;
import Things.PickUp;

public class Bar extends Room {

	public Bar(Street s) {
		this.locked = false;
		this.info = "This is an extremely busy place, and people around here seem anxious to fight. There is an unattended beer on the table. The bartender greets you as you walk in.";
		this.n = s;
		this.s = null;
		this.e = null;
		this.w = null;
		this.items = new ArrayList<PickUp>();
		items.add(new Medicine("beer", "It looks delicious, and will heal you if you drink it.", 40));
		this.friendlies = new ArrayList<Friendly>();
		friendlies.add(new Friendly("Bartender", "There have been some strange things happening by an abandoned house over past the lake. You could get lost if you go out there, but I can write down some directions for you."));
		this.enemies = null;
		waits = 0;
	}

	public void talkTo(String s, Player p) {
		if (s.equals("Bartender")) {
			if (!(hasItem("Directions") || p.hasItem("Directions"))) {
				items.add(new Key("Directions", "A list of directions. This should help you find the old house. It is east of the lake."));
			}
			System.out.println(friendlies.get(0).getDialogue());
			pickUp(getItem("Directions"), p);
		} else if (s.equals("Waitress")) {
			if (!(hasItem("Phone number") || p.hasItem("Phone number"))) {
				items.add(new Key("Phone number", "The waitress' phone number. Maybe I'll call her up when all this is over."));
			}
			System.out.println(friendlies.get(1).getDialogue());
		} else {
			System.out.println("Are you talking to yourself again?");
		}
	}
	
	public void trigger() {
		if (items.isEmpty() && enemies == null) {
			enemies = new ArrayList<Monster>();
			enemies.add(new Monster("Ruffian", "A huge, intimidating guy. He wants to fight.", "You beat the ruffian. That was way too easy.", 10, 100));
		}
	}

	public void itemDrop(Player p) {
		if (enemies != null && !enemies.get(0).isAlive() && (!(hasItem("Wallet") || p.hasItem("Wallet")))) {
			items.add(new Item("Wallet", "A wallet with money in it. I guess he won't miss it."));
		}
	}

	@Override
	public void waitTurn() {
		waits++;
		if (waits % 2 == 0) {
			friendlies.remove(1);
			info = "This is an extremely busy place, and people around here seem anxious to fight. There is an unattended beer on the table. The bartender greets you as you walk in.";
		} else {
			friendlies.add(new Friendly("Waitress", "Here's my number. I get off at 3:00."));
			info = "This is an extremely busy place, and people around here seem anxious to fight. There is an unattended beer on the table. The bartender greets you as you walk in. A waitress is passing time by the bar.";
		}
	}
}
