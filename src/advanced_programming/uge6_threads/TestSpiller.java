package advanced_programming.uge6_threads;

public class TestSpiller {

    public static void main(String[] args) {


        TennisSpiller caroline = new TennisSpiller("Caroline");
        TennisSpiller serena = new TennisSpiller("Serena");

        caroline.setOpponent(serena);
        serena.setOpponent(caroline);
        caroline.modtagBold();

        (new Thread(caroline)).start();
        (new Thread(serena)).start();


    }

}
