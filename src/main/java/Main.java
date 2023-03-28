import org.mindrot.jbcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {
        String password = "password";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(password);
        System.out.println(hashed);

        if (BCrypt.checkpw(password,hashed)) {
            System.out.println("OK");
        }
    }
}
