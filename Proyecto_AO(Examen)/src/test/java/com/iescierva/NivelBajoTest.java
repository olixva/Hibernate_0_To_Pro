package com.iescierva;

import com.iescierva.model.Empleado;
import com.iescierva.model.Tecnico;
import com.iescierva.model.Trabaja;
import jakarta.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NivelBajoTest {

    @Test
    void consulta1JPQL() {
        // Obtener la lista de empleados junto con el nombre del departamento al que pertenecen.

        Session session = HibernateUtil.getSessionFactory().openSession();

        String JPQL = "select e from  Empleado e";

        session.createQuery(JPQL, Empleado.class)
                .getResultList()
                .forEach(empleado -> System.out.println(empleado + " " + empleado.getDepartamento().getNombreDepto()));

        session.close();
    }

    @Test
    void consulta2Criteria() {

    }

    @Test
    void consulta3LengNat() {
        // Obtener el nombre y el número de matrícula de los empleados junto con el código y nombre
        //del proyecto en el que están trabajando actualmente.

        Session session = HibernateUtil.getSessionFactory().openSession();

        String sqlQuery =
                """
                        SELECT e.nombre AS nombre_empleado, e.num_matricula AS num_matricula, 
                        p.cod_proyecto AS cod_proyecto, p.nombre_proyecto AS nombre_proyecto
                        FROM tecnicos t 
                        JOIN empleados e ON t.num_matricula = e.num_matricula
                        JOIN trabaja tr ON t.num_matricula = tr.num_matricula 
                        JOIN proyectos p ON tr.cod_proyecto = p.cod_proyecto ;
                        """;

        List<Object[]> results = session.createNativeQuery(sqlQuery).getResultList();

        for (Object[] result : results) {
            String nombreEmpleado = (String) result[0];
            String numMatricula = (String) result[1];
            String codProyecto = (String) result[2];
            String nombreProyecto = (String) result[3];
            System.out.println("Empleado: " + nombreEmpleado + ", Num. Matrícula: " + numMatricula +
                    ", Código Proyecto: " + codProyecto + ", Nombre Proyecto: " + nombreProyecto);
        }

        session.close();
    }
}
