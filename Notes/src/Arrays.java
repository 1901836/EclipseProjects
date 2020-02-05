

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//primitive types
		//base of all operations
		//basic - fundamental types
		//store one value at a time
		int x, z = 3; //numerical types default to 0 or 0.0 when not initialized
		boolean y; //default for booleans is false
		
		// first data-structure
		// an array
		// 1-row matrix
		// 1-row table
		
		int[] myarray; //reference to a 1d array
					   // the array does not exist however...
					   // there is not structure, just a variable that holds its address
		
		//full array declaration
		int [] myarray2 = new int[2]; //no array is created unless there was a prior call to new
									  //the number inside the bracket is the length
		
		//create a boolean array with a length of 31
		boolean[] arr = new boolean[31];
		
		//accessing elements - most common rookie mistake
		System.out.println(arr);
		
		//access the last element in the boolean array
		System.out.println(arr[30]); //where is the last element - 30 not 31 because it starts at 0
		
		//indexing in everything but matlab starts at 0!!!
		//first element is at index 0;
		System.out.println(arr[0]); //access element at position 0
		
		//property of an array
		//using the dot operator
		int length = arr.length; //arrayName.length -> gives you length of any array you might have
		
		/*
		 * Generate 100 numbers between 1 and 100 inclusive
		 * store each random number in an array called data
		 */
		
		int[] data = new int[100]; //data array of ints
		int index = 0; //loop generates addresses for the data array
		while(index < data.length){
			
			int rand = (int)(Math.random()*(100-1+1)+1);
			
			
			//write at current index position
			data[index] = rand; //assign position to the value rand
			index++;
			
		}
		
		System.out.println(Arrays.toString(data));
		
		//write the block of code to double every value
		//in the data array
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
