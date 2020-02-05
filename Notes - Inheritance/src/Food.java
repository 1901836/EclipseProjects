
public class Food {
	
	//attributes of the food class
	protected int calories; //protected allows direct access by RELATED classes
	private String name;
	private int acidity;
	private boolean isHot;
	
	//job of constructor is to setup our instance variables
	
	public Food(){
		calories = 50;
		name = "generic";
		acidity = 7;
		isHot = false;
	}
	
	
	//allow instantiation of Food objects with a specific caloric value
	public Food(int calories){
		this(); //will invoke the zero - parameter constructor
		
		//now handle stuff specific to this constructor
		this.calories = calories; //naming conflict
								  //(this dot) specifies variables in the class
		
	}


	public int getCalories() {
		return calories;
	}


	public void setCalories(int calories) {
		this.calories = calories;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAcidity() {
		return acidity;
	}


	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}


	public boolean isHot() {
		return isHot;
	}


	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}
	
	
	
	
	
	
	
	
}
