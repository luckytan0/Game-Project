package GameLab;

public class Projector extends Item{
	public Projector(String na, String de) {
		super("Projector","Flashing Projector");
	}
	@Override
	public void use() {
		if(getInventoryIt("diamond") == null) {
			Game.print("Can't use this projector without this item");
		}
		else{
			Game.print("Use this item to flash at the combination number due to the darkness.");
		
	}
}
