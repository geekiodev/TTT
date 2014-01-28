package com.ttt;

import java.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board board = new Board();
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Player 1 please enter your name: ");
		
		Player player1 = new Player();
		player1.setPlayerName(reader.nextLine());
		player1.setPiece(GamePiece.X);
		System.out.println("Welcome " + player1.getPlayerName() + "\n");
		
		System.out.println("Player 2 please enter your name: ");
		Player player2 = new Player();
		player2.setPlayerName(reader.nextLine());
		player2.setPiece(GamePiece.O);
		System.out.println("Welcome " + player2.getPlayerName() + "\n");
		
		Player currentPlayer = player1;
		
		board.showPositions();
		
		
		while(board.winner() == null)
		{
			board.showPositions();
			
			System.out.println(currentPlayer.getPlayerName() + " your move...");
			
			int selection = reader.nextInt();
			
			
			switch(selection)
			{
				case 1:
					board.movePiece(currentPlayer.getPiece(), 0, 0);
					break;
				case 2:
					board.movePiece(currentPlayer.getPiece(), 0, 1);
					break;
				case 3:
					board.movePiece(currentPlayer.getPiece(), 0, 2);
					break;
				case 4:
					board.movePiece(currentPlayer.getPiece(), 1, 0);
					break;
				case 5:
					board.movePiece(currentPlayer.getPiece(), 1, 1);
					break;
				case 6:
					board.movePiece(currentPlayer.getPiece(), 1, 2);
					break;
				case 7:
					board.movePiece(currentPlayer.getPiece(), 2, 0);
					break;
				case 8:
					board.movePiece(currentPlayer.getPiece(), 2, 1);
					break;
				case 9:
					board.movePiece(currentPlayer.getPiece(), 2, 2);
					break;
			}
			
			// switch user after each move
			currentPlayer = (currentPlayer == player1) ? player2 : player1;
		}
		
		GamePiece winner = board.winner();
		
		if(winner != null)
		{
			System.out.println("\n===========================================\n");
			
			System.out.println(winner.toString() + " Won");
			
			board.showPositions();
			
			System.out.println("\n===========================================\n");
		}
	}

}
