package com.hibernate;

import com.github.javafaker.Faker;
import com.hibernate.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ExamenTest {

    private static Faker faker = new Faker();

    @BeforeAll
    public static void insertData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Mecanicos
        for (int i = 0; i < 10; i++) {
            var mecanico = new Mecanico(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(), faker.number().randomDouble(2, 1000, 2000), "Manana");
            session.persist(mecanico);
        }

        // Propietarios
        for (int i = 0; i < 10; i++) {
            var propietario = new Propietario(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(), faker.phoneNumber().cellPhone());
            session.persist(propietario);
        }

        // Pilotos
        for (int i = 0; i < 10; i++) {
            var piloto = new Piloto(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(), faker.number().digits(8));
            session.persist(piloto);
        }

        // Tipos
        for (int i = 0; i < 10; i++) {
            var tipo = new Tipo(faker.name().name(), faker.number().numberBetween(100, 200), faker.number().numberBetween(10000, 20000));
            session.persist(tipo);
        }

        // Hangares
        for (int i = 0; i < 10; i++) {
            var hangar = new Hangar(faker.number().digits(4), faker.number().numberBetween(10, 20), faker.address().city());
            session.persist(hangar);
        }

        Set<Hangar> hangares = new HashSet<>(session.createQuery("from Hangar", Hangar.class).list());

        // Aviones
        for (int i = 0; i < 10; i++) {
            //var avion = new Avion(faker.number().numberBetween(1, 10), faker.letterify("???-####"), faker.date().birthday(1, 5), faker.date().birthday(2, 10), hangares.)
            //session.persist(avion);
        }


        session.getTransaction().commit();

    }

    @Test
    public void test() {
        System.out.println("Test");
    }
}
