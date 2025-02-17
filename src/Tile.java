public enum Tile {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    Tile(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
