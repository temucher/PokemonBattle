package PokemonBattle;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
	
	public Player() {
		
	}
	public Player(String name, ArrayList<Pokemon> pokeList) {
		this.name = name;
		this.pokeList = pokeList;
	}
	
}
