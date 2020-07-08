package PokerPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Rank {
	
	//Check the Highest card - Working Fine
		public String checkHighestCard(String playerCardValue) {
			//5D 8C 9S JS AC //4D 6S 9H QH QC //"5D 8C 9S JS AC"
			
			//String playerCardValue = "5D 8C 9S JS AC";
			//String playerCardValue = "4D 6S 9H QH QC";
			String[] playerCardValues = playerCardValue.split(" ");
			
			int tenValue =0, aValue = 0, kValue = 0, qValue = 0, jValue = 0;
			String finalValue = "";
			int integerCardValue = 0;
			
			
			for(int k=0; k<playerCardValues.length; k++) {
				if(playerCardValues[k] != null) {
					char firstValue = playerCardValues[k].charAt(0);
					if(firstValue == 'A')
						aValue =14;
					else if(firstValue == 'T')
						tenValue =10;
					else if(firstValue == 'K')
						kValue = 13;
					else if(firstValue == 'Q')
						qValue = 12;
					else if(firstValue == 'J')
						jValue = 11;
				}
			}

			if(aValue!=0 || tenValue !=0 ||kValue !=0 || qValue !=0 || jValue !=0) {
				for(int i=0; i<playerCardValues.length; i++) {
					
					if(playerCardValues[i] != null) {
						char firstValue = playerCardValues[i].charAt(0);
						if(firstValue =='A' || firstValue =='K' || firstValue =='Q' || firstValue =='J' || firstValue =='T') {
							if(aValue != 0)
								return  (finalValue = "A");
							if(kValue != 0 && kValue > aValue)
								return (finalValue = "K");
							if(qValue !=0 &&  qValue > aValue &&  qValue > kValue)
								return (finalValue = "Q");
							if(jValue !=0 && jValue == aValue && jValue == kValue && jValue == qValue)
								return (finalValue = "J");
							else
								return (finalValue = "T");
						}
						}
					}			
			}else {
				for(int i=0; i<playerCardValues.length; i++) {
					if(playerCardValues[i] != null) {
						char secondValue = playerCardValues[i].charAt(0);
						int firstCharToInt = Integer.parseInt(String.valueOf(secondValue));
						if(firstCharToInt > integerCardValue) {
							integerCardValue = firstCharToInt;
							//System.out.println("With in method: "+integerCardValue);
							finalValue = Integer.toString(integerCardValue);
						}
					}
				}
				
			}
			return finalValue;
		}
		
		//Checks the PAIR value - Working fine 
		public char checkPairValueFromCardValue(String playerCardValue) {
			//String playerCardValue = "9C 9D 5D 7C 3C";
			String[] playerCardValues = playerCardValue.split(" ");
			int count = 0;
			char valueOfCountPair='N';
			String wholeValue ="0";
				
			//9C 9D 8D 7C 3C 
			
			
		
			for(int i=0; i<playerCardValues.length; i++) {
				if(playerCardValues[i] != null) {
					for(int j=0; j<playerCardValues.length; j++) {
						if(playerCardValues[j] != null){
							char firstValue = playerCardValues[i].charAt(0);						
							char secondValue = playerCardValues[j].charAt(0);
							if(i !=j && firstValue == secondValue) {
								count++;
								valueOfCountPair = secondValue; 
								wholeValue = playerCardValues[i];
							}
						}
					}
				}
			}
			if(count == 2 && valueOfCountPair !='0')			
				//System.out.println("For the card: "+ playerCardValue+ " = No pair values found");
				return valueOfCountPair;
			else{
				//System.out.println("countpair: "+count);
				//System.out.println("Value: "+valueOfCountPair);
				return (valueOfCountPair='N');
			}
		}
		
		//Check Two different pairs - Working Fine
		public String checkTwoDifferentPairs(String twoDifferentPairsString) {
			//String twoDifferentPairsString = "4S 2C 4S 5D 5H";
			String result = "N";
			char tempFirstValue = 'N',  tempSecondValue = 'N', tempThirdValue = 'N';
			int countFirstValue = 0, countSecondValue = 0, countThirdValue = 0;
			String twoDifferentPairs = "N";
			
			String[] playerCardValues = twoDifferentPairsString.split(" ");
			if(playerCardValues[0] != null)
				tempFirstValue = playerCardValues[0].charAt(0);
			
			for(int i=0; i<playerCardValues.length; i++) {
				if(playerCardValues[i] != null) {
					char localFirstValue = playerCardValues[i].charAt(0);
					if(localFirstValue!= tempFirstValue)
						tempSecondValue = localFirstValue;
				}
			}
			
			for(int j=0; j<playerCardValues.length; j++) {
				if(playerCardValues[j] != null) {
					char localFirstValue = playerCardValues[j].charAt(0);
					if(localFirstValue!= tempFirstValue && localFirstValue != tempSecondValue)
						tempThirdValue = localFirstValue;
				}
			}
			for(int j=0; j<playerCardValues.length; j++) {
				if(playerCardValues[j] != null) {
					char localFirstValue = playerCardValues[j].charAt(0);
					if(localFirstValue == tempFirstValue)
						countFirstValue++;
					if(localFirstValue == tempSecondValue)
						countSecondValue++;
					if(localFirstValue == tempThirdValue)
						countThirdValue++;
				}
			}
			if(countFirstValue == 2 && countSecondValue == 2 && countThirdValue == 1) {
				twoDifferentPairs = "Y";
				result = countFirstValue +" "+tempFirstValue + "'s " +countSecondValue+ " "+tempSecondValue+"'s"; 
			}
				
				
			if(countFirstValue == 2 && countSecondValue == 1 && countThirdValue == 2) {
				twoDifferentPairs = "Y";
				result = countFirstValue +" "+tempFirstValue + "'s " +countThirdValue+ " "+tempThirdValue+"'s";
			}
			if(countFirstValue == 1 && countSecondValue == 2 && countThirdValue == 2) {
				twoDifferentPairs = "Y";
				result = countSecondValue +" "+tempSecondValue + "'s " +countThirdValue+ " "+tempThirdValue+"'s";
			}
			return result;
		}
		
		//Check the Three of a Kind- Working Fine
		public char checkThreeOfAKind(String playerCardValue) {
			//String playerCardValue = "2H 2D 4C 4D 4S"; 
			String[] playerCardValues = playerCardValue.split(" ");
			
			char valueOfThreeOfAKind='N';
			
			
			char tempFirstValue = 'N';
			char tempSecondValue = 'N';
			char tempThirdValue = 'N';
			int firstValueCount = 0;
			int secondValueCount = 0;
			int thirdValueCount = 0;
			
			if(playerCardValues[0] != null) 
				tempFirstValue = playerCardValues[0].charAt(0);
			if(playerCardValues[1] != null) 
				tempSecondValue = playerCardValues[1].charAt(0);
			if(playerCardValues[2] != null) 
				tempThirdValue = playerCardValues[2].charAt(0);
			
			for(int m=0; m<playerCardValues.length; m++) {
				if(playerCardValues[m] != null) {
					char firstValue = playerCardValues[m].charAt(0);	
					if(firstValue == tempFirstValue)
						firstValueCount++;
					if(firstValue == tempSecondValue)
						secondValueCount++;
					if(firstValue == tempThirdValue)
						thirdValueCount++;
					
				}
			}
			if(firstValueCount == 3)
				valueOfThreeOfAKind = tempFirstValue;
			if(secondValueCount == 3)
				valueOfThreeOfAKind = tempSecondValue;
			if(thirdValueCount == 3)
				valueOfThreeOfAKind = tempThirdValue;

			//System.out.print("Three of a kind: "+ valueOfThreeOfAKind);
			return valueOfThreeOfAKind;
			
		}
		

		//Straight - All five cards in consecutive value order - is working fine
		public String checkStraight(String straightString) {
			//String straightString = "5S 7C 6S 8D 9H";
			//String straightString = "TS KC AS JD QH";
			//3S AC AH AS 5H
			
			int countTen=0, countAce=0, countKing=0, countQueen=0, countJack=0;
			ArrayList<Integer> integerCardValueList = null;
			ArrayList<String> stringCardValueList = null;
			String straightSequentialResult = "N";
			
			
			String[] playerCardValues = straightString.split(" ");
			
			//to overcome straight flush issue
			boolean differentSuite = checkDifferentSuite(playerCardValues);
		
			
			for(int i=0; i<playerCardValues.length; i++) {
				if(playerCardValues[i] !=null) {
					char firstValue = playerCardValues[i].charAt(0);
					if(firstValue == 'A')
						countAce++;
					else if(firstValue == 'T')
						countTen++;
					else if(firstValue == 'K')
						countKing++;
					else if(firstValue == 'Q')
						countQueen++;
					else if(firstValue == 'J')
						countJack++;								
				}
			}
			if(countTen > 1 && countAce >1 && countKing >1 && countQueen > 1 && countJack >1 && !differentSuite ) {
				integerCardValueList = new ArrayList<Integer>();
				
				for(int j=0; j<playerCardValues.length; j++) {
					if(playerCardValues[j] != null) {
						char localFirstValue = playerCardValues[j].charAt(0);
						int firstCharToInt = Integer.parseInt(String.valueOf(localFirstValue));
						integerCardValueList.add(firstCharToInt);
						
					}
				}
				//sorts the integer value
				Collections.sort(integerCardValueList);
				

				//checks the integer values are sequential
				int minValue = getMinimumValue(integerCardValueList);
				for(int k=0; k<integerCardValueList.size() -1; k++) {
					if(integerCardValueList.get(k) +1 == (minValue +1)) {
						straightSequentialResult = "Y";
						minValue ++;
					}else {
						straightSequentialResult = "N";
					}
						
				}

				if( integerCardValueList.size() == 5 && (minValue) != integerCardValueList.get(4))
					straightSequentialResult = "N";
					
				//System.out.println("sorted value is: "+integerCardValueList);
				
				if(straightSequentialResult == "Y")
					straightSequentialResult = integerCardValueList.toString();
				
			
			}else if(countTen ==1 && countAce ==1 && countKing ==1 && countQueen == 1 && countJack == 1 && !differentSuite) {
				straightSequentialResult = "Y";
				stringCardValueList = new ArrayList<String>();
				for(int l=0; l<playerCardValues.length; l++) {
					if(playerCardValues[l] != null) {
						char localFirstValue = playerCardValues[l].charAt(0);
						String localStringValue = Character.toString(localFirstValue);
						stringCardValueList.add(localStringValue);					
					}		
				}
				
				if(straightSequentialResult == "Y")
					straightSequentialResult = stringCardValueList.toString();			
				
			}
			
			//System.out.println(straightSequentialResult);
			return straightSequentialResult;
			
		}	

		//Flush - All five cards having the same suite
		public String checkFlush(String flushString) {
			//String flushString = "3C 6C 7C TC QC";
			char tempSuite = 'N';
			int countSuite = 0;
			String flushResult = "N";
			
			String[] playerCardValues = flushString.split(" ");
			if(playerCardValues[0] != null)
				tempSuite = playerCardValues[0].charAt(1);
			for(int i=0; i<playerCardValues.length; i++) {
				if(playerCardValues[i] != null) {
					char secondValue = playerCardValues[i].charAt(1);
					if(secondValue == tempSuite)
						countSuite++;					
				}
			}
			if(countSuite == 5)
				flushResult = "Y";
			
			return flushResult;	
		}
		
		//Full House - Three of a kind and a pair is working fine
		public String checkFullHouse(String fullHouseString) {
			//String fullHouseString = "QH QD 4C 4D 4S";
			String fullHouseResult = "N";
			char tempFirstValue = 'N';
			char tempSecondValue = 'N';
			int countFirstValue = 0;
			int countSecondValue = 0;
			String fullHouse = "N";
			
			
			String[] playerCardValues = fullHouseString.split(" ");
			if(playerCardValues[0] != null)
				tempFirstValue = playerCardValues[0].charAt(0);
			
			for(int i=0; i<playerCardValues.length; i++) {
				if(playerCardValues[i] != null) {
					char localFirstValue = playerCardValues[i].charAt(0);
					if(localFirstValue!= tempFirstValue)
						tempSecondValue = localFirstValue;
				}
			}
			
			for(int j=0; j<playerCardValues.length; j++) {
				if(playerCardValues[j] != null) {
					char localFirstValue = playerCardValues[j].charAt(0);
					if(localFirstValue == tempFirstValue)
						countFirstValue++;
					if(localFirstValue == tempSecondValue)
						countSecondValue++;
				}
			}
			if(countFirstValue == 2 && countSecondValue == 3)
				fullHouseResult = "Y";
			else if(countFirstValue == 3 && countSecondValue == 2)
				fullHouseResult = "Y";
			
			//System.out.println("Full House with "+countFirstValue+ " "+ tempFirstValue+"'s  and "+countSecondValue+ " "+
				//				tempSecondValue+ "'s");
			
			if(fullHouseResult == "Y")
				fullHouse = countFirstValue+ " "+ tempFirstValue+"'s  and "+countSecondValue+ " "+tempSecondValue+ "'s";
				//System.out.println(fullHouse);
				
			return fullHouse;
		}
		//Check Four of a kind - Working fine
		public char checkFourOfAKind(String playerCardValue) {
			//String playerCardValue = "2H 2D 2C 2D 4S"; 
			String[] playerCardValues = playerCardValue.split(" ");
			char valueOfFourOfAKind='N';
		
			
			char tempFirstValue = 'N';
			char tempSecondValue = 'N';
			int firstValueCount = 0;
			int secondValueCount = 0;
			
			if(playerCardValues[0] != null) 
				tempFirstValue = playerCardValues[0].charAt(0);
			if(playerCardValues[1] != null) 
				tempSecondValue = playerCardValues[1].charAt(0);
			for(int m=0; m<playerCardValues.length; m++) {
				if(playerCardValues[m] != null) {
					char firstValue = playerCardValues[m].charAt(0);	
					if(firstValue == tempFirstValue)
						firstValueCount++;
					if(firstValue == tempSecondValue)
						secondValueCount++;
				}
			}
			if(firstValueCount == 4)
				valueOfFourOfAKind = tempFirstValue;
			if(secondValueCount == 4)
				valueOfFourOfAKind = tempSecondValue;
	
			//System.out.println("Four of a kind: "+valueOfFourOfAKind);
			return valueOfFourOfAKind;
			
		}
		
		
	
	// Royal Flush - Ten, Jack, Queen, King and Ace in the same suit - Working Fine
	public String checkStraightFlush(String straightFlushString) {
		//String straightFlushString = "TH AH JH QH KH";
		int countTen=0, countAce=0, countKing=0, countQueen=0, countJack=0;
		String straightFlushResult = "N";
		ArrayList<String> stringCardValueList = null;
		
		String[] playerCardValues = straightFlushString.split(" ");
		boolean sameSuite = checkDifferentSuite(playerCardValues);
		for(int i=0; i<playerCardValues.length; i++) {
			if(playerCardValues[i] !=null) {
				char firstValue = playerCardValues[i].charAt(0);
				if(firstValue == 'A')
					countAce++;
				else if(firstValue == 'T')
					countTen++;
				else if(firstValue == 'K')
					countKing++;
				else if(firstValue == 'Q')
					countQueen++;
				else if(firstValue == 'J')
					countJack++;								
			}
		}
		if(countTen ==1 && countAce ==1 && countKing ==1 && countQueen == 1 && countJack == 1 && sameSuite) {
			straightFlushResult = "Y";
			stringCardValueList = new ArrayList<String>();
			for(int l=0; l<playerCardValues.length; l++) {
				if(playerCardValues[l] != null) {
					char localFirstValue = playerCardValues[l].charAt(0);
					String localStringValue = Character.toString(localFirstValue);
					stringCardValueList.add(localStringValue);					
				}		
			}			
		}
		if(straightFlushResult == "Y")
			straightFlushResult = stringCardValueList.toString();
		
		//System.out.println(straightFlushResult);
		
		return straightFlushResult;
		
		
	}
	

	
	
	//Royal Flush - Working Fine
	public String checkRoyalFlush(String royalString) {
		//String royalString = "AC TC KC QC JC";
		char tempSuite = 'N';
		int countTen = 0, countAce = 0, countKing = 0, countQueen = 0, countJack = 0;
		String royalSuiteResult = "N";
		
		String[] playerCardValues = royalString.split(" ");
		
		if(playerCardValues[0] != null)
			tempSuite = playerCardValues[0].charAt(1);
		
		for(int i=0; i<playerCardValues.length; i++) {
			if(playerCardValues[i] !=null) {
				char firstValue = playerCardValues[i].charAt(0);	
				char localSuite = playerCardValues[i].charAt(1);
				if(firstValue == 'T' && tempSuite == localSuite)
					countTen++;
				if(firstValue == 'A' && tempSuite == localSuite)
					countAce++;
				if(firstValue == 'K'  && tempSuite == localSuite)
					countKing++;
				if(firstValue == 'Q'  && tempSuite == localSuite)
					countQueen++;
				if(firstValue == 'J'  && tempSuite == localSuite)
					countJack++;				
			}
		}
		if(countTen == 1 && countAce ==1 && countKing == 1 && countQueen == 1 && countJack == 1)
			royalSuiteResult = "Y";
		
		return royalSuiteResult;
	}
	
		

	
	//Used in "checkStraight and "checkStraightFlush" method to overcome straight flush issue 
	//It checks the values have different suite or same suite
	private boolean checkDifferentSuite(String[] playerCardValues) {
		char tempSuite = 'N';
		int count = 0;
		boolean sameSuite =false;
		if(playerCardValues[0] !=null) 
			tempSuite = playerCardValues[0].charAt(1);
	
		
		for(int i=0;i<playerCardValues.length; i++) {
			if(playerCardValues[i] != null) {
				char localSuiteValue = playerCardValues[i].charAt(1);
				if(localSuiteValue == tempSuite)
					count++;
			}
		}
		if(count == 5)
			sameSuite = true;
		
		return sameSuite;
				
		
	}
	
	//Used in "checkStraight" method to have the minimum value
	private int getMinimumValue(ArrayList<Integer> integerList) {
		int minValue =10;
		
		for(int i=0; i< integerList.size(); i++) {
			if(integerList.get(i) < minValue)
				minValue = integerList.get(i);
		}
		return minValue;
		
	}


}
