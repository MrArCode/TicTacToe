import java.util.Scanner;

public class AI {

    Difficulty difficulty;
    Mark mark;
    Rules rules = Rules.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

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


}
