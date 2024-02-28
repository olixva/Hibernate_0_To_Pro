package com.hibernate.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.hibernate.HibernateUtil;

public class InsertDataTest {

    private static Faker faker = new Faker();
    private static Random random = new Random();

    @Test
    void test() {
        insertData();
    }

    void insertData() {
        var session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        // Generamos 25 localizaciones que seran las padres 0-24
        List<Localizacion> localizacionesPadres = new ArrayList<>();
        Set<String> codigosLocalizaciones = new HashSet<>();
        while (localizacionesPadres.size() < 25) {
            Localizacion localizacion =
                    new Localizacion(faker.letterify("???").toUpperCase() + faker.numerify("###"),
                            faker.address().cityName(), faker.address().streetAddress());

            if (codigosLocalizaciones.add(localizacion.getCodLocalizacion())) {
                localizacionesPadres.add(localizacion);
                session.persist(localizacion);
            }
        }

        // Generamos 25 localizaciones que seran las hijas 25-49
        List<Localizacion> localizacionesHijas = new ArrayList<>();
        while (localizacionesHijas.size() < 25) {
            Localizacion localizacion =
                    new Localizacion(faker.letterify("???").toUpperCase() + faker.numerify("###"),
                            faker.address().cityName(), faker.address().streetAddress(),
                            localizacionesPadres.get(random.nextInt(localizacionesPadres.size())));

            if (codigosLocalizaciones.add(localizacion.getCodLocalizacion())) {
                localizacionesHijas.add(localizacion);
                session.persist(localizacion);
            }
        }

        // Guardamos las 50 localizaciones mezcladas a partir de las 25 padres y 25 hijas
        List<Localizacion> localizaciones = new ArrayList<>();
        localizaciones.addAll(localizacionesPadres);
        localizaciones.addAll(localizacionesHijas);

        // Generamos 50 usuarios normales
        List<Usuario> usuarios = new ArrayList<>();
        Set<String> cod_usuarios = new HashSet<>();
        while (usuarios.size() < 50) {
            Usuario usuario =
                    new Usuario(faker.letterify("????-").toUpperCase() + faker.numerify("####"),
                            faker.name().username(), faker.internet().emailAddress(), faker.internet().emailAddress(),
                            faker.name().firstName(), faker.name().lastName());

            if (cod_usuarios.add(usuario.getCodUsuario())) {
                usuarios.add(usuario);
                session.persist(usuario);
            }
        }

        // Generamos 50 usuarios Tecnicos
        List<Tecnico> tecnicos = new ArrayList<>();
        while (tecnicos.size() < 50) {
            Tecnico tecnico =
                    new Tecnico(faker.letterify("????-").toUpperCase() + faker.numerify("####"),
                            faker.name().username(), faker.internet().emailAddress(), faker.internet().emailAddress(),
                            faker.name().firstName(), faker.name().lastName(), convertToLocalDate(faker.date().birthday(0, 40)),
                            faker.lorem().word());

            if (cod_usuarios.add(tecnico.getCodUsuario())) {
                tecnicos.add(tecnico);
                usuarios.add(tecnico);
                session.persist(tecnico);
            }
        }

        // Generamos 50 usuarios Responsables
        List<Responsable> responsables = new ArrayList<>();
        while (responsables.size() < 50) {
            Responsable responsable =
                    new Responsable(faker.letterify("????-").toUpperCase() + faker.numerify("####"),
                            faker.name().username(), faker.internet().emailAddress(), faker.internet().emailAddress(), faker.name().firstName(),
                            faker.name().lastName(), faker.lorem().sentence(), faker.lorem().word());

            if (cod_usuarios.add(responsable.getCodUsuario())) {
                responsables.add(responsable);
                usuarios.add(responsable);
                session.persist(responsable);
            }
        }

        // Generamos 150 telefonos
        List<Telefono> telefonos = new ArrayList<>();
        Set<String> codigosTelefonos = new HashSet<>();
        while (telefonos.size() < 150) {
            Telefono telefono =
                    new Telefono(faker.letterify("??").toUpperCase() + faker.phoneNumber().extension(),
                            faker.phoneNumber().phoneNumber(), usuarios.get(random.nextInt(usuarios.size())));

            if (codigosTelefonos.add(telefono.getCodTelefono())) {
                telefonos.add(telefono);
                session.persist(telefono);
            }
        }

        // Generamos 50 incidencias
        List<Incidencia> incidencias = new ArrayList<>();
        Set<String> codigosIncidencias = new HashSet<>();
        while (incidencias.size() < 50) {
            Incidencia incidencia =
                    new Incidencia(faker.letterify("??-").toUpperCase() + faker.numerify("####"),
                            convertToLocalDate(faker.date().birthday(3, 5)), convertToLocalDate(faker.date().birthday(0, 3)),
                            faker.lorem().sentence(), usuarios.get(random.nextInt(usuarios.size())),
                            responsables.get(random.nextInt(responsables.size())), localizaciones.get(random.nextInt(localizaciones.size())));

            if (codigosIncidencias.add(incidencia.getCodIncidencia())) {
                incidencias.add(incidencia);
                session.persist(incidencia);
            }
        }

        // Generamos 100 tareas
        List<Tarea> tareas = new ArrayList<>();
        Set<String> codigosTareas = new HashSet<>();
        while (tareas.size() < 100) {
            Tarea tarea =
                    new Tarea(incidencias.get(random.nextInt(incidencias.size())),
                            faker.numerify("TA-####"), faker.lorem().sentence());

            if (codigosTareas.add(tarea.getCodIncidencia() + tarea.getNumOrden())) {
                tareas.add(tarea);
                session.persist(tarea);
            }
        }

        // Generamos 150 participaciones
        List<Participa> participaciones = new ArrayList<>();
        Set<String> codigosParticipaciones = new HashSet<>();
        while (participaciones.size() < 150) {
            Participa participa =
                    new Participa(tecnicos.get(random.nextInt(tecnicos.size())),
                            tareas.get(random.nextInt(tareas.size())),
                            convertToLocalDate(faker.date().birthday(0, 3)),
                            faker.lorem().sentence());

            if (codigosParticipaciones.add(participa.getCodIncidencia() + participa.getNumOrden() + participa.getCodTecnico())) {
                participaciones.add(participa);
                session.persist(participa);
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
