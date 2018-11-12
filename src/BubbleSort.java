

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

public class BubbleSort extends JPanel implements Runnable {
	int a, b;
	ArrayList<Integer> numbers;
	
	public BubbleSort() {
		numbers = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
	}

	@Override
	public void run() {
		int length = numbers.size();
		boolean swapped;
		try {
		for(int i=0; i<length-1; i++) {
			swapped = false;
			for(int j=0; j<length-i-1; j++) {
				a = j;
				b = j+1;
				if(numbers.get(j)>numbers.get(j+1)) {
					int temp=numbers.get(j);
					numbers.set(j,numbers.get(j+1));
					numbers.set(j+1, temp);
					swapped = true;
				}
				repaint();
				Thread.sleep(50);
			}
			if(swapped == false)
				break;
		}
		}
		catch(InterruptedException e) {
			System.out.println("Sorting interrupted");
		}
	}	
	
	@Override
	public void paintComponent(Graphics g) {
		int y0=0;
		int thickness = 5;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 3*50, 50*(thickness+3));
		
		
		for(int i=0; i<numbers.size(); i++) {
			if(i==a || i==b)
				g.setColor(Color.GREEN);
			else
				g.setColor(Color.DARK_GRAY);
			g.fillRect(0, y0, 3*numbers.get(i), thickness);
			y0 += 3+thickness;
		}
	}
}
