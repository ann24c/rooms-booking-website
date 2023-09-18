package example.webproject;

import example.webproject.Entities.Guest;
import example.webproject.Entities.House;
import example.webproject.Entities.Reservation;
import example.webproject.Entities.Room;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConfig {
    public static Session session;
    static{
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(House.class);
        configuration.addAnnotatedClass(Guest.class);
        configuration.addAnnotatedClass(Reservation.class);

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();
        // Initialize Session Object
        session = sessionFactory.openSession();
    }
}
