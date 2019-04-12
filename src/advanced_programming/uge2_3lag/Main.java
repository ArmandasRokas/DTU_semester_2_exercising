package advanced_programming.uge2_3lag;

import advanced_programming.uge2_3lag.data.Data;
import advanced_programming.uge2_3lag.data.IData;
import advanced_programming.uge2_3lag.functionality.*;
import advanced_programming.uge2_3lag.view.TUI;

public class Main {

    public static void main(String[] args) {
        double i = 11.1;

        IData data = new Data();
        IFunktionalitet funktionalitet = new Funktionalitet(data);
        IDance dance = new FancyDance();
        TUI tui = new TUI(funktionalitet, dance);
        tui.run();
    }
}
