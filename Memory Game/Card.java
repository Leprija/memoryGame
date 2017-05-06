package memory;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {

	private static final long serialVersionUID = 1L;
	private static ImageIcon back = new ImageIcon("C:/Program Files/Memory/Brain.png");
	private static int numOfTurnedCards = 0;
	
	private ImageIcon front;
	
	protected Card(ImageIcon front) {
		this.setIcon(back);
		this.front = front;
	}
	
	protected static int getNumOfTurnedCards() {
		return numOfTurnedCards;
	}
	
	protected static void setNumOfTurnedCards(int num) {
		numOfTurnedCards = num;
	}

	protected static void incNumOfTurnedCards() {
		numOfTurnedCards++;
	}

	protected static ImageIcon getBack() {
		return back;
	}

	protected ImageIcon getFront() {
		return front;
	}
	
}
