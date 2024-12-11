package Gaming;

import javax.swing.JOptionPane;

public class NPC {
	private String name; // NPC's name
	private String desc; // NPC's description
	public NPC(String name, String desc) {
	this.name = name;
	this.desc = desc;
	}
	public String getName() {
	return name;
	}
	public void setDesc(String desc) {
	this.desc = desc;
	}
	public void say(String dialog) {
	Game.print(name+": "+dialog);
	}
	public void talk() {
	Game.print("You can't talk to "+name+".");
	}
	public void response(int option) {
	// This method intentionally left blank.
	}
	public void getResponse(String[] options) {
        String dc = "";
        for (int i = 0; i < options.length; i++) {
            dc += "Option " + (i + 1) + ": " + options[i] + "\n";
        }
        dc += "Enter an option (1-" + options.length + "):";
        int option = Integer.parseInt(JOptionPane.showInputDialog(dc));
        response(option);
    }
	public void give(Item it){
        Game.print(name + " doesn't want that.");
    }
}
