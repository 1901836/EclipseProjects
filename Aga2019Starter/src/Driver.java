import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	//size of jframe
	int screen_width 	= 900;
	int screen_height 	= 800;

	//max number
	int max = 10000;
	
	
	//array for radii of each circle
	int[] rads = new int[max]; //arrays holding all the diff radii of the food
	int[] x = new int[max];// x and y arrays for the food position
	int[] y = new int[max];
	
	Color[] colors = new Color[max];
	
	//player variables
	//radius, positon and such
	int pw = 20;
	int px = screen_width/ 2 - pw/2;
	int py = screen_height/ 2 - pw/2;
	
	//declare a new set of arrays for food
	int[] foodx = new int[max];
	int[] foody = new int[max];
	
	//
	int[] enemiesx = new int[max];
	int[] enemiesy = new int[max];
	
	//movement variables
	//velocity for player
	int vx = 0;
	int vy = 0;
	
	double pvx = 0;
	double pvy = 0;
	
	
	
	
	// reading a val from a 1d array
	// System.out.print( x[0]); //reading value
	// x[0] = 5; //writing is similar to regular variables but now you have to specify WHERE
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//write a loop setup to visit every possible index
		for(int i=0; i < foodx.length; i++){
			
			//size, shape, and color of food, enemies, and player
			//draw food
			g.setColor(Color.green);
			g.fillOval(foodx[i],foody[i],10,10);
			
			
		}
		
		for(int i=0; i< x.length; i++){
			//draw enemies
			g.setColor(colors[i]);
			g.fillOval(x[i],y[i],20,20);
			i+=5;
		}
		
		//draw the player
		g.setColor(Color.blue);
		g.fillOval(px, py, pw, pw);
		g.setColor(Color.black);
		g.drawOval(px, py, pw, pw);
		
		

		
	}//end of paint method - put code above for anything dealing with drawing -
	
	
	
	Font font = new Font ("Courier New", 1, 50);
	public void update() {
		
		//px += pvx;
		//py += pvy;
		
		//move the background (enemies and food)
		//and it will look like the player is moving!
		
		//for food and circle collision
		for(int i = 0; i <foodx.length; i++){
			foodx[i] += pvx;
			foody[i] += pvy;
		//distance formula, food: fx, fy player:px,py
			//square root of (x2-x1^2 + (y2-y1)^2
			//Math.sqrt()
			//Math.pow(base,exp)
			double distance = Math.sqrt((Math.pow((foodx[i]-px),2))+(Math.pow(foody[i]-py,2)));
			double sum = distance/2;
			if((distance<rads[i]+pw/2)&&(pw<=105)){
				foodx[i] =(int)(Math.random()*(11111)-4444); //food spawn point
				foody[i] =(int)(Math.random()*(11111)-4444);
				pw+=1;
			}else if((distance>rads[i]+pw/2)&&(pw>105))
				 pw+=0;
				}
			
		
		int px = screen_width/ 2 - pw/2;
		int py = screen_height/ 2 - pw/2;
			//remember you want CENTER points
		   // your x,y values are in the top-left corner!
			
		//players and enemy collision
		for(int i = 0; i < enemiesx.length; i++){
				x[i] += pvx;
				y[i] += pvy;
				double distance2 = Math.sqrt((Math.pow(x[i]-px,2)+(Math.pow(y[i]-py,2))));
				double sum1 = distance2/2;
				if(distance2<rads[i]+pw/2){
					x[i] =(int)(Math.random()*(10000)-44);
					y[i] =(int)(Math.random()*(10000)-44);
					pw+=1;
		}
		}
		
	for(int i = 0; i < enemiesx.length; i++){
		enemiesx[i] +=pvx;
		enemiesy[i] += pvy;
		//enemies movement 
		//direction of movement based on enemies position
		if(x[i]<2000 && y[i]>1000){
			x[i]++;
			y[i]--;
		}else if(x[i]>=2000 && y[i]>1000)
			x[i]--;
			y[i]--;
	if(x[i]>=2000 && y[i]<=1000){
			x[i]--;
			y[i]++;
	}else{
		x[i]++;
		y[i]--;
	}
	  
		
	//double distance3 = Math.sqrt(Math.pow((enemiesx[i]+(rads[i]/2))-(foodx[i]+rads[i]/2)),2) + (Math.pow((enemiesy[i] + (rads[i]/2))-(foody[i]+(rads[i]/2)),2));	
		
		
		
		
		
	}
	for(int i = 0; i < enemiesx.length; i++){
		enemiesx[i] +=pvx;
		enemiesy[i] += pvy;
	//double distance3 = Math.sqrt(Math.pow((enemiesx[i]+(rads[i]/2))-(foodx[i]+rads[i]/2)),2) + (Math.pow((enemiesy[i] + (rads[i]/2))-(foody[i]+(rads[i]/2)),2));	
		
		
		
		
		
	}
	
		
		
	}//end of update method - put code above for any updates on variable
		
	
	//==================code above ===========================
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	public Driver(){
		JFrame f = new JFrame();
		f.setTitle("Agar.io");
		f.setSize(screen_width, screen_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);
		
		//this special "method" is called the Constructor
		//initialized structures here!
		
		
		//this entire block generates random values for our
		//arrays which are the properties of the cells
		int counter = 0;
		while(counter<max){
		rads[counter] = 10; //all must be the same size to start
			x[counter] = (int)(Math.random()*(11111)-4444);
			y[counter] = (int)(Math.random()*(11111)-4444);
			
			//randomize food using constructor(which only runs once! ever)
			
			// x - > [-500000, 500000]
			// y - > [-500000, 500000
			
			foodx[counter] = (int)(Math.random()*(11111)-4444);
			foody[counter] = (int)(Math.random()*(11111)-4444);
			
			//create colors from your color lab
			//students generate r, g, b values for Color
			
			int red = (int)(Math.random()*256);//random colors for enemies
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
			Color newColor = new Color (red,green,blue); //use random numbers
			colors[counter] = newColor;
			
			
			
			counter++;
		}
		
		
		

		f.add(this);
		
		
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		
		case 38: //when key is pressed, velocity changes and diagonals don't go faster and as player grows bigger speed gets slower
			//diagonals don't go faster
			if(pvx>0){pvy = 200/pw; pvx = 200/pw;}
			if(pvx<0){pvy = 200/pw; pvx = -200/pw;}
			else{
				pvy = 200/pw;
			}
		break;
			
		case 40: // if down key is pressed
			if(pvx>0){pvy = -200/pw; pvx = 200/pw;}
			if(pvx<0){pvy = -200/pw; pvx = -200/pw;}
			else{
				pvy = -200/pw;
			}
			break;
			//d>r1+r2
			//d<=((r1+r2))
			
		case 37: //if left key is pressed

			if(pvy>0){pvy = 200/pw; pvx = 200/pw;}
			if(pvy<0){pvy = -200/pw; pvx = -200/pw;}
			else{
				pvx = 200/pw;
			}
			break;
		case 39: //if right key is pressed

			if(pvy>0){pvy = 200/pw; pvx = -200/pw;}
			if(pvy<0){pvy = -200/pw; pvx = -200/pw;}
			else{
				pvx = -200/pw;
						}
			break;	
	//to lose mass when space bar is pressed to help player go faster
		case 32: //if space bar is pressed
			if(pw>20){pw-=3;}
			if(pw<20){pw+=0;}
			break;
		
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		switch(e.getKeyCode()){
		//when everything is released, everything should stop, velocity becomes zero and such
		case 38:
			pvy = 0;
		break;
		
		case 40: // if down key is pressed
			pvy = 0;
			break;
		
		case 37: //left key
			pvx = 0;
			break;
			
		case 39: //right key
			pvx = 0;
			break;
		
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 

	
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent m) { //to direct with the mouse, code not in use currently
		// TODO Auto-generated method stub
		//System.out.println(m.getX() + ":" + m.getY());
		
		/*if(m.getX()<px){
			pvx = -5;
		}else{
			pvx = 5;
		}
		if(m.getY()<py){
			pvy = -5;
		}else{ 
			pvy = 5;
		}
		*/
	}
	
}


/*Please Leave Comments Here and Be Nice :) Please restart/run again when you leave
 *if you hold down the down key and then press left key then u go the wrong way
 * you did a good job with changing the speed however the enemies move only in one direction.
 * the game is pretty good except the enemies only move in 1 direction and the eating mechanism is very buggy
 * it eats enemies and food even when it's not touching (especially top left)
 * You gotta fix that movement... I go the wrong way a lot. Also top left collision detection.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


