package dicegames;

public class PigPlayApp {
    public static void main(String[] args) {
        Pig play = new Pig();
        play.welcomeGame();
        play.setWincondition();
        play.takeTurn();
    }
}
