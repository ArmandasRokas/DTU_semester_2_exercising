package databases.uge2_aflevering1_dao.dal;

import databases.uge2_aflevering1_dao.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO implements IUserDAO {


    private final String url = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?";
    private final String userName= "user=s185144";
    private final String pass = "password=XFfpicTFLy2RzYknRgLMO";

    @Override
    public UserDTO getUser(int userId) throws DALException {
        return null;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {


        List<UserDTO> users = new ArrayList<>();



        try(Connection connection = DriverManager.getConnection( url + userName +"&"+ pass)){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while(resultSet.next()){

                UserDTO userDTO = new UserDTO(resultSet.getInt(1), resultSet.getString(2));

                List<String> rolesList = new ArrayList<>();
                String roles = resultSet.getString(4);
                String[] rolesArray = roles.split(",");
                rolesList = Arrays.asList(rolesArray);
                userDTO.setRoles(rolesList);
                users.add(userDTO);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void createUser(UserDTO user) throws DALException {

        try(Connection connection = DriverManager.getConnection(url + userName +"&"+ pass)){   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO users VALUES(null,?,1,?)");

            pStmt.setString(1 ,user.getUserName());
            pStmt.setString(2 ,user.getRolesString());
            pStmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    /**
     * Updates userName and roles in the database with the values
     * received in UserDTO object, where userID matches.
     */
    @Override
    public void updateUser(UserDTO user) throws DALException {

        try(Connection connection = DriverManager.getConnection( url + userName +"&"+ pass)){

            PreparedStatement pStmt = connection.prepareStatement("UPDATE users SET userName = ?, roles = ? WHERE id = ?");
            pStmt.setString(1, user.getUserName());
            pStmt.setString(2, user.getRolesString());
            pStmt.setInt(3, user.getUserId());
            pStmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *  Set 0 value to 'active' attribute for the user, whose userID matches.
     *  This means that the user is no longer active.
     */

    @Override
    public void deleteUser(int userId) throws DALException {


    }
}
