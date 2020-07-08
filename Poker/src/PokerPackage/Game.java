package PokerPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

import java.util.ArrayList;

public class Game {
	
	Rank rank;
	HashMap<String, String> playerOneResultMap = null;
	HashMap<String, String> playerTwoResultMap = null;
	HashMap<String, Integer> combinationPriorityMap = null;
	
	int playerOneTotalValueCount = 0, playerTwoTotalValueCount = 0, tieCount = 0;
		
	public void getCardValues() {
		try {
			//Reads players card values from the text file
			FileIO fileIO = new FileIO();
			rank = new Rank();
			
			ArrayList<String> cardValues = new ArrayList<>();
			cardValues = fileIO.readInputs();
			getCombinationPriority();
			
			 String fileName="gameoutcome.txt";
	         FileWriter fw = new FileWriter(fileName);
	         PrintWriter writer = new PrintWriter(fw);

	 		for(int i=0; i<cardValues.size(); i++) {
		        String playerOne = getPlayerOneCardValues(cardValues.get(i));
				String playerTwo = getPlayerTwoCardValues(cardValues.get(i));
				
		 		playerOneResultMap = getPlayerOneResult(playerOne);
		 		playerTwoResultMap = getPlayerTwoResult(playerTwo);
		 		
		 		int playerOneTotalValue = getPlayerTotalValue(playerOneResultMap);
		 		int playerTwoTotalValue = getPlayerTotalValue(playerTwoResultMap);
		 		
		 		if(playerOneTotalValue > playerTwoTotalValue)
		 			playerOneTotalValueCount++;
		 		else if(playerOneTotalValue < playerTwoTotalValue)
		 			playerTwoTotalValueCount++;
		 		else if(playerOneTotalValue == playerTwoTotalValue)
		 			tieCount++;
			 		
			 		//System.out.println(cardValue);
			 		//System.out.println(playerOneResultMap + " Value: "+playerOneValue);
			 		//System.out.println(playerTwoResultMap + " Value: "+playerTwoValue);
	 		}
	 		fileIO.writeOutput(playerOneTotalValueCount, playerTwoTotalValueCount, tieCount);	 		
		}catch(Exception ex) {
			System.out.println("IO exception: "+ex);
		}
		
	}
	
	//Based on the player card value -  Calculates the total score 
	public int getPlayerTotalValue(HashMap<String, String> playerMap) {
		int playerValue = 0;
				
		for(HashMap.Entry<String, String> entryOne: playerMap.entrySet()) {
			
			for(HashMap.Entry<String, Integer> entryTwo : combinationPriorityMap.entrySet()) {
				if(entryOne.getKey() == entryTwo.getKey()) {
					playerValue += entryTwo.getValue();
				}				
			}			
		}
		return playerValue;
	}
	
	//Sets ranks for each combination
	public void getCombinationPriority() {
		combinationPriorityMap = new  HashMap<>();
		combinationPriorityMap.put("H", 1);
		combinationPriorityMap.put("P", 2);
		combinationPriorityMap.put("TP", 3);
		combinationPriorityMap.put("THK", 4);
		combinationPriorityMap.put("S", 5);		
		combinationPriorityMap.put("F", 6);
		combinationPriorityMap.put("FH", 7);
		combinationPriorityMap.put("FOK", 8);
		combinationPriorityMap.put("SF", 9);
		combinationPriorityMap.put("SF", 10);
		
	}
	
	//Returns first 5 card values for player 1
	public String getPlayerOneCardValues(String playersCardValue) {
		String playerOne = playersCardValue.substring(0,14);
		return playerOne;		
	}
	
	//Returns last 5 card values for player 2
	public String getPlayerTwoCardValues(String playersCardValue) {		
		String playerTwo = playersCardValue.substring(15,29);
		return playerTwo;		
	}
	
