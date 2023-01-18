import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner user = new Scanner(System.in);

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        
    }

    @Override
    public void makeMove(Board board) {
        System.out.print(name+ ", please input your move: ");
        int col = user.nextInt();
        col = col + (col-1);
        while(true){
            if (Board.validateCol(col)) {
                System.out.print("Error! This column is full! You need to re-enter a number: ");
                col = user.nextInt();
                col = col + (col-1);
            }else{
                break;
            }
        }
        Board.addSymbol(col, symbol);
    }
    // By li1276
}
