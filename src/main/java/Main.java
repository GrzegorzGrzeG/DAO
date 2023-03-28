import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        User user = new User()
                .setEmail("testowy@gmail.com")
                .setUserName("testowanazwa")
                .setPassword("testowe");
        UserDao userDao = new UserDao();
        try {
            userDao.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
