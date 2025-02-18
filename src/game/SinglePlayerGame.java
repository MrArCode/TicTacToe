package game;

import ai.AI;
import model.Board;
import model.Player;
import model.Mark;
import rule.Rules;

public class SinglePlayerGame extends Game {
    private final Board board = new Board();
    private final Player player;
    private final AI ai;
    private final Rules rules = Rules.getInstance();

    public SinglePlayerGame() {
        player = Player.createPlayer();
        ai = AI.createAI(player);
    }

    @Override
    public void play() {
        boolean isPlayerTurn = (player.mark() == Mark.X);

        while (true) {
            if (isPlayerTurn) {
                board.showBoard();
                System.out.println(player.name() + " makes a move:");
                player.makeMove(board);
                if (rules.checkWin(board, player.mark())) {
                    System.out.println(player.name() + " wins!");
                    break;
                }
            } else {
                board.showBoard();
                System.out.println("AI's move:");
                ai.makeMove(board);
                if (rules.checkWin(board, ai.getMark())) {
                    System.out.println("AI wins!");
                    break;
                }
            }

            if (rules.isDraw(board)) {
                System.out.println("Draw!");
                break;
            }
            isPlayerTurn = !isPlayerTurn;
        }
    }
}
