package connection;

import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";

    static {
        Properties properties = new Properties();
        try {
//            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("/connection/jdbc.properties"));
//            driver = properties.getProperty("jdbc.driverClassName");
//            url = properties.getProperty("jdbc.url");
//            username = properties.getProperty("jdbc.username");
//            password = properties.getProperty("jdbc.password");

            driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/testjavaweb";
            username = "root";
            password = "root";
            Class.forName(driver);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement statement){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println("连接数据库成功");
    }

}
