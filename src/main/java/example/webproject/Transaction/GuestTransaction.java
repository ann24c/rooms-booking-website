package example.webproject.Transaction;

import example.webproject.Entities.Guest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class GuestTransaction {
    public static Guest getGuestById(Session session, int id){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);
        Root<Guest> rootEntry = cq.from(Guest.class);
        CriteriaQuery<Guest> guestById = cq.select(rootEntry).where(cb.equal(rootEntry.get("guestId"), id));
        Query<Guest> query = session.createQuery(guestById);
        Guest guest = query.getSingleResult();
        return guest;
    }


    public static void addGuest(Session session, String firstName, String lastName, String phoneNumber, String email, String password){
        session.beginTransaction();
        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setPhoneNumber(phoneNumber);
        guest.setEmail(email);
        guest.setPassword(password);
        session.save(guest);
        session.getTransaction().commit();
    }
}
