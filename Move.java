package PokemonBattle;

public class Move {
	String name;
	String type;
	int pp;
	//healthEffect will be a baseline, static int for now. Will implement some element of variation and randomness later
	int healthEffect;
	int speedEffect;
	
	//constructors
	public Move() {
		
	}
	public Move(String name, String type, int pp, int healthEffect, int speedEffect) {
		this.name = name;
		this.type = type;
		this.pp = pp;
		this.healthEffect = healthEffect;
		this.speedEffect = speedEffect;
	}
	
	//Figure out some way to have moves effect different types differently
}
