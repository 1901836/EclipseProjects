

	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;
	
	public class Enemies {
		private int x, y;
		private int vx, vy;
		public boolean Visible = true;
		private int width, height;
		private Image img1;
		public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
		
		
		public Enemies( String fileName) {
			x = 0;
			y = 200;
			vx = 3;
			vy = 0;
			width = 50;
			height = 38;
				//helper functions - ok to be blackboxed
			img1= getImage("Enemies.png");
			
			init(x,y);
			
		}

		public Enemies(String fileName, int startX, int startY){
			x = startX;
			y = startY;
			vx = 3;
			vy = 0;
			width = 50;
			height = 38;
			img1 = getImage("Enemies.png");
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
			Rectangle Enemy = new Rectangle(x,y,width,height); //from attributes
			return obs.intersects(Enemy);

		}


		public boolean isVisible(){
			 
			return Visible;	
		}
		public void setVisible(boolean Visible){
			this.Visible = Visible;
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
				y=0;
				tx.setToTranslation(x,y);
			}

			if(y>600){ //boundaries for y
				y=500;
				tx.setToTranslation(x, y);
			}
			if(x<0){
				x=0;
			vx = 3;
			vx++;
			y+=50;
				tx.setToTranslation(x, y); //boundaries for x on the left
			}
			if(x>640){
				x=620;
				vx=-3;
				vx--;
				y+=50;
				tx.setToTranslation(x,y); //boundaries for x on the right
			} 
			
		}
		
		
		public void fireBombs(){
			Bomb bomb = new Bomb("Bomb.png", x, y+20);
			bombs.add(bomb);
		}
		
		private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

		//draw the affinetransform
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img1, tx, null);
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
				URL imageURL = Player.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}

	}

	
	
	
	
	
	
