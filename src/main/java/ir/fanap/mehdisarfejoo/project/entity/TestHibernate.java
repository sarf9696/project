package ir.fanap.mehdisarfejoo.project.entity;

import ir.fanap.mehdisarfejoo.project.entity.device.SmartPhone;
import ir.fanap.mehdisarfejoo.project.entity.simcard.IrancellSIMCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestHibernate {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mehdifinalproject");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        SmartPhone phone = new SmartPhone();
        phone.setType("smartphone");

        IrancellSIMCard simCard = new IrancellSIMCard();
        simCard.setNumber("9385554444");
        phone.setSimCard(simCard);

        entityManager.persist(phone);

        entityManager.flush();
        entityManager.refresh(phone);
        entityManager.getTransaction().commit();

        entityManager.close();




    }
}
