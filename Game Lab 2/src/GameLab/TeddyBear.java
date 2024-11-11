package GameLab;

public class TeddyBear extends Item {
	public TeddyBear(String na, String de) {
		super("TeddyBear", "Big Brown Teddy Bear with Diamond");
	}
	@Override
	public void use() {
		if(getInventoryIt("diamond") == null) {
			Game.print("Can't use the teddy bear without this item");
		}
		else {
			Game.print("Use this item to get more info from the teddy bear.");
		}
	}
}
