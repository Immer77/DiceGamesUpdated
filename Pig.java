package dicegames;

import java.util.Scanner;

public class Pig {
    private final Die die;
    private final Scanner scan;
    private int playerOnePoints;
    private int playerTwoPoints;
    private boolean finished = false;


    public Pig() {
        die = new Die();
        scan = new Scanner(System.in);
    }

    public void checkWinCondition(int points) {
        if (points >= 100) {
            System.out.println("Congratulations you win");
            gameOver();
        }
    }

    public void gameOver() {
        System.out.println("Thanks for playing!");
        finished = true;
        System.exit(0);
    }

    public void welcomeGame() {
        System.out.println("Welcome to the Pig game!");
    }

    public void takeTurn(int playerNumber) {
        boolean done = false;
        while (!finished) {
            if (playerNumber == 1) {
                int playerOneCurrentPoints = playerOnePoints;
                while (!done) {
                    System.out.println("Player One's Turn");
                    System.out.println("Do you Wish to throw the dice? Y/N");
                    String svar = scan.nextLine();
                    if (svar.equalsIgnoreCase("N")) {
                        playerNumber = 2;
                        done = true;
                    } else {
                        die.roll();
                        if (die.getFaceValue() == 1) {
                            System.out.println("You Threw 1, you suck");
                            playerOnePoints = playerOneCurrentPoints;
                            playerNumber = 2;
                            done = true;
                        } else {
                            playerOnePoints = playerOnePoints + die.getFaceValue();
                            System.out.println("Player one points is" + getPlayerOnePoints());
                            checkWinCondition(getPlayerOnePoints());
                        }
                    }
                }
            } else if (playerNumber == 2) {
                int playerTwoCurrentPoints = playerTwoPoints;
                while (done) {
                    System.out.println("Player Two's Turn");
                    System.out.println("Do you Wish to throw the dice? Y/N");
                    String svar = scan.nextLine();
                    if (svar.equalsIgnoreCase("N")) {
                        playerNumber = 1;
                        done = false;
                    } else {
                        die.roll();
                        if (die.getFaceValue() == 1) {
                            System.out.println("You Threw 1, you suck");
                            playerTwoPoints = playerTwoCurrentPoints;
                            playerNumber = 1;
                            done = false;
                        } else {
                            playerTwoPoints = playerTwoPoints + die.getFaceValue();
                            System.out.println("Player Two points is" + getPlayerTwoPoints());
                            checkWinCondition(getPlayerTwoPoints());
                        }
                    }
                }
            }
        }
    }

    //P1's Point
    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    //P2's point
    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }
}
