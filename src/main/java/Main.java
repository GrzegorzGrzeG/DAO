import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
//        User user = new User()
//                .setEmail("testowy2@gmail.com")
//                .setUserName("testowanazwa2")
//                .setPassword("testowe");
//        UserDao userDao = new UserDao();
//        try {
//            userDao.createUser(user);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        UserDao userDao = new UserDao();


        userDao.read("abacki@gmail.com");




    }
}
