public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        
    }

    @Override
    public void makeMove(Board board) {
        int col = Board.AInextstep(symbol);
        while(Board.validateCol(col)) {
            col =(int)(Math.random() * ((7-1) +1))+1;
		    col=col*2-1;
        }
        Board.addSymbol(col, symbol);
        
    }
    // By li1276
}
