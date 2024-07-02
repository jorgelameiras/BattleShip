
public class Ship {
	// Data members
	protected int size;
    protected int hits;
    protected char symbol;

    // Constructor
    public Ship(int size, char symbol) {
        this.size = size;
        this.hits = 0;
        this.symbol = symbol;
    }

    // Method to check if ship is sunk
    public boolean isSunk() {
        return hits == size;
    }

    // Method to take a hit
    public void takeHit() {
        hits++;
    }

    // Method to get the ship symbol
    public char getSymbol() {
        return symbol;
    }
}
