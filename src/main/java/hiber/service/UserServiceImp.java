package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDaoImp UserDaoImp) {
        this.userDao = UserDaoImp;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public List<User> findUsersByCarModelAndSeries(String model, int series) {
        return userDao.findUsersByCarModelAndSeries(model, series);

    }


}
