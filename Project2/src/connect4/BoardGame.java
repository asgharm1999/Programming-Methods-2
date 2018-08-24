package connect4;

public interface BoardGame {

	public void displayBoard();
	public void clearBoard();
	public void displayWinner();
	public void updateCurrPlayer();
	public boolean isFull();
	public void takeTurn();
}
