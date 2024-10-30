package GameLab;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	public static void main(String[] args) {
		runGame();
	}
	static ArrayList<Item> inventory = new ArrayList<Item>();
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		String command; //player's command
		do {
			System.out.println(currentRoom);
			System.out.println("What location do you wanna go?");
			command = input.nextLine();
			String[] words = command.split(" ");
			
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if(nextRoom == null)
					System.out.println("You can't go that way.");
				else
					currentRoom = nextRoom;
				break;
				
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			case "take":
				System.out.println("You are trying to take the " +words[1]+".");
				Item i = currentRoom.getItem(words[1]);
				if(i == null)
					System.out.println("There's nothing to take.");
				else
					inventory.add(i);
					System.out.println("You pick up the " + i.getName() + ",");
					currentRoom.addItem(words[1], null);
				break;
			case "look":
				if(currentRoom.getItem(words[1]) != null)
					System.out.println(currentRoom.getItem(words[1]).getDescription()+"\n");
				else {
					boolean found = false;
					for(Item it: inventory)
						if(it.getName().equals(words[1]))
							System.out.println(it.getDescription() + "\n");
							found = true;
					
					if(found==false)
							System.out.println("There is no such item.\n");
				}
						
				break;			
					
			case "i":
				System.out.println("You are carrying:");
					for(Item it:inventory)
						System.out.println(it);
					System.out.println();
					break;
			default:
				System.out.println("I don't know what that means sorry!");
			}
			}while(!command.equals("x"));
		input.close();
	}
}
