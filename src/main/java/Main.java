import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int i=0;
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();

        String busqueda="SELECT  i.nombre,i.peso, i.posicion, e.puntosPorPartido,e.asistenciasPorPartido,e.taponesPorPartido,e.rebotesPorPartido FROM Jugadores i, Estadisticas e WHERE i.codigo=e.codigoJugador";

        Query query= entityManager.createQuery(busqueda);
        List<Object[]> listaBusqueda=query.getResultList();
        System.out.println("Nombre Posicion Altura PuntosPorPartido AsistenciasPorPartido TaponesPorPartido RebotesPorPartido");
        for (Object[] e: listaBusqueda){
            String resultado= Arrays.toString(listaBusqueda.get(i));

            System.out.println(resultado);
            i++;
        }

        entityManager.close();
        entityManagerFactory.close();
    }
    }

