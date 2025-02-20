package GameLab;

public class World {
	public static Room buildWorld() {
		Room kapelski = new Room("Kapelski Hall 200", "You are at Kapelski Hall 200.");
		Room kapelski1 = new Room("Kapelski Room 215", "You are at Kapelski Room 215.");
		Room kapelski2 = new Room("Kapelski Room 222B", "You are at Kapelski Room 222B.");
		Room kapelski3 = new Room("Kapelski Room 229", "You are at Kapelski Room 229.");
		Room kapelski4 = new Room("Kapelski Room 236", "You are at Kapelski Room 236.");
		Room kapelski5 = new Room("Kapelski Room 310", "You are at Kapelski Room 310.");
		Room kapelski6 = new Room("Kapelski Room 101", "You are at Kapelski Room 101.");
		Item book = new Item("ThomasCalculusBook", "Math Textbook");
		Item marker = new Item("ExpoMarker", "Black Marker");
		Item computer = new Item("Dell", "Desktop");
		Item toy = new Item("toy", "puppy's favorite item");
		Item currency = new Item("currency", "Donkey and Diddy Kong's banana grind");
		Key key = new Key("SwordKey", "Sora's Key");
		TeddyBear teddybear = new TeddyBear("TeddyBear", "Brown Teddy Bear");
		TimeMachine timemachine = new TimeMachine("TimeMachine", "Reverse Time Machine");
		Combination combination = new Combination("Combination", "Combination for the school's safe");
		Safe safe = new Safe("Safe", "Safe with textbooks");
		Puppy puppy = new Puppy("Puppy", "A hideous puppy wags his tail.");
		Gorilla gorilla = new Gorilla("Gorilla", "Donkey and Diddy Kong");
		kapelski1.setLock(false);
		kapelski2.setLock(false);
		kapelski3.setLock(false);
		kapelski4.setLock(false);
		kapelski5.setLock(true);
		kapelski6.setLock(false);
		kapelski.addExit(kapelski1, 'e');
		kapelski.addExit(kapelski2, 'w');
		kapelski.addExit(kapelski3, 'n');
		kapelski.addExit(kapelski4, 's');
		kapelski.addExit(kapelski5, 'u');
		kapelski.addExit(kapelski6, 'd');
		
		kapelski1.addExit(kapelski, 'w');
		kapelski1.addNPC("Puppy", puppy);
		kapelski1.addItem(toy.getName(), toy);
		kapelski1.addNPC("Gorilla", gorilla);
		kapelski1.addItem(currency.getName(), currency);
		
		kapelski2.addExit(kapelski, 'e');
		kapelski2.addNPC("Gorilla", gorilla);
		kapelski2.addItem(book.getName(), book);
		kapelski2.addItem("SwordKey", key);
		kapelski2.addExit(kapelski5, 'u');
		
		kapelski3.addExit(kapelski, 's');
		kapelski3.addItem(marker.getName(), marker);
		
		kapelski4.addExit(kapelski, 'n');
		kapelski4.addItem(computer.getName(), computer);
		
		kapelski5.addExit(kapelski, 'd');
		kapelski5.addItem(combination.getName(),combination);
		kapelski5.addItem("TeddyBear", teddybear);
		kapelski5.addItem("TimeMachine", timemachine);
		kapelski5.addExit(kapelski1, 'e');
		
		kapelski6.addExit(kapelski, 'u');
		kapelski6.addItem(safe.getName(), safe);
		return kapelski;
	}
}
