package test.entityjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestCase {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager manager =  factory.createEntityManager();
        EntityTransaction tran = manager.getTransaction();
        tran.begin();
        JesonTest ower = new JesonTest();
        ower.setUserid(1);
        ower.setPassword("exigen");
        ower.setName("wpeng_8g");
        manager.persist(ower);
        tran.commit();
        System.out.println(ower.getName());
    }

}