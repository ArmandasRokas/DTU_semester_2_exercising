package databases.uge2_aflevering1_dao.test;

import databases.uge2_aflevering1_dao.dal.IUserDAO;
import databases.uge2_aflevering1_dao.dal.UserDAO;
import databases.uge2_aflevering1_dao.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp(){
        userDAO = new UserDAO();
    }

    @Test
    void getUserTest() {

        try {
            UserDTO user = userDAO.getUser(1);
            assertEquals("David" , user.getUserName());
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteUserTest(){
        try{
            userDAO.deleteUser(1);
            boolean res = true; // user not exist is true
            for(UserDTO user: userDAO.getUserList()){
                if(user.getUserId() == 1){
                    res = false; // set to false is user appeared in the list
                }
            }

            assertTrue(res);

            userDAO.activateUser(1);
        } catch (IUserDAO.DALException e){
            e.printStackTrace();
        }
    }

    @Test
    void activateUserTest(){
        try{
            userDAO.activateUser(1);
            boolean res = false;  //user not found yet, so it is false
            for(UserDTO user: userDAO.getUserList()){
                if(user.getUserId() == 1){
                    res = true; // user found
                }
            }

            assertTrue(res);

            userDAO.activateUser(1);
        } catch (IUserDAO.DALException e){
            e.printStackTrace();
        }
    }
}