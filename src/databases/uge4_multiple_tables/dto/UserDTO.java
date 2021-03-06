package databases.uge4_multiple_tables.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 4545864587995944260L;
    private int userId;
    private String userName;
    private String ini;
    private List<String> roles;

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String cpr;
    private String password;
    //TODO Add relevant fields

//    public static final int USER= 1;   // in constructor (int role) 296 in Tim courses
//    public static final int OPERATOR = 2;
//    public static final int ADMIN = 3;


    public UserDTO() {
        this.roles = new ArrayList<>();
    }

    public UserDTO(int userId, String name, String cpr ,String password){
        this.userId = userId;
        this.userName = name;
        this.roles = new ArrayList<>();
        this.password = password;
        this.cpr = cpr;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO(String name, List<String> roles){
        this.userName = name;
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getRolesString(){
        String rolesString = "";
        for(int i = 0; i < roles.size(); i++){
            rolesString += roles.get(i);
            if(i<roles.size()-1){
                rolesString += ",";
            }
        }
        return rolesString;
    }

    public void setRolesString(String rolesString){

        String[] rolesArray = rolesString.split(",");
        roles = Arrays.asList(rolesArray);

    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        this.roles.add(role);
    }

    /**
     * @param role
     * @return true if role existed, false if not
     */
    public boolean removeRole(String role) {
        return this.roles.remove(role);
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
    }
}