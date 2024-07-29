package hiber.dao;

import hiber.model.User;
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
    public void add(User user) {

        this.sessionFactory.getCurrentSession().save(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {

        TypedQuery<User> query = this.sessionFactory.getCurrentSession().createQuery("from User");

        return query.getResultList();
    }

    @Override
    public List<User> findUsersByCarModelAndSeries(String model, int series) {

        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
        TypedQuery<User> query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", model);
        query.setParameter("series", series);

        return query.getResultList();
    }


}
