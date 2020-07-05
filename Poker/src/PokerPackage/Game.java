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
			
			for(int i=0; i<cardValues.size(); i++) {
				String playerOne = getPlayerOneCardValues(cardValues.get(i));
				String playerTwo = getPlayerTwoCardValues(cardValues.get(i));
				
				writer.println(i + " game P1 - card is "+playerOne+" Highest Card =  "+rank.checkHighestCard(playerOne));
				writer.println(i + " game P2 - card is "+playerTwo+" Highest Card =  "+rank.checkHighestCard(playerTwo));
				
				writer.println("Player 1 pair value: "+ rank.checkPairValueFromCardValue(playerOne));
				writer.println("Player 2 pair value: "+ rank.checkPairValueFromCardValue(playerTwo));
				
				writer.println("Player 1 three of a card value: "+ rank.checkThreeOfAKind(playerOne));
				writer.println("Player 2 three of a card value: "+ rank.checkThreeOfAKind(playerTwo));
				
				writer.println("Player 1 four of a card value: "+ rank.checkFourOfAKind(playerOne));
				writer.println("Player 2 four of a card value: "+ rank.checkFourOfAKind(playerTwo));
				writer.println();
				
			
				System.out.println(i + " game P1 - card is "+playerOne+" Highest Card =  "+rank.checkHighestCard(playerOne));
				System.out.println(i + " game P2 - card is "+playerTwo+" Highest Card =  "+rank.checkHighestCard(playerTwo));
				
				System.out.println("Player 1 pair value: "+ rank.checkPairValueFromCardValue(playerOne));
				System.out.println("Player 2 pair value: "+ rank.checkPairValueFromCardValue(playerTwo));
				
				System.out.println("Player 1 three of a card value: "+ rank.checkThreeOfAKind(playerOne));
				System.out.println("Player 2 three of a card value: "+ rank.checkThreeOfAKind(playerTwo));
				
				System.out.println("Player 1 four of a card value: "+ rank.checkFourOfAKind(playerOne));
				System.out.println("Player 2 four of a card value: "+ rank.checkFourOfAKind(playerTwo));
				System.out.println();
				
				
				
			}

			
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
