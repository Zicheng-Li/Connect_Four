public class Board {
	
	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private static char[][] board;

	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	
	// By li1276 
	public Board() {
		Board.board= new char[NUM_OF_ROW][15];
	}
	
	public void printBoard() {
		for(int i =0; i<NUM_OF_ROW; i++) {
			for(int j=0; j<15; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean containsWin() {
		// check for horizontal
		for(int i=5; i>=0; i--) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] != ' ') {
					if(board[i][j] == board[i][j+2] && board[i][j+2]==board[i][j+4] && board[i][j+4]== board[i][j+6]) {
						return true;
					}
				}
			}
		}

		// check for vertical 
		for(int i=5; i>=3; i--) {
			for(int j=1; j<=13; j+=2) {
				if(board[i][j] != ' ') {
					if(board[i][j] == board[i-1][j] && board[i-1][j]== board[i-2][j] && board[i-2][j]==board[i-3][j]) {
						return true;
					}
				}
			}
		}

		// check for diagonal from left to right
		for(int i=0; i<=2; i++) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] != ' ') {
					if(board[i][j] == board[i+1][j+2] && board[i+1][j+2]==board[i+2][j+4] && board[i+2][j+4]== board[i+3][j+6]) {
						return true;
					}
				}
			}
		}

		// check for diagonal from right to left
		for(int i=0; i<=2; i++) {
			for(int j=13; j>=7; j-=2) {
				if(board[i][j] != ' ') {
					if(board[i][j] == board[i+1][j-2] && board[i+1][j-2]==board[i+2][j-4] && board[i+2][j-4]== board[i+3][j-6]) {
						return true;
					}
				}
			}
		}
		return false;
		
	}

	public static boolean validateCol(int col) {
		if(board[0][col] != ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isTie() {
		for(int i =0; i<NUM_OF_ROW; i++) {
			for(int j=1; j<=13; j+=2) {
				if (board[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		for(int i =0; i<NUM_OF_ROW; i++) {
			for(int j=0; j<= 12; j=j+2) {
				board[i][j] = '|';
				board[i][j+1] = ' ';
			}
			board[i][14] = '|';
		}
	}

	public static void addSymbol(int col, char symbol) {
		for(int i=5; i>=0; i--) {
            if (board[i][col] == ' ') {
                board[i][col] = symbol;
                break;
            }
        }
	}

	public static int AInextstep(char symbol) {
		int r =(int)(Math.random() * ((7-1) +1))+1;
		r=r*2-1;
		// To win move for horizontal from left to right 
		for(int i=5; i>=0; i--) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] == symbol && board[i][j+2]==symbol && board[i][j+4]== symbol) {
					if(board[i][j+6] == ' ') {
						return j+6;
					}
				}
				if(board[i][j] == symbol && board[i][j+2]==symbol && board[i][j+6]== symbol) {
					if(board[i][j+6] == ' ') {
						return j+4;
					}
				}
				if(board[i][j] == symbol && board[i][j+4]==symbol && board[i][j+6]== symbol) {
					if(board[i][j+2] == ' ') {
						return j+2;
					}
				}
			}
		}
		// To win move for horizontal from right to left 
		for(int i=5; i>=0; i--) {
			for(int j=13; j>=7; j-=2) {
				if(board[i][j] == symbol && board[i][j-2]==symbol && board[i][j-4]== symbol) {
					if(board[i][j-6] == ' ') {
						return j-6;
					}
				}
				if(board[i][j] == symbol && board[i][j-4]==symbol && board[i][j-6]== symbol) {
					if(board[i][j-2] == ' ') {
						return j-2;
					}
				}
				if(board[i][j] == symbol && board[i][j-2]==symbol && board[i][j-6]== symbol) {
					if(board[i][j-4] == ' ') {
						return j-4;
					}
				}
			}
		}
		// To win move on vertical 
		for(int i=5; i>=3; i--) {
			for(int j=1; j<=13; j+=2) {
				if(board[i][j] == symbol && board[i-1][j]== symbol && board[i-2][j]==symbol) {
					if(board[i-3][j]== ' ') {
						return j;
					}
				}
			}
		}
		// To win move for diagonal from bottom left to right
		for(int i=5; i>=3; i--) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] == symbol && board[i-1][j+2]==symbol && board[i-2][j+4]== symbol) {
					if(board[i-3][j+6]== ' ') {
						return j+6;
					}
				}
				if(board[i][j] == symbol && board[i-1][j+2]==symbol && board[i-3][j+6]== symbol) {
					if(board[i-2][j+4]== ' ') {
						return j+4;
					}
				}
				if(board[i][j] == symbol && board[i-2][j+4]==symbol && board[i-3][j+6]== symbol) {
					if(board[i-1][j+2]== ' ') {
						return j+2;
					}
				}
			}
		}
		// To win move for diagonal from bottom right to left
		for(int i=5; i>=3; i--) {
			for(int j=13; j>=7; j-=2) {
				if(board[i][j] == symbol && board[i-1][j-2]==symbol && board[i-2][j-4]== symbol) {
					if(board[i-3][j-6]== ' ') {
						return j-6;
					}
				}
				if(board[i][j] == symbol && board[i-1][j-2]==symbol && board[i-3][j-6]== symbol) {
					if(board[i-2][j-4]== ' ') {
						return j-4;
					}
				}
				if(board[i][j] == symbol && board[i-2][j-4]==symbol && board[i-3][j-6]== symbol) {
					if(board[i-1][j-2]== ' ') {
						return j-2;
					}
				}
			}
		}
		// To block move for horizontal from left to right 
		for(int i=5; i>=0; i--) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] != ' ' && board[i][j] != symbol) {
					if(board[i][j] == board[i][j+2] && board[i][j+2]==board[i][j+4]) {
						return j+6;
					}
					if(board[i][j] == board[i][j+4] && board[i][j+4]==board[i][j+6]) {
						return j+2;
					}
					if(board[i][j] == board[i][j+2] && board[i][j+2]==board[i][j+6]) {
						return j+4;
					}
				}
			}
		}
		// To block move for horizontal from right to left
		for(int i=5; i>=0; i--) {
			for(int j=13; j>=7; j-=2) {
				if(board[i][j] != ' ' && board[i][j] != symbol) {
					if(board[i][j] == board[i][j-2] && board[i][j-2]==board[i][j-4]) {
						return j-6;
					}
					if(board[i][j] == board[i][j-2] && board[i][j-2]==board[i][j-6]) {
						return j-4;
					}
					if(board[i][j] == board[i][j-4] && board[i][j-4]==board[i][j-6]) {
						return j-2;
					}
				}
			}
		}
		// To block move for vertical 
		for(int i=5; i>=3; i--) {
			for(int j=1; j<=13; j+=2) {
				if(board[i][j] != ' ' && board[i][j] != symbol) {
					if(board[i][j] == board[i-1][j] && board[i-1][j]==board[i-2][j]) {
						return j;
					}
				}
			}
		}
		// To block move for diagonal from bottom left to right
		for(int i=5; i>=3; i--) {
			for(int j=1; j<=7; j+=2) {
				if(board[i][j] != ' ' && board[i][j] != symbol) {
					if(board[i][j] == board[i-1][j+2] && board[i-1][j+2]==board[i-2][j+4]) {
						return j+6;
					}
					if(board[i][j] == board[i-1][j+2] && board[i-1][j+2]==board[i-3][j+6]) {
						return j+4;
					}
					if(board[i][j] == board[i-2][j+4] && board[i-2][j+4]==board[i-3][j+6]) {
						return j+2;
					}
				}
			}
		}
		// To block move for diagonal from bottom right to left
		for(int i=5; i>=3; i--) {
			for(int j=13; j>=7; j-=2) {
				if(board[i][j] != ' ' && board[i][j] != symbol) {
					if(board[i][j] == board[i-1][j-2] && board[i-1][j-2]==board[i-2][j-4]) {
						return j-6;
					}
					if(board[i][j] == board[i-1][j-2] && board[i-1][j-2]==board[i-3][j-6]) {
						return j-4;
					}
					if(board[i][j] == board[i-2][j-4] && board[i-2][j-4]==board[i-3][j-6]) {
						return j-2;
					}
				}
			}
		}
	return r;
	}
}


