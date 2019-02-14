package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner UserInput = new Scanner(System.in);
    	System.out.print("Enter a fraction problem:  "); 
    	String userResponse = UserInput.nextLine(); 
    	
    	while(!userResponse.equals("quit")) { 
    		System.out.println(produceAnswer(userResponse)); 
    		System.out.println("Enter a fraction problem: "); 
    		userResponse = UserInput.nextLine(); 
    	}   
    	UserInput.close();                       
    }

    public static String produceAnswer(String input)
    {
    	Fraction fraction1 = new Fraction(input.split(" ")[0]); 
    	Fraction fraction2 = new Fraction(input.split(" ")[2]);
    	String operator = input.split(" ")[1]; 
    	Fraction answer = new Fraction (); 
    	answer = fraction1.DoMath(operator, fraction2);
    	
    	answer.reduce();
    	answer.toMixedNum();
    	return answer.toString();
   	//Fraction test = new Fraction(-2,0,0);
   	//return test.toString();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
