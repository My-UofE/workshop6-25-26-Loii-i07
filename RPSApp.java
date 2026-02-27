import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        // Use n to select a HandSign
        switch (n) {
            case 0: computerMove = HandSign.ROCK; break;
            case 1: computerMove = HandSign.PAPER; break;
            case 2: computerMove = HandSign.SCISSORS; break;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        HandSign playerHandSign = null;
        
        do {
            System.out.println("Enter move: (R)ock, (P)aper, (S)cissors, or (Q)uit:");
            
            // Read input and clean it up
            String input = in.next().toLowerCase();
            if (input.length() == 0) continue;
            char inChar = input.charAt(0);

            // Logic to map character to HandSign or Quit
            if (inChar == 'r') {
                playerHandSign = HandSign.ROCK;
                validInput = true;
            } else if (inChar == 'p') {
                playerHandSign = HandSign.PAPER;
                validInput = true;
            } else if (inChar == 's') {
                playerHandSign = HandSign.SCISSORS;
                validInput = true;
            } else if (inChar == 'q') {
                // Return null to signify the user wants to quit
                return null; 
            } else {
                System.out.println("### Invalid input! Please use R, P, S, or Q.");
            }

        } while(!validInput);
        
        return playerHandSign;
    }

    /**
     * Check who wins
     * @return 0 if tie, -1 if h2 wins, 1 if h1 wins
     */
    public static int whoWins(HandSign h1, HandSign h2){
        if (h1 == h2) {
            return 0; // Tie
        }
        
        // Winning conditions for player (h1)
        if ((h1 == HandSign.ROCK && h2 == HandSign.SCISSORS) ||
            (h1 == HandSign.PAPER && h2 == HandSign.ROCK) ||
            (h1 == HandSign.SCISSORS && h2 == HandSign.PAPER)) {
            return 1;
        }
        
        // Otherwise, computer (h2) wins
        return -1;
    }
    
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        boolean gameOver = false;
        System.out.println("--- Welcome to Rock Paper Scissors ---");

        while (!gameOver){
            // Step 1: Get the player move
            HandSign playerMove = getPlayerMove();

            // Check if user chose to quit
            if (playerMove == null) {
                gameOver = true;
                System.out.println("Thanks for playing!");
                break;
            }

            // Step 2: Get the computer move
            HandSign computerMove = getComputerMove();

            // Step 3: Check who wins
            int result = whoWins(playerMove, computerMove);

            // Step 4: Output the results of the round
            System.out.println("You played: " + playerMove);
            System.out.println("Computer played: " + computerMove);

            if (result == 0) {
                System.out.println("It's a TIE!");
            } else if (result == 1) {
                System.out.println("You WIN this round!");
                playerScore++;
            } else {
                System.out.println("Computer WINS this round!");
                computerScore++;
            }

            // Step 5: Update and print scores
            System.out.println("Score -> Player: " + playerScore + " | Computer: " + computerScore);
            System.out.println("---------------------------------------");
        }
        
        System.out.println("Final Score -> Player: " + playerScore + " | Computer: " + computerScore);
    }
}