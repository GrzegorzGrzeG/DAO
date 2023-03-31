package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

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
//        User user = new User()
//                .setEmailUser("testowy6@gmail.com")
//                .setUserNameUser("testowanazwa6")
//                .setPasswordUser("testowe66");
//
//        UserDao userDao = new UserDao();
//        try {
//            userDao.createUser(user);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        //ODCZYT użytkownika działa
//        UserDao userDao = new UserDao();
//        User user = userDao.read("testowy@gmail.com");
//
//        System.out.println(user);

        //usuwanie użytkownika działa
//        UserDao userDao = new UserDao();
//        userDao.delete("testowy3@gmail.com");

        //Odczyt wszystkich działa
//        UserDao userDao = new UserDao();
//        List<User> list = userDao.findAll();
//        for (User element: list) {
//            System.out.println(element);
//
//        }

//Modyfikacja użytkownika dziala
        UserDao userDao = new UserDao();
        User user = userDao.readById(11);

        System.out.println(user);
        user.setEmailUser("testowy10@gmail.com")
                .setUserNameUser("testowy10")
                .setPasswordUser("haselko10");
        userDao.update(user);
        System.out.println(user);

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
