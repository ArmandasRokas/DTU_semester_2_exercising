package advanced_programming.uge6_threads;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

public class TennisSpiller implements Runnable {

    private String name;
    private TennisSpiller opponent;
    private boolean harBolden;
    private boolean isOn;

//    private CountDownLatch latch;



    public TennisSpiller(String name){
        this.name = name;
        harBolden = false;
        isOn = true;
//        latch = new CountDownLatch(1);
    }

    public void setOpponent(TennisSpiller tennisSpiller){
        this.opponent = tennisSpiller;
    }


    public void modtagBold(){
        harBolden = true;

    }
//    public void latchCountDown(){
//        latch.countDown();
//    }


    @Override
    public void run() {


        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (harBolden){


                    harBolden = false;
                    System.out.println(name + " kaster");

//                    opponent.latchCountDown();
                    opponent.modtagBold();



            }

//            try {
////                latch.await();
//                //       latch = new CountDownLatch(1);
//
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }
    }
}
