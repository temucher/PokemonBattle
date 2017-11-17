
public class Type {
	String name;
	String oppType;
	public Type() {
		
	}
	public Type(String name) {
		this.name = name;
		this.name.replaceAll("\\s+", "");
		if(this.name.equals("Psychic")) {
			this.oppType = "Ghost";
		}
		if(this.name.equals("Water")) {
			this.oppType = "Electric";
		}
		if(this.name.equals("Fire")) {
			this.oppType = "Water";
		}
		if(this.name.equals("Electric")) {
			this.oppType = "Psychic";
		}
		if(this.name.equals("Ghost")) {
			this.oppType = "Electric";
		} 
	}
}
