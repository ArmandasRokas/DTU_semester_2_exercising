package databases.uge2_aflevering1_dao.controller;

import databases.uge2_aflevering1_dao.dal.IUserDAO;
import databases.uge2_aflevering1_dao.dal.UserDAO;
import databases.uge2_aflevering1_dao.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void createUser(String name, List<String> roles){

        UserDTO userDTO = new UserDTO(name, roles);

        try {
            userDAO.createUser(userDTO);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    public List<UserDTO> getUserList(){



        List<UserDTO> users = null;
        try {
            users = userDAO.getUserList();
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void update(){
        UserDTO user = new UserDTO(2, "John");
        List<String> roles = new ArrayList<>();
        roles.add("user");
        user.setRoles(roles);
        try {
            userDAO.updateUser(user);
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }


}
