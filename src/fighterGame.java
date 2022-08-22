import java.util.Scanner;

public class fighterGame {

		public static void main(String args[]) throws InterruptedException {
			fighterGame fg = new fighterGame();
		}
		
		private fighterGame() throws InterruptedException {

			
			//Getting data from excel file to a fileStructure class. (User implemented class to manage data from file)
			fileStructure fc = new fileGraph("src/characters.csv");
			
			//Uncomment next line to Check data extracted:
//			System.out.println(fc.adj);
			
			System.out.print("Enter User Name:");
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			System.out.println("\t\t|||----------------------|||");
			System.out.println("\t\t||| C M D  F I G H T E R |||");
			System.out.println("\t\t|||----------------------|||");
			System.out.println();
			System.out.println("\tWelcome " + name.toUpperCase() + ", time to learn how to play!.");
			Thread.sleep(3000);
			System.out.println("This current build has only PvE, which means you can only play against a computer.");
			System.out.println("Multiplayer/PvP coming in a later build...");
			System.out.println("-------------------------------------------");
			System.out.println("How to Play: ");
			System.out.println("1 _ The 2 Players will shuffle through a set of characters...");
			System.out.println("2 _ Every round either you or the opponent will get to choose the attribute.");
			System.out.println("3 _ Your job is to have a higher value in that attribute. Like trading cards.");
			System.out.print("*Question* Would you like a Demo...enter(Y/N)");
			String response = sc.nextLine();
			
			while(true) {
				if(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes")) {
					System.out.println();
					System.out.println("DEMO START");
					System.out.println("(The Brackets hold dialogues, Enter to continue)");
					response = sc.nextLine();
					System.out.println("Game BEGINS...");
					Thread.sleep(1000);
					System.out.println();
					System.out.println("****************************************************");
					System.out.println("*  Your character is : SAMURAI AT:20 DF:60 ST:200  *"); 
					System.out.println("****************************************************");
					System.out.println("(This will present you with your character with a name[SAMURAI]");
					System.out.println("the attack value[AT], the defense value[DF], the stealth value[ST])");
					System.out.println();
					System.out.println("Enter to continue");
					response = sc.nextLine();
					System.out.println("**************************");
					System.out.println("*  Choose an attribute!  *");
					System.out.println("**************************");
					System.out.println("(Here its your turn to choose so you can choose an attribute that you think will be more than your opponent's.");
					System.out.println("Choosing your highest value would be the smart play. If its your opponents turn...well...Hope you have a higher one!");
					System.out.println("You can enter AT for attack, DF for defense, ST for stealth, in this example lets say you chose ST.)");
					
					System.out.println();
					System.out.println("Enter to continue");
					response = sc.nextLine();
					
					System.out.println();
					System.out.println("********************************");
					System.out.println("*  You have chosen STEALTH...  *");
					System.out.println("********************************");
					
					Thread.sleep(1000);
					System.out.println("Deciding winner...");
					Thread.sleep(2500);
					System.out.println(">> Winner of this round is : COMPUTER <<");
					
					System.out.println("(In this case sadly the opponent had value higher than 200, so they won...");
					System.out.println("But dont worry, just play again :D )");
					System.out.println();
					System.out.println("Enter to continue");
	
					response = sc.nextLine();
					System.out.println("DEMO END");
					System.out.println("----------------------------------------------------------------");
				} else {
					break;
				}
				// Code to setup the player
				System.out.print("*Question* Do you want to replay the DEMO if you're unsure how to play? Enter (Y/N)");
				response = sc.nextLine();
				if(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("no") || response.equalsIgnoreCase("nah")) {
					break;
				}
			}
			
//			// The actual Game code
			System.out.println();
			System.out.println("*Question* How many rounds? (Enter number in 1 - 8)");
			response = sc.nextLine();
			int rounds;
			while(true) {
				try {
					 rounds = Integer.parseInt(response);
					if(rounds < 1 || rounds > 8 ) {
						throw new IllegalArgumentException();
					}
					break;
				} catch (Exception e) {
					System.out.println("Enter valid number of rounds please (1-8)");
					response = sc.nextLine();
				}
			}
			System.out.println("Lets get the TERMINAL ready !");
			Thread.sleep(3000);
			System.out.print("\033\143");
			System.out.println();
			System.out.println("************");
			System.out.println("* STARTING *");
			System.out.println("************");
			Thread.sleep(1000);
			System.out.println();
			System.out.print("3");
			for(int i = 0; i < 3; i++) {System.out.print(".");Thread.sleep(333);}
			System.out.print("2");
			for(int i = 0; i < 3; i++) {System.out.print(".");Thread.sleep(333);}
			System.out.print("1");
			for(int i = 0; i < 3; i++) {System.out.print(".");Thread.sleep(333);}
			
			
			System.out.println();
			Thread.sleep(2000);
			int round ;
			for( round = 1; round <= rounds; round++) {
				
			System.out.println("Lets Go! Round " + round);
			
			Fighter player1 = getFighter(fc);
			Fighter playerComp = getFighter(fc);
			while(playerComp.equals(player1)) {playerComp = getFighter(fc);}
			
			System.out.println("**********************************************************");
			System.out.println("Your character is : " + player1.getName() + " AT:" + player1.getAttack() + " DF:" + player1.getDefence() + " ST:"+player1.getStealth()); 
			System.out.println("**********************************************************");

			
			
			
			//Attribute get and processing
			System.out.println("*  Enter an attribute !  *");
			String attribute = sc.nextLine();
			int breaker = 0;
			int cmp = 0;
			
			while( breaker < 20) {
				if(attribute.equalsIgnoreCase("at") || attribute.equalsIgnoreCase("attack")) {
					cmp = compareAttribute(player1.getAttack(),playerComp.getAttack());
					break;
				} else if (attribute.equalsIgnoreCase("df") || attribute.equalsIgnoreCase("defence")){
					cmp = compareAttribute(player1.getDefence(),playerComp.getDefence());
					break;
				} else if (attribute.equalsIgnoreCase("st") || attribute.equalsIgnoreCase("stealth")){
					cmp = compareAttribute(player1.getStealth(),playerComp.getStealth());
					break;
				} else {
					System.out.println("!! Please select a valid attribute ('at' or 'df' or 'st') !!");
					attribute = sc.nextLine();
				}
				breaker++;
			}
			System.out.println();
			
			System.out.println("                *** R o u n d   ["+ round + "/" + rounds+ "]   r e s u l t  ***" );
			whoWon(cmp);
			System.out.println("	Your character was : " + player1.getName() + " AT:" + player1.getAttack() + " DF:" + player1.getDefence() + " ST:"+player1.getStealth()); 
			System.out.println("	Your Opponent was : " + playerComp.getName() + " AT:" + playerComp.getAttack() + " DF:" + playerComp.getDefence() + " ST:"+playerComp.getStealth()); 
			System.out.println("	You chose to play : " + attribute);
			System.out.println("");
			if(round < rounds) {
				System.out.println("Press enter to go the next round...");
			}
			sc.nextLine();
			}
			System.out.println("******GAME OVER!******");
			Thread.sleep(1000);
			System.out.println("Clearing terminal...");
			Thread.sleep(2000);
			System.out.print("\033\143");
		}
		
		private static void whoWon(int cmp) throws InterruptedException {
			
			if(cmp < 0) {
				System.out.println("                   ****** Y o u   L o s t ! ******");
			} else if (cmp > 0) {
				System.out.println("                    ****** Y o u   W o n ! ******");
			} else {
				System.out.println("                       ****** D R A W ! ******");
			}
			System.out.println();
		}
		
		private static int compareAttribute(double p1, double comp) {
			if(p1 > comp) {
				return 1;
			} else if (p1 < comp) {
				return -1;
			} else {
				return 0;
			}
		}
		
		private static Fighter getFighter(fileStructure fc) {
			
			int randomNum = (int) Math.floor(Math.random() *fc.E);
			return fc.adj.get(randomNum);
		}
	
	    public static void ClearConsole(){
	        try{
	            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
	              
	            if(operatingSystem.contains("Windows")){        
	                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
	                Process startProcess = pb.inheritIO().start();
	                startProcess.waitFor();
	            } else {
	                ProcessBuilder pb = new ProcessBuilder("clear");
	                Process startProcess = pb.inheritIO().start();

	                startProcess.waitFor();
	            } 
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }
		
		
}
