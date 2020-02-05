import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

public class Bullet {
	
	
	private int bx, by;
	private boolean visible;
	private int bw, bh;
	private int bvx, bvy;
	private Image img2;
	

	public Bullet( String fileName) {
		bx = 0;
		by = 200;
		bvx = 0;
		bvy = 5;
		bw = 10;
		bh = 10;
			//helper functions - ok to be blackboxed
		img2= getImage("Bullet.png");
		init(bx,by);
		
	}

	public Bullet(String fileName, int startX, int startY){
		bx = startX;
		by = startY;
		bvx = 0;
		bvy = 5;
		bw = 10;
		bh = 10;
		img2 = getImage("Bullet.png");
		init(bx,by);
	}

	public void setbVx (int bvx){ //setting velocity variables, vx setter, return void
		this.bvx = bvx;
		}

		
	public int getbVx() {
		return bvx;
	}

	public int getbVy() {
		return bvy;
	}

	public void setbVy (int bvy){ //Vy setter, return void, only to set values
			this.bvy = bvy;
		}


	public boolean collided(int ox, int oy, int ow, int oh){ //collision code
		
		Rectangle obs = new Rectangle(ox,oy,ow,oh); //from parameters
		Rectangle bullet = new Rectangle(bx,by,bw,bh); //from attributes
		return obs.intersects(bullet);

	}





	public int getbX() {
		return bx;
	}

	public void setbX(int bx) {
		this.bx = bx;
		tx.setToTranslation(bx,by);
	}

	public int getbY() {
		return by;
	}

	public void setbY(int by) {
		this.by = by;
		tx.setToTranslation(bx, by);
	}

	public int getbw() {
		return bw;
	}

	public void setbw(int bw) {
		this.bw = bw;
	}

	public int getbh() {
		return bh;
	}

	public void setbh(int bh) {
		this.bh = bh;
	}

	public void move() { //movement setter, blackboxing code
		tx.translate(bvx,bvy);
		bx+=bvx;
		by+=bvy;
		
			tx.setToTranslation(bx,by); //boundaries for x on the right
		} 
		
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(bx, by);

	//draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img2, tx, null);
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