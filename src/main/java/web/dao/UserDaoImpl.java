package web.dao;

import web.models.Users;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;


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
        TypedQuery<Users> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void deleteAllUsers() {
        List<Users> users = listUsers();
        for (Users user : users) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public Users findOwner(String car_name, int car_series) {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from User u,Car c where u.car.id = c.id and c.model = :car_name and " +
                "c.series = :car_series");
        return (Users) query.setParameter("car_name",car_name).setParameter("car_series",car_series).getSingleResult();
    }
}
