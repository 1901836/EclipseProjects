
public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		//invoke the slideRight method on the array 
		int [] arr = new int[3];
		arr[0] = 1;
		arr[1] = 0;
		arr[2] = 0;
		
		Board b = new Board();
		
		b.slideRight(arr);
		System.out.println(b);
		//print out the array to see if slideRight
		//worked
		
		
	}

}
