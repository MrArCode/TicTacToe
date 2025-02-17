public class Rules {
    private static final Rules INSTANCE = new Rules();

    private Rules() {}

    public static Rules getInstance() {
        return INSTANCE;
    }

    public boolean checkWin(Board board, Mark player) {
        Mark[][] state = board.getBoard();

        for (int row = 0; row < 3; row++) {
            if (state[row][0] == player && state[row][1] == player && state[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (state[0][col] == player && state[1][col] == player && state[2][col] == player) {
                return true;
            }
        }

        if ((state[0][0] == player && state[1][1] == player && state[2][2] == player) ||
            (state[0][2] == player && state[1][1] == player && state[2][0] == player)) {
            return true;
        }

        return false;
    }


    public boolean isDraw(Board board) {
        Mark[][] state = board.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (state[row][col] == Mark.EMPTY) {
                    return false;
                }
            }
        }

        return !checkWin(board, Mark.X) && !checkWin(board, Mark.O);
    }

}
