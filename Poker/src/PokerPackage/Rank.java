package PokerPackage;

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
			
		String[] playerCardValues = playerCardValue.split(" ");
		int count = 0;
		char valueOfCountPair='0';
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
		if(count == 0 && valueOfCountPair=='0' )			
			//System.out.println("For the card: "+ playerCardValue+ " = No pair values found");
			return valueOfCountPair;
		else{
			//System.out.println("countpair: "+count);
			//System.out.println("Value: "+valueOfCountPair);
			return valueOfCountPair;
		}
	}
	
	//Check the Three of a Kind- Working Fine
	public char checkThreeOfAKind(String playerCardValue) {
		//playerCardValue = "2H 2D 4C 4D 4S"; 
		String[] playerCardValues = playerCardValue.split(" ");
		int count = 0;
		char valueOfThreeOfAKind='0';
		String wholeValue ="0";
		int threeKind ;

		for(int i=0; i<playerCardValues.length; i++) {
			if(playerCardValues[i] != null) {
				for(int j=0; j<playerCardValues.length; j++) {
					if(playerCardValues[j] != null){
						char firstValue = playerCardValues[i].charAt(0);						
						char secondValue = playerCardValues[j].charAt(0);
						if(i !=j && firstValue == secondValue) {
							count++;
							valueOfThreeOfAKind = secondValue; 
							wholeValue = playerCardValues[i];
						}
					}
				}
			}
		}
		if(count == 0 && valueOfThreeOfAKind=='0' )			
			//System.out.println("For the card: "+ playerCardValue+ " = No pair values found");
			return valueOfThreeOfAKind;
		else{
			if(count%3 == 0 && (count/2)==3) {
				//threeKind = count/2;
				return valueOfThreeOfAKind;
				//System.out.println("Three of a kind: "+threeKind);
				//System.out.println("Value: "+valueOfThreeOfAKind);
			}

			return '0';
		}
		
	}
	
	//Check Four of a kind - Working fine
	public char checkFourOfAKind(String playerCardValue) {
		//playerCardValue = "2H 2D 2C 2D 4S"; 
		String[] playerCardValues = playerCardValue.split(" ");
		int count = 0;
		char valueOfFourOfAKind='0';
		String wholeValue ="0";
		int fourKind ;

		for(int i=0; i<playerCardValues.length; i++) {
			if(playerCardValues[i] != null) {
				for(int j=0; j<playerCardValues.length; j++) {
					if(playerCardValues[j] != null){
						char firstValue = playerCardValues[i].charAt(0);						
						char secondValue = playerCardValues[j].charAt(0);
						if(i !=j && firstValue == secondValue) {
							count++;
							valueOfFourOfAKind = secondValue; 
							wholeValue = playerCardValues[i];
						}
					}
				}
			}
		}
		if(count == 0 && valueOfFourOfAKind=='0' )			
			//System.out.println("For the card: "+ playerCardValue+ " = No pair values found");
			return valueOfFourOfAKind;
		else{
			if(count%4 == 0 && (count/3)==4) {
				//fourKind = count/3;
				return valueOfFourOfAKind;
				//System.out.println("Four of a kind: "+fourKind);
				//System.out.println("Value: "+valueOfFourOfAKind);
			}

			return '0';
		}
		
	}
	

}
