package DriverEtc;
import Rooms.Room;
import Things.Friendly;
import Things.Item;
import Things.Medicine;
import Things.PickUp;

public class Parser {

	private Room curRoom;

	public Parser(Room curRoom) {
		this.curRoom = curRoom;
	}
	
	public void waitThere() {
		//Implement Later...
	}

	public void goTo(String s) {
		if (s.endsWith("north")) {
			TextAdventure.changeRoom(curRoom.goTo('n'));
		} else if (s.endsWith("south")) {
			TextAdventure.changeRoom(curRoom.goTo('s'));
		} else if (s.endsWith("east")) {
			TextAdventure.changeRoom(curRoom.goTo('e'));
		} else if (s.endsWith("west")) {
			TextAdventure.changeRoom(curRoom.goTo('w'));
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
				lookAt(p);
			} else {
				System.out.println("You cannot use that here.");
			}
		} else {
			System.out.println("You do not have the " + s + ".");
		}
	}
	
	public void lookAt (PickUp item) {
		System.out.println(item.getInfo());
	}

	public void parse(String s, Player player) {
		s = s.toLowerCase().trim();
		if (s.startsWith("go ")) {
			goTo(s);
		} else if (s.startsWith("talk to ")) {
			talkTo(s);
		} else if (s.startsWith("pick up ")) {
			pickUp(s, player);
		} else if (s.startsWith("use ")) {
			useItem(s, player);
		}
	}

}
