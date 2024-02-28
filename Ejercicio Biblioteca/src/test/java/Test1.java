import com.ingeniero.HibernateUtil;
import com.ingeniero.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Test1 {
    private static Faker faker = new Faker();
    private static Random random = new Random();

    @Test
    public void consultasRelacionesNM() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        insertAll();

        // Obtenemos las obras de los autores
        session.createQuery("select a from Autor a", Autor.class).getResultList()
                .forEach(autor -> System.out.println(autor.getObras()));
        System.out.println("---------------------------------------------------");
        // Obtenemos los autores de las obras
        session.createQuery("select o from Obra o", Obra.class).getResultList()
                .forEach(obra -> System.out.println(obra.getAutores()));
        System.out.println("---------------------------------------------------");
        // Obtenemos los articulos de los socios
        session.createQuery("select s from Socio s", Socio.class).getResultList()
                .forEach(socio -> System.out.println(socio.getArticulos()));
        System.out.println("---------------------------------------------------");
        // Obtenemos los socios de los articulos
        session.createQuery("select a from Articulo a", Articulo.class).getResultList()
                .forEach(articulo -> System.out.println(articulo.getSocios()));
    }

    @Test
    public void consultaArticulosUlt5Anos(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        insertAll();

        // Articulos que han sido prestados a los socios en los ultimos 5 anos con JPQL
        String jpql =
                """
                    select p from prestar p
                    join Articulo a on p.codArt = a.codArt
                    where p.fechPrest > :fecha
                    order by p.fechPrest
                """;
        session.createQuery(jpql, Prestar.class)
                .setParameter("fecha", LocalDate.now().minusYears(5))
                .getResultList().forEach(System.out::println);

    }

    @Test
    public void consulta(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        insertAll();

        // Dime los autores que tengan mas de 3 CDS y mas de 3 Peliculas ordenados por nombre
        String jpql =
                """
                           select a
                           from Autor a
                           join publica p on a.codAutor = p.codAutor
                           join Obra o on p.codObra = o.codObra
                           group by a.codAutor, a.nombre, a.pais
                           having
                               (select count(c.codObra) from Cd c where c.codObra = o.codObra) > 3
                               and
                               (select count(pe.codObra) from Pelicula pe where pe.codObra = o.codObra) > 3
                           order by a.nombre
                           
                """;

        session.createQuery(jpql, Autor.class).getResultList().forEach(System.out::println);
    }


    @Test
    public void insertAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Obra> obras = new ArrayList<>();

        //Creacion 10 libros
        List<Libro> libros = new ArrayList<>();
        Set<String> codigos = new HashSet<>();
        while (libros.size() < 10) {
            Libro libro = new Libro("LI-" + faker.numerify("####"), faker.book().title(), convertToLocalDate(faker.date().birthday(0, 100)), faker.number().numberBetween(100, 1000));

            if (codigos.add(libro.getCodObra())) {
                session.persist(libro); // Guardamos el libro en la base de datos
                libros.add(libro); // Añadimos el libro a la lista de libros
                obras.add(libro); // Añadimos el libro a la lista de obras
            }
        }

        //Creacion 10 peliculas
        List<Pelicula> peliculas = new ArrayList<>();
        Set<String> codigosPeliculas = new HashSet<>();
        while (peliculas.size() < 10) {
            Pelicula pelicula = new Pelicula("PE-" + faker.numerify("####"), faker.book().title(), convertToLocalDate(faker.date().birthday(0, 100)), faker.number().numberBetween(60, 180));

            if (codigosPeliculas.add(pelicula.getCodObra())) {
                session.persist(pelicula); // Guardamos la pelicula en la base de datos
                peliculas.add(pelicula); // Añadimos la pelicula a la lista de peliculas
                obras.add(pelicula); // Añadimos la pelicula a la lista de obras
            }
        }

        //Creacion 10 CDs
        List<Cd> cds = new ArrayList<>();
        Set<String> codigosCds = new HashSet<>();
        while (cds.size() < 10) {
            Cd cd = new Cd("CD-" + faker.numerify("####"), faker.book().title(), convertToLocalDate(faker.date().birthday(0, 100)), faker.number().numberBetween(10, 20));

            if (codigosCds.add(cd.getCodObra())) {
                session.persist(cd); // Guardamos el cd en la base de datos
                cds.add(cd); // Añadimos el cd a la lista de cds
                obras.add(cd); // Añadimos el cd a la lista de obras
            }
        }

        // Creamos 10 autores
        List<Autor> autores = new ArrayList<>();
        Set<String> codigosAutores = new HashSet<>();
        while (autores.size() < 10) {
            Autor autor = new Autor("AU-" + faker.numerify("####"), faker.book().author(), faker.book().genre());
            if (codigosAutores.add(autor.getCodAutor())) {
                session.persist(autor); // Guardamos el autor en la base de datos
                autores.add(autor); // Añadimos el autor a la lista de autores
            }
        }

        // Creamos 30 publicaciones
        List<Publica> publicaciones = new ArrayList<>();
        Set<String> ids = new HashSet<>();
        while (publicaciones.size() < 300) {
            Autor autorAleatorio = autores.get(random.nextInt(autores.size()));
            Obra obraAleatoria = obras.get(random.nextInt(obras.size()));

            // Comproobamos que no exista la publicacion
            if (ids.add(autorAleatorio.getCodAutor() + obraAleatoria.getCodObra())) {
                Publica publica = new Publica(autorAleatorio, obraAleatoria, Roles.values()[faker.number().numberBetween(0, 6)]);
                publicaciones.add(publica);
                session.persist(publica);
            }
        }

        // Creamos 10 articulos
        List<Articulo> articulos = new ArrayList<>();
        Set<String> codigosArticulos = new HashSet<>();
        while (articulos.size() < 10) {
            Articulo articulo = new Articulo("AR-" + faker.numerify("####"), obras.get(random.nextInt(obras.size())), faker.bool().bool(), faker.lorem().sentence());

            if (codigosArticulos.add(articulo.getCodArt())) {
                session.persist(articulo); // Guardamos el articulo en la base de datos
                articulos.add(articulo); // Añadimos el articulo a la lista de articulos
            }
        }

        // Creamos 10 socios
        List<Socio> socios = new ArrayList<>();
        Set<String> codigosSocios = new HashSet<>();
        while (socios.size() < 10) {
            Socio socio = new Socio("SO-" + faker.numerify("####"), faker.idNumber().valid(), faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(), Arrays.asList(faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone()));

            if (codigosSocios.add(socio.getCodSocio())) {
                session.persist(socio); // Guardamos el socio en la base de datos
                socios.add(socio); // Añadimos el socio a la lista de socios
            }
        }

        // Creamos 10 prestamos de socio a articulo
        List<Prestar> prestamos = new ArrayList<>();
        Set<String> codigosPrestamos = new HashSet<>();
        while (prestamos.size() < 500) {
            Socio socioAleatorio = socios.get(random.nextInt(socios.size()));
            Articulo articuloAleatorio = articulos.get(random.nextInt(articulos.size()));
            LocalDate fechaPrestamo = convertToLocalDate(faker.date().birthday(3, 10));

            // Comprobamos que no exista el prestamo
            if (codigosPrestamos.add(socioAleatorio.getCodSocio() + articuloAleatorio.getCodArt() + fechaPrestamo.toString())) {
                {
                    Prestar prestar = new Prestar(articuloAleatorio, socioAleatorio, fechaPrestamo, convertToLocalDate(faker.date().birthday(2, 3)), convertToLocalDate(faker.date().birthday(0, 1)));
                    prestamos.add(prestar);
                    session.persist(prestar);
                }
            }

        }

        session.getTransaction().commit();
    }

    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
