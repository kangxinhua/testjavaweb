package connection;

import java.sql.*;

public class ConnectionTest {

    public static void main(String[] args) {
        Connection connection;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjavaweb";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = " SELECT * FROM vm  ";
            ResultSet rs = statement.executeQuery(sql);
            String id = null;
            String name = null;
            String pro = null;
            String app = null;
            while (rs.next()){
                id = rs.getString("id");
                name = rs.getString("name");
                pro = rs.getString("project");
                app = rs.getString("application");
                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("project = " + pro);
                System.out.println("application = " + app);
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
