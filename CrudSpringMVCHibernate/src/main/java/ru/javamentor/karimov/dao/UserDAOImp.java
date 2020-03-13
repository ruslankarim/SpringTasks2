package ru.javamentor.karimov.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javamentor.karimov.model.User;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
        return query;
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        User userEntity = sessionFactory.getCurrentSession().get(User.class, user.getId());
        userEntity.setName(user.getName());
        userEntity.setAddress(user.getAddress());
        sessionFactory.close();
    }

    @Override
    public User getUserByID(Long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.close();
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
        session.close();
    }
}
