package example.webproject.Transaction;

import example.webproject.Entities.PaidStatus;
import example.webproject.Entities.Reservation;
import example.webproject.Entities.ReservationStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ReservationTransaction {
    public static Reservation getReservationById(Session session, int id){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
        Root<Reservation> rootEntry = cq.from(Reservation.class);
        CriteriaQuery<Reservation> reservationById = cq.select(rootEntry).where(cb.equal(rootEntry.get("reservationId"), id));
        Query<Reservation> query = session.createQuery(reservationById);
        Reservation reservation = query.getSingleResult();
        return reservation;
    }

    public static List<Reservation> getAllGuestReservations(Session session, int guestId){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
        Root<Reservation> rootEntry = cq.from(Reservation.class);
        CriteriaQuery<Reservation> reservationById = cq.select(rootEntry).where(cb.equal(rootEntry.get("guestId"), guestId));
        Query<Reservation> query = session.createQuery(reservationById);
        return query.getResultList();
    }

    public static void addReservation(Session session, String arrival, String departure, int guestId, int roomId){
        session.beginTransaction();
        Reservation res = new Reservation();
        res.setArrival(Date.valueOf(arrival));
        res.setDeparture(Date.valueOf(departure));
        res.setGuest(GuestTransaction.getGuestById(session,guestId));
        res.setRoom(RoomTransaction.getRoomById(session, roomId));
        res.setPaid(PaidStatus.NONE);
        res.setStatus(ReservationStatus.WAITING);
        session.save(res);
        session.getTransaction().commit();
    }

    public static void cancelReservation(Session session, int id){
        session.beginTransaction();
        Reservation reservation = getReservationById(session, id);
        session.evict(reservation);
        reservation.setStatus(ReservationStatus.CANCELLED);
        session.merge(reservation);
        session.getTransaction().commit();
    }

}
