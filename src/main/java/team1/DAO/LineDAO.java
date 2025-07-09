package team1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team1.entities.Line;
import team1.exceptions.NotFoundException;

public class LineDAO {

    private final EntityManager entityManager;

    public LineDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Line newline){
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newline);
        transaction.commit();
        System.out.println("The line has been saved");

    }
    public Line findById(long id) {
        Line found = entityManager.find(Line.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
