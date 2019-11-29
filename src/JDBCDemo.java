
import org.junit.Test;

import java.sql.*;

/**
        * 前提：
        *  想使用jdbc连接：导入一个jar包
        *              |-----------mysql-connector-java-5.1.47------------|
        *  1.注册驱动
        *  2.通过驱动管理（DrviverManage）获取连接class.forName(url user password)
        *  3.通过连接(connection)对象创建statement(陈述 声明)对象
        *  4.通过statement对象执行SQL语句  execute执行
        *  5.操作结果集对象ResultSet
        *  6.释放资源
        */
public class JDBCDemo {

    private static String url = "jdbc:mysql://localhost:3306/bookmanage";
    private static String driverClassName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";

    @Test
    public void addJdbc(){
        try {
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            statement.execute("insert into dept(id,name,location) values (100,'学术部','深圳')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void delJdbc(){
        try {
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            String sql;
            sql="delete from dept where id=100";
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void editJdbc(){
        try {
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            statement.execute("update dept set location='上海' where id = 33");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void listJdbc(){
        try {
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            String sql;
            sql="select * from dept";
            ResultSet rs = statement.executeQuery(sql);
            int id = 0;
            String name = "";
            String location = "";
            while (rs.next()){
                 id = rs.getInt("id");
                 name = rs.getString("name");
                 location = rs.getString("location");
                System.out.println(id + "   " + name + "   " + location);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
