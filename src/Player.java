
public class Player {
	
	private String fighterChoice;
	private Fighter fighter;
	private int HEALTH = 100;
	
	private Player() {}
	public Player(String fighterChoice) {
		this.fighterChoice = fighterChoice;
//		if(fighterChoice.equalsIgnoreCase("S") || fighterChoice.equalsIgnoreCase("Samurai")) {
//			this.fighter = new Fighter();
//		} else {
//			this.fighter = new Fighter();
//		}
	}
//	
//	public String getFighterName() {
//		return this.fighter.getName();
//	}
//	
//	public String getAttack(String num) {
//		return  " Ability : " +  this.fighter.getAttackName(num);
//	}
//	public int getDamage(String num) {
//		return this.fighter.getAttackDamage(num); 
//	}
}
