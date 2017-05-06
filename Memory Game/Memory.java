package memory;

public class Memory {

	private static final Memory MEMORY = new Memory();
	private static final Tile TILE = Tile.getInstance();
	
	private Memory() {
		
	}
	
	public final void startGame() {
		TILE.populate();
	}
	
	protected void restartGame() {		
		TILE.getPanel().removeAll();
		TILE.populate();
	}
	
	public static final Memory getInstance() {
		return MEMORY;
	}

}
