import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Log {

		private int logx, logy; //log position
		private int logvx, logvy;
		private int logwidth, logheight; //log variables, all private
		private Image img5;

		public Log ( String fileName) {
			logx = 700; //constructor it sets things up
			logy = 700;
			logvx = 3;
			logvy = 0;
			logheight = 40; //397
			logwidth = 108; //800
				//helper functions - ok to be blackboxed
			img5 = getImage("log.png");
			init(logx,logy);
		}
			
			public Log(String fileName, int logstartX, int logstartY){ //more constructors
				logx = logstartX;
				logy = logstartY;
				logvx = 5;
				logvy = 0;
				logwidth = 108;
				logheight = 40;
				img5 = getImage("log.png");
				init(logx,logy);
			}

			
		
			
		
		
		
		
		
		//log getters and setters

		public int getlogx() {  // get log x position
				return logx;
			}

			public void setlogx(int logx) { // set log x position
				this.logx = logx;
			}

			public int getlogy() { // get log y position
				return logy;
			}

			public void setlogy(int logy) { //setter for log y
				this.logy = logy;
			}

			public int getlogwidth() {  //get log width
				return logwidth;
			}

			public void setlogwidth(int logwidth) { //log width setter
				this.logwidth = logwidth;
			}

			public int getlogheight() { //get log height getter 
				return logheight;
			}

			public void setlogheight(int logheight) { //set log height position
				this.logheight = logheight;
			}
			

		

		public void setlogvx(int logvx) { //set log vx 
				this.logvx = logvx;
			}

			public void setlogvy(int logvy) { //set log vy
				this.logvy = logvy;
			}

		public void move() { //movement setter, blackboxing code
			tx.translate(logvx,logvy);
			logx += logvx;
			logy += logvy;
				for(int i = 0; i < 6; i++){
					if(logx<0){
						logx = 900; //if log goes off screen then it comes back 
						tx.setToTranslation(logx, logy);
					}
					if(logx>900){
						logx = 0;
						tx.setToTranslation(logx, logy);
					}
				}
			
		}
		
		
	     	
		
		
		
		private AffineTransform tx = AffineTransform.getTranslateInstance(logx, logy);

		//draw the affinetransform
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img5, tx, null);
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

	
