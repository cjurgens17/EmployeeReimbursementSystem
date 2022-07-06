

import com.alldaos.UserDAO;
import com.models.User;
import com.utils.ConnectionControl;

import java.nio.channels.SocketChannel;
import java.sql.Connection;

public class Main {
    public static void main(String[] args){

    ConnectionControl.connect();

    UserDAO userDAO = new UserDAO();
    User chris = new User("BigDawg17", "myPassword");
    User mike = new User(3,"TysonFuryMike","anotherPassword");
    //userDAO.create(chris);
   // userDAO.create(mike);
    //userDAO.delete(2);
    //mike.setUsername("BigMike");
    //System.out.println(mike.getUsername());
    //userDAO.update(mike);
        //userDAO.checkLoginInfo("BigMike");
        //userDAO.read(1);
        userDAO.checkLoginInfo("BigMike");





        
    }
}
