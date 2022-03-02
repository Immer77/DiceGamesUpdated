package dicegames;

import java.util.Scanner;

/**
 * This class models one pair of dices.
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;
    /**
     * The second die in the pair.
     */
    private Die die2;

    /**
     * Added Attraibute to calculate number of throws:
     */
    private int numberOfRolls;
    /**
     * Constructor for objects of class PairOfDices
     */

    /**
     * Number of 6's
     */
    private int numberOfSixRolls;
    private int numberOfFiveRolls;
    private int numberOfFourRolls;
    private int numberOfThreeRolls;
    private int numberOfTwoRolls;
    private int numberOfOneRolls;
    private int numberOfSameRolls;
    private int highestFaceSum;
    private Scanner scan = new Scanner(System.in);

    // TODO: put the constructior here!
    public PairOfDices() {
        die1 = new Die();
        die2 = new Die();

    }

    // Parameter i PairofDices så den tager 2 sides input
    public PairOfDices(int sides1, int sides2) {
        die1 = new Die(sides1);
        die2 = new Die(sides2);
    }

    public void rollBothDices() {
        die1.roll();
        die2.roll();
        numberOfRolls += 2;
        //Nedenstående må kunne gøres bedre
        if (die1.getFaceValue() == 6) {
            numberOfSixRolls++;
        }
        if (die2.getFaceValue() == 6) {
            numberOfSixRolls++;
        }
        if (die1.getFaceValue() == 5) {
            numberOfFiveRolls++;
        }
        if (die2.getFaceValue() == 5) {
            numberOfFiveRolls++;
        }
        if (die1.getFaceValue() == 4) {
            numberOfFourRolls++;
        }
        if (die2.getFaceValue() == 4) {
            numberOfFourRolls++;
        }
        if (die1.getFaceValue() == 3) {
            numberOfThreeRolls++;
        }
        if (die2.getFaceValue() == 3) {
            numberOfThreeRolls++;
        }
        if (die1.getFaceValue() == 2) {
            numberOfTwoRolls++;
        }
        if (die2.getFaceValue() == 2) {
            numberOfTwoRolls++;
        }
        if (die1.getFaceValue() == 1) {
            numberOfOneRolls++;
        }
        if (die2.getFaceValue() == 1) {
            numberOfOneRolls++;
        }

        if (die1.getFaceValue() == die2.getFaceValue()) {
            numberOfSameRolls++;
        }
        if (sumOfDices() > highestFaceSum) {
            highestFaceSum = sumOfDices();
        }

    }

    public int sumOfDices() {
        int result = die1.getFaceValue() + die2.getFaceValue();
        return result;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public int getNumberOfSixRolls() {
        return numberOfSixRolls;
    }

    public int getNumberOfFiveRolls() {
        return numberOfFiveRolls;
    }

    public int getNumberOfFourRolls() {
        return numberOfFourRolls;
    }

    public int getNumberOfThreeRolls() {
        return numberOfThreeRolls;
    }

    public int getNumberOfTwoRolls() {
        return numberOfTwoRolls;
    }

    public int getNumberOfOneRolls() {
        return numberOfOneRolls;
    }

    public int getNumberOfSameRolls() {
        return numberOfSameRolls;
    }

    public void resetPairOfDice() {
        numberOfSixRolls = 0;
        numberOfFiveRolls = 0;
        numberOfFourRolls = 0;
        numberOfThreeRolls = 0;
        numberOfTwoRolls = 0;
        numberOfOneRolls = 0;
        numberOfSameRolls = 0;
    }



}
