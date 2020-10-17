// Aakash Shetty
// Period 3
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Monopoly {
	private static final int BOARDSIZE = 28;
	private static SquareType[] board = new SquareType[BOARDSIZE];
	private ArrayList<card> deck = new ArrayList<card>();
	public static void main(String[] args) {
		int dice1;
		int dice2;
		Monopoly monopoly = new Monopoly();
		monopoly.startGame();
		Player one = new Player("Player One");
		Player two = new Player("Player Two");
		board[one.getPosition()].setPlayer1(true);
		board[two.getPosition()].setPlayer2(true);
		boolean gameIsOver = false;
		while(!gameIsOver) {
			monopoly.displayBoard();
			System.out.println("Player 1 has $" + one.getMoney() + ". Player 2 has $ " + two.getMoney());
			while(one.getMoney() > 0) {
				System.out.println("PLAYER 1: WHAT WOULD YOU LIKE TO DO?");
				System.out.println("1. ROLL DICE");
				System.out.println("2. SELL PROPERTY");
				System.out.println("3. SELL RAILROAD");
				
				Scanner sc = new Scanner(System.in);
				int selection = sc.nextInt();
				
				if(selection == 2) {
					monopoly.sellProperty(one);
				} else if(selection == 3) {
					monopoly.sellRailRoad(one);
				}
				
				int orig = one.getPosition();
				dice1 = 1+ (int)(Math.random() * 6);
				dice2 = 1+ (int)(Math.random() * 6);
				if(monopoly.checkSquare(one) == "J" && one.isInJail()) {
					if(dice1 == dice2) {
						one.sendPosition(dice1 + dice2);
					}
				} else {
					int roll = 1;
					int total = dice1 + dice2;
					System.out.println(dice1 + " + " + dice2);
					
					while(roll < 3) {
						if(dice1 == dice2) {
							dice1 = 1+ (int)(Math.random() * 6);
							dice2 = 1+ (int)(Math.random() * 6);
							total += dice1 + dice2;
							roll++;
						} else {
							break;
						}
					}
					
		/*			int t = 1;
					int total = 0;
					while(t < 3) {
						total = total + dice1 + dice2;
						t++;
						if(dice1 == dice2) {
							dice1 = 1+ (int)(Math.random() * 6);
							dice2 = 1+ (int)(Math.random() * 6);
						}
					}*/
					//board[orig].setPlayer1(false);
					if(roll == 3) {
						one.sendPosition(7);
						one.setJail(true);
					}else {
						one.addPosition(total);
					}
					//board[one.getPosition()].setPlayer1(true);
				}
				
				monopoly.movesquare(one, orig, one.getPosition());
				
				System.out.println();
				monopoly.displayBoard();
				System.out.println("Player 1 has $" + one.getMoney() + ". Player 2 has $ " + two.getMoney());
				
				if(monopoly.checkSquare(one) == "P") {
					monopoly.maybeTransaction(one, two);
				}
				else if(monopoly.checkSquare(one) == "GTJ") {
					one.sendPosition(7);
					one.setJail(true);
				}
				else if(monopoly.checkSquare(one) == "LT") {
					monopoly.payLT(one);
				}
				else if(monopoly.checkSquare(one) == "C") {
					int num = monopoly.drawCard(); 
					if(num == 1) {
						one.sendPosition(7);
						one.setJail(true);
					} else if(num == 2) {
						one.sendPosition(0);
						one.addMoney(200);
					} else if(num == 3) {
						one.addMoney(50);
					} else {
						one.sendPosition(orig - 3);
					}
				}
				else if(monopoly.checkSquare(one) == "U") {
					monopoly.maybeTransactionU(one);
				} else if(monopoly.checkSquare(one) == "RR") {
					monopoly.maybeTransactionRR(one);
				}
				if(one.getNumber() > 0) {
					monopoly.improveProperties(one);
				}
				
				System.out.print("WOULD YOU LIKE TO END YOUR TURN PLAYER 1? (Y/N): ");
				String response = sc.next();
				
				if(response.equalsIgnoreCase("Y")) {
					break;
				}
			}
			
			System.out.println();
			monopoly.displayBoard();
			System.out.println("Player 1 has $" + one.getMoney() + ". Player 2 has $ " + two.getMoney());
			
			while(two.getMoney() > 0) {
				//System.out.println(orig);
				// Player 2 playing
				int orig = two.getPosition();
				dice1 = 1+ (int)(Math.random() * 6);
				dice2 = 1+ (int)(Math.random() * 6);
				if(monopoly.checkSquare(two) == "J" && two.isInJail()) {
					if(dice1 == dice2) {
						one.sendPosition(dice1 + dice2);
					}
				}else {
					int roll = 1;
					int total = dice1 + dice2;
					System.out.println(dice1 + " + " + dice2);
					
					while(roll < 3) {
						if(dice1 == dice2) {
							dice1 = 1+ (int)(Math.random() * 6);
							dice2 = 1+ (int)(Math.random() * 6);
							total += dice1 + dice2;
							roll++;
						} else {
							break;
						}
					}
					//board[orig].setPlayer2(false);
					if(roll == 3) {
						two.sendPosition(7);
						two.setJail(true);
					}else {
					two.addPosition(total);
					}
					//board[two.getPosition()].setPlayer2(true);
				}
				
				monopoly.movesquare(two, orig, two.getPosition());

				System.out.println();
				monopoly.displayBoard();
				System.out.println("Player 1 has $" + one.getMoney() + ". Player 2 has $ " + two.getMoney());
				
				if(monopoly.checkSquare(two) == "P") {
					monopoly.maybeTransaction(two, one);
				}
				else if(monopoly.checkSquare(two) == "GTJ") {
					two.setPosition(14);
					two.setJail(true);
				}
				else if(monopoly.checkSquare(two) == "LT") {
					monopoly.payLT(two);
				}
				else if(monopoly.checkSquare(two) == "C") {
					int num = monopoly.drawCard(); 
					if(num == 1) {
						two.sendPosition(7);
						two.setJail(true);
					} else if(num == 2) {
						two.sendPosition(0);
						two.addMoney(200);
					} else if(num == 3) {
						two.addMoney(50);
					} else {
						two.sendPosition(orig - 3);
					}
				}
				if(two.getNumber() > 0) {
					monopoly.improveProperties(two );
				}
				
				Scanner sc = new Scanner(System.in);
				System.out.print("WOULD YOU LIKE TO END YOUR TURN PLAYER 2? (Y/N): ");
				String response = sc.next();
				
				if(response.equalsIgnoreCase("Y")) {
					break;
				}
			}
		}
	}
	
	public void sellRailRoad(Player p) {
		Scanner sc = new Scanner(System.in);
		p.addRailRoad((RailRoad)board[4]);
		p.addRailRoad((RailRoad)board[11]);
		RailRoad[] rs = p.getRailRoads();
		for(int i = 0; i < rs.length - 1; i++) {
			System.out.print((i + 1) + ": " + rs[i].getName() + ", ");
		}
		System.out.print(rs.length + ": " + rs[rs.length - 1].getName() + "\n");
		System.out.println("WHICH RAILROAD WOULD YOU LIKE TO SELL?");
		int railroadSelection = sc.nextInt();
		RailRoad rr = p.getRailRoad(railroadSelection - 1);
		p.addMoney(rr.getMortgage());
		p.removeProperty(railroadSelection - 1);
	}
	
	public void sellProperty(Player p) {
		Scanner sc = new Scanner(System.in);
		p.addProperty((Property)board[1]);
		p.addProperty((Property)board[2]);
		p.addProperty((Property)board[5]);
		p.addProperty((Property)board[6]);
		Property[] ps = p.getProperties();
		for(int i = 0; i < ps.length - 1; i++) {
			System.out.print((i + 1) + ": " + ps[i].getName() + ", ");
		}
		System.out.print(ps.length + ": " + ps[ps.length - 1].getName() + "\n");
		System.out.println("WHICH PROPERTY WOULD YOU LIKE TO SELL?");
		int propertySelection = sc.nextInt();
		Property pr = p.getProperty(propertySelection - 1);
		p.addMoney(pr.getMortgage());
		p.removeProperty(propertySelection - 1);
	}
	
	public void startGame() {
		System.out.println("WELCOME TO MONOPOLY");
		initializeBoard();
		initializeDeck();
	}
	// Creating the board array
	private void initializeBoard() {
		board[0] = new Go();
		board[1] = new Property("Prop1A", 0);
		board[2] = new Property("Prop1B", 0);
		board[3] = new Chance();
		board[4] = new RailRoad("Read");
		board[5] = new Property("Prop1C", 0);
		board[6] = new Property("Prop1C", 0);
		board[7] = new Jail();
		board[8] = new Property("Prop2A", 0);
		board[9] = new Property("Prop2B", 0);
		board[10] = new Utility();
		board[11] = new RailRoad("Write");
		board[12] = new Property("Prop2C", 0);
		board[13] = new Property("Prop2D", 0);
		board[14] = new FreeParking();
		board[15] = new Property("Prop3A", 0);
		board[16] = new Property("Prop3B", 0);
		board[17] = new Chance();
		board[18] = new RailRoad("Math");
		board[19] = new Property("Prop3C", 0);
		board[20] = new Property("Prop3D", 0);
		board[21] = new GoToJail();
		board[22] = new Property("Prop4A", 0);
		board[23] = new Property("Prop4B", 0);
		board[24] = new LuxuryTax();
		board[25] = new RailRoad("Science");
		board[26] = new Property("Prop4C", 0);
		board[27] = new Property("Prop4D", 0);
	}
	// Displaying the board each time
	private void displayBoard() {
		int divider = 5;
		int index = 0;
		int index2 = board.length - 1;
		for(int i = 0; i < divider*((BOARDSIZE/4) + 1) + 2; i++) {
			if(i == 0 || i == divider*((BOARDSIZE/4) + 1) + 1) {
				System.out.println("+------+------+------+------+------+------+------+------+");
			} else {
				if(i == 1) {
					System.out.println("|" + printPiece(board[index++]) + "|" + printPiece(board[index++]) +
					"|" + printPiece(board[index++]) + "|" + printPiece(board[index++]) + "|" + printPiece(board[index++]) +
					"|" + printPiece(board[index++]) + "|" + printPiece(board[index++]) + "|" + printPiece(board[index++]) + "|");
					index = 0;
					System.out.println("|  " + board[index].getPlayer1() + board[index++].getPlayer2() + "  |  " + board[index].getPlayer1()  + board[index++].getPlayer2() +
							"  |  " + board[index].getPlayer1()  + board[index++].getPlayer2() + "  |  " + board[index].getPlayer1()  + board[index++].getPlayer2() + "  |  " + board[index].getPlayer1() + board[index++].getPlayer2() +
							"  |  " + board[index].getPlayer1()  + board[index++].getPlayer2() + "  |  " + board[index].getPlayer1() + board[index++].getPlayer2()  + "  |  " + board[index].getPlayer1()  + board[index++].getPlayer2() + "  |");
					System.out.println("|      | " + printProperty((Property)board[1]) + " | " + printProperty((Property)board[2]) + " |      |      | " + printProperty((Property)board[5]) + " | " + printProperty((Property)board[6]) 
					+ " |      |");
				} else if (i == 6) {
					int index3 = index;
					int index4 = index2;
					System.out.println("+------+------+------+------+------+------+------+------+");
					System.out.println("|" + printPiece(board[index2--]) + "|                                         |" + 
				printPiece(board[index++]) + "|");
					System.out.println("|  " + board[index4].getPlayer1() + board[index4--].getPlayer2() + "  |                                         |  " + 
							board[index3].getPlayer1() + board[index3++].getPlayer2() + "  |");
				} else if((i - 1) % divider == 0 && i >= 6 && i <= 31) {
					int index3 = index;
					int index4 = index2;
					System.out.println("+------+                                         +------+");
					System.out.println("|" + printPiece(board[index2--]) + "|                                         |" + 
				printPiece(board[index++]) + "|");
					System.out.println("|  " + board[index4].getPlayer1() + board[index4--].getPlayer2() + "  |                                         |  " + 
							board[index3].getPlayer1() + board[index3++].getPlayer2() + "  |");
				} else if(i == 36) {
					int index4 = index2;
					System.out.println("+------+------+------+------+------+------+------+------+");
					System.out.println("|" + printPiece(board[index2--]) + "|" + printPiece(board[index2--]) +
							"|" + printPiece(board[index2--]) + "|" + printPiece(board[index2--]) + "|" + printPiece(board[index2--]) +
							"|" + printPiece(board[index2--]) + "|" + printPiece(board[index2--]) + "|" + printPiece(board[index2--]) + "|");
					System.out.println("|  " + board[index4].getPlayer1() + board[index4--].getPlayer2() + "  |  " + board[index4].getPlayer1()  + board[index4--].getPlayer2() +
							"  |  " + board[index4].getPlayer1()  + board[index4--].getPlayer2() + "  |  " + board[index4].getPlayer1()  + board[index4--].getPlayer2() + "  |  " + board[index4].getPlayer1() + board[index4--].getPlayer2() +
							"  |  " + board[index4].getPlayer1()  + board[index--].getPlayer2() + "  |  " + board[index4].getPlayer1() + board[index4--].getPlayer2()  + "  |  " + board[index4].getPlayer1()  + board[index4--].getPlayer2() + "  |");
					System.out.println("|      | " + printProperty((Property)board[20]) + " | " + printProperty((Property)board[19]) + " |      |      | " + printProperty((Property)board[16]) + " | " + printProperty((Property)board[15]) 
					+ " |      |");
				} else {
					System.out.println("|      |                                         |      |");
				}
				
				if(i == 6) {
					System.out.println("| " + printProperty((Property)board[27]) + " |                                         | " +  printProperty((Property)board[8]) + " |");
				} else if(i == 11) {
					System.out.println("| " + printProperty((Property)board[26]) + " |                                         | " +  printProperty((Property)board[9]) + " |");
				} else if(i == 26) {
					System.out.println("| " + printProperty((Property)board[23]) + " |                                         | " +  printProperty((Property)board[12]) + " |");
				} else if(i == 31) {
					System.out.println("| " + printProperty((Property)board[22]) + " |                                         | " +  printProperty((Property)board[13]) + " |");
				}
			}
		}
	}
	public String printPiece(SquareType s) {
		if(s == null) {
			return "";
		}
		return (s.getName() + "       ").substring(0,6);
	}
	
	public String printProperty(Property p) {
		if(p.getHotel()) {
			return "H   ";
		} else {
			String house = "";
			for(int i = 0; i < p.getHouses(); i++) {
				house += "h";
			}
			house += "    ";
			return house.substring(0,4);
		}
	}
	// creating Chance deck
	private void initializeDeck() {
		//card a = new card("Go to Go", 1);
		card b = new card("Go to Jail", 1);
		//card c = new card("Get out of Jail Free", 3);
		card d = new card("Advance to Go", 2);
		card e = new card("Bank pays you dividend of $50", 3);
		card f = new card("Go Back Three {3} Spaces.", 4);
		
		//deck.add(a);
		deck.add(b);
		//deck.add(c);
		deck.add(d);
		deck.add(e);
		deck.add(f);
	}
	private String checkSquare(Player p) {
		// Checking if the square is a Property
		if(board[p.getPosition()] instanceof Property) {
			return "P";
		}
		// Checking if the square is the Go to Jail space
		else if(board[p.getPosition()] instanceof GoToJail) {
			return "GTJ";
		}
		// Checking if the square is the Go space
		else if(board[p.getPosition()] instanceof Go) {
			return "G";
		}
		// Checking if the square is the Luxury Tax space
		else if(board[p.getPosition()] instanceof LuxuryTax) {
			return "LT";
		}
		// Checking if the square is the Jail Space
		else if(board[p.getPosition()] instanceof Jail) {
			return "J";
		}
		// Checking if the square is
		else if(board[p.getPosition()] instanceof Chance) {
			return "C";
		}
		else if(board[p.getPosition()] instanceof Utility) {
			return "U";
		}
		else if(board[p.getPosition()] instanceof RailRoad) {
			return "RR";
		}
		// Else is Free Parking
		else {
			return "FP";
		}
	}
	// Property Transaction
	private void maybeTransaction(Player p, Player p1) {
		Scanner sc = new Scanner(System.in);
		if(board[p.getPosition()] instanceof Property){
			// If the property is not owned already
			if(board[p.getPosition()].getOwner() == 0) {
				System.out.println("Would you like to buy this property, " + p.getName() + "? 1. Yes 2. No");
				int c = sc.nextInt();
				if(c == 1) {
					if(p.getName() == "Player One") {
						board[p.getPosition()].setOwner(1);
					}
					if(p.getName() == "Player Two") {
						board[p.getPosition()].setOwner(2);
					}
					Property a =(Property) board[p.getPosition()];
					p.addProperty(a);
				}
				else {
					System.out.print("");
				}
			}
			// If the property is owned by Player One and Player Two lands on it
			else if(board[p.getPosition()].getOwner() == 1 && p.getName().equals("Player Two")) {
				Property a = (Property) board[p.getPosition()];
				p.Pay(a.getRent());
				p1.addMoney(a.getRent());
			}
			// If the property is owned by Player Two and Player One lands on it
			else if(board[p.getPosition()].getOwner() == 2 && p.getName().equals("Player One")) {
				Property a = (Property) board[p.getPosition()];
				p.Pay(a.getRent());
				p1.addMoney(a.getRent());
			}
		}
	}
	
	public void maybeTransactionRR(Player p) {
		Scanner sc = new Scanner(System.in);
		if(board[p.getPosition()].getOwner() == 0) {
			RailRoad r = (RailRoad) board[p.getPosition()];
			p.addRailRoad(r);
			if(p.getName().equals("Player One")) {
				board[p.getPosition()].setOwner(1);
			}
			else {
				board[p.getPosition()].setOwner(2);
			}
			p.Pay(r.getPrice());
		}
		else if(board[p.getPosition()].getOwner() == 1 && p.getName().equals("Player Two")){
			
		}
		else if(board[p.getPosition()].getOwner() == 2 && p.getName().equals("Player One")) {
			
		}
	}
	// Luxury Tax payment when landing
	private void payLT(Player p) {
		LuxuryTax a = (LuxuryTax) board[p.getPosition()];
		p.Pay(a.getPrice());
	}
	// Chance Space
	private int drawCard() {
		return (int) (Math.random() * deck.size()) + 1;
	}
	private void improveProperties(Player p) {
		Scanner sc = new Scanner(System.in);
		int a  = 0;
		while(a < 28) {
			if(board[a] instanceof Property) {
				if(p.getName().equals("Player One")) {
					if(board[a].getOwner() == 1) {
						Property b = (Property) board[a];
						System.out.println(a + ")" + board[a].getName());
					}
				}else{
					if(board[a].getOwner() == 2) {
						System.out.println(a + ")" + board[a].getName());
					}
				}
			}
		}
	}
	private void maybeTransactionU(Player p) {
		Scanner sc = new Scanner(System.in);
		if(board[p.getPosition()].getOwner() == 0) {
			Utility a = (Utility) board[p.getPosition()];
			p.setUtility(true);
			if(p.getName().equals("Player One")) {
				board[p.getPosition()].setOwner(1);
			}
			else {
				board[p.getPosition()].setOwner(2);
			}
			p.Pay(a.getPrice());
		}
		else if(board[p.getPosition()].getOwner() == 1 && p.getName().equals("Player Two")){
			
		}
		else if(board[p.getPosition()].getOwner() == 2 && p.getName().equals("Player One")) {
			
		}
	}
	private void movesquare(Player p, int orig, int fin) {
		if(p.getName().equals("Player One")) {
			board[orig].setPlayer1(false);
			board[fin].setPlayer1(true);
		}
		else {
			board[orig].setPlayer2(false);
			board[fin].setPlayer2(true);
		}
	}
}