	//Gets player 1 card values and store it in hashmap
	public HashMap<String, String> getPlayerOneResult(String firstPlayer) {
		//String cardValues = "5C 9D 9D 7C 3C 2S KD TH 9H 8H";
		//String firstPlayer = getPlayerOneCardValues(cardValues);
		
		String playerOneHighValue = rank.checkHighestCard(firstPlayer);
		char playerOnePair = rank.checkPairValueFromCardValue(firstPlayer);
		String playerOneTwoPairs = rank.checkTwoDifferentPairs(firstPlayer);
		char playerOneThreeOfAKind = rank.checkThreeOfAKind(firstPlayer);
		String playerOneStraight = rank.checkStraight(firstPlayer);
		String playerOneFlush = rank.checkFlush(firstPlayer);
		String playerOneFullHouse = rank.checkFullHouse(firstPlayer);
		char playerOneFourOfAKind = rank.checkFourOfAKind(firstPlayer);
		String playerOneStraightFlush = rank.checkStraightFlush(firstPlayer);
		String playerOneRoyalFlush = rank.checkRoyalFlush(firstPlayer);
		
		HashMap< String, String> playerOneMap = new HashMap<>();
		
		
		if(playerOneHighValue != "N")
			playerOneMap.put("H", playerOneHighValue);
		if(playerOnePair != 'N') {
			String tempPairValue = Character.toString(playerOnePair);
			playerOneMap.put("P", tempPairValue);
		}
		if(playerOneTwoPairs != "N")
			playerOneMap.put("TP", playerOneTwoPairs);
		if(playerOneThreeOfAKind != 'N') {
			String tempThreeOfAKind = Character.toString(playerOneThreeOfAKind);
			playerOneMap.put("THK", tempThreeOfAKind );
		}
		if(playerOneStraight != "N")
			playerOneMap.put("S", playerOneStraight);
		if(playerOneFlush != "N")
			playerOneMap.put("F", playerOneFlush);
		if(playerOneFullHouse != "N")
			playerOneMap.put("FH", playerOneFullHouse);
		if(playerOneFourOfAKind != 'N') {
			String tempFourOfAKind = Character.toString(playerOneFourOfAKind);
			playerOneMap.put("FOK", tempFourOfAKind);
		}
		if(playerOneStraightFlush != "N")
			playerOneMap.put("SF", playerOneStraightFlush);
		if(playerOneRoyalFlush != "N")
			playerOneMap.put("RF", playerOneRoyalFlush);
		
		return playerOneMap;
		

	}
	
	//Gets player 1 card values and store it in hashmap
	public HashMap<String, String> getPlayerTwoResult(String secondPlayer) {
		
		//String cardValues = "5C 9D 9D 7C 3C 2S KD TH 9H 8H";
		//String secondPlayer = getPlayerTwoCardValues(cardValues);
		
		String highValuePlayerTwo = rank.checkHighestCard(secondPlayer);
		char pairPlayerTwo = rank.checkPairValueFromCardValue(secondPlayer);
		String twoPairsPlayerTwo = rank.checkTwoDifferentPairs(secondPlayer);
		char threeOfAKindPlayerTwo = rank.checkThreeOfAKind(secondPlayer);
		String straightPlayerTwo = rank.checkStraight(secondPlayer);
		String FlushPlayerTwo = rank.checkFlush(secondPlayer);
		String fullHousePlayerTwo = rank.checkFullHouse(secondPlayer);
		char fourOfAKindPlayerTwo = rank.checkFourOfAKind(secondPlayer);
		String straightFlushPlayerTwo = rank.checkStraightFlush(secondPlayer);
		String royalFlushPlayerTwo = rank.checkRoyalFlush(secondPlayer);
		
		HashMap< String, String> playerTwoMap = new HashMap<>();
		
		
		if(highValuePlayerTwo != "N")
			playerTwoMap.put("H", highValuePlayerTwo);
		if(pairPlayerTwo != 'N') {
			String tempPairValue = Character.toString(pairPlayerTwo);
			playerTwoMap.put("P", tempPairValue);
		}
		if(twoPairsPlayerTwo != "N")
			playerTwoMap.put("TP", twoPairsPlayerTwo);
		if(threeOfAKindPlayerTwo != 'N') {
			String tempThreeOfAKind = Character.toString(threeOfAKindPlayerTwo);
			playerTwoMap.put("THK", tempThreeOfAKind );
		}
		if(straightPlayerTwo != "N")
			playerTwoMap.put("S", straightPlayerTwo);
		if(FlushPlayerTwo != "N")
			playerTwoMap.put("F", FlushPlayerTwo);
		if(fullHousePlayerTwo != "N")
			playerTwoMap.put("FH", fullHousePlayerTwo);
		if(fourOfAKindPlayerTwo != 'N') {
			String tempFourOfAKind = Character.toString(fourOfAKindPlayerTwo);
			playerTwoMap.put("FOK", tempFourOfAKind);
		}
		if(straightFlushPlayerTwo != "N")
			playerTwoMap.put("SF", straightFlushPlayerTwo);
		if(royalFlushPlayerTwo != "N")
			playerTwoMap.put("RF", royalFlushPlayerTwo);
		
		return playerTwoMap;
		
	}
	

}
