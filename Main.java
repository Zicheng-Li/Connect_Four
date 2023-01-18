import java.sql.ConnectionBuilder;

import javax.swing.event.HyperlinkEvent;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour connectFour = new ConnectFour(board);
        HumanPlayer humanPlayer = new HumanPlayer('S', board, "Tom");
        AIPlayer aiPlayer = new AIPlayer('A', board, "AI");
        connectFour.setPlayer1(humanPlayer);
        connectFour.setPlayer2(aiPlayer);
        connectFour.playGame();
    }
}
