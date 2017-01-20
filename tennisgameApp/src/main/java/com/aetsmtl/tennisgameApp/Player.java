package com.aetsmtl.tennisgameApp;

public class Player {
	
	int points;
	String name;
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public void winService ()
	{
		this.points = this.points + 1 ;
	}
	
}
