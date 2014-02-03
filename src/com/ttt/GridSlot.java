package com.ttt;

public class GridSlot {
	int Id;
	private SlotState state;
	
	public GridSlot()
	{
		this.state = SlotState.Empty;
	}
	
	public void setState(SlotState state)
	{
		if(isEmpty())
		{
			this.state = state;
		}
	}
	
	public boolean isEmpty()
	{
		return state == SlotState.Empty || state == null;
	}
	
	public SlotState getState()
	{
		return state;
	}
}
