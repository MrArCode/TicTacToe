package ai;

import model.Board;
import model.Mark;
import model.Player;
import rule.Rules;
import util.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    public enum Difficulty {EASY, MEDIUM}

    private final Difficulty difficulty;
    private final Mark mark;
    private final Rules rules = Rules.getInstance();
    private final Random random = new Random();

    public AI(Difficulty difficulty, Mark mark) {
        this.difficulty = difficulty;
        this.mark = mark;
    }

    public static AI createAI(Player humanPlayer) {
        Mark aiMark = (humanPlayer.mark() == Mark.X) ? Mark.O : Mark.X;
        displayAIDifficultyMenu();
        int choice = ConsoleUtil.readInt("Enter your choice: ", 1, 2);
        Difficulty difficulty = (choice == 1) ? Difficulty.EASY : Difficulty.MEDIUM;
        return new AI(difficulty, aiMark);
    }

    public void makeMove(Board board) {
        switch (difficulty) {
            case MEDIUM:
                makeStrategicMove(board);
                break;
            case EASY:
            default:
                makeRandomMove(board);
        }
    }

    public Mark getMark() {
        return mark;
    }

    private static void displayAIDifficultyMenu() {
        System.out.println("""
                Choose AI difficulty level:
                1 - Easy
                2 - Medium
                """);
    }

    private void makeRandomMove(Board board) {
        List<int[]> availableMoves = new ArrayList<>();
        Mark[][] state = board.getBoard();
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                if (state[row][col] == Mark.EMPTY) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }
        if (!availableMoves.isEmpty()) {
            int[] move = availableMoves.get(random.nextInt(availableMoves.size()));
            board.markCell(move[0], move[1], mark);
        }
    }

    private void makeStrategicMove(Board board) {
        int[] winningMove = findWinningMove(board, mark);
        if (winningMove != null) {
            board.markCell(winningMove[0], winningMove[1], mark);
            return;
        }

        int[] blockingMove = findWinningMove(board, getOpponentMark());
        if (blockingMove != null) {
            board.markCell(blockingMove[0], blockingMove[1], mark);
            return;
        }
        makeRandomMove(board);
    }

    private int[] findWinningMove(Board board, Mark testMark) {
        Mark[][] state = board.getBoard();
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                if (state[row][col] == Mark.EMPTY) {
                    state[row][col] = testMark;
                    boolean win = rules.checkWin(board, testMark);
                    state[row][col] = Mark.EMPTY;
                    if (win) {
                        return new int[]{row, col};
                    }
                }
            }
        }
        return null;
    }

    private Mark getOpponentMark() {
        return (mark == Mark.X) ? Mark.O : Mark.X;
    }
}