package DriverEtc;

import Rooms.Room;
import Things.Friendly;
import Things.Item;
import Things.Medicine;
import Things.Monster;
import Things.PickUp;

public class Parser {

	private Room curRoom;

	public Parser(Room curRoom) {
		this.curRoom = curRoom;
	}

	public void parse(String s, Player player) {
		s = s.toLowerCase().trim();
		if (s.equals("wait")) {
			waitThere();
		} else if (s.startsWith("go ")) {
			goTo(s, player);
		} else if (s.startsWith("talk to ")) {
			talkTo(s);
		} else if (s.startsWith("pick up ")) {
			pickUp(s, player);
		} else if (s.startsWith("use ")) {
			useItem(s, player);
		} else if (s.startsWith("attack ")) {
			attack(s, player);
		} else if (s.startsWith("look at ")) {
			lookAt(s, player);
		} else {
			System.out.println("I didn't understand that. Please input a valid command.");
		}
	}

	public void waitThere() {
		curRoom.waitTurn();
	}

	public void goTo(String s, Player p) {
		if (s.endsWith("north") && curRoom.getN() != null) {
			if (curRoom.isLocked()) {
				curRoom.unlock(p);
			}
			TextAdventure.changeRoom(curRoom.getN());
		} else if (s.endsWith("south") && curRoom.getS() != null) {
			if (curRoom.isLocked()) {
				curRoom.unlock(p);
			}
			TextAdventure.changeRoom(curRoom.getS());
		} else if (s.endsWith("east") && curRoom.getE() != null) {
			if (curRoom.isLocked()) {
				curRoom.unlock(p);
			}
			TextAdventure.changeRoom(curRoom.getE());
		} else if (s.endsWith("west") && curRoom.getW() != null) {
			if (curRoom.isLocked()) {
				curRoom.unlock(p);
			}
			TextAdventure.changeRoom(curRoom.getW());
		} else {
			System.out.println("You cannot go that way.");
		}
	}

	public void talkTo(String s) {
		s = s.substring(8);
		Friendly f = curRoom.getFriendly(s);
		if (f != null) {
			System.out.println(f.getDialogue());
		} else {
			System.out.println("That person is not here.");
		}
	}

	public void pickUp(String s, Player player) {
		s = s.substring(8);
		PickUp p = curRoom.getItem(s);
		if (p != null) {
			player.pickUp(p);
		} else {
			System.out.println("That item is not here.");
		}
	}

	public void useItem(String s, Player player) {
		s = s.substring(5);
		PickUp p = player.getItem(s);
		if (p != null) {
			if (p instanceof Medicine) {
				player.healBy((Medicine) p);
			} else if (p instanceof Item) {
				lookAt(p.getName(), player);
			} else {
				System.out.println("You cannot use that here.");
			}
		} else {
			System.out.println("You do not have the " + s + ".");
		}
	}
	
	public void attack(String s, Player p) {
		s = s.substring(8);
		Monster m = curRoom.getMonster(s);
		if (m != null) {
			m.attackMonster(p.getEquip(), p);
		} else {
			System.out.println("You cannot attack that!");
		}
	}

	public void lookAt(String s, Player p) {
		s = s.substring(9);
		PickUp item = curRoom.getItem(s);
		PickUp item2 = p.getItem(s);
		if (item != null) {
			System.out.println(item.getInfo());
		} else if (item2 != null) {
			System.out.println(item2.getInfo());
		} else {
			System.out.println("There is nothing to look at.");
		}
	}

}
