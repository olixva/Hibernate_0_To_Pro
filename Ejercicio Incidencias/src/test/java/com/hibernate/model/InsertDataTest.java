package com.hibernate.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.hibernate.HibernateUtil;

public class InsertDataTest {

    private static Faker faker = new Faker();

    @Test
    void test() {
        insertData();

        var session = HibernateUtil.getSessionFactory().openSession();

        session.createQuery("from Tarea", Tarea.class)
                .list()
                .forEach(tecnico -> System.out.println(tecnico.getTecnicos()));
    }

    void insertData() {
        // Especialidades de incidencias
        String[] especialidades = {"Hardware", "Software", "Redes", "Sistemas Operativos", "Otros"};
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<String> telefonos = List.of(faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber());

        for (int i = 0; i < 10; i++) {
            Responsable responsable = new Responsable(
                faker.number().digits(8),
                faker.letterify("????????"),
                faker.name().fullName(),
                faker.number().randomDouble(2, 0, 10),
                faker.lorem().sentence()
            );
            responsable.setTelefonos(telefonos);
            session.persist(responsable);
        }

        List<Responsable> responsables = session.createQuery("from Responsable", Responsable.class).list();

        for (int i = 0; i < 10; i++) {
            var incidencia = new Incidencia(
                faker.number().digits(5),
                convertToLocalDate(faker.date().birthday(11, 20)),
                convertToLocalDate(faker.date().birthday(0, 10)),
                faker.lorem().sentence()
            );
            incidencia.setResponsable(responsables.get(faker.number().numberBetween(0, responsables.size())));
            incidencia.setUsuario(responsables.get(faker.number().numberBetween(0, responsables.size())));
            session.merge(incidencia);
        }
        
        List<Incidencia> inciencias = session.createQuery("from Incidencia", Incidencia.class).list();

        for (int i = 0; i < 10; i++) {
            var tarea = new Tarea(
                inciencias.get(faker.number().numberBetween(0, inciencias.size())),
                faker.number().numberBetween(1, 100),
                faker.lorem().sentence()
            );
            session.merge(tarea);
        }

        List<Tarea> tareas = session.createQuery("from Tarea", Tarea.class).list();

        for (int i = 0; i < 10; i++) {
            Tecnico tecnico = new Tecnico(
                faker.number().digits(8),
                faker.letterify("????????"),
                faker.name().fullName(),
                especialidades[faker.number().numberBetween(0, especialidades.length)],
                convertToLocalDate(faker.date().birthday(13, 16))
            );
            tecnico.setTelefonos(telefonos);
            session.persist(tecnico);
        }

        List<Tecnico> tecnicos = session.createQuery("from Tecnico", Tecnico.class).list();

        // Creamos 3 roles
        for (int i = 0; i < 3; i++) {
            Rol rol = new Rol(
                // Codigo de rol numerico
                faker.numerify("##"),
                faker.lorem().sentence()
            );
            session.persist(rol);
        }

        List<Rol> roles = session.createQuery("from Rol", Rol.class).list();

        // Insertamos 100 trabajos realizados
        for (int i = 0; i < 100; i++) {
            Trabaja trabaja = new Trabaja(
                tecnicos.get(faker.number().numberBetween(0, tecnicos.size())),
                tareas.get(faker.number().numberBetween(0, tareas.size())),
                roles.get(faker.number().numberBetween(0, roles.size())),
                convertToLocalDate(faker.date().birthday(0, 10)),
                faker.lorem().sentence()
            );
            session.merge(trabaja);
        }

        session.getTransaction().commit();
    }

    private LocalDate convertToLocalDate(java.util.Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.of("Europe/Madrid"))
                .toLocalDate();
    }

}
