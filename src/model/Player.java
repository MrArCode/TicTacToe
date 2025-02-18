package model;

import util.ConsoleUtil;

public record Player(String name, Mark mark) {

    public static Player createPlayer() {
        System.out.print("Enter your name: ");
        String name = ConsoleUtil.scanner.nextLine();
        Mark mark = chooseMark();
        return new Player(name, mark);
    }

    private static Mark chooseMark() {
        while (true) {
            System.out.print("Choose your mark (X/O): ");
            String input = ConsoleUtil.scanner.nextLine().trim().toUpperCase();

            try {
                return Mark.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid mark. Please try again.");
            }
        }
    }

    public void makeMove(Board board) {
        while (true) {
            int move = ConsoleUtil.readInt("Choose a cell: ", 1, 9);
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            if (board.isCellEmpty(row, col)) {
                board.markCell(row, col, mark);
                break;
            } else {
                System.out.println("This cell is already occupied. Choose another one.");
            }
        }
    }
}