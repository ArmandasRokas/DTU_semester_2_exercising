package advanced_programming.uge6_threads;

public class TestSpiller {

    public static void main(String[] args) {


        TennisSpiller caroline = new TennisSpiller("Caroline", 3);
        TennisSpiller serena = new TennisSpiller("Serena", 6);

        caroline.setOpponent(serena);
        serena.setOpponent(caroline);
        caroline.modtagBold();

       // caroline.start;
        (new Thread(caroline)).start(); // man behøver ikke new Thread if extends Thread instead of implements Runnable
        (new Thread(serena)).start();

    }

}
