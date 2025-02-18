package game;

import util.ConsoleUtil;

public class TicTacToe extends Game {
    @Override
    public void play() {
        boolean playing = true;
        while (playing) {
            showMenu();
            int choice = ConsoleUtil.readInt("Choose an option: ", 1, 3);
            handleChoice(choice);
            playing = shouldContinuePlaying(playing);
        }
    }

    private void showMenu() {
        System.out.println("""
                ===== Tic Tac Toe =====
                1. Single Player
                2. Hot Seat
                3. Exit
                """);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                new SinglePlayerGame().play();
                break;
            case 2:
                System.out.println("Hot Seat mode is not yet implemented.");
                break;
            case 3:
                System.out.println("Thank you for playing!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private boolean shouldContinuePlaying(boolean playing) {
        if (playing) {
            String again = ConsoleUtil.readString("Do you want to play again? (y/n): ", "y", "n");
            return again.equals("y");
        }
        return false;
    }
}