package dao;

import model.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VmDaoImpl implements IVmDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Vm> findAllVm(){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM vm ");
        List<Vm> vms = jdbcTemplate.query(sql.toString(), new RowMapper<Vm>() {
            @Nullable
            @Override
            public Vm mapRow(ResultSet rs, int rowNum) throws SQLException {
                Vm vm = new Vm();
                vm.setId(rs.getString("id"));
                vm.setName(rs.getString("name"));
                vm.setApplication(rs.getString("application"));
                vm.setProject(rs.getString("project"));
                return vm;
            }
        });
        return vms;
    }
    @Override
    public Vm findVm(String id){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM vm ");
        sql.append(" WHERE vm.id = '" + id + "'");
        Vm vm = jdbcTemplate.queryForObject(sql.toString(), Vm.class);
        return vm;
    }

}
