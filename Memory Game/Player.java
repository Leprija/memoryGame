package memory;

public class Player {

	private boolean turn;
	private int score;
	
	protected Player() {
		
	}
	
	protected boolean isTurn() {
		return turn;
	}
	
	protected void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	protected int getScore() {
		return score;
	}
	
	protected void setScore(int score) {
		this.score = score;
	}
	
	protected void incScore() {
		score+=2;
	}

}
