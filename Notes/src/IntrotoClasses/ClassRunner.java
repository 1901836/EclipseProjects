package IntrotoClasses;

public class ClassRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//we can now use the class as a type!
		Human a;
		Human Dave; //references
		Human Bob; //references not real humans
		
		
		
		int[] arr = { 1 , 2 , 3 }; //reference not actual array
		Dave = new Human(); //instantation of the object
		//System.out.println(Bob); bob must be instantiated
		
		//System.out.println(Dave); //instantation of the object
								  //a call to a "constructor"
								  //constructs the object
							      //declare the properties
								 //written for that class constructor
		//System.out.println(arr);
		
		//dot operator exists for all objects
		Dave.setName("Your Mom");
		System.out.println(Dave.getName());
		
		Dave.setName("Sally");
		System.out.println(Dave.getName());
	
		
		Dave.setAge(-2);
		System.out.println(Dave.getAge());
		
		Dave.setAge(160);
		System.out.println(Dave.getAge());
		
		HalloweenCandy SourPatch = new HalloweenCandy();
		//System.out.println(SourPatch);
		
		
	}

}
