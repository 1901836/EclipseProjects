
// burger inherits from Food 
//burger is the child class 
//food is the parent class (inherited class)
//burger is a subclass of the food class
public class Burger extends Food {
	//what does it mean to be a burger
	private int numPatty;
	private int numCheese;
	private boolean hasBacon;
	private boolean hasPickles;
	
	public Burger(){
		//calories is inherited from Food (parent class)
		calories = 1000;
		numPatty = 1;
		numCheese = 0;
		hasBacon = false;
		hasPickles = true;
	}
	
	
	public Burger(int param_patty, int param_cheese){
		this(); //invoke the default (no argument) constructor
		numPatty = param_patty;
		numCheese = param_cheese;
	}


	public int getNumPatty() {
		return numPatty;
	}


	public void setNumPatty(int numPatty) {
		this.numPatty = numPatty;
	}


	public int getNumCheese() {
		return numCheese;
	}


	public void setNumCheese(int numCheese) {
		this.numCheese = numCheese;
	}


	public boolean isHasBacon() {
		return hasBacon;
	}


	public void setHasBacon(boolean hasBacon) {
		this.hasBacon = hasBacon;
	}


	public boolean isHasPickles() {
		return hasPickles;
	}


	public void setHasPickles(boolean hasPickles) {
		this.hasPickles = hasPickles;
	}
	
	
	
}
