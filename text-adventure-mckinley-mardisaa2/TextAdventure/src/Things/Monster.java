package Things;

public class Monster {

	private String name;
	private String info;
	private String deathMessage;
	private int attStat;
	private int health;
	
	public Monster (String name, String info, String deathMessage, int attStat, int health) {
		this.name = name;
		this.info = info;
		this.deathMessage = deathMessage;
		this.attStat = attStat;
		this.health = health;
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
	
	public void attack(Weapon w) {
		health -= w.getAttack();
	}
	
	public boolean isAlive() {
		return (health > 0);
	}
}
