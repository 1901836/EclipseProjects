
public class Expression {
	public static void main(String[] args) {
		

	 /* declaring and assign statement */
	 boolean my_bool = true; //true and false are literals for booleans
	 						 // values in java are called literals
	 						 //i.e the numbers 1,3, 5, -7 are literals
	 String my_str = "Hello World"; //string literals are surrounded by double quotes
	 
	 //compound assignment statements!
	 //+, -, *, /, % are common mathematical operators
	 int x = 5; 
	     x += 5; //the same as x = x+5
	     x *= 5; //the same as x = x*5
	     x/= x;  // the same x - x/x;
	     
	     //boolean expressions
	     // an expression that evals to True/False
	     // relational operators are useful when writing these
	     // <, >, <=, >=, are relational operators
	     //==, != are equality operators
	     boolean my_expression = (x>5);
	     System.out.println(my_expression);
	    		 my_expression = (x==3000); //is x equal to 3000?
	    		 
	     // check if x is in the range [-500 9001]
	     // x >= -500 and x <= 9001
	     // AND -> &&
	     boolean y = x >= -500 && x <= 9001;
	  
	     //check if x outside of the range [30 50]
	     // x <30 or x>50
	     y = x < 30 || x > 50;
	     
	     //NOT in java!
	     y = !(x < 30 || x > 50); // true if x is in the range [30 50]
	     
	     int a = 5;
	     boolean b = true;
	     int c = 30;
	     y = a ==5 && a!= 5 && b;
	     //what is the value of y? -> false because all must be true when using &&
	     
	     y = (a==5) || !(a==5) || false; // y = 
	     // (a==5) or ! (a==5) or false
	
	     y = (a!=5)&&(b||!b)&&true; //what is y? false
	     
	     y =!((a!=5)&&(b||!b)&&true); //what is y?
	        /*
	         * !(a!=5)||!(b||!b)||!true
	         * a==5 || (b&&!!b) || false
	         * a==5 || (!b && b) || false
	         * a==5 || false || false
	         */
	
	   
	         /*
	          * casting
	          * int x  = 5/3; //1
	          * integer divison results in an int
	          * doubles: 3.5, 2.13
	          * 
	          * double x = 5/3; //1
	          * if the operands are integers than integer math will take place
	          * double x = 5.0/3;
	          * as long as one of them is a decimal then you will get a decimal result
	          * int x = (int)(5.0/3);
	          * casting is transforming from one type to another. 
	          * Syntax: parenthesis with type inside
	          */	          
	
	
	
	
	
	
	}

}
