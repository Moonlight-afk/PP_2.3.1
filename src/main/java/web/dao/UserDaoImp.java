package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.models.Users;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        TypedQuery<Users> query = sessionFactory.getCurrentSession().createSQLQuery("select * from users");
        return query.getResultList();
    }

    @Override
    public void deleteAllUsers() {
        List<Users> users = listUsers();
        for (Users user : users) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
