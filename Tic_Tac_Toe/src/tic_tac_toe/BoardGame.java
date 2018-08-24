package tic_tac_toe;

public interface BoardGame {

	public void displayBoard();
	public void clearBoard();
	public void displayWinner();
	public void takeTurn();
	public void updateCurrPlayer();
	public boolean isFull();
	// any other methods you may need
}
