package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.ModuleFunctionDao;
import sjgyh.domain.ModFunction;
import sjgyh.domain.Module;
import sjgyh.util.JDBCUtils;

import java.util.List;

@SuppressWarnings("all")
public class ModFunctionDaoImpl implements ModuleFunctionDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ModFunction> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT MF.id AS function_id, MF.name AS function_name, M.type, MF.description, MF.priority, MF.prepass " +
                "FROM modfunction AS MF JOIN module AS M ON MF.module_id = M.id";
        List<ModFunction> modFunctions = template.query(sql, new BeanPropertyRowMapper<ModFunction>(ModFunction.class));

        return modFunctions;
    }
}
