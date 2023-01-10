import entity.Estadisticas;
import entity.Jugadores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int i=0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        System.out.println("Ejercicio 1");
        mostrarStatsJugador(em);
    }

    private static void mostrarStatsJugador(EntityManager em){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el código del jugador");
        int codigoJugador = sc.nextInt();
        Query query = em.createQuery("SELECT s FROM Estadisticas s WHERE s.codigoJugador = "+codigoJugador);
        Query queryAux = em.createQuery("SELECT j FROM Jugadores j WHERE j.codigo = "+codigoJugador);
        List<Estadisticas> listaStats = (List<Estadisticas>) query.getResultList();
        List<Jugadores> listaJugadores = (List<Jugadores>) query.getResultList();
        System.out.println("Estadisticas del jugador con código: "+ codigoJugador);
        for (Jugadores jogador : listaJugadores){
            System.out.println("Nombre del jugador: " + jogador.getNombre()+".\nEquipo del jugador: "+jogador.getNombreEquipo());
        }
        for (Estadisticas stats: listaStats) {
            System.out.println("Temporada: "+stats.getTemporada()+", Puntos por partido: "+stats.getPuntosPorPartido()+", Asistencias por partido: "+stats.getAsistenciasPorPartido()+", Tapones por partido: "+stats.getTaponesPorPartido()+", Rebotes por partido: "+stats.getRebotesPorPartido());
        }
    }
}
