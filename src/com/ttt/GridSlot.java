package com.ttt;

public class GridSlot {
	int Id;
	private GamePiece gamePiece;
	
	public GridSlot()
	{
		this.gamePiece = null;
	}
	
	public void setPiece(GamePiece gamePiece)
	{
		if(isEmpty())
		{
			this.gamePiece = gamePiece;
		}
	}
	
	public boolean isEmpty()
	{
		return gamePiece == null;
	}
	
	public GamePiece getPiece()
	{
		return gamePiece;
	}
}
