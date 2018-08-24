package tic_tac_toe;

public class Show_TicTacToe {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GUI_TicTacToe gui = new GUI_TicTacToe();
			}
		});
	}
}
