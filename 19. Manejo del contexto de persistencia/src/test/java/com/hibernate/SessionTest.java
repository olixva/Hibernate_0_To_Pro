package com.hibernate;

import com.hibernate.model.Address;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class SessionTest {

    @Test
    void refreshTest() { // Para deshacer cambios de un objeto que se ha modificado después de haber sido persistido

        var session = HibernateUtil.getSessionFactory().openSession();

        var address = new Address("street1", "city1", "country1");

        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
//
//        session.close();
//
//        session = HibernateUtil.getSessionFactory().openSession();

        // cambios
        address.setCity("ciudad cambiada");
        address.setCountry("otro sitio");
        // deshacer cambios
        session.refresh(address);

        System.out.println(address);
    }

    @Test
    void getVsGetReference() {
        insertData();
        var session = HibernateUtil.getSessionFactory().openSession();


        // get() - realiza la consulta inmediatamente
//        var address1 = session.get(Address.class, 1L);
//        System.out.println("======");
//        System.out.println(address1.getCountry());

        // getReference() - difiere la consulta para el momento en el que se utiliza, por ejemplo getCountry()
        var address1 = session.getReference(Address.class, 1L);
        System.out.println("======");
        System.out.println(address1.getCountry());
    }

    @Test
    void load() { // Para cargar en memoria el objeto si esta en transient pero existe en la base de datos
        insertData();
        Session session = HibernateUtil.getSessionFactory().openSession();
        var address = new Address("prueba", "prueba", "prueba"); // transient
        System.out.println(session.contains(address)); // false

        session.load(address, 1L); // persistent

        System.out.println(address);
        System.out.println(session.contains(address)); // true
    }

    //por aqui
    @Test
    void evict() {
        insertData();
        Session session = HibernateUtil.getSessionFactory().openSession();

        var address = session.get(Address.class, 1L);
        System.out.println(session.contains(address)); // true

        session.evict(address); // Para eliminarlo de la memoria, se convierte en detached
//        session.detach(address); // Igual que evict, es lo contrario a load

        System.out.println(address);
        System.out.println(session.contains(address)); // false

    }

    @Test
    void isDirty() { // Para saber si un objeto ha sido modificado (tiene cambios)
        insertData();
        Session session = HibernateUtil.getSessionFactory().openSession();
        var address = session.get(Address.class, 1L);
        System.out.println(session.contains(address)); // true

        System.out.println(session.isDirty()); // false

        address.setCountry("otro sitio");

        System.out.println(session.isDirty()); // true porque se ha modificado
        session.beginTransaction();
        session.persist(address);
        System.out.println(session.isDirty()); // true porque no se ha hecho commit

        session.getTransaction().commit();
        System.out.println(session.isDirty()); // false
    }

    @Test
    void byId() { // Alternativa a find()
        insertData();
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.byId(Address.class)
                .loadOptional(9999L)
                .ifPresent(a -> System.out.println(a.getCountry()));

        session.byId(Address.class)
                .loadOptional(1L)
                .ifPresent(System.out::println);

    }

    void insertData() {
        var session = HibernateUtil.getSessionFactory().openSession();

        var address1 = new Address("street1", "city1", "country1");
        session.beginTransaction();
        session.persist(address1);
        session.getTransaction().commit();

    }

}