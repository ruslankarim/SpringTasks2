package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
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
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.close();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(Long id) {
      Car car = carDao.getCarById(id);
      User user = (User) sessionFactory.getCurrentSession()
              .createQuery("from User u where u.car = :car")
              .setParameter("car", car).list().get(0);
      sessionFactory.close();
      return user;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      sessionFactory.close();
      return query.getResultList();
   }
}
