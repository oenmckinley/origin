package Rooms;

import java.util.ArrayList;

import DriverEtc.Player;
import Things.Friendly;

public class Square extends Room{
	
	public Square(Street s){
		this.locked = false;
		this.info = "The square is deserted except for an old preacher walking aimlessly. He is muttering something to himself.";
		this.n = null;
		this.s = new Store(this);
		this.e = s;
		this.w = null;
		this.items = null;
		this.friendlies = new ArrayList<Friendly>();
		friendlies.add(new Friendly("Preacher", "The end is nigh! Repent! The beast is rising from the earth! REPENT!"));
		this.enemies = null;
		waits = 0;
	}
	
	public void talkTo(String s, Player p) {
		if (s.equals("Preacher")) {
			System.out.println(friendlies.get(0).getDialogue());
		} else {
			System.out.println("Are you talking to yourself again?");
		}
	}

	@Override
	public void waitTurn() {
		waits++;
		if (waits % 2 == 0) {
			friendlies.get(0).changeDialogue("The end is nigh! Repent! The beast is rising from the earth! REPENT!");
		} else {
			friendlies.get(0).changeDialogue("The beast I saw resembled a leopard, but had feet like those of a bear and a mouth like that of a lion. "
					+ "The dragon gave the beast his power and his throne and great authority. Revelations 13:2");
		}
	}
	
	@Override
	public void unlock(Player p) {
		locked = false;
	}
	
}
