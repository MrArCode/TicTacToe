package rule;

import model.Board;
import model.Mark;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Rules {
    private static final Rules INSTANCE = new Rules();

    private Rules() {
    }

    public static Rules getInstance() {
        return INSTANCE;
    }

    public boolean checkWin(Board board, Mark player) {
        Mark[][] state = board.getBoard();
        if (isAnyRowWinning(state, player)) return true;
        if (isAnyColumnWinning(state, player)) return true;
        return isDiagonalWinning(state, player);
    }

    public boolean isDraw(Board board) {
        Mark[][] state = board.getBoard();
        return Arrays.stream(state)
                .flatMap(Arrays::stream)
                .noneMatch(mark -> mark == Mark.EMPTY);
    }

    private boolean isAnyRowWinning(Mark[][] state, Mark player) {
        return Arrays.stream(state)
                .anyMatch(row -> Arrays.stream(row).allMatch(mark -> mark == player));
    }

    private boolean isAnyColumnWinning(Mark[][] state, Mark player) {
        return IntStream.range(0, 3)
                .anyMatch(col -> IntStream.range(0, 3).allMatch(row -> state[row][col] == player));
    }

    private boolean isDiagonalWinning(Mark[][] state, Mark player) {
        boolean diag1 = state[0][0] == player && state[1][1] == player && state[2][2] == player;
        boolean diag2 = state[0][2] == player && state[1][1] == player && state[2][0] == player;
        return diag1 || diag2;
    }
}