package DriverEtc;
import java.util.Scanner;

import Rooms.BobbyHouse;
import Rooms.Room;

public class TextAdventure {
	
	private static Room curRoom;
	
	public static void changeRoom(Room room) {
		curRoom = room;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean ended = false;
		System.out.println("Greetings! Welcome to our adventure!");
		curRoom = new BobbyHouse();
		Player player = new Player();
		System.out.println(curRoom.getInfo());
		while (!ended) {
			String command = in.nextLine();
			Parser parse = new Parser(curRoom);
			parse.parse(command, player);
		}
		in.close();
	}
	
}
