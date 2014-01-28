package com.ttt;

public class Player {
	int Id;
	private String playerName;
	private GamePiece gamePiece;
	
	public Player()
	{
		
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPiece(GamePiece gamePiece)
	{
		this.gamePiece = gamePiece;
	}
	
	public GamePiece getPiece()
	{
		return gamePiece;
	}
}
