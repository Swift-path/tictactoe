package tictactoe;
import java.util.Scanner;
public class Ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** Pseudo code
		 * game board prints with 9 possible spots with promt
		 * variables defined as x and o
		 * players defined
		 * game loop starts to check for a winner
		 * game allows for player 1 to input a position for there specific charachter
		 * inputs new character on board and prints
		 * game allows for payer 2 to enter character
		 * inputs new character into game board and displays
		 * checks for winner
		 * as long as there is no winner code repeats
		 * 
		 * 
		 */
		char [][] gameBoard = new char [3][3];
		boolean player1 = true;
		System.out.println ("tictactoe");
	
		while (NoWinner(gameBoard )){
			printBoard(gameBoard);
			System.out.println("its " + WhoseTurn (player1) + " turn");
			gameBoard = Tic (gameBoard, player1);
			player1 = !player1;
		}
	 	
	}
	/**
	 * 
	 * @param gameBoard
	 */
		public static void printBoard(char[][] gameBoard) {
			String newLine = System.getProperty("line.separator");
			
			
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print ("[ " + gameBoard[x][y] + "]");
				}
				System.out.print(newLine);
				}
			}
		/**
		 * 
		 * @param gameBoard
		 * @param player1
		 * @return
		 */
		public static char[][] Tic(char[][] gameBoard, Boolean player1) {
			Scanner xi = new Scanner(System.in);
			Scanner yi = new Scanner (System.in);
			System.out.println("enetr x coordinate 0,1, or 2");
			int x = xi.nextInt();
			System.out.println("enter y coordinate 0,1, or 2");
			int y = yi.nextInt();
			if (player1 && gameBoard[x][y] != 'O') {
				gameBoard[x][y] = 'X';
			} else if (!player1 && gameBoard[x][y] != 'X') {
				gameBoard[x][y] = 'O';
			}
			return gameBoard;
			}
		/**
		 * 
		 * @param gameBoard
		 * @return
		 */
		public static boolean NoWinner(char[][] gameBoard) {
			int current;
			int last = 0;
			int counter = 0;
			int yDiag = 2;
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					current = gameBoard [x][y];
					
					if (last == current && last != 0){
						counter++; //how many in a row
					}
					if (counter == 2) {
						System.out.println("you win");
						return false;
			
				}
					last = current;
				}
			}
			counter = 0;
			for (int y = 0; y < 3; y++) { 
				for (int x = 0; x < 3; x++) { //horizontal patter
					current = gameBoard[x][y];
					if (last == current && last != 0) {
							counter++;
					}
				if (counter == 2) {
					System.out.println("You won!");
					return false;
				}
				last = current;
				}
			}
			counter = 0;
			for (int y = 0; y < 3; y++) { // check for a diagnal down pattern
	 			current = gameBoard[y][y];
	 			if (last == current && last != 0) {
	 				counter++;
	 			}
	 			if (counter == 2) {
	 				System.out.println("You won!");
	 				return false;
	 			}
	 			last = current;
	 		}
			counter = 0;
			for (int x = 0; x < 3; x++) { //diaganal up pattert
				current = gameBoard[x][yDiag];
				if (last == current && last !=0) {
					counter++;
				}
				if (counter == 2) {
					System.out.println("win!");
					return false;	
				}
				last = current;
				yDiag--;
			}
			return true;
		}
		/**
		 * 
		 * @param player1
		 * @return
		 */

			public static String WhoseTurn(boolean player1) {
				if (player1) {
					return "player 1";
				} else {
					return "player 2";
					}
			}
}

