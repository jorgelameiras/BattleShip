// Michael Gallagher, Jorge Lameiras, and Zach Taylor
// The project is the creation of the game Battleship

import java.util.Scanner;

public class BattleshipGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create players
		Player player1 = new Player("Player 1", 8); // 8x8 board for player 1
		Player player2 = new Player("Player 2", 8); // 8x8 board for player 2

		// Place ships for each player
		player1.getBoard().placeShips();
		player2.getBoard().placeShips();

		// Game loop
		Player currentPlayer = player1;
		Player opponentPlayer = player2;
        
		while (true) {
			// Display current player's own board
			System.out.println(currentPlayer.getName() + "'s Turn");
			currentPlayer.getBoard().display(true); // Show own ships

			// Get the user input for attacking positions
			int row, col;
			
            do {
            	System.out.println(currentPlayer.getName() + ", enter row and column to attack (e.g., 0 0): ");
            	row = scanner.nextInt();
            	col = scanner.nextInt();
            	if (!isValidMove(row, col, currentPlayer.getBoard())) {
            		System.out.println("Invalid move. Please enter coordinates within the board.");
            	}
            } 
            
            while (!isValidMove(row, col, currentPlayer.getBoard()));

            // Attack opponent's board
            opponentPlayer.getBoard().attack(row, col);

            // Check if all opponent's ships are sunk
            if (opponentPlayer.getBoard().allShipsSunk()) {
            	System.out.println(currentPlayer.getName() + " wins! All opponent's ships are sunk.");
            	break;
            }

            // Swap players for the next turn
            Player temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
		}

		scanner.close();
	}

	// Method to check if the move is valid (which is within the bounds of the board)
	private static boolean isValidMove(int row, int col, Board board) {
		int boardSize = board.getSize();
		return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
	}
}
