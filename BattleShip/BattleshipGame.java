// Michael Gallagher, Jorge Lameiras, and Zach Taylor
// The project is the creation of the game Battleship

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;

public class BattleshipGame extends JFrame{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		BattleshipGame bg = new BattleshipGame();
		bg.run(dm);
		
		// Create players
		Player player1 = new Player("Bot", 8); // 8x8 board for player 1
		Player player2 = new Player("You", 8); // 8x8 board for player 2

		// Place ships bot player
		player1.getBoard().placeShips();
		//player2.getBoard().placeShips();
		
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
	
	public void run(DisplayMode dm) {
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		
		Screen s = new Screen();
		
		try {
			s.setFullScreen(dm, this);	// "this" always references to the object you are working on. In this case is "s"
			try {
				Thread.sleep(5000);		// This make the screen do nothing for 5s once its in full screen mode
			}catch(Exception ex){}
		}finally {
			s.restoreScreen();
		}
	}
	
	public void paint(Graphics g) {
		g.drawString("This is gonnabe awesome", 200, 200);
	}
}
