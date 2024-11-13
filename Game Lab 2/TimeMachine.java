package Gaming;

public class TimeMachine extends Item{
	public TimeMachine(String na, String de) {
		super("TimeMachine", "Time Machine with Diamond");
	}
	@Override
	public void use() {
		if(getInventoryIt("diamond") == null) {
			Game.print("Can't use the time machine without this item");
		}
		else {
			Game.print("Use this item to go all the way back to Kapelski Room 215 since the time machine is reversed according to the Teddy Bear.");
			currentRoom = currentRoom.getExit('d').getExit('e');
	}
	
}
}		
