package databases.uge1_database_sneak_JDBC;


import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try(Connection connection =
                     DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?"
                    + "user=s185144&password=XFfpicTFLy2RzYknRgLMO")){   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test");
            System.out.println("Got resultset from database:");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) +
                        ": " + resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
