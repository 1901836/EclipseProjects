
import java.util.Scanner;


public class IfStatement {

	public static void main(String[] args) {
		
 /* 
  * if(boolean expression){
  * 
  * }
  * 
  * if statements are sometimes known as blocking statements/code
  * the body of the if statement only runs iff
  * the boolean expression (aka condition) evaluates to true
  * 
  * reserved keywords cannot be used as var (variable) names
  * 
  * 
  */
		
		Scanner input = new Scanner(System.in);  //for user input
		System.out.println("Enter number of seconds");
 
		int data = input.nextInt("You entered: " + data); 	
		if(data <60){ 
			System.out.println("less than a minute");
			
		 if(data >=60){
			 System.out.println("You entered" +data/60+ "minutes");
			 
		 }else{
			 System.out.println("you entered" + data + "seconds");
			 
		 }
			
		 
		 // (int) 5.4 -> explicit cast (you are literally writing the conversion)
		 //implicit is when java does it behind the scenes
		 // "you" + "5" + "me"
		}
		
	}

}
