package GameLab;


public class Item{
	private String name;
	private String description;
	public Item(String na, String de){
		name = na;
		description = de; 
	}
	public void setName(String na) {
		name = na;
	}
	public void setDescription(String de) {
		description = de;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String toString() {
		return name;
	}
	public void open() {
		Game.print("You can't open that!");
	}
	public void use() {
		Game.print("You can't use that!");
	}
	public void give() {
		Game.print("You can't give that!");
	}
}
