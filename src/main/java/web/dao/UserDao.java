package web.dao;

import web.models.Users;

import java.util.List;

public interface UserDao {
    void add(Users user);
    List<Users> listUsers();
    void deleteAllUsers();
}
