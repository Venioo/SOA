package com.venio.soa;

import com.venio.soa.entity.AppUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AppUser user1 = new AppUser("firstuser");
        session.save(user1);
        AppUser user2 = new AppUser("seconduser");
        session.save(user2);

        List<AppUser> users = session.createQuery("FROM AppUser").list();

        session.close();

        for (AppUser user : users) {
            System.out.println(user.getId() + ". " + user.getLogin());
        }
    }
}