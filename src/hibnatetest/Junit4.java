package hibnatetest;

import entity.UserEntity;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit4 {

    private Session session = null;

    @Before
    public void after() {
        if (session == null) session = HibernateSession.getSession();
    }


    @After
    public void before() {
        if (session != null) {
            if (session.isConnected()) {
//                session.getTransaction().commit();
                session.close();
            }
        }
    }


    @Test
    public void addData() {

        session.getTransaction().begin();
        UserEntity user = session.load(UserEntity.class, 2);
        System.out.println(user.getAttentions().size());
        user.getFans().add(new UserEntity());
        session.saveOrUpdate(user);
        session.getTransaction().commit();


    }


}
