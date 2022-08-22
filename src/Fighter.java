
public class Fighter {
	
	private String name;
	private double attack;
	private double defence;
	private double stealth;
	
	private Fighter() {}
	
	public Fighter(String name, double attack, double defence, double stealth) {
		this.name = name; 
		this.attack = attack;
		this.defence = defence; 
		this.stealth = stealth;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAttack() {
		return this.attack;
	}
	public double getDefence() {
		return this.defence;
	}
	
	public double getStealth() {
		return this.stealth;
	}
	
	@Override
	public String toString() {
		return "Name-"+  this.getName() + " AT-"+ this.getAttack() + " DF-" + this.getDefence() + " ST-" + this.stealth;
	}

	public boolean equals(Fighter fighter) {
		return this.getName().equals(fighter.getName());
	}
}

