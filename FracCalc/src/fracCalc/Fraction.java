package fracCalc;

public class Fraction {
	private int whole;
	private int numerator; 
	private int denominator; 
	private String fractionStr; 
 
	public Fraction() { 
	whole = 0; 
	numerator = 0; 
	denominator = 0;
	}
	
	
	
	public Fraction(String oprand) {
		String[] wholesplit = oprand.split("_"); 
		String[] rest = wholesplit[1].split("/"); 
		whole = Integer.parseInt(wholesplit[0]); 
		numerator = Integer.parseInt(rest[0]); 
		denominator = Integer.parseInt(rest[1]);
		toImproperFrac(); 
	}
	
	private void toImproperFrac() {
		numerator = denominator * whole + numerator; 
		whole= 0; 		
	}
	
	public static int gcf(int a, int b) { // a & b are the numerators and denominators, b is the initial denominator 
	if( b == 0) { //checks if b = 0
		return a; // if b = 0 then returns the value of a
		}
	else { // if b is not equal to zero
		return gcf(b, a%b); //then does gcf again, with 'b' as the 'a'-input and the remainder of a/b as the 'b'-input
		}
	}
	public Fraction DoMath (String operator, Fraction fraction2) {
	  Fraction answer = new Fraction (); 
		if(operator.equals("+")) { 
      	answer = (addition(fraction2));  
      }
      else if(operator.equals("-")) { 
      	answer = (subtraction(fraction2)); 
      }
      else if(operator.equals("*")) { 
      	answer = (mutiplication(fraction2));
      }
      else if(operator.equals("/")) { 
      	answer = (Division(fraction2)); 
      }
		return answer; 
}
	public Fraction addition(Fraction fraction2) { 
		  Fraction answer = new Fraction (); 
    	if(this.denominator == fraction2.denominator) {
    		answer.numerator = this.numerator + fraction2.denominator;
    		answer.denominator = this.denominator;
    	}else { 
    		answer.numerator= (this.numerator*fraction2.denominator) + (fraction2.numerator*this.denominator);
    		answer.denominator= this.denominator * fraction2.denominator;
    	}
    	return answer;
	}
 
    
    public Fraction subtraction(Fraction fraction2) { 
    	Fraction answer = new Fraction ();
        if(this.denominator == fraction2.denominator) {
    		answer.numerator = this.numerator - fraction2.denominator;
    		answer.denominator = this.denominator;	 
        }else { 
    		answer.numerator= (this.numerator*fraction2.denominator) - (fraction2.numerator*this.denominator);
    		answer.denominator= this.denominator*fraction2.denominator;
        	//return ((op1Num*op2Deno) - (op2Num*op1Deno)) + "/" + op1Deno * op2Deno;
        }
        return answer; 
    }
 
     
    public Fraction mutiplication(Fraction fraction2) { 
    	Fraction answer = new Fraction (); 
    	answer.numerator = this.numerator*fraction2.numerator; 
    	answer.denominator = this.denominator*fraction2.denominator; 
        return answer; 
    }
    
	public Fraction Division(Fraction fraction2) { 
		Fraction answer = new Fraction ();
    	answer.numerator =  (this.numerator*fraction2.denominator); 
    	answer.denominator = (this.denominator*fraction2.numerator); 
    	return answer; 
    }
	public Fraction reducedNum (Fraction answer) { 
		 Fraction answer = new Fraction (); 
		//use gcf to reduce
		answer.numerator = answer.numerator / gcf(answer.numerator,answer.denominator); 
		answer.denominator = answer.denominator / gcf(answer.numerator,answer.denominator ); 
		return answer;
	}
	public Fraction toMixedNum(Fraction answer) { 
		answer.whole= answer[0] / answer[1]; // whole
		answer.remainder= answer[0] % answer[1]; // remainder
		int denominator = answer[1]
;			
		String answerStr="";
		if (wholenum != 0) {   
			if (remainder != 0) {
				if (wholenum < 0) {
					remainder = remainder * -1; 
					answerStr = wholenum + "_" + remainder + "/" + denominator; 
				}
				if (remainder < 0 && denominator <0) {
					remainder = remainder * -1; 
					denominator = denominator * -1; 
					answerStr = wholenum + "_" + remainder + "/" + denominator;
				}
				else { 
				answerStr = wholenum + "_" + remainder + "/" + denominator ;
			}
			}// if both num and deno are nega then return posi
			else { 
				if(denominator == 1) {
					answerStr = Integer.toString(wholenum);
				}
				else if (denominator == -1) {
					wholenum = wholenum * -1; 
					answerStr = Integer.toString(wholenum);
				}
				                                                          
			}
		}
		else { 
			if (remainder != 0) {
				answerStr = remainder + "/" + denominator; 
			}
			else {
				answerStr = "0"; 
			}
		}
			
		return answerStr;	
	}

	
}










