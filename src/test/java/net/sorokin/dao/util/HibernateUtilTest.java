package net.sorokin.dao.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;

public class HibernateUtilTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp(){
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void SessionFactoryOpenTest(){
        Assert.assertNotNull(sessionFactory);
        Assert.assertTrue(sessionFactory.isOpen());
    }

    @Test
    public void SessionOpenTest(){
        Assert.assertNotNull(session);
        Assert.assertTrue(session.isOpen());
    }

    @Test
    public void SessionConnectedTest(){
        Assert.assertTrue(session.isConnected());
    }

    @Test
    public void SessionCloseTest(){
        session.close();
        Assert.assertFalse(session.isConnected());
    }

    @AfterClass
    public static void after(){
        sessionFactory.close();
    }
}
