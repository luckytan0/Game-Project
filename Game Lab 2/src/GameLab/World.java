package GameLab;

public class World {
	public static Room buildWorld() {
		Room kapelski = new Room("You are at the Kapelski Hall 200.");
		Room kapelski1 = new Room("You are at Kapelski Room 215.");
		Room kapelski2 = new Room("You are at Kapelski Room 222B.");
		Room kapelski3 = new Room("You are at Kapelski Room 229.");
		Room kapelski4 = new Room("You are at Kapelski Room 236.");
		Room kapelski5 = new Room("You are at Kapelski Room 310.");
		Room kapelski6 = new Room("You are at Kapelski Room 101.");
		Item book = new Item("ThomasCalculusBook", "Math Textbook");
		Item marker = new Item("ExpoMarker", "Black Marker");
		Item computer = new Item("Dell", "Desktop");
		kapelski.addExit(kapelski1, 'e');
		kapelski.addExit(kapelski2, 'w');
		kapelski.addExit(kapelski3, 'n');
		kapelski.addExit(kapelski4, 's');
		kapelski.addExit(kapelski5, 'u');
		kapelski.addExit(kapelski6, 'd');	
		kapelski1.addExit(kapelski, 'w');
		kapelski2.addExit(kapelski, 'e');
		kapelski2.addItem(book.getName(), book);
		kapelski3.addExit(kapelski, 's');
		kapelski3.addItem(marker.getName(), marker);
		kapelski4.addExit(kapelski, 'n');
		kapelski4.addItem(computer.getName(), computer);
		kapelski5.addExit(kapelski, 'd');
		kapelski6.addExit(kapelski, 'u');
		return kapelski;
	}
}
