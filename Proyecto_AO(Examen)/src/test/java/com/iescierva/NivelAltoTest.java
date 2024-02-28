package com.iescierva;

import com.iescierva.model.Departamento;
import com.iescierva.model.Proyecto;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class NivelAltoTest {

    @Test
    void consulta1JPQL() {
        // Encontrar los departamentos que tienen más de 8 empleados

        Session session = HibernateUtil.getSessionFactory().openSession();

        String JPQL = "select d from Departamento d where size(d.empleados) > 8";

        session.createQuery(JPQL, Departamento.class).getResultList()
                .forEach(System.out::println);
    }

    @Test
    void consulta2Criteria() {
        //
    }

    @Test
    void consulta3LengNat() {
        // Listar los proyectos que tienen una duración superior a la duración promedio de todos los proyectos.
        // El campo duracion no existe, solo tenemos la fecha de inicio y fin del proyecto.

        Session session = HibernateUtil.getSessionFactory().openSession();

        String sqlQuery = """
                SELECT *
                FROM proyectos
                WHERE fecha_fin - fecha_inicio > (
                    SELECT AVG(fecha_fin - fecha_inicio)
                    FROM proyectos
                )
                """;

        session.createNativeQuery(sqlQuery, Proyecto.class).getResultList()
                .forEach(System.out::println);
    }
}
