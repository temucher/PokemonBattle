import java.util.ArrayList;

public class Pokemon {
	String name;
	String type; //potentially make type its own class
	//keep it simple with ints, no need to make these doubles or floats as of yet
	int health;
	int speed;
	
	ArrayList<Move> moveList= new ArrayList<Move>();
	
	//constructors
	public Pokemon() {
		
	}
	public Pokemon(String name, String type, int health, int speed, ArrayList<Move> moveList) {
		this.name = name;
		this.type = type;
		this.health = health;
		this.speed = speed;
		this.moveList = moveList;
	}
	//methods 
	
}
