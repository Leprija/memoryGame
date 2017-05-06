package memory;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Action implements ActionListener {

	private boolean gameOver = false;
	
	private static final Card[] CARDS = Tile.getCards();
	private static final Card[] TURNED_CARD = new Card[2];
	private static final ArrayList<Card> GUESSED_CARDS = new ArrayList<Card>();
	private static final Player p1 = new Player();
	private static final Player p2 = new Player();
		
	protected Action() {
		p1.setTurn(true);
		p2.setTurn(false);
		Tile.getInstance().getPanel().setBackground(Color.RED);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {		
		int numOfTurnedCards = Card.getNumOfTurnedCards();
			
		for(int i = 0; i < CARDS.length; i++) {

			if(numOfTurnedCards < 2) {				
				if(ae.getSource() == CARDS[i] && !GUESSED_CARDS.contains(CARDS[i])) {
					CARDS[i].setIcon(CARDS[i].getFront());					
					TURNED_CARD[numOfTurnedCards] = CARDS[i];
					if(TURNED_CARD[0] == TURNED_CARD[1]) {
						TURNED_CARD[1] = null;
						Card.setNumOfTurnedCards(1);
					}else{
						Card.incNumOfTurnedCards();
					}				
				}
			}
			if(numOfTurnedCards == 2  && !gameOver) {				
				if(TURNED_CARD[0].getFront().equals(TURNED_CARD[1].getFront()) && !GUESSED_CARDS.contains(TURNED_CARD[0]) && !GUESSED_CARDS.contains(TURNED_CARD[1])) {					
					GUESSED_CARDS.add(TURNED_CARD[0]);
					GUESSED_CARDS.add(TURNED_CARD[1]);
					if(p1.isTurn()) {
						p1.incScore();
					}else {
						p2.incScore();
					}					
				}
				if(!TURNED_CARD[0].getFront().equals(TURNED_CARD[1].getFront())) {					
					TURNED_CARD[0].setIcon(Card.getBack()); 
					TURNED_CARD[1].setIcon(Card.getBack());
					if(p1.isTurn()) {
						p1.setTurn(false);
						p2.setTurn(true);
						Tile.getInstance().getPanel().setBackground(Color.BLUE);
						i = CARDS.length-1;
					}else {
						p1.setTurn(true);
						p2.setTurn(false);
						Tile.getInstance().getPanel().setBackground(Color.RED);
						i = CARDS.length-1;
					}
				}
				if(GUESSED_CARDS.size() == CARDS.length) {
					gameOver = true;
					GUESSED_CARDS.removeAll(GUESSED_CARDS);
					JOptionPane.showMessageDialog(null, "Red player's score: " + p1.getScore());
					JOptionPane.showMessageDialog(null, "Blue player's score: " + p2.getScore());
					if(p1.getScore() > p2.getScore()) {
						JOptionPane.showMessageDialog(null, "Red player wins!");
					}else if(p1.getScore() < p2.getScore()) {
						JOptionPane.showMessageDialog(null, "Blue player wins!");
					}else {
						JOptionPane.showMessageDialog(null, "Draw!");
					}
					p1.setTurn(true);
					p2.setTurn(false);
					p1.setScore(0);
					p2.setScore(0);
					Memory.getInstance().restartGame();	
				}
				Card.setNumOfTurnedCards(0);				
			}
			
		}
		
		
	
	}
	
}
