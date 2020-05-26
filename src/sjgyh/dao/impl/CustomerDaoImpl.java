package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.CustomerDao;
import sjgyh.domain.Customer;
import sjgyh.util.JDBCUtils;

import java.util.List;

@SuppressWarnings("all")
public class CustomerDaoImpl implements CustomerDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Customer> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT * FROM customer ";
        List<Customer> customers = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));

        return customers;
    }
}
