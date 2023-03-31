package pl.coderslab;

public class UserNotFoundExeption extends RuntimeException {
    private static final String ERROR_MSG = "pl.coderslab.entity.User for given email %s not found";


    public UserNotFoundExeption(String email) {
        super(String.format(ERROR_MSG, email));
    }
}
