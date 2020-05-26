package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.CusModFunctionDao;
import sjgyh.domain.CusModFunction;
import sjgyh.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class CusModFunctionDaoImpl implements CusModFunctionDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<CusModFunction> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT MF.id AS function_id, C.name, M.type, MF.description, MF.priority, MF.prepass, " +
                "(SELECT SUM(temp.quantity) " +
                "FROM (SELECT MS2.quantity, MF2.priority, MF2.module_id FROM modstore AS MS2 LEFT JOIN modfunction AS MF2 ON MS2.function_id = MF2.id) AS temp " +
                "WHERE MF.priority > temp.priority AND M.id = temp.module_id) AS alternative " +
                "FROM cusmodfunction AS CMF JOIN customer C ON c.id = CMF.customer_id " +
                "JOIN modfunction AS MF ON CMF.function_id = MF.id " +
                "JOIN module AS M ON MF.module_id = M.id";
        List<CusModFunction> cusModFunctions = template.query(sql, new BeanPropertyRowMapper<CusModFunction>(CusModFunction.class));

        return cusModFunctions;
    }

    @Override
    public int findTotalCount(String cusName) {
        String sql = "SELECT COUNT(*) FROM cusmodfunction AS CMF LEFT JOIN customer AS C ON CMF.customer_id = C.id WHERE 1 = 1 ";
        List<Object> pars = new ArrayList<Object>();

        if (null != cusName && !"".equals(cusName)) {
            StringBuilder sb = new StringBuilder(sql);
            sb.append(" AND C.name like ? ");
            sql = sb.toString();
            pars.add("%" + cusName + "%");
        }
        return template.queryForObject(sql, Integer.class, pars.toArray());
    }

    @Override
    public List<CusModFunction> findCMFByPageRow(int currentPage, int row, String cusName) {
        String sql = "SELECT MF.id AS function_id, C.name, M.type, MF.description, MF.priority, MF.prepass, " +
                "(SELECT SUM(temp.quantity) " +
                "FROM (SELECT MS2.quantity, MF2.priority, MF2.module_id FROM modstore AS MS2 LEFT JOIN modfunction AS MF2 ON MS2.function_id = MF2.id) AS temp " +
                "WHERE MF.priority > temp.priority AND M.id = temp.module_id) AS alternative " +
                "FROM cusmodfunction AS CMF JOIN customer C ON c.id = CMF.customer_id " +
                "JOIN modfunction AS MF ON CMF.function_id = MF.id " +
                "JOIN module AS M ON MF.module_id = M.id " +
                "WHERE 1=1 ";

        List<Object> pars = new ArrayList<Object>();
        StringBuilder sb = new StringBuilder(sql);

        if (null != cusName && !"".equals(cusName)) {
            sb.append(" AND C.name like ? ");
            pars.add("%" + cusName + "%");
        }
        sb.append(" LIMIT ?, ? ");
        sql = sb.toString();
        pars.add(currentPage);
        pars.add(row);

        return template.query(sql, new BeanPropertyRowMapper<CusModFunction>(CusModFunction.class), pars.toArray());
    }
}
