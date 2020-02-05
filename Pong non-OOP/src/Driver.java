/*Leave feedback/constructive criticism here :)
 * gj
 * It is mostly fine but the ball often lags when it tries to bounce off the paddles and just gets stuck.
 * Ball gets stuck at bottom. The different bouncing when the paddle is moving isn't done very well
 * goes thruogh the paddle
 * Good basketball game. Dribble detections on the ground is amazing
 * 
 * ball does not follow the laws of conversation of momentum
 * why the ball so big and slow it makes the game too easy it needs a challenge
 * paddles are slow and lags at holding
 * 
 * love the color! however, ball does not bounce correctly off the bottom left (doesn't do physics)
 * 
 * I hate the colors, they make my eyes hurt and not want to play, please change them.
 * Also, Everything is smooth, however, the ball movement is a little sporadic and makes no sense at times.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {
int table_width = 900; //width of the screen "table"
int table_height = 600;//height of the screen "table"

//ball variables
int radius = 50;//radius of the ball
int g = 10;// g is just the gravity for the ball

//ball position
int b_x = 0; //ball x
int b_y = 0; //ball y


//ball movement
int b_vx = 4; //ball velocity for the x position
int b_vy = 3;//ball velocity for the y position

 

//paddle variables
int p1x = 0; //paddle 1 x position
int p1y = 175;//paddle 1 y position
int p2x = 873;//paddle 2 x position
int p2y = 175;//paddle 2 y position
int pw = 20;//paddle 1 and 2 width
int ph = 120;//paddle 1 and 2 height

//velocity variables for paddle 1 and 2
int p1v = 0, p2v = 0;//the velocity for each paddle
// In Case of overlap:
//max-min < width1 + width 2
//when there's no overlap:
//max - min > w1 + w2
int p1score= 0;//what the score starts at
int p2score=0;

 


//drawing should be done here
public void paint(Graphics g) {

super.paintComponent(g);

//painting the background
// set color for changing color before paint method
g.setColor (new Color(66, 194 , 245));//background color, it's a blue
g.fillRect(0,0,table_width, table_height);//should be the background and frame

//paint a paddle
g.setColor(Color.WHITE);
g.drawRect(p1x, p1y, pw, ph);//Paddle 1 dimensions, height, length, and width
g.fillRect(p1x, p1y, pw, ph);

g.setColor(Color.WHITE);
g.drawRect(p2x, p2y, pw, ph);//This is paddle 2 dimensions, the height, length, width and such
g.fillRect(p2x, p2y, pw, ph);

g.setColor(Color.WHITE);// ball position number in the center of the screen between P1 and P2 points
g.drawString(b_x+"", 400, 100);

//draw the ball based on its properties (variables)
//set color for ball before trying to draw it
g.setColor(Color.WHITE);
g.fillOval(b_x,b_y,radius, radius);//ball graphics, white color

//drawing strings for scores!
g.setColor(Color.WHITE);
g.setFont(new Font("Times New Roman", 0, 40));//Player 1 Score Text
g.drawString("P1 Score: " + p1score, 100, 100);

g.setColor(Color.WHITE);
g.setFont(new Font("Times New Roman", 0, 40 ));//Player 2 Score Text
g.drawString("P2 Score: " + p2score, 650, 100);


}

@Override
public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub

b_x+= b_vx;
b_y += b_vy;

//paddles move according to their velocity variable
p1y += p1v;
p2y += p2v;

if(b_y>=520 || b_y<=0){
b_vy = -b_vy;
}

//scores, and points
//or part plus y means that it accounts for the other side in this case the right one
//sets boundaries for ball so it doesn't go off into negative space
if(b_x>=845){
//b_vx = -b_vx;
//}
//if(b_x>=450){
p1score++;
//score count
b_x=table_width/2;//spawn point in center after ball hits right side of frame
b_y=table_height/2;
}
//when x position of ball is less than zero, this indicates left wall has been hit. Then p2 gets another point.
if(b_x<=0){
p2score++;
b_x=table_width/2;//center spawn point after ball hits left side of frame
b_y=table_height/2;
}
//}

if(b_x==0) {
b_vx = -b_vx;
}
if(b_y==0){
b_vy = -b_vy;
}
//ball bounces off the two paddles
//pw and ph are for the quadrants and intersections with the ball and the paddle
//helps set boundaries and limits on the space where they intersect
if(b_x>=p1x && b_x<=p1x + pw){
if(b_y >= p1y && b_y<=p1y + ph){
b_vx=-b_vx;
b_vy=-b_vy;
b_vy+=1;//velocity change after ball hits left paddle, for player 1, it should increase by 1
b_vx+=1;//same velocity change but for the x position of the ball
}// velocity just keeps increasing, doesn't reset once ball spawns again in the center, as it makes the game more interesting and fast paced
//Increasing velocity is a design feature
}
//Collision between the ball and the right paddle
if((b_x + radius)>=p2x && b_x<p2x + pw){
//needed to add the radius in order to get that right top quadrant to touch the paddle
//ball velocity plus the radius to segment the top quadrant of ball, when it intersects with the paddle to get collision
if(b_y >= p2y && b_y<=p2y+ph){
b_vx=-b_vx;//ball bounces after collision happens between ball and paddle 2
b_vy=-b_vy;

}
}

repaint();
}

public static void main(String[] arg) {
Driver d = new Driver();
}

public Driver(){

JFrame f = new JFrame();
f.setTitle("Pong");
f.setSize(table_width,table_height);
f.setBackground(Color.BLACK);
f.setResizable(false);

f.addKeyListener(this);


f.add(this);
t = new Timer(17,this);
t.start();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
Timer t;


@Override
public void keyPressed(KeyEvent e) {
// TODO Auto-generated method stub
System.out.println(e.getKeyCode());

if(e.getKeyCode()==87 ){
if(p1y>0){
//change position of paddle y by some offset
//87 is for W key, is UP for Player 1 paddle
p1y -= 15; //user has released the control for paddle movement
//turn off movement
}
}else if(e.getKeyCode()==83){ //83 is code for S, which is DOWN for Player 1 paddle
if(p1y<448){ //check whether P1 paddle has hit lower boundary
p1y +=15; //if not hit lower boundary, move P1 paddle
}

}

//38 is UP arrow code, which is UP for player 2 paddle
if(e.getKeyCode()==38){
if(p2y>0){
p2y-=15;
}
//40 is DOWN arrow, and DOWN for Player 2 paddle
}else if(e.getKeyCode()==40){
if(p2y<448){
p2y+=15;
}
}
}


@Override
public void keyReleased(KeyEvent e) {
// TODO Auto-generated method stub

}

@Override
public void keyTyped(KeyEvent e) {
// TODO Auto-generated method stub
//typed means you pressed and released
}
}