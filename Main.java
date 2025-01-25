public class SnakeAndLadder {

    private static final int BOARD_SIZE = 100;

    public static void main(String[] args) {
        Board board = new Board();
        Dice dice = new Dice();
        Scanner scanner = new Scanner(System.in);

        int player1Position = 0;
        int player2Position = 0;

        System.out.println("Welcome to Snake and Ladder!");
        System.out.println("First to reach square 100 wins!");

        while (true) {
            player1Position = takeTurn("Player 1", player1Position, board, dice, scanner);
            if (player1Position == BOARD_SIZE) {
                System.out.println("Player 1 wins!");
                break;
            }

            player2Position = takeTurn("Player 2", player2Position, board, dice, scanner);
            if (player2Position == BOARD_SIZE) {
                System.out.println("Player 2 wins!");
                break;
            }
        }

        scanner.close();
    }

    private static int takeTurn(String playerName, int currentPosition, Board board, Dice dice, Scanner scanner) {
        System.out.println(playerName + "'s turn. Press Enter to roll the dice.");
        scanner.nextLine();
        int diceRoll = dice.roll();
        System.out.println(playerName + " rolled a " + diceRoll);
        return board.movePlayer(currentPosition, diceRoll);
    }
}
