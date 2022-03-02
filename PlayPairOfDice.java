package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {
    private Scanner scan = new Scanner(System.in);
    private PairOfDices pairOfDices = new PairOfDices();

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet KAST terning");
    }


    public void gameOver(){
        System.out.println("Du kastede terningen: " + pairOfDices.getNumberOfRolls() + " gange");
        System.out.println("Du ramte 1: " + pairOfDices.getNumberOfOneRolls() + " gange");
        System.out.println("Du ramte 2: " + pairOfDices.getNumberOfTwoRolls() + " gange");
        System.out.println("Du ramte 3: " + pairOfDices.getNumberOfThreeRolls() + " gange");
        System.out.println("Du ramte 4: " + pairOfDices.getNumberOfFourRolls() + " gange");
        System.out.println("Du ramte 5: " + pairOfDices.getNumberOfFiveRolls() + " gange");
        System.out.println("Du ramte 6: " + pairOfDices.getNumberOfSixRolls() + " gange");
        System.out.println("Du ramte samme terningskast: " + pairOfDices.getNumberOfSameRolls() + " gange");
        scan.close();
    }
    public void startGame() {
        welcomeToGame();
        Boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste en terning ja/nej");
            String svar = scan.nextLine();
            if (svar.equalsIgnoreCase("Nej")) {
                finished = true;
            } else {
                pairOfDices.rollBothDices();
                System.out.println("Du slog: " + pairOfDices.sumOfDices());
            }
        }
        gameOver();


    }
}

