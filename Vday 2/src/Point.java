import java.awt.Color;

public class Point {
	int x, y;
	Color c;
	// finish the constructor for Point that will
	// allow someone to create a point Object
	
	public Point(int paramX, int paramY){
		//set up the variables
		x = paramX;
		y = paramY;
		
		
		//set up a color
		int red = (int)(Math.random()*(256)+ 0); //max : 255 min: 0
		int green = (int)(Math.random()*(256)+ 0);
		int blue = (int)(Math.random()*(256)+ 0);
		
		//create color object set the instance variable
		c = new Color(red, green, blue);
		
	}


}