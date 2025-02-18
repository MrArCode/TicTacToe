public final class SinglePlayer extends TicTacToe {
    private final Board board = Board.createBoard();
    private final Player player;
    private final AI ai;

    private SinglePlayer(Player player, AI ai) {
        this.player = player;
        this.ai = ai;
    }


    public static SinglePlayer CreteSinglePlayerGame() {
        Player player = Player.createPlayer();
        AI ai = AI.createAI(player);
        return new SinglePlayer(player, ai);
    }

    public void play() {
        boolean gameOver = false;

        while (true) {

            player.makeMove(board);
            board.showBoard();
            gameOver = super.getRules().checkWin(board, player.mark());

            if (gameOver) {
                break;
            }

            ai.makeMove(board);
            board.showBoard();
            gameOver = super.getRules().checkWin(board, ai.getMark());

            if (gameOver) {
                break;
            }
        }
    }


}
