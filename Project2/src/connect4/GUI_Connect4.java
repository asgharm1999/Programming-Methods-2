package connect4;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class GUI_Connect4 extends JFrame implements BoardGame, ActionListener {
	private JFrame frame;
	private JPanel jpMain, jpBoard, jpIO, panel;
	private JLabel displayOut; 
	private JButton[][] jpBtns;
	private String currPlayer = "Player 1";
	private int p1 = 1;
	private final JButton[][] buttons; 
	private Cell[][] gameBoard;	
	private boolean is_winner = false;
	private boolean startGame = true; 
	
	private int playerOrder = 0;

	private static int livingCellNumber = 0;


	private int sizeRow; // specify row size
	private int sizeColumn; // specify column size
	private final GridLayout grid;
	
	// icons
	ImageIcon empty = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/emptycell.png");
	ImageIcon player1 = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/player1.png");	
	ImageIcon player2 = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/player2.png");
	ImageIcon downArrow = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/"
			+ "Down-Arrow-PNG-Transparent-Image.png");
	
	public GUI_Connect4() {
		frame = new JFrame("Connect 4");
		panel = new JPanel();
		
		playerBoardSize();
		dynamicAllocation();

		setTitle("Connect 4");
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());

		displayOut = new JLabel(currPlayer + " goes.");
		displayOut.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		startGame = false;
		jpIO = new JPanel();
		jpIO.add(displayOut);
		jpMain.add(jpIO, BorderLayout.NORTH);
		
		buttons = new JButton[getBoardRow()][getBoardColumn()];
		grid = new GridLayout(getBoardRow(), getBoardColumn());
		panel.setLayout(grid);
		
		initialBoard();

		frame.setContentPane(panel);
		frame.pack();
		frame.setSize(800, 800);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	public static int numberOfLivingCells() {
		return livingCellNumber;
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
	
//	public void dynamicAllocation() { // creates 2D cell array
//		gameBoard = new Cell[getBoardRow()][getBoardColumn()];
//		
//		for(int i = 0; i < getBoardRow(); i++) {
//			for(int j = 0; j < getBoardColumn(); j++) {
//				gameBoard[i][j] = new Cell();
//			}
//		}
//	}
	
	
	public void addButtonsToBoard() {
		for(int i = 0; i < getBoardRow(); i++){
			for(int j = 0; j < getBoardColumn(); j++) {
				buttons[i][j] = new JButton(downArrow);
			}
		}
	}

	public void initialBoard() {
		for(int i = getBoardRow() - 2; i >= 0; --i) {
            for(int j = getBoardColumn() - 1; j >= 0; --j) {
                gameBoard[i][j].setCellState(-99);
            }
        }    
       addButtonsToBoard(); // Add buttons
    }
	
	public void winnerPlayer(int winner) {
        for(int i = 0; i < getBoardRow(); ++i) {         
            for(int j = 0; j < getBoardColumn(); ++j){     
                if(gameBoard[i][j].getCellState() == winner) {    
                  
                	// CHECK UP TO DOWN POSITIONS
                    if(i + 3 < getBoardColumn()) {
                        if(gameBoard[i+1][j].getCellState() == winner 
                        		&& gameBoard[i+2][j].getCellState() == winner 
                        		&& gameBoard[i+3][j].getCellState() == winner) {
                        	if(winner==1) {
                        		showResult(1);
                        	} else {
                        		showResult(2);
                        	}
                        }
                    }
                    
                    // CHECK LEFT TO RIGHT POSITION
                    if(j + 3 <getBoardRow()) { 
                    	if(gameBoard[i][j+1].getCellState() == winner 
                    			&& gameBoard[i][j+2].getCellState() == winner
                    			&& gameBoard[i][j+3].getCellState() == winner) { 
                    		if(winner==1) {
                    			showResult(1);
                    		} else {
                    			showResult(2);
                    		}
                    	}
                    }

                    // CHECK DIAGONAL LEFT TO RIGHT POSITION
                    if(i < getBoardRow() - 3 && j < getBoardColumn() - 3) {
                        if(gameBoard[i+1][j+1].getCellState() == winner 
                        		&& gameBoard[i+2][j+2].getCellState() == winner 
                        		&& gameBoard[i+3][j+3].getCellState() == winner) {  
                            if(winner==1) {
                                showResult(1);
                            } else {
                                showResult(2);
                            }
                        }   
                    }

                    // CHECK DIAGONAL RIGHT TO LEFT POSITION
                    if(i < getBoardRow()- 3 && j - 3 >= 0) {
                        if(gameBoard[i+1][j-1].getCellState() == winner 
                        		&& gameBoard[i+2][j-2].getCellState() == winner 
                        		&& gameBoard[i+3][j-3].getCellState() == winner) {
                            if(winner==1) {
                                showResult(1);
                            } else {
                                showResult(2);
                            }
                        } 
                    }                           
                }         
            }             
        } 
    } // End winnerPlayer function
	
	 public void showResult(int winnerPlayer) {
	       JFrame frameShowResult = new JFrame();       
	       if(winnerPlayer == 1) {
	    	   JOptionPane.showMessageDialog(frameShowResult,
	    			   "\nWinner : Player 1\n\nThe new game will start.\n\n",
	    			   "End Game",
	    			   JOptionPane.INFORMATION_MESSAGE);
	    	   startAgain(); 
	       } else {
	    	   JOptionPane.showMessageDialog(frameShowResult,
	    			   "\nWinner : Player 2\n\nThe new game will start.\n\n",
	    			   "End Game",
	    			   JOptionPane.INFORMATION_MESSAGE); 
	    	   startAgain();    
	       }
	 }
	 
	 public void startAgain() {
		 for(int i = 0; i< getBoardRow(); ++i) {         
			 for(int j = 0; j<getBoardColumn(); ++j) {
				 gameBoard[i][j].setCellState(-99);  // Initial Value
				 buttons[i][j].setIcon(empty);       // Put the empty cell icon
			 }
		 }

		 frame.setVisible(false);                           // Invisible previous game board
		 ConnectFour newGame = new ConnectFour();           // New Game Object
	 }

	 public void warningMessage() {
	        JFrame frameWarning = new JFrame();           
	        JOptionPane.showMessageDialog(frameWarning,
	        "Invalid Movement !!\nThe cell is not empty.", "Warning",
	        JOptionPane.WARNING_MESSAGE);
	    }
	                        
	    /**
	     * Set the upper cells to empty cell to listen button
	     * @param rowPos integer row position to board
	     * @param columnPos integer column position to board
	     */ 
	 public void setUpperCellToEmpty(int rowPos, int columnPos) {
		 try {
			 gameBoard[rowPos-1][columnPos].setCellState(0);    
		 } catch (Exception e) 
		 { }      
	 }
	 
	 private class listenButtonTwoPlayers implements ActionListener {           
	      
		 @Override
		 public void actionPerformed(ActionEvent e) {            
			 try {
				 int eventFlag = 0;
				 int flagPlayerOrder=0;

				 for(int i = getBoardRow() - 1; i >= 0; --i) {
					 for(int j = 0; j<=getBoardColumn()-1; ++j) {
						 if(eventFlag==0 && buttons[i][j]== e.getSource()) { // Get the button component that was clicked
							 if(flagPlayerOrder == 0 && playerOrder%2 == 0) { 
							 
								 // Player 1 Operations                           
								 // Fill the board from down to up
								 for(int k = 0; k <= getBoardColumn(); ++i) {
									 if(gameBoard[i-k][j].getCellState() == 0 && playerOrder%2 == 0) {
										 buttons[i-k][j].setIcon(player1);          // Set new icon to player 1 
										 gameBoard[i-k][j].setAllPosition('X', i);  // Set cell parameters
										 gameBoard[i-k][j].setCellState(1);
										 ++livingCellNumber;  // Increase living cell number
										 winnerPlayer(1);     // Check player 1 winning state
										 flagPlayerOrder = 1;   
										 eventFlag = 1;
										 break; 
									 } 
								 }

								 setUpperCellToEmpty(i,j);   // Set upper cell to empty 
								 System.out.println("... Player 1 played ... ");
								 ++playerOrder; // Change order from player 1 to player 2
								 break;
							 }

							 // Player 2 operations
							 if(flagPlayerOrder==0 && playerOrder%2 == 1) { 
								 for(int k = 0; k <= getBoardRow(); ++i) {
									 if(gameBoard[i-k][j].getCellState() == 0 && playerOrder%2 == 1) {
									 
										 buttons[i-k][j].setIcon(player2);            // Set new icon to player 2
										 gameBoard[i-k][j].setAllPosition('O', i);    // Set cell parameters    
										 gameBoard[i-k][j].setCellState(2);           // Set cell state
										 ++livingCellNumber;
										 winnerPlayer(2);
										 flagPlayerOrder = 1;
										 eventFlag = 1;
										 break;
									 } 
								 }
								 
								 setUpperCellToEmpty(i,j);
								 System.out.println("... Player 2 played ... ");
								 ++playerOrder;
								 break;
							 }
						 } // END EVENT SOURCE
					 } // END SECOND FOR LOOP         
				 } // END FIRST FOR LOOP     
			 }catch(Exception ex) 
			 { 
				 warningMessage(); 
			 }   
		 }
	 }
}

	
//	@Override
//	public void displayWinner() {
//		if(checkColumn() || checkRow() || checkAscendingDiagonal() || checkDescendingDiagonal()) {
//			displayOut.setText("Winner is "+ currPlayer);
//		} else {
//			if(isFull()) {
//				displayOut.setText("Draw, do you want to play it again?"); //if isFull
//
//			}
//		}
//	}
	
