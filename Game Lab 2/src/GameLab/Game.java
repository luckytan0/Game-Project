package GameLab;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Game {
	public static void main(String[] args) {
		hmtextFile();
		runGame();
	}
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	static Room currentRoom = World.buildWorld();
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
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static HashMap<String, String> rooms = new HashMap<String, String>(); 
	static HashMap<String, Room> roomObjects = new HashMap<String, Room>();
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
            		stream.writeObject(roomObjects);
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
            		roomObjects = (HashMap) stream.readObject();
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
	public static Scanner input = new Scanner(System.in);
	public static void runGame() {
		Room currentRoom = getRoom();
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
				else if(nextRoom.getLock()==true)
						System.out.println("Room is locked sorry!");
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
				else {
					inventory.add(i);
					System.out.println("You pick up the " + i.getName() + ",");
					currentRoom.addItem(words[1], null);
				}
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
			case "use":
				System.out.println("You are trying to use the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
					System.out.println();
				}
				else {
					if(getInventoryIt(words[1]) == null) {
						System.out.println("There is no such item");
					}
					else {
						getInventoryIt(words[1]).use();
						System.out.println();
					}
				}
				break;
			case "open":
				System.out.println("You are trying to open the " + words[1] + ".");
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
					System.out.println();
				}
				else
					if(getInventoryIt(words[1]) == null) {
						System.out.println("There is no such item");
					}
					else {
						getInventoryIt(words[1]).open();
						System.out.println();
					}
				break;
			case "talk":
                		System.out.println("You are trying to talk to the " + words[1] + ".");
				if(currentRoom.getNPC(words[1]) != null){
                    			currentRoom.getNPC(words[1]).talk();
                   			System.out.println();
                		}
				else{
                    			System.out.println("There is no such thing!");
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
		}}while(!command.equals("x"));
		input.close();
	}
}
