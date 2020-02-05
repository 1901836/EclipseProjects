import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Background {

	
	private int bx, by;
	private Image img4;
	
	public Background(String fileName, int startBx, int startBy){
		bx = startBx;
		by = startBy;
		img4 = getImage("background.png");
		init(bx,by);
	}
	
	
	
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(bx, by);

	//draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img4, tx, null);
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
