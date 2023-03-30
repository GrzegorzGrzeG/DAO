import java.sql.*;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void printAllData(Connection connection, String query) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println(id + "\t" + email + "\t" + userName + "\t" + password);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
