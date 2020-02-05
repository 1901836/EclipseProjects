import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;




public class Froggy {


//attributes of a frog
private int x,y; //frog position
private int vx, vy; //frog velocities
private boolean alive;
private int width, height;
private Image img; //image for frog

//write the constructor for Froggy 
//which takes a String fileName that will be used for the image setup
//set x and y to be the middle of a 400 by 400 screen
//set width and height to be 50

//for constructor - public nameOfClass(any parameters for constructors){
	//assignment statements for attributes (instance variables)
//}
public Froggy( String fileName) {
	x = 450;
	y = 900;
	vx = 0;
	vy = 0;
	width = 50;
	height = 50;
		//helper functions - ok to be blackboxed
	img= getImage(fileName);
	init(x,y);
	
}

public Froggy(String fileName, int startX, int startY){
	x = startX;
	y = startY;
	vx = 0;
	vy = 0;
	width = 50;
	height = 50;
	img = getImage(fileName);
	init(x,y);
}

public void setVx (int vx){ //setting velocity variables, vx setter, return void
	this.vx = vx;
	}

	
public int getVx() {
	return vx;
}

public int getVy() {
	return vy;
}

public void setVy (int vy){ //Vy setter, return void, only to set values
		this.vy = vy;
	}


public boolean collided(int ox, int oy, int ow, int oh){ //collision code
	
	Rectangle obs = new Rectangle(ox,oy,ow,oh); //from parameters
	Rectangle froggy = new Rectangle(x,y,width,height); //from attributes
	return obs.intersects(froggy);

}





public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
	tx.setToTranslation(x,y);
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
	tx.setToTranslation(x, y);
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public void move() { //movement setter, blackboxing code
	tx.translate(vx,vy);
	x+=vx;
	y+=vy;
	if(y<0){ //boundary for y
		y=850;
		x = 450;
		tx.setToTranslation(x,y);
	}
	if(y>50 && y < 400 && (x<0 || x>850)){
		y = 825;
		x = 450;
		tx.setToTranslation(x, y);
	}
	if(y>850){ //boundaries for y
		y=850;
		tx.setToTranslation(x, y);
	}
	if(x<0){
		x=0;
		tx.setToTranslation(x, y); //boundaries for x on the left
	}
	if(x>850){
		x=850;
		tx.setToTranslation(x,y); //boundaries for x on the right
	} 
	
	
	
}

private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

//draw the affinetransform
public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.drawImage(img, tx, null);
}

private void init(double a, double b) {
	tx.setToTranslation(a, b); //don't scale it that interferes with collision
	tx.scale(1, 1); //1 to 1 scale now but increasing it increases the size of the frog
//making it a decimal reduces the frog's size
	}

// converts image to make it drawable in paint
private Image getImage(String path) {
	Image tempImage = null;
	try {
		URL imageURL = Froggy.class.getResource(path);
		tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return tempImage;
}










}