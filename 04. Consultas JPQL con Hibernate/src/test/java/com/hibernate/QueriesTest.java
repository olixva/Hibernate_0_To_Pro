package com.hibernate;

import com.hibernate.HibernateUtil;
import com.hibernate.model.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class QueriesTest {

    @BeforeAll
    public static void setup() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Author author1 = new Author("John", "Doe", LocalDate.of(1990, 1, 1));
        Author author2 = new Author("Calero", "Chapa", LocalDate.of(122, 1, 1));
        Author author3 = new Author("Jose", "Porro", LocalDate.of(1323, 1, 1));

        session.save(author1);
        session.save(author2);
        session.save(author3);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String jpql = "SELECT a FROM Author a";

        Query<Author> query = session.createQuery(jpql, Author.class);
        query.getResultList().forEach(System.out::println);
        session.close();

    }
}
