package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class UsersServiceImpl implements UsersService {

    private final UserDao userDao;

    public UsersServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(Users user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void deleteAllUsers(){
        userDao.deleteAllUsers();
    }

}
