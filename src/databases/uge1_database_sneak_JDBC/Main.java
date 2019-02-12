package databases.uge1_database_sneak_JDBC;


import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarDAO carDAO = new CarDAO();
        CarController carController = new CarController(carDAO);
        TUI tui = new TUI(carController);
        tui.run();

    }
}
