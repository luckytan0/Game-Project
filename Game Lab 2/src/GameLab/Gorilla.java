package GameLab;

public class Gorilla extends NPC{
	public Gorilla(String na, String de) {
		super("Gorilla", "Donkey and Diddy Kong");
	}
	int count = 0;
	@Override
	public void talk() {
		if(count==0) {
			say("Hi, we're Donkey and Diddy Kong from Donkey Kong Country Returns");
			String[] options = {
					"Hey nice to meet you guys! I'm a huge fan of you guys video game",
					"You guys are actual monkeys? No thank you"
			};
			getResponse(options);
			count++;
		}
		else if(count==1) {
			say("Hey would you guys tell us about your video game? Yes or No?");
			String[] options = {
					"Sure thing give us a sec, thanks for asking by the way",
					"No since you offended us we will not tell you about our video game."
			};
			getResponse(options);
			count++;
		}
		else {
			say("ooh ooh ah ah");
			count++;
		}
	}
	@Override
	public void response(int option) {
		if(count==0) {
			switch(option) {
			case 1:
				say("It's nice meeting you too glad that you're our fan");
				break;
			case 2:
				say("We are monkeys, got a problem with it?");
				Game.print("The Kongs attacks you with their strong fist espeically their bananas. You deserve it.");
				break;
			}
		}
		else if(count==1) {
			switch(option) {
			case 1:
				say("Yes we will tell you about our video game.");
				Game.print("All you have to do is collect as much bananas as you can in the game.");
				Item banana = new Item("Banana", "A banana of currency");
                		Game.inventory.add(banana);
				break;
			case 2:
				say("You're such a hater seriously");
				Game.print("The Kongs stops talking.");
				break;
			}
		}
	}
	public void give(Item it){
        if(Game.getInventoryIt(it.getName()) == null){
            Game.print("You dont have such item");
        }
        else if(it.getName() == "currency"){
            Game.print("You gave the " + it.getName() + " to Donkey and Diddy Kong");
            Game.inventory.remove(it);
        }
        else{
            Game.print("You can't give the " + it.getName() + " to Donkey and Diddy Kong");
        }
    }
}
