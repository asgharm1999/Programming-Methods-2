package connect4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uni.ConnectFour;

public class GUI_Connect4_Me extends JFrame implements BoardGame, ActionListener {
	private JPanel jpMain, jpBoard, jpIO;
	private JLabel displayOut; 
	private BtnPanel jpBtns;
	private JButton[][] Btns;
	private String currPlayer = "red";
	private int player1 = 1;
	private boolean is_winner = false;
	private int[] nextRow = {5,5,5,5,5,5,5};
	private JLabel[][] gameBoard;	
	private Cell[][] gameCellBoard;	
	private int sizeRow; // specify row size
	private int sizeColumn; // specify column size
//	private final GridLayout grid;
	
	// icons
	ImageIcon empty = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/emptycell.png");
	ImageIcon p1 = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/player1.png");	
	ImageIcon p2 = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/player2.png");
	ImageIcon downArrow = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/"
			+ "Down-Arrow-PNG-Transparent-Image.png");
	
	public GUI_Connect4_Me() {
		playerBoardSize();
		
		setTitle("Connect 4");
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
//		if(player1 == 1) {
//			currPlayer = "red";
//			displayOut = new JLabel(currPlayer + " goes.");
//			displayOut.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//			player1 = 2;
//		} else if(player1 == 2) {
//			currPlayer = "blue";
//			displayOut = new JLabel(currPlayer + " goes.");
//			displayOut.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//			player1 = 1;
//		}
		
		displayOut = new JLabel(currPlayer + " goes.");
		displayOut.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		jpIO = new JPanel();
		jpIO.add(displayOut);
		jpMain.add(jpIO, BorderLayout.NORTH);
		
		jpIO = new JPanel();
		
//		grid = new GridLayout(getBoardRow(), getBoardColumn());
//		jpMain.setLayout(grid);
		
		jpBoard = new JPanel();
		jpBoard.setLayout(new GridLayout(6,7));
		displayBoard();
		
		jpIO.add(displayOut);
		jpMain.add(jpIO, BorderLayout.NORTH);
		
		jpBtns = new BtnPanel();	
		jpIO.add(jpBtns, BorderLayout.CENTER);

		jpMain.add(jpBoard, BorderLayout.CENTER);
		
		add(jpMain);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setVisible(true);
	}
	
	public void displayBoard() {
		gameBoard = new JLabel[6][7];
		for(int row = 0; row < gameBoard.length; row++) {
			for(int col = 0; col < gameBoard[row].length; col++) {
				gameBoard[row][col] = new JLabel("-");
				gameBoard[row][col].setFont(new Font(Font.SERIF, Font.BOLD, 30));
				gameBoard[row][col].setEnabled(true);
				jpBoard.add(gameBoard[row][col]);
			}
		}
	}
	
	@Override
	public void clearBoard() {
		for(int row = 0; row < gameBoard.length; row++) {
			for(int col = 0; col < gameBoard[row].length; col++) {
				gameBoard[row][col].setText("");
				gameBoard[row][col].setEnabled(true);
			}
		}
	}
	
	
	
	public void setBoardSize(int newSizeRow, int newSizeColumn) {
		sizeRow = newSizeRow;
		sizeColumn = newSizeColumn;
	}

	public int getBoardRow() {
		return sizeRow;
	}
	
	public int getBoardColumn() {
		return sizeColumn;
	}
	

	public void playerBoardSize() { // gets board size from player
		String boardSizeRow = JOptionPane.showInputDialog("Game Board Size [Row]");
		String boardSizeColumn = JOptionPane.showInputDialog("Game Board Size [Column]");
		
		int sizeOfBoardRow = Integer.parseInt(boardSizeRow);
		int sizeOfBoardColumn = Integer.parseInt(boardSizeColumn);
		
		if(sizeOfBoardRow < 4) {
			JFrame frameInputError = new JFrame();
			JOptionPane.showMessageDialog(frameInputError, "Board size must be greater than 4",
					"Board size Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		if(sizeOfBoardColumn < 4) {
			JFrame frameInputError = new JFrame();
			JOptionPane.showMessageDialog(frameInputError, "Board size must be greater than 4",
					"Board size Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		setBoardSize(sizeOfBoardRow, sizeOfBoardColumn);
	}	
	
	
	@Override
	public void displayWinner() {
		if(checkColumn() || checkRow() || checkAscendingDiagonal() || checkDescendingDiagonal()) {
			displayOut.setText("Winner is "+ currPlayer);
			JFrame frameShowResult = new JFrame();       
			if(currPlayer == "red") {
				JOptionPane.showMessageDialog(frameShowResult,
						"\nWinner : Player 1\n\nThe new game will start.\n\n",
						"End Game",
						JOptionPane.INFORMATION_MESSAGE);
				startAgain(); 
			} else {
				displayOut.setText("Draw, do you want to play it again?"); //if isFull
				JOptionPane.showMessageDialog(frameShowResult,
						"\nWinner : Player 2\n\nThe new game will start.\n\n",
						"End Game",
						JOptionPane.INFORMATION_MESSAGE); 
				startAgain();    
			}
		}
	}
	
	 public void startAgain() {
		 for(int i = 0; i < getBoardRow(); ++i) {         
			 for(int j = 0; j < getBoardColumn(); ++j) {
				 gameCellBoard[i][j].setCellState(-99);  // Initial Value
				 Btns[i][j].setIcon(empty);       // Put the empty cell icon
			 }
		 }

		 setVisible(false);                           // Invisible previous game board
		 ConnectFour newGame = new ConnectFour();           // New Game Object
	 }

	
	private boolean checkRow() {
		int rowCount = 0;
		for(int i = 0; i < gameBoard.length; i++) {
			if(gameBoard[i][0].getText().contains(currPlayer) == true 
					|| gameBoard[i][1].getText().contains(currPlayer) == true 
					|| gameBoard[i][2].getText().contains(currPlayer) == true) {
				rowCount++;
				if(rowCount == 4) {
					return is_winner = true;
				}
			} 
		}
		return is_winner;
	}	
	
	private boolean checkColumn() {
		int colCount = 0;
		for(int i = 0; i < gameBoard.length; i++) {
			if(gameBoard[0][i].getText().contains(currPlayer) == true 
					|| gameBoard[1][i].getText().contains(currPlayer) == true 
					|| gameBoard[2][i].getText().contains(currPlayer) == true) {
				colCount++;
				if(colCount == 3) {
					return is_winner = true;
				}
			} 
		}
		return is_winner;
	}

	private boolean checkAscendingDiagonal() {
		int diagCount = 0;
		for(int i = 0; i < gameBoard.length; i++) {
			if(gameBoard[i][i].getText().contains(currPlayer)) {
				diagCount++;
				if(diagCount == 3) {
					return is_winner = true;
				}
			}
		}
		return is_winner;
	}

	private boolean checkDescendingDiagonal() {
		int diagCount = 0;
		int row = gameBoard.length - 1;
		int col = 0;
		while(row >= 0 && col < gameBoard.length) {
			if(gameBoard[row][col].getText().contains(currPlayer)) {
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
	
	private class BtnPanel extends JPanel implements ActionListener {
		ImageIcon downArrow_reg = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/Down-Arrow-PNG-Transparent-Image.png");
		ImageIcon downArrow = new ImageIcon(((Image)downArrow_reg.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
	
		private JButton [] jbtns; // columns 1-7

		public BtnPanel(){
			setLayout(new GridLayout(1,7));
			jbtns = new JButton[7];
			populatePanelWithButtons();
		}

		private void populatePanelWithButtons() {
			for(int i = 0; i < 7; i++){
				jbtns[i] = new JButton(downArrow);
				jbtns[i].addActionListener(this);
				add(jbtns[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("INSIDE actionPerformed");
			JButton btnClicked = (JButton)e.getSource();
			int row = gameBoard.length - 1;
			int col;

			if(btnClicked.equals(jbtns[0])) {
				col = 0;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}

			if(btnClicked.equals(jbtns[1])) {
				col = 1;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}
			
			if(btnClicked.equals(jbtns[2])) {
				col = 2;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}
			
			if(btnClicked.equals(jbtns[3])) {
				col = 3;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}
			
			if(btnClicked.equals(jbtns[4])) {
				col = 4;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}

			if(btnClicked.equals(jbtns[5])) {
				col = 5;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}

			if(btnClicked.equals(jbtns[6])) {
				col = 6;
				int rowToSet = nextRow[col];
				gameBoard[rowToSet][col].setText(currPlayer);
				nextRow[col]--;
				displayWinner();
				updateCurrPlayer();
			}
		}
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
		if(currPlayer.equalsIgnoreCase("red")) {
			currPlayer = "blue";
			System.out.println("Player 1's turn");
		} else { 
			currPlayer = "red";
			System.out.println("Player 2's turn");
		}
	}

	@Override
	public boolean isFull() {
		for(int row = 0; row < gameBoard.length; row++) {
			for(int col = 0; col < gameBoard[row].length; col++) {
				if(gameBoard[row][col].getText().isEmpty()) {
					return false;
				}
			}
		}
		return true; // none were empty return true
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton)e.getSource();
		btnClicked.setText(currPlayer);
		btnClicked.setEnabled(false);
		
		displayWinner();
		updateCurrPlayer();
	}
}