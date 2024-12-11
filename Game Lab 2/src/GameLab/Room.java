package GameLab;

import java.util.HashMap;
import java.io.Serializable;

public class Room implements Serializable{
	private String name;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private HashMap<String, Item> it = new HashMap<String, Item>(); // The item in the room
	private HashMap<String, NPC> npc = new HashMap<String, NPC>(); // The npc in the room
	private boolean lock;
	
	public Room(String ne, String y){
		name = ne;
		Game.roomObjects.put(ne, this);
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
		String dc = this.getDescription(name);
		return dc;
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
	public String getDescription(String n){
	       for(String dc : Game.rooms.keySet()){
	           if(dc.equals(n)){
	               return Game.rooms.get(d);
	           }
	       }
	       return null;
	}
	public void addNPC(String name, NPC x){
		npc.put(name, x);
	}
	public NPC getNPC(String name){
		return npc.get(name);
	}
	public void removeNPC(String name){
		npc.remove(name);
	}
	
}
