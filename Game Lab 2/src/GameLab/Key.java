package GameLab;

public class Key extends Item {
	public Key(String na, String de) {
		super("SwordKey", "Sora's Key");
	}
	@Override
	public void use() {
		if(currentRoom.getExit('u') == null) {
			Game.print("Try using this key to open Kapelski Room 310 door");
		}
		else if(currentRoom.getExit('u').getName().equals("Kapelski Room 310")) {
			Game.print("Kapelski Room 310 has been opened!");
			currentRoom.getExit('u').setLock(false);
		}
		else
			Game.print("Try using this key to open Kapelski Room 310 door");
	}
}
