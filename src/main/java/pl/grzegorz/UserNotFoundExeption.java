package pl.grzegorz;

public class UserNotFoundExeption extends RuntimeException {
    private static final String ERROR_MSG = "User for given email/id %s not found";


    public UserNotFoundExeption(String email) {
        super(String.format(ERROR_MSG, email));
    }

    public UserNotFoundExeption(long id) {
        super(String.format(ERROR_MSG, id));
    }
}
