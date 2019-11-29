import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///bookmanage", "root", "root");
        PreparedStatement ps = con.prepareStatement("select * from dept");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String location = rs.getString("location");
            System.out.println(id + "-" + name + "-" + location);
        }
        if (rs != null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if (con != null){
            con.close();
        }
    }
}
