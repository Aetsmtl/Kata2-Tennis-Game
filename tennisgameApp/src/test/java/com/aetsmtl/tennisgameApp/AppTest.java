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

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testCheckCorrectDescriptionOfScoreBeforeFourPoints()
    {
    	Player firstPlayer = new Player("Arnold");
    	Player secondPlayer = new Player("Fotsing");
    	
    	Game g = new Game(firstPlayer, secondPlayer);
    	
    	String resultTemp;
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : fifteen - Fotsing : love");
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : thirty - Fotsing : love");
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold : forty - Fotsing : love");
    }
    
    public void testCheckCorrectDescriptionOfScoreAfterThreePoints()
    {
    	Player firstPlayer = new Player("Arnold");
    	Player secondPlayer = new Player("Fotsing");
    	
    	Game g = new Game(firstPlayer, secondPlayer);
    	
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService();
    		secondPlayer.winService();
    	}
    	
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Arnold");
    	
    	secondPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    	
    	secondPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Fotsing");
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "deuce");
    }
    
    public void testCheckWinAfterDeuce()
    {
    	Player firstPlayer = new Player("Arnold");
    	Player secondPlayer = new Player("Fotsing");
    	
    	Game g = new Game(firstPlayer, secondPlayer);
    	
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService();
    		secondPlayer.winService();
    	}
    	
    	secondPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "advantage For : Fotsing");
    	
    	secondPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Fotsing is the winner");
    }
    
    public void testCheckWinWithoutDeuce()
    {
    	Player firstPlayer = new Player("Arnold");
    	Player secondPlayer = new Player("Fotsing");
    	
    	Game g = new Game(firstPlayer, secondPlayer);
    	
    	String resultTemp;
    	
    	for (int i=0 ; i<3 ; i++)
    	{
    		firstPlayer.winService();
    	}
    	
    	firstPlayer.winService();
    	resultTemp = g.giveCurrentlyResult(firstPlayer, secondPlayer);
    	assertEquals(resultTemp , "Arnold is the winner");
    }
}
