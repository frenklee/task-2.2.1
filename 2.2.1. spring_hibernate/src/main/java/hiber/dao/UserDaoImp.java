package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      Query query=sessionFactory.getCurrentSession().createQuery("from user");
      return query.getResultList();
   }

   @Override
   public User getPerson(Car car) {
      String model = car.getModel();
      int series = car.getSeries();
      String hql = "SELECT e.user "
              +      "FROM Car e "
              +      "LEFT OUTER JOIN User a ON a.car = e.user "
              +       "where (e.series = "  + series + ") "
              +       "AND (e.model = '"  + model + "') ";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      return (User)query;
   }
}
