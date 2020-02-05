import java.util.ArrayList;


//Notes Array List
public class Driver {
	public static void main(String[] args){
		
		int[] nums = new int[50];
		for(int i = 0; i < nums.length; i++){
			nums[i] = (int)(Math.random()*100);
			System.out.println(nums[i]);
		}
		
		
		//I need to expand the 1d array to hold a hundred elements
	//data must be preserved
		 int[] bigger = new int[nums.length*2];
		 for(int i = 0; i < nums.length; i++){
			 bigger[i] = nums[i];
		 }
		
		 //ArrayList -> abstraction of a LIST in java
		 //methods: adding / deleting / inserting
		 ArrayList<String> arr; //angle brackets for ArrayList specifies
		 						//the type of objects the list stores
		//declaration and instantiation
		 ArrayList<Integer> myNums = new ArrayList<Integer>();
		 
		 
		 //adding to a "list"
		 myNums.add(7);
		 myNums.add(13);
		 myNums.add(99);
		 
		 System.out.println(myNums);
		 System.out.println(myNums.size());
		
		//add method #2
		 //myNums.add(index,element)
		 myNums.add(0, 1234); //add 1234 at location 0
		 System.out.println(myNums); //print state of the list after adding to index 0
		
		 //What happens if index  provided is invalid?
		 //myNums.add(-1,1234);out of bounds
		 myNums.add(4,1234); //valid to specific index to be the next open spot
		 System.out.println(myNums);
		 
		 //try adding to an index that's definetly not at the edge of the list
		 //myNums.add(99,1234); //valid to specific index to be the next open spot
		 //System.out.println(Nums);
		
		 //removing elements from an arraylist
		 myNums.remove(0); //remove the element at index 0
		 System.out.println(myNums);
		 myNums.remove(0); //remove the element at index 0
		 System.out.println(myNums);
		 
		 
		 //remove from a non-valid index?
		 //myNums.remove(3); //size 3, remove at index 3
		 //out of bounds exception
		 
		 //reading elements = .get
		 
		 //declare and instantiate a new list
		 //fill it with numbers between -50 and 50 (100 of them)
		 //filter out all even numbers
		 
		 ArrayList<Integer> arr1 = new ArrayList<Integer>();
		 for(int i = 0; i < 100; i++){
			 arr1.add((int)(Math.random()*(101)-50));
			 
		 }
		 
		 //remove all evens
		 arr1.get(0); //grab element at position 0
		 for(int i = 0; i < 100; i++){
			 arr1.get(i);
			 	if(arr1.get(i)%2==0);
			 	arr1.remove(i);
		 }
		 
		 
		 
		 
	}
}
