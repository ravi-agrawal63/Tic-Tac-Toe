package ticTacToe;

import java.util.Scanner;
public class TicTacToe {
	private Player player1, player2;
	private Board board;
	private int numPlayers;
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
		
	}
	public void startGame() {
		// take players input
		Scanner s = new Scanner(System.in);
		player1 = takePlayerInput(++numPlayers);
		player2 = takePlayerInput(++numPlayers);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol alreadyy taken ! PLease enetr the correct symbol");
			player2.setSymbol(s.next().charAt(0));
			
		}
		
		//create the bard
		board = new Board(player1.getSymbol(), player2.getSymbol());
		
		// play the game
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		
		while(status == board.INCOMPLETE || status == board.INVALIDMOVE) {
			if(player1Turn) {
				System.out.print("Player1 -" + player1.getName() + "'s turn");
				System.out.println("Enter x :");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				
				status = Board.move(player1.getSymbol(),x, y);
				if(status == 5) {
					System.out.println("Invalid move! Plaese try gaing!!");
					continue;
				}else {
					player1Turn = false;
					
				}
				board.print();
				
			} 
			else {
				System.out.print("Player2 -" + player2.getName() + "'s turn");
				System.out.println("Enter x :");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				status = Board.move(player2.getSymbol(),x, y);
				if(status == 5) {
					System.out.println("Invalid move! Plaese try gaing!!");
					
				}else {
					player1Turn = true;
				
				}
				board.print();
				
			}
		}
		if(status == Board.PLAYER1WINS) {
			System.out.println("Player 1 _" + player1.getName() + " wins!!");
			
			
		}else if(status == Board.PLAYER2WINS) {
			System.out.println("Player 2 _" + player2.getName() + " wins!!");
			
		}
		
		
	}
	private Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player" + num + " name:");
		String name = s.nextLine();
		System.out.println("Enter Player" + num+ " Symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
		
	}

}
