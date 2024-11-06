package GameLab;

public class Combination extends Item {
	public Combination(String na, String de) {
		super("Combination", "Combination for the school's safe.");
	}
	@Override
	public void use() {
		Game.print("If you find a safe, try opening it!" );
	}
}
