package databases.uge4_multiple_tables;


import databases.uge4_multiple_tables.dal.IUserDAO;
import databases.uge4_multiple_tables.dal.UserDAO;
import databases.uge4_multiple_tables.dto.UserDTO;

public class Main {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
//        UserDTO user = new UserDTO(3, "Tom","123456" ,"123");
//        user.addRole("admin");
//        user.addRole("operator");
//        user.setIni("T");
//        try {
//            userDAO.createUser(user);
//        } catch (IUserDAO.DALException e) {
//            e.printStackTrace();
//        }
        try {
            UserDTO user = userDAO.getUser(3);
            System.out.println(user.toString());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }
}
