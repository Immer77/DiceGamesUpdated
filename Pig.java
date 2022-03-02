package dicegames;

import java.util.Scanner;

public class Pig {
    private final Die die;
    private final Scanner scan;
    private int playerOnePoints;
    private int playerTwoPoints;
    private boolean finished = false;
    private int playerNumber = 1;
    private int wincondition = 100;
    private int playerOneCurrentPoints;
    private int playerTwoCurrentPoints;



    public Pig() {
        die = new Die();
        scan = new Scanner(System.in);
    }

    /**
     * Sætter mænge af point der kræves
     */
    public void setWincondition(){
        System.out.print("How much do you wish to play to? : ");
        wincondition = scan.nextInt();
    }

    /**
     * Tjekker spillerens point for at se efter om de er nået over 100
     *
     * @param points
     */
    public void checkWinCondition(int points) {
        if (points >= wincondition) {
            System.out.println("Congratulations you win");
            gameOver();
        }
    }

    /**
     * Når spillet er slut efter en når 100
     */
    public void gameOver() {
        System.out.println("Thanks for playing!");
        finished = true;
        System.exit(0);
    }

    /**
     * Byder brugeren velkommen
     */
    public void welcomeGame() {
        System.out.println("Welcome to the Pig game!");
    }

    /**
     * Skifter player nummer
     *
     * @return
     */
    public int switchPlayerNumber() {
        String svar = scan.nextLine();
        if (svar.equalsIgnoreCase("N")) {
            if (playerNumber == 1) {
                playerNumber = 2;
            } else {
                playerNumber = 1;
            }
        }
        return playerNumber;
    }

    /**
     * Metoden der skifter tur mellem hver spiller
     */
    public void takeTurn() {
        boolean done = false;
        while (!finished) {
            while (!done) {
                playerOneCurrentPoints = playerOnePoints;
                playerTwoCurrentPoints = playerTwoPoints;
                switchPlayerNumber();
                if (playerNumber == 1) {
                    die.roll();
                    if (die.getFaceValue() == 1) {
                        System.out.println("Player one Threw 1, you suck");
                        playerOnePoints = playerOneCurrentPoints;
                        playerNumber = 2;
                    } else {
                        playerOnePoints = playerOnePoints + die.getFaceValue();
                        System.out.println("Player One's Turn");
                        System.out.println("Player One points is: " + getPlayerOnePoints());
                        System.out.println("Press 'y' to roll, press 'n' to stop");
                        checkWinCondition(getPlayerOnePoints());
                    }
                } else {
                    die.roll();
                    if (die.getFaceValue() == 1) {
                        System.out.println("Player two Threw 1, you suck");
                        playerTwoPoints = playerTwoCurrentPoints;
                        playerNumber = 1;
                    } else {
                        playerTwoPoints = playerTwoPoints + die.getFaceValue();
                        System.out.println("Player Two's turn");
                        System.out.println("Player two point is: " + getPlayerTwoPoints());
                        System.out.println("Press 'y' to roll, press 'n' to stop");
                        checkWinCondition(getPlayerTwoPoints());
                    }
                }
            }
        }

    }

    /**
     * Returnere antal point player 1 har
     *
     * @return
     */
    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    /**
     * Returnere antal point player 2 har
     *
     * @return
     */
    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }
}
