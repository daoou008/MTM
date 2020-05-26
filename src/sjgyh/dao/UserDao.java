package sjgyh.dao;

import sjgyh.domain.User;

/**
 * 用户信息Dao
 */
public interface UserDao {
     /**
     * 根据用户名密码查找用户
     * @param username
     * @param password
     * @return
     */
    public User findUserNameAndPassword(String username, String password);
}
