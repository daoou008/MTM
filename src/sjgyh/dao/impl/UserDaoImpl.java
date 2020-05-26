package sjgyh.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sjgyh.dao.UserDao;
import sjgyh.domain.User;
import sjgyh.util.JDBCUtils;
import sjgyh.util.MD5;


public class UserDaoImpl implements UserDao {
    //使用util工具类，获取数据库连接池
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserNameAndPassword(String username, String password) {
        try {
            String oriPassword = password;
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            password = MD5.enCode(password);
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            if (user != null) {
                user.setPassword(oriPassword);
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
