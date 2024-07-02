
public class Grid {
	// Data members
	private char[][] grid;
    private int size;

    // Constructor
    public Grid(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid();
    }

    // Method to set the grid
    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    // Method to display the grid
    public void display(boolean showShips) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to get the character at a specific position
    public char getCharAtPosition(int row, int col) {
        return grid[row][col];
    }

    // Method to set the character at a specific position
    public void setCharAtPosition(int row, int col, char character) {
        grid[row][col] = character;
    }

    // Method to check if all ships are sunk
    public boolean allShipsSunk() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 'S' || grid[i][j] == 'B' || grid[i][j] == 'D') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to get the size of the grid
    public int getSize() {
        return size;
    }
}
