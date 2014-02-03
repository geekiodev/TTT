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
				System.out.print("[" + (gridSlot.isEmpty() ? " " : gridSlot.getState()) + "] ");
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
				System.out.print("[" + (gridSlot.isEmpty() ? positions : gridSlot.getState()) + "] ");
			}
			System.out.println();
		}
		System.out.println("\n===========================================\n");
	}
	
	public void movePiece(SlotState gamePiece, int row, int col)
	{
		GridSlot gridSlot = (GridSlot)board[row][col];
		gridSlot.setState(gamePiece);
	}
	
	public void revealWinner()
	{
		SlotState winner = winner();
		
		if(winner != null)
		{
			System.out.println(winner.toString() + " Won");
			System.out.println("\n===========================================\n");
		}
	}
	
	public SlotState winner()
	{
		SlotState horizontalLines = checkHorizontalLines();
		SlotState verticalLines = checkVerticalLines();
		SlotState diagonalLines = checkDiagonalLines();
		
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
	
	private SlotState checkHorizontalLines()
	{
		GridSlot[] gridSlots = new GridSlot[board.length];
		
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board.length; col++)
			{
				GridSlot gridSlot = (GridSlot)board[row][col];

				gridSlots[col] = gridSlot;
			}

			if(!gridSlots[0].isEmpty() && gridSlots[0].getState().equals(gridSlots[1].getState()) && gridSlots[1].getState().equals(gridSlots[2].getState()))
			{
				return gridSlots[0].getState();
			}
		}
		return null;
	}
	
	private SlotState checkVerticalLines()
	{
		if(!((GridSlot)board[0][0]).isEmpty() && ((GridSlot)board[0][0]).getState().equals(((GridSlot)board[1][0]).getState()) && ((GridSlot)board[1][0]).getState().equals(((GridSlot)board[2][0]).getState()))
		{
			return ((GridSlot)board[0][0]).getState();
		}
		else if(!((GridSlot)board[0][1]).isEmpty() && ((GridSlot)board[0][1]).getState().equals(((GridSlot)board[1][1]).getState()) && ((GridSlot)board[1][1]).getState().equals(((GridSlot)board[2][1]).getState()))
		{
			return ((GridSlot)board[0][1]).getState();
		}
		else if(!((GridSlot)board[0][2]).isEmpty() && ((GridSlot)board[0][2]).getState().equals(((GridSlot)board[1][2]).getState()) && ((GridSlot)board[1][2]).getState().equals(((GridSlot)board[2][2]).getState()))
		{
			return ((GridSlot)board[0][2]).getState();
		}
		return null;
	}
	
	private SlotState checkDiagonalLines()
	{
		if(!((GridSlot)board[0][0]).isEmpty() && ((GridSlot)board[0][0]).getState().equals(((GridSlot)board[1][1]).getState()) && ((GridSlot)board[1][1]).getState().equals(((GridSlot)board[2][2]).getState()))
		{
			return ((GridSlot)board[0][0]).getState();
		}
		else if(!((GridSlot)board[0][2]).isEmpty() && ((GridSlot)board[0][2]).getState().equals(((GridSlot)board[1][1]).getState()) && ((GridSlot)board[1][1]).getState().equals(((GridSlot)board[2][0]).getState()))
		{
			return ((GridSlot)board[0][2]).getState();
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
