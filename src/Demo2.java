import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {
    public static void main(String[] args) {

        //类名  的  类  的  获取类加载器  的  通过流获取资源  （文件名）
        InputStream resourceAsStream = Demo2.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driverClassName = p.getProperty("DriverClassName");
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user");
            int id = 0;
            String susername = "";
            String spassword = "";

            while (resultSet.next()){
                id = resultSet.getInt("id");
                susername = resultSet.getString("username");
                spassword = resultSet.getString("password");
                System.out.println(id + "   " + susername + "   " + spassword);
            }

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
