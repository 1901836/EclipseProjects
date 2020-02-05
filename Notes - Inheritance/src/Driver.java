import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {
		//files to instantiate objects
		
		Food f = new Food();
		Food f2 = new Food(2000);
		
		Burger b = new Burger();
		Burger doubleCheeseBurger = new Burger(2,2);
		
		//because a burger is a Food
		//we have access to all public methods
		b.getCalories();
		
		//a container a food
		ArrayList<Food> food = new ArrayList<Food>();
		food.add(new Food());
		
		//any "Food" type can be stored in this container
		//is-a check: Burger is-a food
		food.add(new Burger());
		food.add(new VeggieBurger());
		
		ArrayList<Burger> burgers = new ArrayList<Burger>();
		
		burgers.add(new Burger());
		burgers.add(new Burger(3,3));
		
		//Food is-a Burger(is this true?) not necessarily
		//fails is-a check therefore not legal to do
		//burgers.add(new Food())
		
		
		
		
		
		
		
		
		
		
	}

}
