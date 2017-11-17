public class Move {
	String name;
	Type type;
	int pp;
	//healthEffect will be a baseline, static int for now. Will implement some element of variation and randomness later
	int healthEffect;
	int defaultHealthEffect;
	int speedEffect;
	int defaultSpeedEffect;
	
	//constructors
	public Move() {
		
	}
	public Move(String name, Type type, int pp, int healthEffect, int speedEffect) {
		this.name = name;
		this.type = type;
		this.pp = pp;
		this.healthEffect = healthEffect;
		this.defaultHealthEffect = this.healthEffect;
		this.speedEffect = speedEffect;
		this.defaultSpeedEffect = this.speedEffect;
	}
	
}
