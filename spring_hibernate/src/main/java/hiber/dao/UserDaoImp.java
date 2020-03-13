package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private CarDao carDao;

   @Override
   public void add(User user) {
      Session session = sessionFactory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      session.save(user);
      transaction.commit();
      session.close();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(Long id) {
      Session session = sessionFactory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      Car car = carDao.getCarById(id);
      User user = (User) session.createQuery("from User u where u.car = :car")
              .setParameter("car", car).list().get(0);
      transaction.commit();
      session.close();
      return user;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      Session session = sessionFactory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      List<User> users = session.createQuery("from User").getResultList();
      transaction.commit();
      session.close();
      return users;
   }
}
