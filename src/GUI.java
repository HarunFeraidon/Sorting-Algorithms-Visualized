
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;

public class GUI {
	static JFrame frame;	
	static JPanel left, right;
	static JPanel mainPanel;
	static JPanel selectionPanel, insertionPanel, bubblePanel;
	static JPanel a1, a2; //selection sort
	static JPanel b1, b2; //insertion sort
	static JPanel c1, c2; //bubble sort
	static JLabel selectionLabel, insertionLabel, bubbleLabel;

	
	public GUI() {
		frame = new JFrame("Sorting"); //the title of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program terminates on close
		frame.setSize(800,800); //the size of the frame, before being packed
		frame.setLocationRelativeTo(null);  //centers the screen
		frame.setVisible(true); //sets frame to be visible
		
		GridLayout layout = new GridLayout(2,3);
		frame.setLayout(layout);
		
		setupEverything();
		//frame.pack();
		frame.setVisible(true); //sets frame to be visible
	}
	
	public static void main(String[] args) {
		new GUI(); //calls the constructor to begin initialization.
	}
	
	public static void setupEverything() {
		
		SelectionSort s = new SelectionSort();
		InsertionSort i = new InsertionSort();
		BubbleSort b = new BubbleSort();
		
		frame.add(s);
		frame.add(i);
		frame.add(b);
		
		frame.add(new JLabel("Selection Sort"));
		frame.add(new JLabel("Insertion Sort"));
		frame.add(new JLabel("Bubble Sort"));
		
		Thread t1 = new Thread((Runnable) s);
		Thread t2 = new Thread((Runnable) i);
		Thread t3 = new Thread((Runnable) b);
		t1.start();
		t2.start();
		t3.start();

		//frame.add(new BubbleSort());
	}
	
}
