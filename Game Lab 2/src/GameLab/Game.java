package GameLab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class Game {
	public static void main(String[] args) {
		hmtextFile();
		gui = new GUI();
		runGame();
	}
	private static GUI gui;
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static HashMap<String, String> rooms = new HashMap<String, String>(); 
	static HashMap<String, Room> roomItems = new HashMap<String, Room>();
	public static Scanner input = new Scanner(System.in);
	static Room currentRoom = World.buildWorld();
	public static void print(Object obj) {
		gui.textArea.append((obj.toString()) + "\n");
	}
	public static Room getRoom(){
		return currentRoom;
	}
	public static Item getInventoryIt(String na) {
		for(Item a: inventory) {
			if(a.getName().equals(na)) {
				return a;
			}
		}
		return null;
	}
	public static void hmtextFile(){
		try {
            		Scanner input = new Scanner(new File("Descrip.txt"));
            		while(input.hasNextLine()) {
                		String name = input.nextLine();
                		String desc = input.nextLine();
                		if(!name.equals("#") && !desc.equals("#")){
                    			rooms.put(name, desc);
                		}
           		 }
           		 input.close();
        	} catch (FileNotFoundException e) {
            		System.out.println("File not found!!!");
        	}
   	}
	public static void saveGame(String fileName) {
        	File f = new File(fileName);
        	try {
            		FileOutputStream fos = new FileOutputStream(f);
            		ObjectOutputStream stream = new ObjectOutputStream(fos);
           		stream.writeObject(currentRoom);
            		stream.writeObject(inventory);
            		stream.writeObject(roomItems);
            		stream.close();
        	} catch (FileNotFoundException e) {
            		System.out.println("File "+fileName+" not found.");
       		} catch (IOException ex) {
            		System.out.println("Bummers, man");
		}
	}
	public static void loadGame(String fileName) {
        	File f = new File(fileName);
        	try {
            		FileInputStream fos = new FileInputStream(f);
            		ObjectInputStream stream = new ObjectInputStream(fos);
            		currentRoom = (Room) stream.readObject();
            		inventory = (ArrayList) stream.readObject();
            		roomItems = (HashMap) stream.readObject();
            		stream.close();
        	} catch (FileNotFoundException e) {
            		System.out.println("File "+fileName+" not found.");
            		System.exit(0);
        	} catch (IOException ex) {
           	 	System.out.println("Bummers, man");
        	} catch (ClassNotFoundException ex) {
            		System.out.println("Not an object.");
		}
	}
	public static void processCommand(String command) {
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
					Game.print("You can't go that way.");
				else if(nextRoom.getLock()==true)
						Game.print("Room is locked sorry!");
				else
					currentRoom = nextRoom;
				Game.print(currentRoom);
				break;	
			case "x":
				Game.print("Thanks for walking through my game!");
				break;
			case "take":
				Game.print("You are trying to take the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) == null)
                    			Game.print("No items found\n");
				else {
					inventory.add(currentRoom.getItem(words[1]));
					Game.print("You pick up the " + currentRoom.getItem(words[1]).getName() + ",");
					currentRoom.addItem(words[1], null);
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1]) != null)
					Game.print(currentRoom.getItem(words[1]).getDescription()+"\n");
				else {
					boolean found = false;
					for(Item it: inventory)
						if(it.getName().equals(words[1]))
							Game.print(it.getDescription() + "\n");
							found = true;
					
					if(found==false)
						Game.print("There is no such item.\n");
				}		
				break;			
			case "i":
				Game.print("You are carrying:");
				for(Item it:inventory)
					Game.print(it);
				Game.print("\n");
				break;
			case "use":
				Game.print("You are trying to use the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
					Game.print("\n");
				}
				else {
					if(getInventoryIt(words[1]) == null) {
						Game.print("There is no such item");
					}
					else {
						getInventoryIt(words[1]).use();
						Game.print("\n");
					}
				}
				break;
			case "open":
				Game.print("You are trying to open the " + words[1] + ".");
				if (currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
					Game.print("\n");
				} else if (getInventoryIt(words[1]) == null) {
					Game.print("There is no such item to open!");
				} else {
					getInventoryIt(words[1]).open();
					Game.print("\n");
				}
				break;
			case "talk":
				Game.print("You are trying to talk to the " + words[1] + ".");
				if (currentRoom.getNPC(words[1]) != null) {
					currentRoom.getNPC(words[1]).talk();
					Game.print("/n");
				} else {
					Game.print("There is no such thing as talking!");
				}
				break;
			case "give":
				Game.print("You are trying to give the " + words[1] + " to the " + words[3]);
				if (currentRoom.getNPC(words[3]) != null) {
					if (getInventoryIt(words[1]) != null)
						currentRoom.getNPC(words[3]).give(getInventoryIt(words[1]));
					else
						Game.print("You don't have " + words[1]);
				} else {
					Game.print("There is no such thing as give!");
				}
				break;
         		case "save":
                		saveGame(words[1]);
                		break;  
            		case "load":
               		 	loadGame(words[1]);
                		break;
			default:
				System.out.println("I don't know what that means sorry!");
			}
	}
}
