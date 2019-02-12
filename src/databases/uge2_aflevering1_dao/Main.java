package databases.uge2_aflevering1_dao;

import databases.uge2_aflevering1_dao.controller.UserController;
import databases.uge2_aflevering1_dao.dal.UserDAO;
import databases.uge2_aflevering1_dao.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        UserController userController = new UserController(userDAO);
        userController.update();

        for(UserDTO user: userController.getUserList()){
            System.out.println(user.getUserId() + " " + user.getUserName()+ " " + user.getRolesString());
        }

//        List<String> roles = new ArrayList<>();
//        roles.add("user");
//        roles.add("admin");
//        userController.createUser("David", roles);

    }
}
