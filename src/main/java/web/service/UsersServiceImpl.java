package web.service;

import org.springframework.stereotype.Component;
import web.models.Users;

import java.util.ArrayList;
import java.util.List;
@Component
public class UsersServiceImpl implements UsersService {
    private List<Users> users;

    {
        users = new ArrayList<>();
    }
}
