
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

import java.awt.Color;

public class SelectionSort extends JPanel implements Runnable {
	int a, b;
	ArrayList<Integer> numbers;

	public SelectionSort() {
		numbers = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
	}

	@Override
	public void run() {
		int length = numbers.size();
		try {
			for(int i=0; i<length-1; i++) {
				int index = i;
				a = b = i;
				for(int j=i+1; j<length; j++) {
					if(numbers.get(j)<numbers.get(index)) {
						index=j;
						b=j;
					}
					repaint();
					Thread.sleep(50);
				}
				
				int temp = numbers.get(index);
				numbers.set(index, numbers.get(i));
				numbers.set(i, temp);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Sorting interrupted");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		int y0 = 0;
		int thickness = 5;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 3*50, 50*(thickness+3));

		for (int i = 0; i < numbers.size(); i++) {
			if(i==a || i==b)
				g.setColor(Color.GREEN);
			else
				g.setColor(Color.DARK_GRAY);
			g.fillRect(0, y0, 3*numbers.get(i), thickness);
			y0 += 3 + thickness;
		}
	}
}
