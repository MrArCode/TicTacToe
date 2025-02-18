public class Board {
    private final Mark[][] board;

    private Board(Mark[][] board) {
        this.board = board;
    }

    public static Board createBoard() {
        Mark[][] board = new Mark[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Mark.EMPTY;
            }
        }
        return new Board(board);
    }

    public void showBoard() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            System.out.println(" " + board[row][0] + "   |  " + board[row][1] + "  |   " + board[row][2]);
            if (row < 2) {
                System.out.println("-----|-----|-----");
            }
        }
        System.out.println();
    }

    public void markCell(int[] position, Mark mark) {
        board[position[0]][position[1]] = mark;
    }

    public Mark[][] getBoard() {
        return board;
    }
}