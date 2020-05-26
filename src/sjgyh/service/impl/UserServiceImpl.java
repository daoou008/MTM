package sjgyh.service.impl;

import sjgyh.dao.UserDao;
import sjgyh.dao.impl.UserDaoImpl;
import sjgyh.domain.User;
import sjgyh.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(User loginUser) {
       return dao.findUserNameAndPassword(loginUser.getUsername(), loginUser.getPassword());
    }
}
