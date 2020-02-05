import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;




public class Car {

	private int carx, cary; //car position
	private int carvx, carvy;
	private int carwidth, carheight;
	private Image img2;

	public Car ( String fileName) {
		carx = 500;
		cary = 500;
		carvx = 3;
		carvy = 0;
		carheight = 68; //397
		carwidth = 137; //800
			//helper functions - ok to be blackboxed
		img2 = getImage("bluecar.png");
		init(carx,cary);
	}
		
		public Car(String fileName, int CarstartX, int CarstartY){
			carx = CarstartX;
			cary = CarstartY;
			carvx = 0;
			carvy = 0;
			carwidth = 137;
			carheight = 68;
			img2 = getImage("bluecar.png");
			init(carx,cary);
		}

		
	
		
	
	
	
	
	
	

	public int getCarx() {
			return carx;
		}

		public void setCarx(int carx) {
			this.carx = carx;
		}

		public int getCary() {
			return cary;
		}

		public void setCary(int cary) {
			this.cary = cary;
		}

		public int getCarwidth() {
			return carwidth;
		}

		public void setCarwidth(int carwidth) {
			this.carwidth = carwidth;
		}

		public int getCarheight() {
			return carheight;
		}

		public void setCarheight(int carheight) {
			this.carheight = carheight;
		}
		

	

	public void setCarvx(int carvx) {
			this.carvx = carvx;
		}

		public void setCarvy(int carvy) {
			this.carvy = carvy;
		}

	public void move() { //movement setter, blackboxing code
		tx.translate(carvx,carvy);
		carx += carvx;
		cary += carvy;
			for(int i = 0; i < 8; i++){
				if(carx<0){
					carx = 900;
					tx.setToTranslation(carx, cary);
				}
				if(carx>900){
					carx = 0;
					tx.setToTranslation(carx, cary);
				}
			}
		
	}
	
	
     	
	
	
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(carx, cary);

	//draw the affinetransform
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img2, tx, null);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
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
