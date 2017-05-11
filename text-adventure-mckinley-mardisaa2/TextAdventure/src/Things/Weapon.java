package Things;
public class Weapon extends PickUp {
	
	private int attStat;
	
	public Weapon (String name, String info, int attStat) {
		this.name = name;
		this.info = info;
		this.attStat = attStat;
	}
	
	public int getAttack() {
		return attStat;
	}
	
	public void useOn(Monster m) {
		m.attack(this);
		if (!m.isAlive()) {
			System.out.println("You have slain the " + m.getName() + "!");
		}
	}
	
}
