import java.util.*;

public class PokemonBattle {
	String p1_name;
	String p2_name;
	public static void main(String[] args) {

		//Creating all objects, initializing everything, etc.
		
		//Creating all moves: 2 Psychic, 2 Water, 2 Fire, 2 Electric, 2 Ghost
		//Not really doing much with speed right now (except agility and confuseRay), probably will change this later
		//damage and pp somewhat arbitrary at the moment, will need to balance later
		
		//psychic moves
		Move agility = new Move("Agility", "Psychic", 30, 0, 20);//raises this pokemon's speed
		Move rest = new Move("Rest", "Psychic", 10, 30, 0);//heals this pokemon, doesnt do damage
		
		//water moves
		Move bubbleBeam = new Move("Bubble Beam", "Water", 20, 15, 0);
		Move waterGun = new Move("Water Gun", "Water", 25, 20, 0);
		
		//fire moves
		Move ember = new Move("Ember", "Fire", 25, 20, 0);
		Move fireBlast = new Move("Fire Blast", "Fire", 40, 35, 0);
		
		//electric moves
		Move thunder = new Move("Thunder", "Electric", 10, 10, 0);
		Move thunderbolt = new Move("Thunderbolt", "Electric", 30, 30, 0);
		
		//ghost moves
		Move lick = new Move("Lick", "Ghost", 30, 30, 0);
		Move confuseRay = new Move("Confuse Ray", "Ghost", 10, 0, -10);//lowers opponents speed
		
		
		//Not sure if I will use this idea -- potentially use a hashMap for easier search? and then put into individual arrayLists for each pokemon
		//Creating a master move list for each pokemon to pull moves from
		//ArrayList<Move> masterMoveList = new ArrayList<Move>();
		//masterMoveList.add()
		
		
		//Creating the 10 Pokemon: 2 Psychic, 2 Water, 2 Fire, 2 Electric, 2 Ghost
		//The moves each pokemon has doesn't make a whole lot of sense right now (e.g. Drowzee can't even fight really)
		ArrayList<Move> psychicMoves = new ArrayList<>();
		psychicMoves.add(agility);
		psychicMoves.add(rest);
		Pokemon drowzee = new Pokemon("Drowzee", "Psychic", 60, 42, psychicMoves);
		Pokemon kadabra = new Pokemon("Kadabra", "Psychic", 40, 80, psychicMoves);
		
		ArrayList<Move> waterMoves = new ArrayList<>();
		waterMoves.add(bubbleBeam);
		waterMoves.add(waterGun);
		Pokemon poliwhirl = new Pokemon("Poliwhirl", "Water", 65, 80, waterMoves);
		Pokemon tentacruel = new Pokemon("Tentacruel", "Water", 70, 45, waterMoves);
		
		ArrayList<Move> fireMoves = new ArrayList<>();
		fireMoves.add(ember);
		fireMoves.add(fireBlast);
		Pokemon rapidash = new Pokemon("Rapidash", "Fire", 55, 90, fireMoves);
		Pokemon growlith = new Pokemon("Growlith", "Fire", 50, 85, fireMoves);
		
		ArrayList<Move> electricMoves = new ArrayList<>();
		electricMoves.add(thunder);
		electricMoves.add(thunderbolt);
		Pokemon magneton = new Pokemon("Magneton", "Electric", 50, 85, electricMoves);
		Pokemon electabuzz = new Pokemon("Electabuzz", "Electric", 65, 75, electricMoves);
		
		ArrayList<Move> ghostMoves = new ArrayList<>();
		ghostMoves.add(lick);
		ghostMoves.add(confuseRay);
		Pokemon haunter = new Pokemon("Haunter", "Ghost", 45, 90, ghostMoves);
		Pokemon gengar = new Pokemon("Gengar", "Ghost", 60, 80, ghostMoves);
		
		ArrayList<Pokemon> allPokemon = new ArrayList<>();
		allPokemon.add(drowzee);
		allPokemon.add(kadabra);
		allPokemon.add(poliwhirl);
		allPokemon.add(tentacruel);
		allPokemon.add(rapidash);
		allPokemon.add(growlith);
		allPokemon.add(magneton);
		allPokemon.add(electabuzz);
		allPokemon.add(haunter);
		allPokemon.add(gengar);
		
	
		//user input to get names
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Pokemon Battle! The only game where you get to play a shitty pokemon battle in a console, using limited moves and only a few Pokemon from Generation 1!");
		System.out.println("Player 1! What is your name?");
		
		//may have to make player names global
		p1_name = scan.nextLine();
		System.out.println("Wow " + p1_name + ", what a stupid name. Player 2, is your name any better?");
		p2_name = scan.nextLine();
		
		
		//user input to pick Pokemon, set up
		ArrayList<Pokemon> p1_Pokemon = new ArrayList<>(); 
		ArrayList<Pokemon> p2_Pokemon = new ArrayList<>();
		
		System.out.println();
		System.out.println("Alright y'all. Here's how this is gonna work");
		System.out.println("There are 10 Pokemon to choose from. You each take a turn, picking one Pokemon at a time");
		System.out.println("Here are your choices:");
		
		ArrayList<String> pokemonNames = new ArrayList<>();
		for(Pokemon p : allPokemon) {
			pokemonNames.add(p.name);
			System.out.println(p.name);
		}
		//Selecting pokemon
		for(int i = 0; i<3; i++) {
			String s;
			if(i == 0) { 
				s = "1st";
			} else if (i==1) {
				s = "2nd";
			} else {
				s = "3rd";
			}
			
			//use boolean to control while loop for checking if a they added a pokemon correctly
			boolean boo = false;
			while(boo == false) {
				System.out.println(p1_name + ", pick your " + s + " pokemon");
				String resp = scan.nextLine();
				if(pokemonNames.contains(resp)) {
					for(Pokemon p : allPokemon) {
						if(p.name.equals(resp)) {
							p1_Pokemon.add(p);
							System.out.println("Added");
							boo = true;
						}
					}
				} else {
					System.out.println("Oops that's not a Pokemon");
					System.out.println();
				}
			}
			boo = false;
			while(boo == false) {
				System.out.println(p2_name + ", pick your " + s + " pokemon");
				String resp = scan.nextLine();
				if(pokemonNames.contains(resp)) {
					for(Pokemon p : allPokemon) {
						if(p.name.equals(resp)) {
							p2_Pokemon.add(p);
							boo = true;
						}
					}
				} else {
					System.out.println("Oops that's not a Pokemon");
					System.out.println();
				}
			}
		}
		//Creating the Players
		Player p1 = new Player(p1_name, p1_Pokemon);
		Player p2 = new Player(p2_name, p2_Pokemon);
		
		//About to begin the game
		System.out.println("The Pokemon have been selected! The players are hungry for glory!");
		System.out.println("Are you ready?!? Begin!");
		scan.close();
		gameControl();
	}
	
	
	public static void gameControl() {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		while (run == true) {
			System.out.println(p1_name + ", your turn. What will you do?");
			System.out.println("Attack              Switch Pokemon");
			
		}
	}
}
