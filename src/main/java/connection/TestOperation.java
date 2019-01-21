package connection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestOperation {

    @Test
    public void insertVm(){
        Connection conn = JdbcUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO vm(id, NAME, project, application) VALUES(?,?,?,?)");
            ps.setString(1, "007");
            ps.setString(2,"CP-aaa-bbb-06");
            ps.setString(3, "项目a");
            ps.setString(4, "系统b");
            ps.executeUpdate();
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateVm(){
        Connection conn = JdbcUtils.getConnection();
        String sql = "UPDATE vm SET vm.name = ? WHERE vm.id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"CP-aaa-bbb-07" );
            ps.setString(2, "007");
            ps.executeUpdate();
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteVm(){
        Connection conn = JdbcUtils.getConnection();
        String sql = "DELETE FROM vm WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "007");
            ps.executeUpdate();
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryVms(){
        Connection conn =  JdbcUtils.getConnection();
        String sql = " SELECT * FROM vm ";
        try {
            PreparedStatement  ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
            JdbcUtils.close(rs);
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void queryVm(){
        Connection conn =  JdbcUtils.getConnection();
        String sql = " SELECT * FROM vm WHERE vm.id = '001'";
        try {
            PreparedStatement  ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
            JdbcUtils.close(rs);
            JdbcUtils.close(ps);
            JdbcUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
