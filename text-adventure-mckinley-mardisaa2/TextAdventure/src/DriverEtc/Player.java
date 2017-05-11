package DriverEtc;
import Things.Medicine;
import Things.Monster;
import Things.PickUp;
import Things.Weapon;

public class Player {

	private Weapon equip;
	private int health;
	private static final int MAX_HEALTH = 100;
	private Inventory inv;

	public Player() {
		equip = new Weapon ("Fists", "Your all-natural weapons.", 45);
		health = MAX_HEALTH;
		inv = new Inventory();
	}

	public int getHealth() {
		return health;
	}

	public void attackedBy(Monster m) {
		health -= m.getAttack();
		System.out.println("The " + m.getName() + " attacks and does " + m.getAttack() + " damage!");
		System.out.println("Your health is now " + health + ".");
	}

	public void healBy(Medicine m) {
		if (health + m.getHealing() > 100) {
			health = 100;
			System.out.println("Your health is now full.");
		} else {
			health += m.getHealing();
			System.out.println("Your health is now " + health + ".");
		}
	}

	public boolean hasItem(String s) {
		return inv.hasItem(s);
	}

	public PickUp getItem(String item) {
		return inv.getItem(item);
	}

	public void pickUp(PickUp item) {
		inv.addItem(item);
	}

	public void equipWeapon(Weapon equip) {
		if (inv.hasItem(equip.getName())) {
			this.equip = equip;
			System.out.println("You are now carrying your " + equip.getName() + ".");
		} else {
			System.out.println("You do not have a(n) " + equip.getName() + "!");
		}
	}

	public Weapon getEquip() {
		return equip;
	}

}
