import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDao {
    private static final String CREATE_QUERY = "INSERT INTO users(email, username, password) VALUES (?, ?, ?);";
    private static final String SELECT_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = ?;";

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
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
                } else {
                    throw new UserCannotBeCreated(user.getEmail(), user.getUserName(), hashed);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User read(String email){
        try (Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL_QUERY)
        ) {
            statement.setString(1,email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    long id = resultSet.getLong("id");
                    String emailReaded = resultSet.getString("email");
                    String userName = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    return new User(id,emailReaded,userName,password);
                }else{
                    throw new UserNotFoundExeption(email);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
