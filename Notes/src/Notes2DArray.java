

public class Notes2DArray {

	public static void main(String[] args){
		
		int[] my1D = new int[3];
		int[][] my2D;
		
		//int[r][c] -> first num is number of rows
		//second number -> number of columns
		int[][]my2D2 = new int[4][3]; //12 elements 
		
		
		//a 2d array in java is a stack of 1D arrays
		//you can grab individual rows easily but not individual columns!
		
		//reading/writing to a 2D array
		
		System.out.println(my2D2[0][0]); //top left element

	
		System.out.println(my2D2[3][0]); //bottom left-most element
		
		
		//.length on a 2D array? -> gives you number of rows
		System.out.println(my2D2.length);
		
		System.out.println(my2D2[0].length); //gives you number of columns
		
		//what happens if you use only one set of square brackets with 2D arrays?
		int[] row0 = my2D2[0]; //grabs row 0 from my2D2
		int[] row1 = my2D2[1]; //grabs row 1 from my2D2
		int[] row2 = my2D2[2]; //grabs row 2 from my2D2
		int[] row3 = my2D2[3]; //grabs row 3 from my2D2

		//write the loop to print out all the values in the first row
		
		for(int col = 0; col < my2D2[0].length; col++){
			System.out.println(my2D2[0][col]);
		}
		
		//do the same thing with an enhanced for-loop
		
		//for(type name: array/structure){
		//}
		
		//for each number in the first row of my2D2
		for(int num: my2D2[0]){
			System.out.println(num);
			num = -5; //if you are trying to alter the array, don't use an enhanced for-loop
			//with primitive types (int, boolean, double,etc.) - a copy is made of the values in the structure
		}
		
	
		//write the loop to print out all the values in the last row
		
		
		//declare and instantiate a 4x4 String 2D array
		String[][] Str2D = new String[4][4]; //number represents total size NOT indexing!
		
		//fill the diagonals with "turkey"
		//everything else should be "pumpkin"
		
		for(int row = 0; row < Str2D.length; row++){
			
			for(int col = 0; col < Str2D[row].length; col++){
				if(row==col){
					Str2D[row][col] = "turkey";
				}else{
					Str2D[row][col] = "pumpkin";
				}
			}
		}
		
		//print values
		//objective: be able to read and understand an enhanced for loop
		//you will not be asked to write  them
		for(String[] row: Str2D){
			for(String str: row){
				System.out.print(str);
			}
			
			System.out.println();
		}
		
		
		
		
		
		
	
	}

	
}
