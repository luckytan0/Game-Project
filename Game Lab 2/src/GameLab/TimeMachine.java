package GameLab;

public class TimeMachine extends Item{
	public TimeMachine(String na, String de) {
		super("TimeMachine", "Time Machine with Diamond");
	}
	@Override
	public void use() {
		if(Game.getInventoryIt("Diamond") == null) {
			Game.print("Can't use the time machine without this item");
		}
		else {
			Game.print("You will teleport to Kapelski Room 215 after the bear tells you to use the time machine with the diamond.");
			Game.currentRoom = Game.currentRoom.getExit('d').getExit('e');
	}
	
}
}		
