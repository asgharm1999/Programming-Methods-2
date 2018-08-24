package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_TicTacToe extends JFrame implements BoardGame, ActionListener {

	private JPanel jpMain, jpBoard, jpIO;
	private JLabel displayOut;
	private JButton [][] board;
	private String currPlayer = "X";
	private int player1 = 1;
	private boolean is_winner = false;
	
	public GUI_TicTacToe() {
		setTitle("TIC TAC TOE");
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
	
		displayOut = new JLabel("Let's Play " + currPlayer + " goes first");
		jpIO = new JPanel();
		jpIO.add(displayOut);
		jpMain.add(jpIO, BorderLayout.NORTH);
		
		jpBoard = new JPanel();
		jpBoard.setLayout(new GridLayout(3,3));
		displayBoard();
		jpMain.add(jpBoard, BorderLayout.CENTER);
		
		add(jpMain);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);
	}
	
	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		board = new JButton[3][3];
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new JButton();
				board[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
				board[row][col].addActionListener(this);
				board[row][col].setEnabled(true);
				jpBoard.add(board[row][col]);
			}
		}
	}

	@Override
	public void clearBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col].setText("");
				board[row][col].setEnabled(true);
			}
		}
	}

	@Override
	public void displayWinner() {
		if(checkMainDiagonal() || checkSecondaryDiagonal() || checkRow() || checkColumn()) {
			displayOut.setText("Winner is "+ currPlayer);
		} else {
			if(isFull()) {
				displayOut.setText("Draw, do you want to play it again?"); //if isFull
				
			}
		}
	}
	
	private boolean checkRow() {
		int rowCount = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[i][0].getText().contains(currPlayer) == true 
					|| board[i][1].getText().contains(currPlayer) == true 
					|| board[i][2].getText().contains(currPlayer) == true) {
				rowCount++;
				if(rowCount == 3) {
					return is_winner = true;
				}
			} 
		}
		return is_winner;
	}

	private boolean checkColumn() {
		int colCount = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[0][i].getText().contains(currPlayer) == true 
					|| board[1][i].getText().contains(currPlayer) == true 
					|| board[2][i].getText().contains(currPlayer) == true) {
				colCount++;
				if(colCount == 3) {
					return is_winner = true;
				}
			} 
		}
		return is_winner;
	}
	
	private boolean checkMainDiagonal(){
		int diagCount = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[i][i].getText().contains(currPlayer)) {
				diagCount++;
				if(diagCount == 3) {
					return is_winner = true;
				}
			}
		}
		return is_winner;
	}
	
	private boolean checkSecondaryDiagonal() {
		int diagCount = 0;
		int row = board.length - 1;
		int col = 0;
		while(row >= 0 && col < board.length) {
			if(board[row][col].getText().contains(currPlayer)) {
				diagCount++;
				if(diagCount == 3) {
					return is_winner = true;
				}
			}
			row--;
			col++;
		}
		return is_winner;
	}
	
	@Override
	public void takeTurn() {
		if(player1 == 1) {
			player1 = 2;
		} else if(player1 == 2) {
			player1 = 1;
		}
	}

	@Override
	public void updateCurrPlayer() {
		if(currPlayer.equalsIgnoreCase("X")) {
			currPlayer = "O";
		} else { 
			currPlayer = "X";
		}
	}

	@Override
	public boolean isFull() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col].getText().isEmpty()) {
					return false;
				}
			}
		}
		return true; //none were empty return true
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		btnClicked.setText(currPlayer);
		btnClicked.setEnabled(false);

		displayWinner();
		updateCurrPlayer();
	}
}