//	private boolean checkRow() {
//		for(int col = 0; col < getHeight() - 3; col++) {
//			for(int row = 0; row < getWidth(); row++) {
//				if(this.gameBoard[row][col].getText().contains(currPlayer) 
//						&& this.gameBoard[row][col + 1].getText().contains(currPlayer) 
//						&& this.gameBoard[row][col + 2].getText().contains(currPlayer) 
//						&& this.gameBoard[row][col + 3].getText().contains(currPlayer)) {
//					return true;
//				}           
//			}
//		}
//		return false;
//	}

//	private boolean checkRow() {
//		int rowCount = 0;
//		for(int i = 0; i < gameBoard.length; i++) {
//			if(gameBoard[i][0].getText().contains(currPlayer) == true 
//					|| gameBoard[i][1].getText().contains(currPlayer) == true 
//					|| gameBoard[i][2].getText().contains(currPlayer) == true) {
//				rowCount++;
//				if(rowCount == 4) {
//					return is_winner = true;
//				}
//			} 
//		}
//		return is_winner;
//	}	
//	
//	private boolean checkColumn() {
//		for(int row = 0; row < getWidth() - 3; row++) {
//			for(int col = 0; col < this.getHeight(); col++) {
//				if(this.gameBoard[row][col].getText().contains(currPlayer) 
//						&& this.gameBoard[row + 1][col].getText().contains(currPlayer)  
//						&& this.gameBoard[row + 2][col].getText().contains(currPlayer) 
//						&& this.gameBoard[row + 3][col].getText().contains(currPlayer)) {
//					return true;
//				}           
//			}
//		}
//		return false;
//	}
//
//	private boolean checkAscendingDiagonal() {
//		for(int row = 3; row < getWidth(); row++) {
//			for(int col = 0; col < getHeight() - 3; col++) {
//				if(this.gameBoard[row][col].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 1][col + 1].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 2][col + 2].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 3][col + 3].getText().contains(currPlayer)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	private boolean checkDescendingDiagonal() {
//		for(int row = 3; row < getWidth(); row++) {
//			for(int col = 3; col < getHeight(); col++) {
//				if(this.gameBoard[row][col].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 1][col - 1].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 2][col - 2].getText().contains(currPlayer) 
//						&& this.gameBoard[row - 3][col - 3].getText().contains(currPlayer)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
//	private class BtnPanel extends JPanel implements ActionListener {
//		ImageIcon downArrow_reg = new ImageIcon("C:/Users/Muhammad/eclipse-workspace/Project2/img/Down-Arrow-PNG-Transparent-Image.png");
//		ImageIcon downArrow = new ImageIcon(((Image)downArrow_reg.getImage()).getScaledInstance(70, 70, Image.SCALE_FAST));
//	
//		private JButton [] jbtns; // columns 1-7
//
//		public BtnPanel(){
//			setLayout(new GridLayout(1,7));
//			jbtns = new JButton[7];
//			populatePanelWithButtons();
//		}
//
//		private void populatePanelWithButtons() {
//			for(int i = 0; i < 7; i++){
//				jbtns[i] = new JButton(downArrow);
//				jbtns[i].addActionListener(this);
//				add(jbtns[i]);
//			}
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("INSIDE actionPerformed");
//			JButton btnClicked = (JButton)e.getSource();
//			int row = gameBoard.length - 1;
//			int col;
//
//			if(btnClicked.equals(jbtns[0])) {
//				col = 0;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//
//			if(btnClicked.equals(jbtns[1])) {
//				col = 1;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//			
//			if(btnClicked.equals(jbtns[2])) {
//				col = 2;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//			
//			if(btnClicked.equals(jbtns[3])) {
//				col = 3;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//			
//			if(btnClicked.equals(jbtns[4])) {
//				col = 4;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//
//			if(btnClicked.equals(jbtns[5])) {
//				col = 5;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//
//			if(btnClicked.equals(jbtns[6])) {
//				col = 6;
//				int rowToSet = nextRow[col];
//				gameBoard[rowToSet][col].setText(currPlayer);
//				nextRow[col]--;
//				displayWinner();
//				updateCurrPlayer();
//			}
//		}
//	}	



	
//	@Override
//	public void takeTurn() {
//		if(player1 == 1) {
//			RoundCount++;
//			player1 = 2;
//		} else if(player1 == 2) {
//			RoundCount++;
//			player1 = 1;
//		}
//	}
//	
//	@Override
//	public void updateCurrPlayer() {
//		if(currPlayer.equalsIgnoreCase("red")) {
//			currPlayer = "black";
//		} else { 
//			currPlayer = "red";
//		}
//	}
//
//	@Override
//	public boolean isFull() {
//		for(int row = 0; row < gameBoard.length; row++) {
//			for(int col = 0; col < gameBoard[row].length; col++) {
//				if(gameBoard[row][col].getText().isEmpty()) {
//					return false;
//				//				if(gameBoard[row][col] == EMPTY) {
////					return false;
////				}
//				}
//			}
//		}
//		return true; // none were empty return true
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton btnClicked = (JButton)e.getSource();
//		btnClicked.setText(currPlayer);
//		btnClicked.setEnabled(false);
//		
//		displayWinner();
//		updateCurrPlayer();
//	}
//}
//
