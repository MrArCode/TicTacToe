import java.util.Scanner;

public sealed class TicTacToe extends Game permits SinglePlayerGame {
    private final Scanner scanner = new Scanner(System.in);
    private final Rules rules = Rules.getInstance();

    enum StateOfGame{
        CONTINUE,
        END
    }


    @Override
    void play() {
        StateOfGame state = StateOfGame.CONTINUE;
        while (state == StateOfGame.CONTINUE) {
            showMenu();
            int decision = readPlayerDecision();
            state = switch (decision) {
                case 1 -> SinglePlayerGame.create().playSinglePlayer();
                case 2 -> {
                    System.out.println("Would you like to play again?");
                    yield StateOfGame.CONTINUE;
                }
                case 3 -> {
                    System.exit(0);
                    yield null;
                }
                default -> throw new IllegalStateException("Unexpected value: " + decision);
            };
        }
    }


    public Rules getRules() {
        return rules;
    }

    private void showMenu() {
        System.out.println("===== Tic-Tac-Toe =====\n" +
                           "1. Single player\n" +
                           "2. Hot Seat\n" +
                           "3. Exit");
    }



    private int readPlayerDecision(){
        while (true){
            System.out.println("Enter your choice: ");
            String input = scanner.nextLine().trim();

            if(input.isEmpty()){
                System.out.println("Input cannot be empty");
                continue;
            }

            try {
                int choice = Integer.parseInt(input);

                if(choice >= 1 && choice <= 3){
                    return choice;
                }

                System.out.println("Please enter a number between 1 and 3");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input please try again");
            }
        }
    }




}
