public class SnakeAndLadder {

    private static final int BOARD_SIZE = 100;

    public static void main(String[] args) {
        Board board = new Board();
        Dice dice = new Dice();
        Scanner scanner = new Scanner(System.in);

        int player1Position = 0;
        int player2Position = 0;

        printWelcomeMessage();

        while (true) {
            player1Position = takeTurn("Player 1", player1Position, board, dice, scanner);
            if (player1Position == BOARD_SIZE) {
                System.out.println("\n🎉 Player 1 wins! Congratulations! 🎉");
                break;
            }

            player2Position = takeTurn("Player 2", player2Position, board, dice, scanner);
            if (player2Position == BOARD_SIZE) {
                System.out.println("\n🎉 Player 2 wins! Congratulations! 🎉");
                break;
            }
        }

        scanner.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("🎲 Welcome to the Snake and Ladder Game! 🎲");
        System.out.println("========================================");
        System.out.println("Rules:");
        System.out.println("1. Reach square 100 to win.");
        System.out.println("2. Landing on a snake sends you down.");
        System.out.println("3. Landing on a ladder takes you up.");
        System.out.println("Let the game begin! Good luck! 🍀");
        System.out.println("========================================\n");
    }

    private static int takeTurn(String playerName, int currentPosition, Board board, Dice dice, Scanner scanner) {
        System.out.println(playerName + "'s turn. Press Enter to roll the dice.");
        scanner.nextLine();
        int diceRoll = dice.roll();
        System.out.println(playerName + " rolled a 🎲 " + diceRoll);
        return board.movePlayer(playerName, currentPosition, diceRoll);
    }
}