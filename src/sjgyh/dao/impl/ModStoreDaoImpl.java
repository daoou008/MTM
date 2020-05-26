package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.ModStoreDao;
import sjgyh.domain.ModStore;
import sjgyh.util.JDBCUtils;

import java.util.List;

@SuppressWarnings("all")
public class ModStoreDaoImpl implements ModStoreDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<ModStore> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT MF.id AS function_id, M.type, MF.description, MF.priority, MF.prepass, MS.quantity " +
                "FROM modstore MS " +
                "JOIN modfunction AS MF ON MF.id = MS.function_id " +
                "JOIN module AS M ON M.id = MF.module_id";
        List<ModStore> modStores = template.query(sql, new BeanPropertyRowMapper<ModStore>(ModStore.class));

        return modStores;
    }
}
