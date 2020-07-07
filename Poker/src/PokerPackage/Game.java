package PokerPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

import java.util.ArrayList;

public class Game {
	
	Rank rank;
	public void getCardValues() {
		try {
			//Reads players card values from the text file
			FileIO fileIO = new FileIO();
			rank = new Rank();
			ArrayList<String> cardValues = new ArrayList<>();
			cardValues = fileIO.readInputs();
			
			 String fileName="gameoutcome.txt";
	         FileWriter fw = new FileWriter(fileName);
	         PrintWriter writer = new PrintWriter(fw);
			
	 		cardValues.add("5C 9D 9D 7C 3C 2S KD TH 9H 8H");
	 		cardValues.add("2D 9C AS AH AC 2S KD TH 9H 8H");
	 		cardValues.add("");

	 		String playerOne = getPlayerOneCardValues(cardValues.get(0));
			String playerTwo = getPlayerTwoCardValues(cardValues.get(0));
			
			//String royalSuiteResult = rank.checkRoyalFlush("");
			//String flushResult = rank.checkFlush();
			//String fullHouseResult = rank.checkFullHouse("");
			//String twoPairs = rank.checkTwoDifferentPairs("");	
			//rank.checkStraight();
			
			rank.checkStraightFlush();
			
			//System.out.println("Full House Result: "+ twoPairs);
	
			
		}catch(Exception ex) {
			System.out.println("IO exception: "+ex);
		}
		
			
	}
	
	public String getPlayerOneCardValues(String playersCardValue) {
		String playerOne = playersCardValue.substring(0,14);
		return playerOne;		
	}
	
	public String getPlayerTwoCardValues(String playersCardValue) {
		
		String playerTwo = playersCardValue.substring(15,29);
		return playerTwo;		
	}
	

}
