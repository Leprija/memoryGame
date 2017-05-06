package memory;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tile {

	private static final Tile INSTANCE = new Tile();
	private static final Card[] CARDS = new Card[12];
	
	private JFrame window = new JFrame("Memory");
	private JPanel panel = new JPanel();
	private Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	private Random rnd = new Random();
	private ArrayList<ImageIcon> list = new ArrayList<ImageIcon>();
		
	private Tile() {
		window.setSize(800, 800);
		window.setResizable(false);
		window.setLocation(screenDimension.width/2 - window.getWidth()/2, screenDimension.height/2 - window.getHeight()/2);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(4, 6, 20, 20));
	}
	 
	protected void populate() {
		int selectedArray = rnd.nextInt(Icons.getImages().length);
		for(int i = 0; i < CARDS.length/2; i++) {						
			ImageIcon selectedImage = Icons.getImages()[selectedArray][rnd.nextInt(Icons.getImages()[selectedArray].length)];   
			
			if(!list.contains(selectedImage)) {
				list.add(selectedImage);
			}else{
				i--;
			}			
		}
		
		list.addAll(list);
		
		for(int i = 0; i < CARDS.length; i++) {			
			ImageIcon selectedIcon = list.get(rnd.nextInt(list.size()));
			CARDS[i] = new Card(selectedIcon);
			CARDS[i].addActionListener(new Action());
			panel.add(CARDS[i]);
			list.remove(selectedIcon);			
		}

		((JComponent) window.getContentPane()).setBorder(new EmptyBorder(-1, -1, -1, -1));
		window.add(panel);
		window.setVisible(true);
		
	}
	
	protected static final Tile getInstance() {
		return INSTANCE;
	}
	
	protected static final Card[] getCards() {
		return CARDS;
	}
	
	protected JPanel getPanel() {
		return panel;
	}
	
}
