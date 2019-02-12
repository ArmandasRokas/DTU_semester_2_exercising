package databases.uge1_database_sneak_JDBC;

import java.util.Scanner;

public class TUI {

    private Scanner scanner;// buffer reader
    private CarController carController;


    public TUI(CarController carController){
        scanner = new Scanner(System.in);
        this.carController = carController;
    }

    public void run(){
        carController.read();

        while(true){
            System.out.println("Write input to database or 'exit' for stop program");

            String input = scanner.nextLine();
            if(input.equals("exit")){
                break;
            }
            carController.write(input);

        }
    }

}
