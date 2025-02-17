import java.util.Scanner;

public class Player {
    private static final Scanner scanner = new Scanner(System.in);
    private final String name;
    private final Mark mark;

    public Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public static Player createPlayer() {
        String name = chooseName();
        Mark mark = chooseMark();
        return new Player(name, mark);
    }

    private static String chooseName(){
        System.out.print("Choose a name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Mark chooseMark() {
        while (true) {
            System.out.print("Choose a mark: X or O: ");
            String mark = scanner.nextLine().trim();
            switch (mark) {
                case "X": return Mark.X;
                case "O": return Mark.O;
                default:
                    System.out.println("Invalid mark. Please try again.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}
