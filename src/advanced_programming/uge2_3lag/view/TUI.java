package advanced_programming.uge2_3lag.view;

import advanced_programming.uge2_3lag.functionality.IDance;
import advanced_programming.uge2_3lag.functionality.IFunktionalitet;

import java.util.Scanner;

public class TUI {

    IFunktionalitet funktionalitet;
    IDance dance;

    public TUI(IFunktionalitet funktionalitet, IDance dance){
        this.funktionalitet = funktionalitet;
        this.dance = dance;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write cpr number");
        String cpr = scanner.nextLine();
        double bmi = funktionalitet.getBMI(cpr);
        System.out.println("BMI:" + bmi);
        dance.dance(cpr);
    }

}
