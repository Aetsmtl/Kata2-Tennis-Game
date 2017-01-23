package com.aetsmtl.tennisgameApp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	Player firstPlayer, secondPlayer;
    Game game;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    @Override
    protected void setUp() throws Exception {
    	// TODO Auto-generated method stub
    	super.setUp();
    	
    	firstPlayer = new Player("Arnold");
    	secondPlayer = new Player("Fotsing");
    	game = new Game(firstPlayer, secondPlayer);
    }
    
    public void testCorrectDescriptionOfScoreBeforeFourPoints()
    {	
    	String resultTemp;
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : fifteen - Fotsing : love");
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : thirty - Fotsing : love");
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : forty - Fotsing : love");
    }
    
    public void testCorrectDescriptionOfScoreAfterThreePoints()
    {
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService();
    		secondPlayer.winService();
    	}
    	
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Arnold");
    	
    	secondPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    	
    	secondPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Fotsing");
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    }
    
    public void testWinAfterDeuce()
    {
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService();
    		secondPlayer.winService();
    	}
    	
    	secondPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Fotsing");
    	
    	secondPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Fotsing is the winner");
    }
    
    public void testWinWithoutDeuce()
    {
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService(); 
    	}
    	
    	firstPlayer.winService();
    	resultTemp = game.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold is the winner");
    }
}
