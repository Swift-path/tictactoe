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
		int[][] gameBoard = new int [3][3];
		boolean player1 = true;
		System.out.println ("tictactoe");
	
		while (NoWinner(gameBoard )){
			printBoard(gameBoard);
			System.out.println("its player " + player1+ " turn");
			gameBoard = Tic (gameBoard, player1);
			player1 = !player1;
		}
	 	
	}
		public static void printBoard(int[][] gameBoard) {
			String newLine = System.getProperty("line.separator");
			
			
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print ("[ " + gameBoard[x][y] + "]");
				}
				System.out.print(newLine);
				}
			}
		public static int[][] Tic(int[][] gameBoard, Boolean player1) {
			Scanner xi = new Scanner(System.in);
			Scanner yi = new Scanner (System.in);
			System.out.println("x coordinate");
			int x = xi.nextInt();
			System.out.println("y");
			int y = yi.nextInt();
			if (player1) {
				gameBoard[x][y] = 1;
			} else {
				gameBoard[x][y] = 2;
			}
			return gameBoard;
			}
		public static boolean NoWinner(int[][] gameBoard) {
			int current;
			int last = 0;
			int counter = 0;
			int yDiag = 2;
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					current = gameBoard [x][y];
					if (last == current && last != 0){
						counter++;
					}
					if (counter == 3) {
						System.out.println("you win");
						return false;
					}
				}
					last = current;
				}
				
			}
			for (int y = 0; y < 3; y++) { 
				for (int x = 0; x < 3; x++) {
					current = gameBoard[x][y];
					if (last == current && last != 0) {
							counter++;
					}
				
				if (counter == 3) {
				System.out.println("You won!");
				return false;
				}
				last = current;
				}
			for (int x = 0; x < 3; x++) {
				current = gameBoard[x][yDiag];
				
			}
		}
}

