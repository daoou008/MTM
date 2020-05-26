package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.ModuleDao;
import sjgyh.domain.Module;
import sjgyh.util.JDBCUtils;

import java.util.List;

@SuppressWarnings("all")
public class ModuleDaoImpl implements ModuleDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Module> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT * FROM module ";
        List<Module> modules = template.query(sql, new BeanPropertyRowMapper<Module>(Module.class));

        return modules;
    }
}
