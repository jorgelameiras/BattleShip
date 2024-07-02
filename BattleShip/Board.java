import java.util.Random;

public class Board {
	// Data members
	private Grid grid;
    private Random random;

    // Constructor
    public Board(int size) {
        this.grid = new Grid(size);
        this.random = new Random();
    }

    // Method to display the board
    public void display(boolean showShips) {
        grid.display(showShips);
    }

    // Method to randomly place ships on the board
    public void placeShips() {
        placeShipRandomly(new Battleship());
        placeShipRandomly(new Submarine());
        placeShipRandomly(new Submarine());
        placeShipRandomly(new Destroyer());
        placeShipRandomly(new Destroyer());
    }

    // Method to randomly place a ship on the board
    private void placeShipRandomly(Ship ship) {
        int shipSize = ship.size;
        int row, col;
        do {
            row = random.nextInt(grid.getSize());
            col = random.nextInt(grid.getSize());
        } 
        while (!canPlaceShip(row, col, shipSize));

        for (int i = 0; i < shipSize; i++) {
            grid.setCharAtPosition(row + i, col, ship.getSymbol());
        }
    }

    // Method to check if a ship can be placed at the given position
    private boolean canPlaceShip(int row, int col, int shipSize) {
        return row + shipSize <= grid.getSize();
    }

    // Method to attack a position on the board
    public void attack(int row, int col) {
        char character = grid.getCharAtPosition(row, col);
        if (character != '-') {
            grid.setCharAtPosition(row, col, 'X'); // Hit
        } 
        else {
            grid.setCharAtPosition(row, col, 'O'); // Miss
        }
    }

    // Method to check if all ships are sunk
    public boolean allShipsSunk() {
        return grid.allShipsSunk();
    }
    public int getSize() {
    	return grid.getSize();
    }
}
