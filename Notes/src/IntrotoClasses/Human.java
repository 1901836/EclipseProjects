package IntrotoClasses;

/*
 * Objectives(s): Learn the anatomy of a class in java! (parts of a class)
 */


public class Human{ //class signature - public keyword followed by the class keyword
						//public allows class to be referred by other files
	
	//classes have properties or attributes
	//a class is a blueprint for an "OBJECT"
	
	private int age; //always try to hide info from outsiders!
	private String name; //a human has a name
	//because we changed it to a public entity we can view it outside that class
	

	//specify what happens
	//when we construct an object of this type
	public Human(){ //all constructor do not have a "return" type like methods
					//they must be named exactly after class name
		//System.out.println("i called the constructor");
		
		//define the values for the instance variables
		age = 0;
		name = "Justin";
		
	}
	
	
	/*
	 * How do we provide access to private attributes
	 * if we wanted to?
	 * 
	 * getters and setters
	 * getters - allow read access to a private data members (attribute)
	 *setters - allow for write access to a private data member 
	 * 
	 * 
	 */

	public String getName(){ //naming convention getAttributeName()
		return name; //return name attribute to method invoker
	}
	
	//setter for name
	//allow outsiders to set the name(write)
	
	public void setName( String newName ){
		if(newName.equals("Your Mom")){
			System.out.println("grow up!");
		}else{
			name = newName; //ok to overwrite name content
		}	
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge( int newAge){
		if(newAge>150){
			System.out.println("Be real");
		}
		if(newAge<0){
			System.out.println("That's not even possible");
		}else{
			age = newAge;
		}
	}
	
	
	
}
