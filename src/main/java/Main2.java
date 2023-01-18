import entity.Equipos;
import entity.Estadisticas;
import entity.Jugadores;
import jakarta.persistence.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int i=0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        System.out.println("Ejercicio 1");
        mostrarStatsJugador(em);
        System.out.println("Ejercicio 2");
        mostrarEquiposStats(em);
        System.out.println("Ejercicio 3");
        insertarDatos(em);
        System.out.println("Ejercicio 4");
        cambiarEquipo(em);
        System.out.println("Ejercicio 5");
        bestEquipo(em);
    }

    private static void mostrarStatsJugador(EntityManager em){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el código del jugador");
        int codigoJugador = sc.nextInt();
        try {
            Query query = em.createQuery("SELECT s FROM Estadisticas s WHERE s.codigoJugador = " + codigoJugador);
            Query queryAux = em.createQuery("SELECT j FROM Jugadores j WHERE j.codigo = " + codigoJugador);
            List<Estadisticas> listaStats = (List<Estadisticas>) query.getResultList();
            List<Jugadores> listaJugadores = (List<Jugadores>) queryAux.getResultList();
            System.out.println("Estadisticas del jugador con código: "+ codigoJugador);
            for (Jugadores jogador : listaJugadores){
                System.out.println("Nombre del jugador: " + jogador.getNombre()+".\nEquipo del jugador: "+jogador.getNombreEquipo()+".");
            }
            System.out.println("Temporada\tPuntos por partido\tAsistencia por partido\tTapones por partido\tRebotes por partido");
            for (Estadisticas stats: listaStats) {
                System.out.println(stats.getTemporada()+"\t\t"+stats.getPuntosPorPartido()+"\t\t\t\t\t"+stats.getAsistenciasPorPartido()+"\t\t\t\t\t\t"+stats.getTaponesPorPartido()+"\t\t\t\t\t"+stats.getRebotesPorPartido());
            }
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                System.out.println("Debe ser un número");
            }
    }

    private static void mostrarEquiposStats(EntityManager em){
        Query query = em.createQuery("SELECT e FROM Equipos e ORDER BY e.nombre");
        List<Equipos> listaEquipos = query.getResultList();
        System.out.println("Cantidad de equipos: " + listaEquipos.size());
        for (Equipos equipos: listaEquipos){
            System.out.println("Nombre equipo: " + equipos.getNombre());
            Query queryAux = em.createQuery("SELECT j.nombre,e.puntosPorPartido FROM Estadisticas e, Jugadores j WHERE e.codigoJugador = j.codigo AND j.nombreEquipo = '"+equipos.getNombre()+"' GROUP BY j.nombre");
            List<Object[]> listaStats = (List<Object[]>)queryAux.getResultList();
            System.out.println("\tNombre\t\t-\t\tMedia");
            for (Object[] objects: listaStats){
                System.out.println("\t"+objects[0]+"\t-\t"+objects[1]);
            }
        }
    }

    private static void insertarDatos(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNativeQuery("insert into Estadisticas (codigoJugador, temporada, rebotesPorPartido, puntosPorPartido, asistenciasPorPartido, taponesPorPartido) values (123,'05/06',5.0,7.0,0.0,0.0) on duplicate key update temporada='05/06'").executeUpdate();
        em.createNativeQuery("insert into Estadisticas (codigoJugador, temporada, rebotesPorPartido, puntosPorPartido, asistenciasPorPartido, taponesPorPartido) values (123,'06/07',0.0,10.0,0.0,0.0) on duplicate key update temporada='06/07'").executeUpdate();
        transaction.commit();
    }

    private static void cambiarEquipo(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery("update Jugadores j SET j.nombreEquipo='Grizzlies' WHERE j.nombreEquipo='Warriors'").executeUpdate();
        transaction.commit();
    }

    private static void bestEquipo(EntityManager em){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNativeQuery("insert into Equipos(nombre, ciudad, conferencia, division) values ('Edgerunners', 'Night City', 'West', 'Central') on duplicate key update nombre='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values ('2077', 'David Martinez', 'Night City', '5-12', 89, 'C', 'Edgerunners') on duplicate key update codigo='2077'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2078, 'Lucyna Kushinada', 'Night City', '5-14', 70, 'F', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2079, 'Rebecca', 'Night City', '5-2', 62, 'G', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2080, 'Maine', 'Night City', '6-4', 105, 'C-F', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2081, 'Dorio', 'Night City', '6-2', 102, 'C-F', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2082, 'Pilar', 'Night City', '6-6', 80, 'C', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2083, 'Falco', 'Night City', '5-7', 74, 'F', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        em.createNativeQuery("insert into Jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) values (2084, 'Kiwi', 'Night City', '5-11', 70, 'F', 'Edgerunners') on duplicate key update nombreEquipo='Edgerunners'").executeUpdate();
        transaction.commit();
    }
}
