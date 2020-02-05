
public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * so you can repeat things
		 * 
		 * 
		 * while(condition to run){
		 * 		//body of loop
		 * }
		 * 
		 * infinite loop! condition is always true!
		 * while(true){
		 *    System.out.println("you are the best);
		 *}
		 * 
		 * 
		 * 
		 */
		
		 //counting to 10 with a counter variable
		 /*int cntr = 5;
		 while(cntr<=80){
			System.out.println(cntr+1);
			
			//you can have any valid java expression in the body
			//increment counter variable used in condition
		  cntr+=2; //++ is the same as +=1
		   }
		   */
		
	/*int cntr = -5;
	while(cntr<=500){
		if(cntr%15==0 && cntr!=0){
			System.out.println(cntr);
		}
		cntr+=1;
	}
	*/
		/*int cntr = 14;
		int sum = 0;
		while(cntr<=100){
			if(cntr%2==0){
				sum+=cntr;
			}
			cntr++;
	}
		System.out.println(sum);
		*/
		
		int num = 1235873;
		int sumDigits = 0;
		while(num>0){
		   
			int rightDigit = num%10;
			sumDigits += rightDigit;
			
			
			//remove rightmost digit
			num=num/10;
		}
		 System.out.println(sumDigits);
		
	}

}
