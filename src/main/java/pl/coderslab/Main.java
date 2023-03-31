package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String QUERY = "SELECT * FROM users;";

    private static String userInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            scanner.next();
        }
        String result = scanner.nextLine();

        return result;
    }

    public static void main(String[] args) {
        //Dodawanie nowego użytkownika działa
//        pl.coderslab.entity.User user = new pl.coderslab.entity.User()
//                .setEmailUser("testowy3@gmail.com")
//                .setUserNameUser("testowanazwa3")
//                .setPasswordUser("testowe2");
//
//        pl.coderslab.entity.UserDao userDao = new pl.coderslab.entity.UserDao();
//        try {
//            userDao.createUser(user);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
        //ODCZYT użytkownika działa
//        pl.coderslab.entity.UserDao userDao = new pl.coderslab.entity.UserDao();
//        pl.coderslab.entity.User user = userDao.read("abacki@gmail.com");
//
//        System.out.println(user);

        //usuwanie użytkownika działa
//        pl.coderslab.entity.UserDao userDao = new pl.coderslab.entity.UserDao();
//        userDao.delete("testowy3@gmail.com");

        //Odczyt wszystkich działa
        UserDao userDao = new UserDao();
        List<User> list = userDao.findAll();
        for (User element: list) {
            System.out.println(element);

        }

//Modyfikacja użytkownika
//        pl.coderslab.entity.UserDao userDao = new pl.coderslab.entity.UserDao();
//        pl.coderslab.entity.User user = userDao.read("testowy3@gmail.com");
//        user.setEmailUser("testowy10@gmail.com")
//                .setUserNameUser("testowy10")
//                .setPassword("haselko10");
//        userDao.update(user);

//        pl.coderslab.entity.User user = userDao.read("testowy3@gmail.com");
//        System.out.println(user.toString());

//        try(Connection connection = pl.coderslab.DbUtil.getConnection()){
//            pl.coderslab.DbUtil.printAllData(connection, QUERY);
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//        System.out.println("Enter the email address of the user you want to edit: ");
//        String emailToEdit = userInput();
//        System.out.println("Set new email: ");
//        String newEmail = userInput();
//        System.out.println("Set new username: ");
//        String newUserName = userInput();
//        System.out.println("Set new password: ");
//        String newPassword = userInput();


    }
}
