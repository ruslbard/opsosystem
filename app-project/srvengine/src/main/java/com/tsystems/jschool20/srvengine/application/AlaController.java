package com.tsystems.jschool20.srvengine.application;

import com.tsystems.jschool20.srvengine.entites.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by ruslbard on 28.03.2017.
 */
public class AlaController {

    private SessionFactory sessionFactory;

    public void setUp() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void tearDown() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    protected void insertTariff() {

        Session session;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new Tariff("Test tarif", 555.32));
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
