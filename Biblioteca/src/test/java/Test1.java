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
    public void CrearBBDD() {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        while (prestamos.size() < 100) {
            Socio socioAleatorio = socios.get(random.nextInt(socios.size()));
            Articulo articuloAleatorio = articulos.get(random.nextInt(articulos.size()));

            // Comprobamos que no exista el prestamo
            if (codigosPrestamos.add(socioAleatorio.getCodSocio() + articuloAleatorio.getCodArt())){
                Prestar prestar = new Prestar(articuloAleatorio, socioAleatorio, convertToLocalDate(faker.date().birthday(0, 100)), convertToLocalDate(faker.date().birthday(0, 100)), convertToLocalDate(faker.date().birthday(0, 100)));
                prestamos.add(prestar);
                session.persist(prestar);
            }
        }

        session.getTransaction().commit();
    }

    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
