import java.util.*;

public class PokemonBattle {
	static String p1_name;
	static Player p1;
	static String p2_name;
	static Player p2;
	static ArrayList<Pokemon> p1_Pokemon = new ArrayList<>(); 
	static ArrayList<Pokemon> p2_Pokemon = new ArrayList<>();
	public static void main(String[] args) {

		//Creating all objects, initializing everything, etc.
		
		//Creating types
		Type psychic = new Type("Psychic");
		Type water = new Type("Water");
		Type fire = new Type("Fire");
		Type electric = new Type("Electric");
		Type ghost = new Type("Ghost");
		
		//Creating all moves: 2 Psychic, 2 Water, 2 Fire, 2 Electric, 2 Ghost
		//Not really doing much with speed right now (except agility and confuseRay), probably will change this later
		//damage and pp somewhat arbitrary at the moment, will need to balance later
		
		//psychic moves
		Move agility = new Move("Agility", psychic, 30, 0, 20);//raises this pokemon's speed
		Move rest = new Move("Rest", psychic, 10, 30, 0);//heals this pokemon, doesnt do damage
		
		//water moves
		Move bubbleBeam = new Move("Bubble Beam", water, 20, -15, 0);
		Move waterGun = new Move("Water Gun", water, 25, -20, 0);
		
		//fire moves
		Move ember = new Move("Ember", fire, 25, -20, 0);
		Move fireBlast = new Move("Fire Blast", fire, 40, -35, 0);
		
		//electric moves
		Move thunder = new Move("Thunder", electric, 10, -10, 0);
		Move thunderbolt = new Move("Thunderbolt", electric, 30, -30, 0);
		
		//ghost moves
		Move lick = new Move("Lick", electric, 30, -30, 0);
		Move confuseRay = new Move("Confuse Ray", electric, 10, 0, -10);//lowers opponents speed
		
		
		//Not sure if I will use this idea -- potentially use a hashMap for easier search? and then put into individual arrayLists for each pokemon
		//Creating a master move list for each pokemon to pull moves from
		//ArrayList<Move> masterMoveList = new ArrayList<Move>();
		//masterMoveList.add()
		
		
		//Creating the 10 Pokemon: 2 Psychic, 2 Water, 2 Fire, 2 Electric, 2 Ghost
		//The moves each pokemon has doesn't make a whole lot of sense right now (e.g. Drowzee can't even fight really)
		ArrayList<Move> psychicMoves = new ArrayList<>();
		psychicMoves.add(agility);
		psychicMoves.add(rest);
		Pokemon drowzee = new Pokemon("Drowzee", psychic, 60, 42, psychicMoves);
		Pokemon kadabra = new Pokemon("Kadabra", psychic, 40, 80, psychicMoves);
		
		ArrayList<Move> waterMoves = new ArrayList<>();
		waterMoves.add(bubbleBeam);
		waterMoves.add(waterGun);
		Pokemon poliwhirl = new Pokemon("Poliwhirl", water, 65, 80, waterMoves);
		Pokemon tentacruel = new Pokemon("Tentacruel", water, 70, 45, waterMoves);
		
		ArrayList<Move> fireMoves = new ArrayList<>();
		fireMoves.add(ember);
		fireMoves.add(fireBlast);
		Pokemon rapidash = new Pokemon("Rapidash", fire, 55, 90, fireMoves);
		Pokemon growlith = new Pokemon("Growlith", fire, 50, 85, fireMoves);
		
		ArrayList<Move> electricMoves = new ArrayList<>();
		electricMoves.add(thunder);
		electricMoves.add(thunderbolt);
		Pokemon magneton = new Pokemon("Magneton", electric, 50, 85, electricMoves);
		Pokemon electabuzz = new Pokemon("Electabuzz", electric, 65, 75, electricMoves);
		
		ArrayList<Move> ghostMoves = new ArrayList<>();
		ghostMoves.add(lick);
		ghostMoves.add(confuseRay);
		Pokemon haunter = new Pokemon("Haunter", ghost, 45, 90, ghostMoves);
		Pokemon gengar = new Pokemon("Gengar", ghost, 60, 80, ghostMoves);
		
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
		System.out.println();
		System.out.println("Alright y'all. Here's how this is gonna work");
		System.out.println("There are 10 Pokemon to choose from. You each take a turn, picking one Pokemon at a time");
		System.out.println("Don't pick the wrong Pokemon, because some can't attack!");
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
							System.out.println("Added");
							boo = true;
						}
					}
				} else {
					System.out.println("Oops that's not a Pokemon");
					System.out.println();
				}
			}
		}
		
		//Initializing the Players
		p1 = new Player(p1_name, p1_Pokemon);
		p2 = new Player(p2_name, p2_Pokemon);
		
		//About to begin the game
		System.out.println("The Pokemon have been selected! The players are hungry for glory!");
		System.out.println("Are you ready?!? Begin!");
		System.out.println();
		
		// ====================================================================================
		//Gameplay
		
		boolean run = true;
		Pokemon p1Active = p1_Pokemon.get(0);
		Pokemon p2Active = p2_Pokemon.get(0);
		while (run == true) {
			
			//Player 1's turn =====================================
			
			boolean control = false;
			if(!p1_Pokemon.isEmpty()) {
				System.out.println(p1_name);
				System.out.println("(" + p1Active.name + ": Health = " + p1Active.health + ", Speed = " + p1Active.speed + ")");
				System.out.println();
				System.out.println("===========");
				System.out.println();
				System.out.println(p2_name);
				System.out.println("(" + p2Active.name + ": Health = " + p2Active.health + ", Speed = " + p2Active.speed + ")");
				System.out.println();
				
				//reset health and speed modifiers
				for(Move m : p1Active.moveList) {
					m.healthEffect = m.defaultHealthEffect;
					m.speedEffect = m.defaultSpeedEffect;
				}
				for(Move m : p2Active.moveList) {
					m.healthEffect = m.defaultHealthEffect;
					m.speedEffect = m.defaultSpeedEffect;
				}
				//Modifying damage
				if(p1Active.type.equals(p2Active.type)) {
					for(Move m : p1Active.moveList) {
						//if this is an attack
						if(m.healthEffect<0) { 
							m.healthEffect = (int)((int)m.healthEffect*.5);
						} 
					}
				}
				if(p1Active.type.name.equals(p2Active.type.oppType)) {
					for(Move m : p1Active.moveList) {
						m.healthEffect = m.healthEffect*2;
					}
				}
				
				while(control == false) {
					String resp = "";
					System.out.println(p1_name + ", your turn. What will you do?");
					System.out.println("Attack              Switch Pokemon");
					resp = scan.nextLine();
					System.out.println();
					
					//User decides to attack
					if(resp.equals("Attack")) {
						System.out.println("What move do you want to use?");
						for(Move m : p1Active.moveList) {
							System.out.println(m.name);
						}
						String moveResp = scan.nextLine();
						for(Move m : p1Active.moveList) {
							if(moveResp.equals(m.name)) {
								control = true;
								if(m.healthEffect>=0) {
									p1Active.useMove(m, p1Active);
								} else {
									p1Active.useMove(m, p2Active);
								}
								System.out.println();
								System.out.println(p1Active.name + " used " + m.name);
							}
						}
						if(p2Active.health <= 0) {
							System.out.println("Oh no! " + p2Active.name + " fainted.");
							//default case to avoid errors
							int oldAct = 0;
							for(int i = 0; i<p2_Pokemon.size(); i++) {
								if(p2_Pokemon.get(i).name.equals(p2Active.name)) {
									oldAct = i;
								}
							}
							p2_Pokemon.remove(oldAct);
							if(p2_Pokemon.isEmpty()) {
								System.out.println("Yikes! Looks like you are out of Pokemon. " + p1_name + " wins!");
								run = false;
								break;
							} else {
								boolean chosen = false;
								while (chosen == false) {
									System.out.println("Who will you pick?");
									for(Pokemon p : p2_Pokemon) {
										System.out.println(p.name);
									}
									String choice = scan.nextLine();
									for(Pokemon p : p2_Pokemon) {
										if(p.name.equals(choice)) {
											if(p.name.equals(p2Active.name)) {
												p.health = p.defaultHealth;
												p.speed = p.defaultSpeed;
											}
											p2Active = p;
											chosen = true;
										}
									}
								}
							}
						}
					//User decides to switch	
					} else if (resp.equals("Switch Pokemon")) {	
						System.out.println("Who will you pick?");
						for(Pokemon p : p1_Pokemon) {
							System.out.println(p.name);
						}
						String choice = scan.nextLine();
						for(Pokemon p : p1_Pokemon) {
							if(p.name.equals(choice)) {
								control = true;
								p1Active = p;
							}
						}
					}
					if(control == false) {
						System.out.println("Whoops, doesn't look like you entered the correct input");
					}
				}
			}
					
			//Player 2's turn ===========================================
			
			control = false;
			if(!p2_Pokemon.isEmpty()) {
				System.out.println(p1_name);
				System.out.println("(" + p1Active.name + ": Health = " + p1Active.health + ", Speed = " + p1Active.speed + ")");
				System.out.println();
				System.out.println("===========");
				System.out.println();
				System.out.println(p2_name);
				System.out.println("(" + p2Active.name + ": Health = " + p2Active.health + ", Speed = " + p2Active.speed + ")");
				System.out.println();
				
				//reset health and speed modifiers
				for(Move m : p1Active.moveList) {
					m.healthEffect = m.defaultHealthEffect;
					m.speedEffect = m.defaultSpeedEffect;
				}
				for(Move m : p2Active.moveList) {
					m.healthEffect = m.defaultHealthEffect;
					m.speedEffect = m.defaultSpeedEffect;
				}
				//Modifying damage
				if(p2Active.type.equals(p1Active.type)) {
					for(Move m : p2Active.moveList) {
						//if this is an attack
						if(m.healthEffect<0) { 
							m.healthEffect = (int)((int)m.healthEffect*.5);
						} 
					}
				}
				if(p2Active.type.name.equals(p1Active.type.oppType)) {
					for(Move m : p2Active.moveList) {
						m.healthEffect = m.healthEffect*2;
					}
				}
				while(control == false) {
					String resp2 = "";
					System.out.println(p2_name + ", your turn. What will you do?");
					System.out.println("Attack              Switch Pokemon");
					resp2 = scan.nextLine();
					System.out.println();
					
					//User decides to attack
					if(resp2.equals("Attack")) {
						System.out.println("What move do you want to use?");
						for(Move m : p2Active.moveList) {
							System.out.println(m.name);
						}
						String moveResp = scan.nextLine();
						for(Move m : p2Active.moveList) {
							if(moveResp.equals(m.name)) {
								control = true;
								if(m.healthEffect>=0) {
									p2Active.useMove(m, p2Active);
								} else {
									p2Active.useMove(m, p1Active);
								}
								System.out.println();
								System.out.println(p2Active.name + " used " + m.name);
							}
						}
						if(p1Active.health <= 0) {
							System.out.println("Oh no! " + p1Active.name + " fainted.");
							int oldAct = 0;
							for(int i = 0; i<p1_Pokemon.size(); i++) {
								if(p1_Pokemon.get(i).name.equals(p1Active.name)) {
									oldAct = i;
								}
							}
							p1_Pokemon.remove(oldAct);
							if(p1_Pokemon.isEmpty()) {
								System.out.println("Yikes! Looks like you are out of Pokemon. " + p2_name + " wins!");
								run = false;
								break;
							} else {
								boolean chosen = false;
								while (chosen == false) {
									System.out.println("Who will you pick?");
									for(Pokemon p : p1_Pokemon) {
										System.out.println(p.name);
									}
									String choice = scan.nextLine();
									for(Pokemon p : p1_Pokemon) {
										if(p.name.equals(choice)) {
											if(p.name.equals(p1Active.name)) {
												p.health = p.defaultHealth;
												p.speed = p.defaultSpeed;
											}
											p1Active = p;
											chosen = true;
										}
									}
								}
							}
						}
					//User decides to switch	
					} else if (resp2.equals("Switch Pokemon")) {	
						System.out.println("Who will you pick?");
						for(Pokemon p : p2_Pokemon) {
							System.out.println(p.name);
						}
						String choice = scan.nextLine();
						for(Pokemon p : p2_Pokemon) {
							if(p.name.equals(choice)) {
								control = true;
								p2Active = p;
							}
						}
					}  
					if(control == false) {
					System.out.println("Whoops, doesn't look like you entered the correct input");
					}
				}
			}
		}
		System.out.println();
		scan.close();
	}
}
