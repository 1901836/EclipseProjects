import java.util.Scanner;

public class RandomNumberNotes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a magic-8-ball style question");
	//string question = input.next();
	/* random numbers in java using Math method random() */
	    System.out.println(Math.random());
	    
	    
	    //What does Math.random() return to the user?
	    //can you guess the range of values?
	    //[0-1} -> non-inclusive on the upper end, you'll never get 1.0
	    while(true){
	    	System.out.println( (int) (Math.random()*10));	
	    }
	//how do we generate a number between 0 and 100 inclusive?
	//101 works instead of 100
	// (int) (Math.random()*101)  
    //how do we generate a number between 10 and 100
	// (int) (Math.random()*91)+10;
	//[min max] -> (int) (Math.random*(range+1))+min;
	//range: max-min
	
	    /*
	     * write a simple magic-8 ball with 5 canned responses
	     * make decision based on that number to figure out what message to print out
	     */
	
	int n = (int)(Math.random()*10);
	if(n<1){
		System.out.println("No Way!");
	}
	if(n<2){
		System.out.println("Heck Yes");
	}
	
	
	
	}
}
