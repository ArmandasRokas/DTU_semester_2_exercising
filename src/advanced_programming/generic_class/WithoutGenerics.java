package advanced_programming.generic_class;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithoutGenerics {
    public static void main(String args[]){

        List users = new ArrayList();
        users.add("User");
        users.add(new Date(1));

        String user = (String) users.get(0);
        System.out.println(user);
        String user2 = (String) users.get(1);

    }
}
