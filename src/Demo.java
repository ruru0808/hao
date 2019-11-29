import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

    private static String url="jdbc:mysql///bookmanage";
    private static String driverClassName="com.mysql.jdbc.Driver";
    private static String username="root";
    private static String password="root";

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.execute("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
