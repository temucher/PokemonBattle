import java.util.*;

public class PokemonBattle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Creating the 10 Pokemon
		
	
		//user input to get names
		Player p1;
		Player p2;
		System.out.println("Welcome to Pokemon Battle! The only game where you get to play a shitty pokemon battle in a console");
		System.out.println("Player 1! What is your name?");
		String p1_name = scan.nextLine();
		System.out.println("Wow " + p1_name + ", what a stupid name. Player 2, is your name any better?");
		String p2_name = scan.nextLine();
		
		
		//user input to pick Pokemon
		System.out.println("Alright y'all. Here's how this is gonna work");
		System.out.println("There are 10 Pokemon to choose from. You each take a turn, picking one Pokemon at a time");
		
		ArrayList<Pokemon> p1_Pokemon; 
		ArrayList<Pokemon> p2_Pokemon;
		
		gameControl();
	}
	public static void gameControl() {
		boolean run = true;
		while (run == true) {
			
		}
	}
}
