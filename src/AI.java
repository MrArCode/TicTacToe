import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AI {

    private static final Scanner scanner = new Scanner(System.in);

    private final Difficulty difficulty;
    private final Mark mark;
    private final Rules rules = Rules.getInstance();

    enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    private AI(Difficulty difficulty, Mark mark) {
        this.difficulty = difficulty;
        this.mark = mark;
    }


    public static AI createAI(Player humanPlayer) {
        Mark aiMark = humanPlayer.mark() == Mark.X ? Mark.X : Mark.O;

        while (true) {
            System.out.println("What difficulty would you like to play?\n" +
                               "1 - Easy\n" +
                               "2 - Medium\n" +
                               "3 - Hard");

            int choice = readPlayerDecision();

            switch (choice) {
                case 1:
                    return new AI(Difficulty.EASY, aiMark);
                case 2:
                    return new AI(Difficulty.MEDIUM, aiMark);
                case 3:
                    return new AI(Difficulty.HARD, aiMark);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }

    }

    private static int readPlayerDecision() {
        while (true) {
            System.out.println("Enter your choice: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
                continue;
            }

            try {
                int choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= 3) {
                    return choice;
                }

                System.out.println("Please enter a number between 1 and 3");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input please try again");
            }
        }
    }

    public void makeMove(Board board) {
        switch (difficulty){
            case EASY: makeEasyMove(board); break;
            case MEDIUM: makeMediumMove(board); break;
            case HARD: makeMediumMove(board); break;
        }
    }


    public void makeEasyMove(Board board) {
        List<int[]> availableMoves = new ArrayList<>();

        Mark[][] state = board.getBoard();

        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                if (state[row][col] == Mark.EMPTY) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        if (availableMoves.isEmpty()) {
            return;
        }

        Random random = new Random();
        int[] position = availableMoves.get(random.nextInt(availableMoves.size()));

        board.markCell(position, mark);

    }



    public void makeMediumMove(Board board) {
        Mark[][] state = board.getBoard();
        Mark playerMark = mark == Mark.X ? Mark.X : Mark.O;

        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                if (state[row][col] == Mark.EMPTY) {
                    state[row][col] = playerMark;
                }

                if(rules.checkWin(board, playerMark)) {
                    state[row][col] = mark;
                }

                state[row][col] = Mark.EMPTY;
            }
        }
    }

    public Mark getMark() {
        return mark;
    }
}
