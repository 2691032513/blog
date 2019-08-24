package dao.implement;

import dao.UserDao;
import entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;


    @Override
    public UserEntity SearchUser(UserEntity user) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class);

        criteria.add(Restrictions.eq("account", user.getAccount()));

        try {
            return (UserEntity) criteria.uniqueResult();
        } catch (Exception e) {
            return null;
        } finally {
            session.getTransaction().commit();
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
