import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDao {
    public static final String CREATE_QUERY = "INSERT INTO users(email, username, password) VALUES (?, ?, ?);";

    public String hashPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
    //Dodać opcje sprawdzania czy użytkownik o podanym adresie email istnieje
    public User createUser(User user) throws SQLException {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)
        ) {
            String hashed = hashPassword(user.getPassword());
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashed);
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    long generetedId = resultSet.getLong(1);
                    return new User(generetedId, user.getEmail(), user.getUserName(), hashed);
                }else{
                    throw new UserCannotBeCreated(user.getEmail(), user.getUserName(), hashed);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
