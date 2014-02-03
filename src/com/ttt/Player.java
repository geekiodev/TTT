package com.ttt;

public class Player {
	int Id;
	private String playerName;
	private SlotState gamePiece;
	
	public Player()
	{
		
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPiece(SlotState gamePiece)
	{
		this.gamePiece = gamePiece;
	}
	
	public SlotState getPiece()
	{
		return gamePiece;
	}
}
