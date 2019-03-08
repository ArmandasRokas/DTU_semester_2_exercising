package advanced_programming.uge2_ingrediens;

import advanced_programming.uge2_ingrediens.data.DemoData;
import advanced_programming.uge2_ingrediens.data.IData;
import advanced_programming.uge2_ingrediens.ui.IUI;
import advanced_programming.uge2_ingrediens.ui.TUI;

public class Main {
    public static void main(String[]  args) {
        IData data = new DemoData();
        IUI ui = new TUI(data);
        while (true){
            ui.showMenu();
        }
    }
}
