import java.util.Scanner;

public final class SinglePlayerGame extends TicTacToe {
    private final Board board = Board.createBoard();
    private final Player player;
    private final AI ai;

    private SinglePlayerGame(Player player, AI ai) {
        this.player = player;
        this.ai = ai;
    }


    public static SinglePlayerGame Create() {
        Player player = Player.createPlayer();
        AI ai = AI.createAI(player);
        return new SinglePlayerGame(player, ai);
    }

    public StateOfGame playSinglePlayer() {
        boolean gameOver = false;

        while (gameOver) {

            player.makeMove(board);
            board.showBoard();
            gameOver = super.getRules().checkWin(board, player.mark());

            if (gameOver) break;

            ai.makeMove(board);
            board.showBoard();
            gameOver = super.getRules().checkWin(board, ai.getMark());

            if (gameOver) break;

        }

        return isPlayingAgain();


    }

    private StateOfGame isPlayingAgain() {
        System.out.println("Would you like to play again? y/n? ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return StateOfGame.CONTINUE;
        }
        return StateOfGame.END;
    }


}
