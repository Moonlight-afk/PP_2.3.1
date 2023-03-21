package web.service;

import web.models.Users;

import java.util.List;

public interface UsersService {
    void add(Users user);
    List<Users> listUsers();
    void deleteAllUsers();
}