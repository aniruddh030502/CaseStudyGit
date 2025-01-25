class Board {
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;
    private static final int BOARD_SIZE = 100;

    public Board() {
        snakes = initializeSnakes();
        ladders = initializeLadders();
    }

    private Map<Integer, Integer> initializeSnakes() {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(97, 78);
        snakes.put(94, 74);
        snakes.put(64, 60);
        snakes.put(35, 5);
        return snakes;
    }

    private Map<Integer, Integer> initializeLadders() {
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 23);
        ladders.put(8, 34);
        ladders.put(20, 77);
        ladders.put(41, 79);
        return ladders;
    }

    public int movePlayer(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > BOARD_SIZE) {
            System.out.println("Roll exceeds board size. Stay at " + currentPosition);
            return currentPosition;
        }

        System.out.println("Moved from " + currentPosition + " to " + newPosition);

        if (snakes.containsKey(newPosition)) {
            System.out.println("Oh no! Bitten by a snake! Sliding down to " + snakes.get(newPosition));
            newPosition = snakes.get(newPosition);
        } else if (ladders.containsKey(newPosition)) {
            System.out.println("Yay! Climbed a ladder! Going up to " + ladders.get(newPosition));
            newPosition = ladders.get(newPosition);
        }

        System.out.println("New position: " + newPosition);
        return newPosition;
    }
}