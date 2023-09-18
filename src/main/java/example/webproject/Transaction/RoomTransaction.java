package example.webproject.Transaction;

import example.webproject.Entities.Room;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class RoomTransaction {
    public static Room getRoomById(Session session, int id){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> rootEntry = cq.from(Room.class);
        CriteriaQuery<Room> roomById = cq.select(rootEntry).where(cb.equal(rootEntry.get("roomId"), id));
        Query<Room> query = session.createQuery(roomById);
        Room room = query.getSingleResult();
        return room;
    }

    public static List<Room> getAllRoom(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> rootEntry = cq.from(Room.class);
        CriteriaQuery<Room> roomById = cq.select(rootEntry);
        Query<Room> query = session.createQuery(roomById);
        return query.getResultList();
    }

}
