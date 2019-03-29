package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.*;
// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    	Scanner UserInput = new Scanner(System.in);
	    	System.out.print("Enter a fraction problem:  "); 
	    	String userResponse = UserInput.nextLine(); 
	    	Spreadsheet sheet = new Spreadsheet();          
	    	while(!userResponse.equals("quit")) {
		  
	    	System.out.println(sheet.processCommand(userResponse));
	    			System.out.print("Enter a command:  ");
	    		userResponse = UserInput.nextLine(); 
	    	}   
	    	UserInput.close();                       
	    }
	}

