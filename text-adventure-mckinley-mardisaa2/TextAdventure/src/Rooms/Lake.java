package Rooms;

public class Lake extends Room{
	public Lake(Street s){
		this.locked = false;
		this.info = "This is the end of the street. There is a beautiful lake. To the east there seems to be something, but the woods are too thick. You might get lost without help.";
		this.n = null;
		this.s = null;
		this.e = new HouseExt(this);
		this.w = s;
		this.items = null;
		this.friendlies = null;
		this.enemies = null;
		waits = 0;
	}

	@Override
	public void waitTurn() {
		waits++;
	}
}
