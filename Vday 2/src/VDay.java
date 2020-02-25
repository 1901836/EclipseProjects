import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VDay extends JPanel implements ActionListener {
	int x = 0, y = 0;
	int radius = 350; // outer circle diameter
	int num_points = 400; // determines resolution
	int m = 2; // multiplier (num circles?)

	// container for points around circle
	ArrayList<Point> points = new ArrayList<Point>();

	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.red);

		for (int i = 0; i < points.size(); i++) {
			g.fillOval(points.get(i).x, points.get(i).y, 5, 5);
		}
		
		
		for (int i = 1; i < points.size(); i++) {
			for (int j = 0; j < m; j++) {
				//draw a line between points a and b from the arraylist
				Point a = points.get(i);
				Point b = points.get(i * m % num_points);
				g.setColor(a.c);
				g.drawLine(a.x, a.y, b.x, b.y);
			}
		}

	}

	public void update() {
		// what if we updated the multiplier here?
		rotate(points);
		
			m +=1 ;//(int)(Math.random()*points.size() + 10);
		
	}

	// shift elements to the right. anything that falls off the list
	// goes to the beginning.
	public void rotate(ArrayList<Point> list) {
		points.add(0, points.remove(points.size()-1));
		
		
		
	}

	public static void main(String[] arg) {
		VDay d = new VDay();
	}

	public VDay() {

		JFrame f = new JFrame();
		f.setSize(800, 800);
		f.setResizable(false);
		
		
	
		
		
		// draw the points around a circle
		double delta = (2 * Math.PI) / num_points;
		double angle = 0;
		for (int i = 0; i < num_points; i++, angle += delta) {
			x = (int) (radius * Math.cos(angle))+400; // how can we shift ?
			y = (int) (radius * Math.sin(angle))+400; // how can we shift ? //385

			
			
			// create a Point object from the found x,y values
			// add this object to our list called points (arraylist)
			points.add(new Point(x,y));
			
			
		}
		
		

		f.add(this);
		f.getContentPane().setBackground(Color.BLACK);

		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		update();
		repaint();
	}

}
