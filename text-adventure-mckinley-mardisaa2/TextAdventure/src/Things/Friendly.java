package Things;

public class Friendly {

	private String name;
	private String dialogue;
	
	public Friendly(String name, String dialogue) {
		this.name = name;
		this.dialogue = dialogue;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDialogue() {
		return dialogue;
	}
	
	
	public void changeDialogue(String s) {
		dialogue = s;
	}
}
