package example.webproject.Transaction;

import example.webproject.Entities.House;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseTransation {
    public static House getHouseById(Session session, int id){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<House> cq = cb.createQuery(House.class);
        Root<House> rootEntry = cq.from(House.class);
        CriteriaQuery<House> houseById = cq.select(rootEntry).where(cb.equal(rootEntry.get("houseId"), id));
        Query<House> query = session.createQuery(houseById);
        House house = query.getSingleResult();
        return house;
    }

    public static List<House> getAllHouse(Session session){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<House> cq = cb.createQuery(House.class);
        Root<House> rootEntry = cq.from(House.class);
        CriteriaQuery<House> houseById = cq.select(rootEntry);
        Query<House> query = session.createQuery(houseById);
        return query.getResultList();
    }

}
