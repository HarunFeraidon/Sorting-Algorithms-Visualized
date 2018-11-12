
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

public class InsertionSort extends JPanel implements Runnable {

	int a,b;
	ArrayList<Integer> numbers;
	
	public InsertionSort() {
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
		for(int i=1; i<length; ++i) {
			int key = numbers.get(i);
			a = b = i;
			int j = i-1;
			while(j>=0 && numbers.get(j)>key) {
				numbers.set(j+1, numbers.get(j));
				b = j;
				j = j-1;
				repaint();
				Thread.sleep(50);
			}
			numbers.set(j+1, key);
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
