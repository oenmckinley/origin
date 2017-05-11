package DriverEtc;
import java.util.Scanner;

import Rooms.Bar;
import Rooms.BobbyHouse;
import Rooms.Room;
import Things.Monster;

public class TextAdventure {
	
	private static Room curRoom;
	
	public static boolean isEnded(Player p) {
		return (p.getItem("Bobby's fatherly love") != null);
	}
	
	public static void changeRoom(Room room) {
		curRoom = room;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Greetings! Welcome to our adventure!");
		curRoom = new BobbyHouse();
		Player player = new Player();
		System.out.println(curRoom.getInfo());
		while (!isEnded(player)) {
			String command = in.nextLine();
			Parser parse = new Parser(curRoom);
			parse.parse(command, player);
			if (curRoom instanceof Bar) {
				((Bar) curRoom).trigger();
			}
			for (Monster m : curRoom.getEnemies()) {
				player.attackedBy(m);
			}
		}
		in.close();
	}
	
}
