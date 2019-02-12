package databases.uge1_database_sneak_JDBC;

public class CarController {

    private CarDAO carDAO;


    public CarController(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    public void write(String model){
        carDAO.write(model);
    }

    public void read(){
        carDAO.read();
    }

    public String driveWithLastCar(){
        return carDAO.getLastCar().getModel();
    }

    public void buyCar(String model){
        carDAO.addCarToUser(new CarDTO(model));
    }
}
