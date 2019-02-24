package databases.uge4_multiple_tables.dal;



import databases.uge4_multiple_tables.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {


    private final String url = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?";
    private final String userName= "user=s185144";
    private final String pass = "password=XFfpicTFLy2RzYknRgLMO";

    @Override
    public UserDTO getUser(int userId) throws DALException {

        UserDTO user = null;

       try(Connection connection = DriverManager.getConnection(url + userName + "&" + pass)){

           PreparedStatement pStmt = connection.prepareStatement(
                   "SELECT * FROM users_without_roles WHERE id = ?");

           pStmt.setInt(1, userId);
           ResultSet resultSet = pStmt.executeQuery();
           resultSet.next();

           user = new UserDTO();
           user.setUserId(userId);
           user.setUserName(resultSet.getString(2));
           user.setIni(resultSet.getString(3));
           user.setCpr(resultSet.getString(4));
           user.setPassword(resultSet.getString(5));

           PreparedStatement pStmt1 = connection.prepareStatement(
                   "SELECT role FROM user_roles WHERE user_id = ?");
           pStmt1.setInt(1, userId);
           ResultSet resultSet1 = pStmt1.executeQuery();

           ArrayList<String> roles = new ArrayList<>();

           while(resultSet1.next()){
               roles.add(resultSet1.getString(1));
           }
           user.setRoles(roles);

       } catch (SQLException e){
           e.printStackTrace();
       }


        return user;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {


        List<UserDTO> users = new ArrayList<>();


        return users;
    }

    @Override
    public void createUser(UserDTO user) throws DALException {

        try(Connection connection = DriverManager.getConnection(url + userName +"&"+ pass)){   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO users_without_roles VALUES(?,?,?,?,?,1)");

            pStmt.setInt(1, user.getUserId());
            pStmt.setString(2 ,user.getUserName());
            pStmt.setString(3, user.getIni());
            pStmt.setString(4, user.getCpr());
            pStmt.setString(5, user.getPassword());
            pStmt.executeUpdate();


            PreparedStatement pStmt2 = connection.prepareStatement("INSERT INTO user_roles VALUES(?,?)");
            for(String role: user.getRoles()){
                pStmt2.setInt(1, user.getUserId());
                pStmt2.setString(2, role);
                pStmt2.executeUpdate();
            }


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

    }

    /**
     *  Set 0 value to 'active' attribute for the user, whose userID matches.
     *  This means that the user is no longer active.
     */

    @Override
    public void deleteUser(int userId) throws DALException {


    }

    /**
     *  Set 1 value to 'active' attribute for the user, whose userID matches.
     *  This means that the user is active again.
     */
    @Override
    public void activateUser(int userId) throws DALException {

    }
}
