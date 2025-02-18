import java.util.Scanner;

public record Player(String name, Mark mark) {
    private static final Scanner scanner = new Scanner(System.in);

    public static Player createPlayer() {
        String name = chooseName();
        Mark mark = chooseMark();
        return new Player(name, mark);
    }

    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int move;
        while (true) {
            System.out.print("Enter your move (1-9): ");
            String input = scanner.nextLine().trim();
            try {
                move = Integer.parseInt(input);
                if (move < 1 || move > 9) {
                    System.out.println("Please enter a number between 1 and 9.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            int row = (move - 1) / 3;
            int col = (move - 1) % 3;

            if (board.getBoard()[row][col] != Mark.EMPTY) {
                System.out.println("Cell is already occupied. Please choose another cell.");
                continue;
            }

            board.markCell(new int[]{row,col}, this.mark());
            break;
        }
    }

    private static String chooseName() {
        System.out.print("Choose a name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Mark chooseMark() {
        while (true) {
            System.out.print("Choose a mark: X or O: ");
            String mark = scanner.nextLine().trim();
            switch (mark) {
                case "X":
                    return Mark.X;
                case "O":
                    return Mark.O;
                default:
                    System.out.println("Invalid mark. Please try again.");
            }
        }
    }


}