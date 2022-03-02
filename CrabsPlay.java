package dicegames;

import java.util.Scanner;

public class CrabsPlay {
    private final Die die1;
    private final Die die2;
    private final Scanner scan;
    private boolean playerWon;
    private int rolls;
    private int point;
    private boolean finished = false;

    public CrabsPlay() {
        scan = new Scanner(System.in);
        die1 = new Die();
        die2 = new Die();
    }

    public void welcomeToGame() {
        System.out.println("Hello and welcome to the Crabs game!");
    }

    public void gameOver(boolean playerWon) {
        if (playerWon == true) {
            System.out.println("Congratulations you won");
        } else {
            System.out.println("You've lost");
        }
        finished = true;

    }

        public void takeTurn(){
        die1.roll();
        die2.roll();
        int roll = die1.getFaceValue() + die2.getFaceValue();
        if(rolls == 0){
            if(roll == 7 || roll == 11){
                gameOver(true);
            }else if(roll == 2 || roll == 3 || roll == 12){
                gameOver(false);
            }
            else{
                point = roll;
                rolls++;
            }
        }else{
            if(roll == 7){
                gameOver(false);
            }else if (roll == point){
                gameOver(true);
            }
        }

    }
    public void startGame(){
        welcomeToGame();

        while (!finished){
            System.out.println("Ønsker du at kaste med terningerne?");
            String svar = scan.nextLine();
            if(svar.equalsIgnoreCase("Nej")){
                finished = true;
            }else {
                takeTurn();
                System.out.println("Du slog: " + getSumOfDices());
            }

        }

    }
    public int getSumOfDices(){
        return die1.getFaceValue() + die2.getFaceValue();
    }

}
