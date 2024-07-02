
public class Player {
	// Data members
	private String name;
    private Board board;

    // Constructor
    public Player(String name, int boardSize) {
        this.name = name;
        this.board = new Board(boardSize);
    }

    // Method to get the player's name
    public String getName() {
        return name;
    }

    // Method to get the player's board
    public Board getBoard() {
        return board;
    }
}
