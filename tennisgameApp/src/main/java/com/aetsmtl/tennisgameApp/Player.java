package com.aetsmtl.tennisgameApp;

public class Player {
	
	int points;
	String name;
	
	public Player(String name) {
		super();
		this.name = name;
		this.points = 0 ;
	}
	
	public void winService ()
	{
		this.points = this.points + 1 ;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
