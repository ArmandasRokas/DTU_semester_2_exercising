package databases.uge1_database_sneak_JDBC;

import java.sql.*;
import java.util.Scanner;

public class CarDAO {


    public void read(){

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


    public CarDTO getLastCar(){

        CarDTO car = null;

        try(Connection connection =
                    DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?"
                            + "user=s185144&password=XFfpicTFLy2RzYknRgLMO")){   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test WHERE indhold= 'audi'");


            car = new CarDTO(resultSet.getString(2));

        } catch (SQLException e){
            e.printStackTrace();
        }

        return car;

    }

    public void write(String model){

        try(Connection connection =
                        DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?"
                                + "user=s185144&password=XFfpicTFLy2RzYknRgLMO")){   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO test VALUES(1,?)");
            pStmt.setString(1,model);
            pStmt.executeUpdate();


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addCarToUser(CarDTO carDTO){

    }
}
