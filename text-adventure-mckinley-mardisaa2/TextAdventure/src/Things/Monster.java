package Things;

import DriverEtc.Player;

public class Monster {

	private String name;
	private String info;
	private String deathMessage;
	private int attStat;
	private int health;
	private PickUp itemDrop;
	
	public Monster (String name, String info, String deathMessage, int attStat, int health, PickUp itemDrop) {
		this.name = name;
		this.info = info;
		this.deathMessage = deathMessage;
		this.attStat = attStat;
		this.health = health;
		this.itemDrop = itemDrop;
	}
	
	public String getName() {
		return name;
	}
	
	public String getInfo() {
		return info;
	}
	
	public String getDeathMessage() {
		return deathMessage;
	}
	
	public int getAttack() {
		return attStat;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void attackMonster(Weapon w, Player p) {
		health -= w.getAttack();
		if (!isAlive()) {
			System.out.println(deathMessage);
			p.pickUp(itemDrop);
			System.out.println("You picked up a " + itemDrop + " from the defeated " + name + ".");
		}
	}
	
	public boolean isAlive() {
		return (health > 0);
	}
}
