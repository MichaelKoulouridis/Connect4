// Koulouridis Mixalis 3120082
package connect4;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
			int move;
		 	Board board = new Board();
		 	Players OPlayer = new Players(4,Board.O);
		 	
		 	board.print();
		 	while(!board.isTerminal()){
		 		System.out.println();
		 		switch(board.getLastLetterPlayed()){
		 		
		 			case Board.O:
		 				
		 				System.out.println("Γύρος Χρήστη με Χ");
		 				System.out.println("Χρησιμοποιειστε 0-6 για να παιξετε!");
		 				Scanner scanner = new Scanner(System.in);
		 				move = scanner.nextInt();
		 				board.makeMove(move, Board.X);
		 				board.print();
						System.out.println();
						break;
		 				
		 				
		 				
		 			case Board.X:
		 				
		 				System.out.println("Γυ�?ος Υπολογιστη με Ο");
		 				Move OMove = OPlayer.Minimax(board);
		 				board.makeMove(OMove.getCol(), Board.O);
		 				board.print();
		 				System.out.println();
		 				break;
		 				
		 		}
		 		
		 	}
	}
    
}	
