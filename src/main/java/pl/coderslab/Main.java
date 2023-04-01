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

    public static void listofUsers() {
        UserDao userDao = new UserDao();
        List<User> list = userDao.findAll();
        System.out.println("ID\tEMAIL\tUSERNAME\tPASSWORD");
        for (User element : list) {
            System.out.println(element);

        }
    }

    public static void createUser(String email, String username, String password) {
        User user = new User()
                .setEmailUser(email)
                .setUserNameUser(username)
                .setPasswordUser(password);

        UserDao userDao = new UserDao();
        try {
            userDao.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateUser(long id, String email, String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.read(id);

        user.setEmailUser(email)
                .setUserNameUser(username)
                .setPasswordUser(password);
        userDao.update(user);
    }
    public static void readUser(String email){
        UserDao userDao = new UserDao();
        User user = userDao.read(email);
        System.out.println(user);

    }
    public static void readUser(long id){
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        System.out.println(user);

    }
    public static void deleteUser(String email){
        UserDao userDao = new UserDao();
        userDao.delete(email);
    }

    public static void main(String[] args) {

        boolean exit = false;
        listofUsers();
        while (!exit) {

            System.out.println("c - Create new User");
            System.out.println("u - update User");
            System.out.println("r - read User");
            System.out.println("d - delete User");
            System.out.println("l - list of Users");
            System.out.println("x - exit");
            String input = userInput();
            switch (input.toLowerCase()) {
                case "c":
                    System.out.println("Creating new User");
                    System.out.println("Email:");
                    String email = userInput();
                    System.out.println("Username:");
                    String username = userInput();
                    System.out.println("Password:");
                    String password = userInput();

                    createUser(email, username, password);
                    listofUsers();
                    break;
                case "u":
                    System.out.println("Updating User");
                    System.out.println("Id of the edited user");
                    long id = Long.parseLong(userInput());
                    System.out.println("Enter new info");
                    System.out.println("Email:");
                    String newEmail = userInput();
                    System.out.println("Username:");
                    String newUsername = userInput();
                    System.out.println("Password:");
                    String newPassword = userInput();
                    updateUser(id, newEmail, newUsername, newPassword);
                    listofUsers();
                    break;
                case "r":
                    System.out.println("Choose option to read ");
                    System.out.println("e - email");
                    System.out.println("i - id");
                    String readOption = userInput();
                    if(readOption.equalsIgnoreCase("e")){
                        System.out.println("Email");
                        String readEmail = userInput();
                        readUser(readEmail);
                    } else if (readOption.equalsIgnoreCase("i")) {
                        System.out.println("Id");
                        long readId = Long.parseLong(userInput());
                        readUser(readId);
                    }else{
                        System.out.println("Error");
                    }
                    break;
                case "d":
                    System.out.println("Delete User");
                    System.out.println("Email");
                    String delete = userInput();
                    deleteUser(delete);

                    listofUsers();
                    break;
                case "l":
                    listofUsers();
                    break;
                case "x":
                    System.out.println("EXIT");
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
}
