package GameLab;

public class TeddyBear extends Item {
	public TeddyBear(String na, String de) {
		super("TeddyBear", "Big Brown Teddy Bear with Diamond");
	}
	@Override
	public void use() {
		if(Game.getInventoryIt("Diamond") == null) {
			Game.print("Can't use the teddy bear without this item");
		}
		else {
			Game.print("You used the diamond and the bear begins to speak.");
			Game.print("You must use the time machine the bear says.");
		}
	}
}
