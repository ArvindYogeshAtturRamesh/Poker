package PokerPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
private String fileName;
    
    
  public FileIO()
    {
        
    }
    
  
    public void setFileName(String newFileName)
    {
        fileName = newFileName;
    }
    

    public String getFileName()
    {
        return fileName;
    }
    

    public void writeOutput(int playerOneScore, int playerTwoScore, int tie) throws IOException
    {
            //PrintWriter writer = new PrintWriter(new FileWriter(fileName, true),true );
    	    fileName="gameoutcome.txt";
            FileWriter fw = new FileWriter(fileName);
            PrintWriter writer = new PrintWriter(fw);
            
            writer.println("Final score: "+" Player 1: ("+ playerOneScore+") Player 2: ("+playerTwoScore+")");
            writer.println("Player 1: "+ playerOneScore);
            writer.println("Player 2: "+ playerTwoScore);
            writer.println("Tie: "+tie );
           
            System.out.println("Player 1: "+ playerOneScore);
            System.out.println("Player 2: "+ playerTwoScore);
            System.out.println("Tie: "+tie );
            fw.close();
        
    }
    

    public ArrayList<String> readInputs() throws IOException
    {
    	ArrayList<String> getCardLine = new ArrayList<>();
    	try {
    		
    	    fileName = "pokerhands.txt";
            FileReader fr = new FileReader(fileName);
            Scanner console = new Scanner(fr);
            while(console.hasNextLine()) {
            	String line= console.nextLine();
            	if(line.trim().isEmpty())
            		continue;
            	getCardLine.add(line);
            }
            fr.close();
            console.close();
            
    		
    	}catch(Exception ex) {
    		System.out.println("IO exception: "+ex);
    	}
    	return getCardLine;          
    }

}
