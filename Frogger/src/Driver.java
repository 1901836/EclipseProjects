import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener,
		MouseListener, MouseMotionListener {

	int screen_width = 900;
	int screen_height = 900;
	Froggy froggy;
	Car[] carsRow1 = new Car[8];
	Bus[] bussesRow2 = new Bus[8];
	Log[] logsRow1 = new Log[3];
	Log[] logsRow2 = new Log[3];
	Log[] logsRow3 = new Log[3];
	Log[] logsRow4 = new Log[3];
	Log[] logsRow5 = new Log[3];
	Log[] logsRow6 = new Log[3];
	Log[] logsRow7 = new Log[3];
	boolean logCollision = false;
	
	Background bg;
	int Wins = 0; //example
	int Lives = 3;
	String lose = "";
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		bg.paint(g);
		Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		g.drawString((("Lives: " + Integer.toString(Lives))),600,870);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(("Wins:")+Integer.toString(Wins), 0, 870);
		g.setFont(font2);
		g.setColor(Color.WHITE);
	
		
		
		//paint sprite 
		
		
		//g.drawString(lose, 350, 600);
		
		for(int i = 0; i < carsRow1.length; i++){
			carsRow1[i].paint(g);
			
			if(froggy.collided( //collision code with the car
				carsRow1[i].getCarx(),
				carsRow1[i].getCary(),
				carsRow1[i].getCarwidth(),
				carsRow1[i].getCarheight())){
			
				froggy.setX(450);
				froggy.setY(800);
				Lives-=1;
				//if(Lives<0){
					//lose = "Game Over";
					//g.drawString(lose, 350, 400);
					//System.exit(1);
				}
				//reset frog if you have lives still
			}	
		
		
		
		for(int i = 0; i < bussesRow2.length; i++){
			bussesRow2[i].paint(g);
			
			if(froggy.collided( //paints the bus(purple car)
			bussesRow2[i].getbusX(),
			bussesRow2[i].getbusY(),
			bussesRow2[i].getbusWidth(),
			bussesRow2[i].getbusHeight())){ //collision code for the bus
			froggy.setX(450);
			froggy.setY(800);
			Lives-=1;
			
			}
		}
			
		for(int i = 0; i < logsRow1.length; i++){ //painting the log arrays on the screen
			logsRow1[i].paint(g);
			
		if(froggy.getY()<400 && froggy.getY()>=350){
			if(froggy.collided(
			logsRow1[i].getlogx(),
			logsRow1[i].getlogy(),
			logsRow1[i].getlogwidth(),
			logsRow1[i].getlogheight())){
				froggy.setVx(4);
				logCollision = true;
				
				
			}
		}
			
			
		}
		{
		for(int i = 0; i < logsRow2.length; i++){
			logsRow2[i].paint(g);
			if(froggy.getY()<350 && froggy.getY()>=300)
			if(froggy.collided(
					logsRow2[i].getlogx(),
					logsRow2[i].getlogy(),
					logsRow2[i].getlogwidth(),
					logsRow2[i].getlogheight())){
						froggy.setVx(-4);
						logCollision = true;
			}
		}
		}
		
		for(int i = 0; i < logsRow3.length; i++){
			logsRow3[i].paint(g);
			if(froggy.getY()<300 && froggy.getY()>=250){
			if(froggy.collided(
					logsRow3[i].getlogx(),
					logsRow3[i].getlogy(),
					logsRow3[i].getlogwidth(),
					logsRow3[i].getlogheight())){
						froggy.setVx(4);
						logCollision = true;
						
			}
		}
		}
		if(froggy.getY()<250 && froggy.getY()>=200){
		for(int i = 0; i < logsRow4.length; i++){
		logsRow4[i].paint(g);
		if(froggy.collided(
				logsRow4[i].getlogx(),
				logsRow4[i].getlogy(),
				logsRow4[i].getlogwidth(),
				logsRow4[i].getlogheight())){
					froggy.setVx(-4);
					logCollision = true;
		}
		}
		}
		for(int i = 0; i < logsRow5.length; i++){
			logsRow5[i].paint(g);
			if(froggy.getY()<200 && froggy.getY()>=150){
			if(froggy.collided(
					logsRow5[i].getlogx(),
					logsRow5[i].getlogy(),
					logsRow5[i].getlogwidth(),
					logsRow5[i].getlogheight())){
						froggy.setVx(4);
						logCollision = true;
			}
		}
		}
		for(int i = 0; i < logsRow6.length; i++){
			logsRow6[i].paint(g);
			if(froggy.getY()<150 && froggy.getY()>=100){
			if(froggy.collided(
					logsRow6[i].getlogx(),
					logsRow6[i].getlogy(),
					logsRow6[i].getlogwidth(),
					logsRow6[i].getlogheight())){
						froggy.setVx(-4);
						logCollision = true;
			}
		}
		}
		for(int i = 0; i < logsRow7.length; i++){
			logsRow7[i].paint(g);
			if(froggy.getY()<100 && froggy.getY()>=50){
			if(froggy.collided(
					logsRow7[i].getlogx(),
					logsRow7[i].getlogy(),
					logsRow7[i].getlogwidth(),
					logsRow7[i].getlogheight())){
						froggy.setVx(4);
						logCollision = true;
			}
			}
			
			if(logCollision==false && froggy.getY()< 400 & froggy.getY()>50){
				froggy.setVx(0);
				froggy.setX(450);
				froggy.setY(850);
				Lives-=1;
			}
			
			
			
			if( froggy.getY()>50 && froggy.getY()<400 && froggy.getVx()==0){
				froggy.setX(450);
				froggy.setY(850);
				Lives-=1;
				//froggy.setVx(0);
			}
			froggy.paint(g);
		}
		if(froggy.getY()==0){
			Wins+=1;
			//froggy.setVx(0);
			//froggy.setVy(0);
		}
		

	
		
	if(Lives==0){ //when the lives counter reaches 0 then game over will appear
		lose = "Game Over";
		g.drawString(lose, 375, 450);
		
		}
	if(Lives==-1){ //after game over, if another collision or another life lost happens the game will exit automatically 
		System.exit(1);
	}
	
}

	
	public void update() {
		froggy.move();
		
		for(int i = 0; i < carsRow1.length; i++){ //sets the car velocity and helps it move
			carsRow1[i].setCarvx(4);
			carsRow1[i].move();
		}
		
		for(int i = 0; i < bussesRow2.length; i++){ //sets the purple car velocity and helps it move
			bussesRow2[i].setbuxVx(-4);
			bussesRow2[i].move();
		}
		
		for(int i = 0; i < logsRow1.length; i++){ //sets the log velocities and helps it move
			logsRow1[i].setlogvx(4);
			logsRow1[i].move();
		}
		for(int i = 0; i < logsRow2.length; i++){
			logsRow2[i].setlogvx(-4);
			logsRow2[i].move();
		}
		for(int i = 0; i < logsRow3.length; i++){
			logsRow3[i].setlogvx(4);
			logsRow3[i].move();
		}
		for(int i = 0; i < logsRow4.length; i++){
			logsRow4[i].setlogvx(-4);
			logsRow4[i].move();
		}
		for(int i = 0; i < logsRow5.length; i++){
			logsRow5[i].setlogvx(4);
			logsRow5[i].move();
		}
		for(int i = 0; i < logsRow6.length; i++){
			logsRow6[i].setlogvx(-4);
			logsRow6[i].move();
		}
		for(int i = 0; i < logsRow7.length; i++){
			logsRow7[i].setlogvx(4);
			logsRow7[i].move();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Frogger");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);
		
		//sprite instantiation
		
		froggy = new Froggy ("froggy.png", 450, 800); 
		for(int i = 0; i < carsRow1.length; i++){
			carsRow1[i]= new Car("bluecar.png", i*310, 690);
		}
		for(int i = 0; i < bussesRow2.length; i++){
			bussesRow2[i] = new Bus("bus.png", i*325, 548); //calling upon the image and instantiating it
		}
		
		for(int i = 0; i < logsRow1.length; i++){
			logsRow1[i] = new Log("log.png", i*150, 370); // i multiplied by something is the space between each object
		}
		for(int i = 0; i < logsRow2.length; i++){
			logsRow2[i] = new Log("log.png", i*150, 320);
		}
		
		for(int i = 0; i < logsRow3.length; i++){
			logsRow3[i] = new Log("log.png", i*150, 270);
		}
		for(int i = 0; i < logsRow4.length; i++){
			logsRow4[i] = new Log("log.png", i*150, 220); // i multiplied by something is the space between each object
		}
		for(int i = 0; i < logsRow5.length; i++){
			logsRow5[i] = new Log("log.png", i*150, 170);
		}
		
		for(int i = 0; i < logsRow6.length; i++){
			logsRow6[i] = new Log("log.png", i*150, 120);
		}
		
		for(int i = 0; i < logsRow7.length; i++){
			logsRow7[i] = new Log("log.png", i*150, 70);
		}
		
		//player.addMouseListener(this);
	bg = new Background("background.png", 0,0);
		//do not add to frame, call paint on
		//these objects in paint method
		
		
		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
//detect up, down, left, right arrow keypresses
		//call setters for velocity attributes
		
		//System.out.println(e.getKeyCode()); //key codes for each key 
		if(e.getKeyCode()==38){ //up key
			froggy.setVy(-5);
			froggy.setVx(0);
		}
		if(e.getKeyCode()==40){ //down key
			froggy.setVy(5);
			froggy.setVx(0);
		
		}
		

		if(e.getKeyCode()==39){ //right key
			froggy.setVx(5);
			froggy.setVy(0);
		}
		if(e.getKeyCode()==37){ //left key
			froggy.setVx(-5);
			froggy.setVy(0);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) { //calling setters to set Vx and Vy to zero
		//when the key is released
		if(e.getKeyCode()==38){ //up key
			froggy.setVy(0);
		}
		if(e.getKeyCode()==40){ //down key
			froggy.setVy(0);
		}
		if(e.getKeyCode()==39){ //right key
			froggy.setVx(0);
		}
		if(e.getKeyCode()==37){ //left key
			froggy.setVx(0);
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

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void reset() {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
