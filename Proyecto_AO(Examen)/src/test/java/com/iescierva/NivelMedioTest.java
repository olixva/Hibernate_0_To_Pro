package com.iescierva;

import com.iescierva.model.Proyecto;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Semaphore;

public class NivelMedioTest {

    @Test
    void consulta1JPQL() {
        // Listar los proyectos finalizados y el número total de técnicos que trabajaron en cada uno.

        Session session = HibernateUtil.getSessionFactory().openSession();

        String JPQL = "select p from Proyecto p where p.fechaFin is not null";

        session.createQuery(JPQL, Proyecto.class).getResultList()
                .forEach(
                        proyecto -> System.out.println("Proyecto: " + proyecto + ", Técnicos: " + proyecto.getTecnicos().size())
                );
    }

    @Test
    void consulta2Criteria() {
        //
    }

    @Test
    void consulta3LengNat() {
        // Mostrar el cliente para el cual se han asignado la mayor cantidad de proyectos.

        Session session = HibernateUtil.getSessionFactory().openSession();

        String sqlQuery = """
                SELECT cliente
                FROM (
                    SELECT cliente, COUNT(*) AS cantidad_proyectos
                    FROM proyectos
                    GROUP BY cliente
                    ORDER BY cantidad_proyectos DESC
                ) AS proyectos_contados
                LIMIT 1
                """;

        List<String> results = session.createNativeQuery(sqlQuery).getResultList();

        String clienteMayorProyectos = results.get(0);
        System.out.println("Cliente con mayor cantidad de proyectos asignados: " + clienteMayorProyectos);


        session.close();
    }
}
