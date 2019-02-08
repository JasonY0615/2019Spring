package fracCalc;

public class Fraction {
	private int whole;
	private int numerator; 
	private int denominator; 

 
	public Fraction() { 
	whole = 0; 
	numerator = 0; 
	denominator = 0;
	}
	
	
	
	public Fraction(String oprand) {

        if (oprand.indexOf("/") != -1){
        	numerator = Integer.parseInt(oprand.substring(oprand.indexOf("_") + 1, oprand.indexOf("/")));
            denominator = Integer.parseInt(oprand.substring(oprand.indexOf("/") + 1, oprand.length()));
            if (oprand.indexOf("_") != -1){ 
              whole = Integer.parseInt(oprand.substring(0, oprand.indexOf("_")));
              if(whole <0){
            	  numerator = (whole * denominator) - numerator;
              }
              else {
            	  numerator = (whole * denominator) + numerator;
              }
            }
            else {
            	whole = 0;             
        }
        }
            else {
            	numerator = Integer.parseInt(oprand);
            	denominator = 1;
            	}
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
		answer.reduce();
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
	public void reduce () { 
		//use gcf to reduce
		numerator = numerator / gcf(numerator,denominator); 
		denominator = denominator / gcf(numerator,denominator ); 
		
	}
	public Fraction toMixedNum(Fraction answer) { 
		answer.whole= answer.numerator / answer.denominator; // whole
		answer.numerator= answer.numerator % answer.denominator; // remainder;	
		return answer;
	}
	public String toString(){
		
		String answerStr="";
		if (whole != 0) {   
			if (numerator != 0) {
				if (whole < 0) {
					numerator = numerator * -1; 
					answerStr = whole + "_" + numerator + "/" + denominator; 
				}
				if (numerator < 0 && denominator <0) {
					numerator = numerator * -1; 
					denominator = denominator * -1; 
					answerStr = whole + "_" + numerator + "/" + denominator;
				}
				else { 
				answerStr = whole + "_" + numerator + "/" + denominator ;
			}
			}// if both num and deno are nega then return posi
			else { 
				if(denominator == 1) {
					answerStr = Integer.toString(whole);
				}
				else if (denominator == -1) {
					whole = whole * -1; 
					answerStr = Integer.toString(whole);
				}
				                                                          
			}
		}
		else { 
			if (numerator != 0) {
				answerStr = numerator + "/" + denominator; 
			}
			else {
				answerStr = "0"; 
			}
		}
			
		return answerStr;	
	}

	
}










