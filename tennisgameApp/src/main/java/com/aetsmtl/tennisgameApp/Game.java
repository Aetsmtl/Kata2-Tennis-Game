package com.aetsmtl.tennisgameApp;

import java.util.Arrays;
import java.util.List;

public class Game {
	
	public Player player1, player2;
	public static final List<String> pointsEquivalence = Arrays.asList("love", "fifteen", "thirty", "forty");
	
	public Game(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}

	public String giveCurrentlyResult (Player pOne, Player pTwo)
	{
		if (pOne.getPoints() >= 3 && pTwo.getPoints() >= 3) 
		{
            if (Math.abs(pTwo.getPoints() - pOne.getPoints()) >= 2) 
            {
                return whoIsLeadingPlayer() + " is the winner";
            } else if (pTwo.getPoints() == pOne.getPoints()) {
                return "deuce";
            } else {
                return "advantage For : " + whoIsLeadingPlayer();
            }
        } else 
        {
        	return pOne.getName() +" : "+ pointsEquivalence.get(pOne.getPoints()) +
        			" - "+ pTwo.getName() +" : "+ pointsEquivalence.get(pTwo.getPoints());        
        }
	}

	private String whoIsLeadingPlayer()
	{
		return (player2.getPoints() < player1.getPoints()) ? player1.getName() : player2.getName();
	}
	
}
