package Rooms;

import java.util.ArrayList;

import DriverEtc.Player;
import Things.Friendly;
import Things.Monster;
import Things.PickUp;

public abstract class Room {

	protected boolean locked;
	protected String info;
	protected Room n;
	protected Room s;
	protected Room e;
	protected Room w;
	protected ArrayList<PickUp> items;
	protected ArrayList<Monster> enemies;
	protected ArrayList<Friendly> friendlies;
	protected int waits;

	public boolean isLocked() {
		return locked;
	}
	
	public ArrayList<Monster> getEnemies() {
		return enemies;
	}
	
	public Room getN() {
		return n;
	}
	
	public Room getS() {
		return s;
	}
	
	public Room getE() {
		return e;
	}
	
	public Room getW() {
		return w;
	}
	
	public PickUp getItem(String item) {
		for (PickUp p : items) {
			if (p.getName().equals(item)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean hasItem(String item) {
		if (getItem(item) != null) {
			return true;
		}
		return false;
	}
	
	public Monster getMonster(String monster) {
		for (Monster m : enemies) {
			if (m.getName().equals(monster)) {
				return m;
			}
		}
		return null;
	}
	
	public Friendly getFriendly(String friendly) {
		for (Friendly f : friendlies) {
			if (f.getName().equals(friendly)) {
				return f;
			}
		}
		return null;
	}
	
	public String getInfo() {
		return info;
	}
	
	public Room goTo(char c) {
		switch(c) {
		case 'n':
			return n;
		case 's':
			return s;
		case 'e':
			return e;
		case 'w':
			return w;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public void pickUp(PickUp item, Player p) {
		if (items.contains(item)) {
			p.pickUp(item);
		} else {
			System.out.println("There is no " + item.getName() + " here.");
		}
	}
	
	public abstract void waitTurn();
	
	public abstract void unlock(Player p);
	
}
