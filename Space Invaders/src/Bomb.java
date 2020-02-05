import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

public class Bomb {
	private int bbx, bby;
	private int bbwidth, bbheight;
	private int bbvy, bbvx;
	private Image img3;
	public boolean Visibility = true;
	public Bomb(String fileName){
		bbx = 0;
		bby = 100;
		bbvx = 0;
		bbvy = 5;
		bbwidth = 10;
		bbheight = 10;
		
		img3 = getImage("Bomb.png");
		init(bbx, bby);
	}
	
	public Bomb(String fileName, int startX, int startY){
		bbx = startX;
		bby = startY;
		bbvx = 0;
		bbvy = 5;
		bbwidth = 10;
		bbheight = 10;
		img3 = getImage("Bomb.png");
		init(bbx,bby);
	}


	
	public int getBbx() {
		return bbx;
	}

	public void setBbx(int bbx) {
		this.bbx = bbx;
	}

	public int getBby() {
		return bby;
	}

	public void setBby(int bby) {
		this.bby = bby;
		tx.setToTranslation(bbx,bby);
	}

	public int getBbwidth() {
		return bbwidth;
	}

	public void setBbwidth(int bbwidth) {
		this.bbwidth = bbwidth;
	}

	public int getBbheight() {
		return bbheight;
	}

	public void setBbheight(int bbheight) {
		this.bbheight = bbheight;
	}

	public int getBbvy() {
		return bbvy;
	}

	public void setBbvy(int bbvy) {
		this.bbvy = bbvy;
	}

	public int getBbvx() {
		return bbvx;
	
	}

	public void setBbvx(int bbvx) {
		this.bbvx = bbvx;
		tx.setToTranslation(bbx,bby);
	}

	public void move() { //movement setter, blackboxing code
		tx.translate(bbvx,bbvy);
		bbx+=bbvx;
		bby+=bbvy;
		
			tx.setToTranslation(bbx,bby); //boundaries for x on the right
		} 

public boolean collided(int ox, int oy, int ow, int oh){ //collision code
		
		Rectangle obs = new Rectangle(ox,oy,ow,oh); //from parameters
		Rectangle bomb = new Rectangle(bbx,bby,bbwidth,bbheight); //from attributes
		return obs.intersects(bomb);

	}







	private AffineTransform tx = AffineTransform.getTranslateInstance(bbx, bby);

	//draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img3, tx, null);
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
