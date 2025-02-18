package game.tictactoe;

import game.Game;
import model.Board;
import model.Mark;
import model.Player;
import rule.Rules;

public class HotSeat extends Game {

    private final Board board = new Board();
    private final Rules rules = Rules.getInstance();
    private final Player firstPlayer;
    private final Player secondPlayer;

    public HotSeat() {
        firstPlayer = Player.createPlayer();
        secondPlayer = Player.createPlayer(firstPlayer);
    }

    @Override
    public void play() {
        boolean isFirstPlayerTurn = (firstPlayer.mark() == Mark.X);

        while (true) {
            board.showBoard();
            if (isFirstPlayerTurn) {
                System.out.println(firstPlayer.name() + " makes a move:");
                firstPlayer.makeMove(board);
                if (rules.checkWin(board, firstPlayer.mark())) {
                    System.out.println(firstPlayer.name() + " wins!");
                    break;
                }
            } else {
                System.out.println(secondPlayer.name() + " makes a move:");
                secondPlayer.makeMove(board);
                if (rules.checkWin(board, secondPlayer.mark())) {
                    System.out.println(secondPlayer.name() + " wins!");
                    break;
                }
            }

            if (rules.isDraw(board)) {
                System.out.println("Draw!");
                break;
            }
            isFirstPlayerTurn = !isFirstPlayerTurn;
        }
    }
}
