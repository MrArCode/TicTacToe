package model;

public class Board {
    private final Mark[][] board;

    public Board() {
        board = new Mark[3][3];
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                board[row][col] = Mark.EMPTY;
            }
        }
    }

    public void showBoard() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            System.out.printf("%-7s|%-7s|%-7s %n",
                    formatCell(row, 0), formatCell(row, 1), formatCell(row, 2));
            if (row < 2) {
                System.out.println("-------|-------|-------");
            }
        }
        System.out.println();
    }

    private String formatCell(int row, int col) {
        return board[row][col] == Mark.EMPTY ? "  {" + (row * 3 + col + 1) + "}" : "   " + board[row][col] + " ";
    }


    public Mark[][] getBoard() {
        return board;
    }

    public void markCell(int row, int col, Mark mark) {
        board[row][col] = mark;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == Mark.EMPTY;
    }
}