package GameLab;

import java.util.HashMap;

public class Room {
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private HashMap<String, Item> it = new HashMap<String, Item>(); // The item in the room
	private boolean lock;
	private String name;
	
	public Room(String ne, String y){
		name = ne;
		description = y;
	}
	public Room getExit(char z) {
		if(z=='e') {
			return east;
		}
		else if(z=='w') {
			return west;
		}
		else if(z=='n') {
			return north;
		}
		else if(z=='s') {
			return south;
		}
		else if(z=='u') {
			return up;
		}
		else if(z=='d') {
			return down;
		}
		return null;
	}
	public Room addExit(Room room, char direction) { 
		if(direction=='e') {
			east = room;
		}
		else if(direction=='w') {
			west = room;
		}
		else if(direction=='n') {
			north = room;
		}
		else if(direction=='s') {
			south = room;
		}
		else if(direction=='u') {
			up = room;
		}
		else if(direction=='d'){
			down = room;
		}
		return null;

	}
	public String toString() {
		return description;
	}
	public void addItem(String de, Item i) {
		it.put(de, i);
	}
	public Item getItem(String na) {
		return it.get(na);
	}
	public Item removeItem(String na) {
		return it.remove(na);
	}
	public boolean getLock() {
		return lock;
	}
	public void setLock(boolean b) {
		lock = b;
	}
	public String getName() {
		return name;
	}
	public void setName(String ne) {
		name = ne;
	}
	
}