package GameLab;


public class Safe extends Item{
	public Safe(String na, String de) {
		super("Safe","School Safe");
	}
	@Override
	public void open() {
		if(Game.getInventoryIt("Combination")==null) {
			Game.print("The safe is locked and you don't have the combination.");
		}
		else {
			Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
			Item diamond = new Item("Diamond", "Blue Diamond");
			Game.inventory.add(diamond);
		}
	}
}
