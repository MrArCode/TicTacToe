import java.util.Scanner;

public record Player(String name, Mark mark) {
    private static final Scanner scanner = new Scanner(System.in);

    public static Player createPlayer() {
        String name = chooseName();
        Mark mark = chooseMark();
        return new Player(name, mark);
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
