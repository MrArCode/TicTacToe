public class Board {
    private final Tile[][] board;

    private Board(Tile[][] board) {
        this.board = board;
    }

    public static Board createBoard() {
        Tile[][] board = new Tile[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Tile.EMPTY;
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


}