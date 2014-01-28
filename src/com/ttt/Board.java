package com.ttt;

public class Board {
	int Id;
	private GridSlot[][] board;
	
	public Board()
	{
		this.board = new GridSlot[3][3];
		clearBoard();
	}
	
	public void showBoard()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				GridSlot gridSlot = (GridSlot)board[row][col];
				System.out.print("[" + (gridSlot.isEmpty() ? " " : gridSlot.getPiece()) + "] ");
			}
			System.out.println();
		}
	}
	
	public void showPositions()
	{
		System.out.println("\n===========================================\n");
		int positions = 0;
		
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				positions++;
				GridSlot gridSlot = (GridSlot)board[row][col];
				System.out.print("[" + (gridSlot.isEmpty() ? positions : gridSlot.getPiece()) + "] ");
			}
			System.out.println();
		}
		System.out.println("\n===========================================\n");
	}
	
	public void movePiece(GamePiece gamePiece, int row, int col)
	{
		GridSlot gridSlot = (GridSlot)board[row][col];
		gridSlot.setPiece(gamePiece);
	}
	
	public void revealWinner()
	{
		GamePiece winner = winner();
		
		if(winner != null)
		{
			System.out.println(winner.toString() + " Won");
			System.out.println("\n===========================================\n");
		}
	}
	
	public GamePiece winner()
	{
		GamePiece horizontalLines = checkHorizontalLines();
		GamePiece verticalLines = checkVerticalLines();
		GamePiece diagonalLines = checkDiagonalLines();
		
		if(horizontalLines != null)
		{
			return horizontalLines;
		}
		else if(verticalLines != null)
		{
			return verticalLines;
		}
		else if(diagonalLines != null)
		{
			return diagonalLines;
		}
		
		return null;
	}
	
	private GamePiece checkHorizontalLines()
	{
		GamePiece[] gamePieces = new GamePiece[board.length];
		
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				GridSlot gridSlot = (GridSlot)board[row][col];
				gamePieces[col] = gridSlot.getPiece();
			}
			
			if(gamePieces[0] == GamePiece.X && gamePieces[1] == GamePiece.X && gamePieces[2] == GamePiece.X)
			{
				return GamePiece.X;
			}
			else if(gamePieces[0] == GamePiece.O && gamePieces[1] == GamePiece.O && gamePieces[2] == GamePiece.O)
			{
				return GamePiece.O;
			}
		}
		return null;
	}
	
	private GamePiece checkVerticalLines()
	{
		if(((GridSlot)board[0][0]).getPiece() == GamePiece.X && ((GridSlot)board[1][0]).getPiece() == GamePiece.X && ((GridSlot)board[2][0]).getPiece() == GamePiece.X)
		{
			return GamePiece.X;
		}
		else if(((GridSlot)board[0][1]).getPiece() == GamePiece.X && ((GridSlot)board[1][1]).getPiece() == GamePiece.X && ((GridSlot)board[2][1]).getPiece() == GamePiece.X)
		{
			return GamePiece.X;
		}
		else if(((GridSlot)board[0][2]).getPiece() == GamePiece.X && ((GridSlot)board[1][2]).getPiece() == GamePiece.X && ((GridSlot)board[2][2]).getPiece() == GamePiece.X)
		{
			return GamePiece.X;
		}
		else if(((GridSlot)board[0][0]).getPiece() == GamePiece.O && ((GridSlot)board[1][0]).getPiece() == GamePiece.O && ((GridSlot)board[2][0]).getPiece() == GamePiece.O)
		{
			return GamePiece.O;
		}
		else if(((GridSlot)board[0][1]).getPiece() == GamePiece.O && ((GridSlot)board[1][1]).getPiece() == GamePiece.O && ((GridSlot)board[2][1]).getPiece() == GamePiece.O)
		{
			return GamePiece.O;
		}
		else if(((GridSlot)board[0][2]).getPiece() == GamePiece.O && ((GridSlot)board[1][2]).getPiece() == GamePiece.O && ((GridSlot)board[2][2]).getPiece() == GamePiece.O)
		{
			return GamePiece.O;
		}
		return null;
	}
	
	private GamePiece checkDiagonalLines()
	{
		if(((GridSlot)board[0][0]).getPiece() == GamePiece.X && ((GridSlot)board[1][1]).getPiece() == GamePiece.X && ((GridSlot)board[2][2]).getPiece() == GamePiece.X)
		{
			return GamePiece.X;
		}
		else if(((GridSlot)board[0][2]).getPiece() == GamePiece.X && ((GridSlot)board[1][1]).getPiece() == GamePiece.X && ((GridSlot)board[2][0]).getPiece() == GamePiece.X)
		{
			return GamePiece.X;
		}
		else if(((GridSlot)board[0][0]).getPiece() == GamePiece.O && ((GridSlot)board[1][1]).getPiece() == GamePiece.O && ((GridSlot)board[2][2]).getPiece() == GamePiece.O)
		{
			return GamePiece.O;
		}
		else if(((GridSlot)board[0][2]).getPiece() == GamePiece.O && ((GridSlot)board[1][1]).getPiece() == GamePiece.O && ((GridSlot)board[2][0]).getPiece() == GamePiece.O)
		{
			return GamePiece.O;
		}
		return null;
	}
	
	private void clearBoard()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				board[row][col] = new GridSlot();
			}
		}
	}
	
	public boolean isEmpty()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				GridSlot gridSlot = (GridSlot)board[row][col];
				if(!gridSlot.isEmpty())
				{
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean isFull()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				GridSlot gridSlot = (GridSlot)board[row][col];
				if(gridSlot.isEmpty())
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
