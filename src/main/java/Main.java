import entity.Equipos;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int i=0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        System.out.println("Ejercicio 1");
        listarEquipos(em);

        System.out.println("Ejercicio 2");
        filtrarEquipo(em, "West");

        System.out.println("Ejercicio 3");
        obtenerStats(em);

        System.out.println("Ejercicio 4");
        ordenarPuntos(em);


        em.close();
        emf.close();
    }

    @SuppressWarnings("unchecked")
    private static void listarEquipos(EntityManager em) {
        System.out.println("Listado de equipos");
        Query query = em.createQuery("SELECT e FROM Equipos e");
        List<Equipos> listaEquipos = (List<Equipos>) query.getResultList();
        for (Equipos equipos: listaEquipos) {
            System.out.println("Nombre: "+equipos.getNombre()+". Ciudad: "+equipos.getCiudad()+". Conferencia: "+equipos.getConferencia()+". División: "+equipos.getDivision()+".");
        }
    }

    @SuppressWarnings("unchecked")
    private static void filtrarEquipo(EntityManager em, String conferencia){
        System.out.println("Equipos filtrados por conferencia " + conferencia);
        Query query = em.createQuery("SELECT e FROM Equipos e WHERE e.conferencia = 'West'");
        List<Equipos> listaEquipos=(List<Equipos>)query.getResultList();
        for (Equipos equipos : listaEquipos){
            System.out.println("Nombre: "+equipos.getNombre()+". Ciudad: "+equipos.getCiudad()+". División: "+equipos.getDivision()+".");
        }
    }

    @SuppressWarnings("unchecked")
    private static void obtenerStats(EntityManager em){
        Query query = em.createQuery("SELECT j.nombre, j.peso, j.posicion, e.puntosPorPartido, e.taponesPorPartido, e.rebotesPorPartido "
                + "FROM Jugadores j, Estadisticas e WHERE j.codigo = e.codigoJugador");
        List<Object[]> lista = (List<Object[]>)query.getResultList();
        System.out.println("Tamaño de la lista: " +lista.size());
        for (Object[] objects : lista){
            System.out.println("Nombre: " + objects[0] + ", Peso: " + objects[1] + ", Posicion: " + objects[2] + ", Puntos por partido: " + objects[3] + ", Tapones por partido: " + objects[4] + ", Rebotes por partido: " + objects[5]);
        }
    }

     @SuppressWarnings("unchecked")
    private static void ordenarPuntos(EntityManager em){
         System.out.println("Puntos por partido ordenados ascendente");
         Query query = em.createQuery("SELECT e.codigoJugador, e.puntosPorPartido FROM Estadisticas e ORDER BY e.puntosPorPartido ASC");
         List<Object[]> listaOrdenada = query.getResultList();
         for (Object[] object : listaOrdenada){
             System.out.println("Código de jugador: " + object[0]+". Puntos por partido: "+object[1]+".");
         }
     }
}