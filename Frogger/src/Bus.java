

	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.geom.AffineTransform;
	import java.net.URL;




	public class Bus {

		private int busX, busY; //car position
		private int buxVx, busVy;
		private int busWidth, busHeight;
		private Image img3;

		public Bus ( String fileName) {
			busX = 500;
			busY = 350;
			buxVx = -3;
			busVy = 0;
			busHeight  = 68;//397
			busWidth = 137; //800
				//helper functions - ok to be blackboxed
			img3 = getImage("bus.png");
			init(busX,busY);
		}
			
			public Bus(String fileName, int BusstartX, int BusstartY){
				busX = BusstartX;
				busY = BusstartY;
				buxVx = 0;
				busVy = 0;
				busWidth = 137;
				busHeight = 68;
				img3 = getImage("bus.png");
				init(busX,busY);
			}

			
		
			
		
		
		
		
		
		

		public int getbusX() {
				return busX;
			}

			public void setbusX(int busX) {
				this.busX = busX;
			}

			public int getbusY() {
				return busY;
			}

			public void setbusY(int busY) {
				this.busY = busY;
			}

			public int getbusWidth() {
				return busWidth;
			}

			public void setbusWidth(int busWidth) {
				this.busWidth = busWidth;
			}

			public int getbusHeight() {
				return busHeight;
			}

			public void setbusHeight(int busHeight) {
				this.busHeight = busHeight;
			}
			

		

		public void setbuxVx(int buxVx) {
				this.buxVx = buxVx;
			}

			public void setbusVy(int busVy) {
				this.busVy = busVy;
			}

		public void move() { //movement setter, blackboxing code
			tx.translate(buxVx,busVy);
			busX += buxVx;
			busY += busVy;
				for(int i = 0; i < 8; i++){
					if(busX<0){
						busX = 900;
						tx.setToTranslation(busX, busY);
					}
					if(busX>900){
						busX = 0;
						tx.setToTranslation(busX, busY);
					}
				}
			
		}
		
		
	     	
		
		
		
		private AffineTransform tx = AffineTransform.getTranslateInstance(busX, busY);

		//draw the affinetransform
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img3, tx, null);
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


