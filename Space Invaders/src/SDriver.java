import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
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
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class SDriver extends JPanel implements ActionListener, KeyListener,
MouseListener, MouseMotionListener {

	int sw = 700; //screen width
	int sh = 600; //screen height
	
	Player player; 
	Enemies[] enemiesRow1 = new Enemies[5];
	Enemies[] enemiesRow2 = new Enemies[5];
	Bullet bullet;
	Bomb bomb;
	
	int Score = 0;
	int lives = 3;
	String lose = "YOU LOSE";
	boolean shoot = false;
	int HighScore = 200;
	
public void paint(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,sw,sh);
	
	Font font = new Font("Courier New", 1, 20);
	Font font2 = new Font("Courier New", 1, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString((("Lives:" + Integer.toString(lives))),600,20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(("Score:")+Integer.toString(Score), 0, 20);
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString(("High Score:")+Integer.toString(HighScore),0,50);
	
		
		
		player.paint(g);
		
		for(int i = 0; i < enemiesRow1.length; i++){
			if(enemiesRow1[i].Visible==true){
			enemiesRow1[i].paint(g);
			}
			else if(enemiesRow1[i].Visible==false && Score>=150){
				g.drawString("YOU WIN!", 300, 300);
			}
			for(int j = 0; j < enemiesRow1[i].bombs.size(); j++){
				if(bomb.Visibility==true){
				enemiesRow1[i].bombs.get(j).setBbvy(6);
				enemiesRow1[i].bombs.get(j).paint(g);
				}
			}
			if(player.collided(enemiesRow1[i].getX(), 
					enemiesRow1[i].getY(), 
					enemiesRow1[i].getWidth(), 
					enemiesRow1[i].getHeight()

)){
				lives--;
				enemiesRow1[i].setX(i*75);
				enemiesRow1[i].setY(150);
				enemiesRow1[i].setVx(1);
				
				
			}
		}
		for(int i = 0; i < enemiesRow2.length; i++){
			if(enemiesRow2[i].Visible==true){
			enemiesRow2[i].paint(g);
			}
			else if(enemiesRow2[i].Visible==false && Score>=150){
				g.drawString("YOU WIN!", 300, 300);
			}
			for(int j = 0; j < enemiesRow2[i].bombs.size(); j++){
				if(bomb.Visibility==true){
				enemiesRow2[i].bombs.get(j).setBbvy(8);
				enemiesRow2[i].bombs.get(j).paint(g);
				}
			}
			if(player.collided(enemiesRow2[i].getX(), 
					enemiesRow2[i].getY(), 
					enemiesRow2[i].getWidth(), 
					enemiesRow2[i].getHeight()

)){
				lives--;
				enemiesRow2[i].setX(i*75);
				enemiesRow2[i].setY(50);
				enemiesRow2[i].setVx(1);
		}
			
			 
	
	
		
		
		for(int j = 0; j < player.bullets.size(); j++){
			player.bullets.get(j).setbVy(-5);
			player.bullets.get(j).paint(g);				
		}
		
		if(lives <= 0){
			g.drawString(lose, 315, 300);
			System.exit(1);
		}
		}
		for(int i = 0; i < enemiesRow1.length; i++){
			for(int j = 0; j < player.bullets.size(); j++){
				if((player.bullets.get(j).collided(enemiesRow1[i].getX(), enemiesRow1[i].getY(), 
						enemiesRow1[i].getWidth(), 
						enemiesRow1[i].getHeight() )) && enemiesRow1[i].Visible==true){
					Score+=10;
					enemiesRow1[i].setVisible(false);
					player.bullets.remove(j);
					
					
			}
			
			}
			for(int j = 0; j < enemiesRow1[i].bombs.size(); j++){
				if((enemiesRow1[i].bombs.get(j).collided(player.getX(), player.getY(), player.getWidth(), player.getHeight()))){
					lives--;
					enemiesRow1[i].bombs.remove(j);
				}
			}
			
			}
		for(int i = 0; i < enemiesRow2.length; i++){
			for(int j = 0; j < player.bullets.size(); j++){
				if((player.bullets.get(j).collided(enemiesRow2[i].getX(), enemiesRow2[i].getY(), 
						enemiesRow2[i].getWidth(), 
						enemiesRow2[i].getHeight())) && enemiesRow2[i].Visible==true){
					Score+=20;
					player.bullets.remove(i);
					enemiesRow2[i].setVisible(false);
					
				
			}
			
			}
			}
		}
		
		
		
public void update() {
	player.move();
	for(int i = 0; i < enemiesRow1.length; i++){
		enemiesRow1[i].move();
		for(int j = 0; j < enemiesRow1[i].bombs.size(); j++){
			enemiesRow1[i].bombs.get(j).move();
		}
	}
	for(int i = 0; i < enemiesRow2.length; i++){
		enemiesRow2[i].move();
		for(int j = 0; j < enemiesRow2[i].bombs.size(); j++){
			enemiesRow2[i].bombs.get(j).move();
		}
	}
	for(int i = 0; i < player.bullets.size(); i++){
		player.bullets.get(i).move();
	}
	
}
	
	
@Override
public void actionPerformed(ActionEvent arg0) {
	update();
	repaint();
}


public static void main(String[] arg) {
	SDriver d = new SDriver();
}

public SDriver() {
	JFrame f = new JFrame();
	f.setTitle("Space Invaders");
	f.setSize(sw, sh);
	f.setResizable(false);
	f.addKeyListener(this);
	f.addMouseListener(this);
	
	//sprite instantiation here
	
	player = new Player("Player.png", 350, 515);
	for(int i = 0; i < enemiesRow1.length; i++){
		enemiesRow1[i] = new Enemies("Enemies.png",i*75, 150);	
		bomb = new Bomb("Bomb.png", enemiesRow1[i].getX(), enemiesRow1[i].getY()+20);
	}
	for(int i = 0; i  < enemiesRow2.length; i++){
		enemiesRow2[i] = new Enemies("Enemies2.png",i*75, 50 );
		bomb = new Bomb("Bomb.png", enemiesRow2[i].getX(), enemiesRow2[i].getY()+20);
	}
	bullet = new Bullet("Bullet.png", player.getX(), player.getY()+20);

	
	f.add(this);
	t = new Timer(17, this);
	t.start();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
}

	Timer t;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==39){ //right key
			player.setVx(5);
			player.setVy(0);
		}
		if(e.getKeyCode()==37){ //left key
			player.setVx(-5);
			player.setVy(0);
		}
		if(e.getKeyCode()==32){ //space bar
		player.fireBullet();
		for(int i = 0; i < enemiesRow1.length; i++){
			enemiesRow1[i].fireBombs();   
		}
		
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==39){ //right key
			player.setVx(0);
		}
		if(e.getKeyCode()==37){ //left key
			player.setVx(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void reset() {

	}

	
}
