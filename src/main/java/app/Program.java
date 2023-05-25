package app;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        /*Person p1 = new Person(null, "Adriano Vicente da Silva", "adriano.silva@gmail.com");
        Person p2 = new Person(null, "Gabriel Vicente da Silva", "gabriel.silva@gmail.com");
        Person p3 = new Person(null, "André Vicente da Silva", "andre.silva@gmail.com");*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /*ADICIONANDO NO BANCO
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();*/

        /*RECUPERANDO DO BANCO ATRAVES DO ID*/
        Person p = em.find(Person.class, 2);

        System.out.println(p + " --- will be removed ---");

        /*REMOVENDO DO BANCO*/
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Final!");

        em.close();
        emf.close();
    }
}