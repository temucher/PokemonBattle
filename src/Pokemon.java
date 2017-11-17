import java.util.ArrayList;

public class Pokemon {
	String name;
	Type type; 
	//keep it simple with ints, no need to make these doubles or floats as of yet
	int health;
	int defaultHealth;
	int speed;
	int defaultSpeed;
	
	ArrayList<Move> moveList= new ArrayList<Move>();
	
	//constructors
	public Pokemon() {
		
	}
	public Pokemon(String name, Type type, int health, int speed, ArrayList<Move> moveList) {
		this.name = name;
		this.type = type;
		this.health = health;
		this.defaultHealth = this.health;
		this.speed = speed;
		this.defaultSpeed = this.speed;
		this.moveList = moveList;
	}
	//methods 
	public void useMove(Move m, Pokemon target) {
		if(m.speedEffect != 0) {
			speedEffect(m.speedEffect);
		}
		target.healthEffect(m.healthEffect);
	}
	public void healthEffect(int h) {
		this.health = this.health + h;
	}
	public void speedEffect(int sp) {
		this.speed = this.speed + sp;
	}
}
