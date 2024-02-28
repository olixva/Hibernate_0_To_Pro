package com.iescierva;

import com.github.javafaker.Faker;
import com.iescierva.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

public class ProyectosTest {

    private static Faker faker = new Faker();

    @Test
    void insertDataTest() {
        //
    }

    private void insertData() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Random random = new Random();

        // Insertar 10 proyectos
        for (int i = 0; i < 10; i++) {
            Proyecto proyecto = new Proyecto(
                faker.letterify("????"),
                faker.book().title(),
                convertToLocalDate(faker.date().birthday(2,3)),
                convertToLocalDate(faker.date().birthday(0,1)),
                faker.company().name()
            );
            session.persist(proyecto);
        }

        List<Proyecto> proyectos = session.createQuery("select p from Proyecto p", Proyecto.class).getResultList();

        // Insertar 10 departamentos
        for (int i = 0; i < 10; i++) {
            Departamento departamento = new Departamento(
                faker.letterify("????"),
                faker.company().name()
            );
            session.persist(departamento);
        }

        List<Departamento> departamentos = session.createQuery("select d from Departamento d", Departamento.class).getResultList();

        // Insertar 50 administrativos
        for (int i = 0; i < 50; i++) {
            Administrativo administrativo = new Administrativo(
                    faker.number().digits(8),
                    faker.name().fullName(),
                    faker.address().fullAddress(),
                    departamentos.get(random.nextInt(departamentos.size())),
                    faker.job().position()
            );
            session.persist(administrativo);
        }

        List<Administrativo> administrativos = session.createQuery("select a from Administrativo a", Administrativo.class).getResultList();

        // Insertar 50 técnicos
        for (int i = 0; i < 50; i++) {
            Tecnico tecnico = new Tecnico(
                    faker.number().digits(8),
                    faker.name().fullName(),
                    faker.address().fullAddress(),
                    departamentos.get(random.nextInt(departamentos.size())),
                    faker.job().seniority()
            );
            session.persist(tecnico);
        }

        List<Tecnico> tecnicos = session.createQuery("select t from Tecnico t", Tecnico.class).getResultList();

        // Generar datos tabla Trabaja
        for (Tecnico tecnico : tecnicos) {
            for (int i = 0; i < faker.random().nextInt(1,3); i++) {
                Trabaja trabaja = new Trabaja(
                        tecnico,
                        proyectos.get((Integer.valueOf(tecnico.getNumMatricula()) + 3*i) % proyectos.size()),
                        convertToLocalDate(faker.date().birthday(2,3)),
                        convertToLocalDate(faker.date().birthday(0,1))
                );

                session.persist(trabaja);
            }
        }

        session.getTransaction().commit();
    }

    private LocalDate convertToLocalDate(java.util.Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.of("Europe/Madrid"))
                .toLocalDate();
    }
}
