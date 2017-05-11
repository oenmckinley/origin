package DriverEtc;
import java.util.ArrayList;

import Things.PickUp;

public class Inventory {
	
	private ArrayList<PickUp> inventory;
	
	public Inventory () {
		inventory = null;
	}
	
	public PickUp getItem(String item) {
		for (PickUp p : inventory) {
			if (p.getName().equals(item)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean hasItem (String item) {
		for (PickUp p : inventory) {
			if (p.getName().equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public void addItem (PickUp item) {
		inventory.add(item);
		System.out.println("You picked up one " + item.getName());
	}
	
}
