package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estadisticas", schema = "nba")
public class Estadisticas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Temporada")
    private String temporada;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CodigoJugador")
    private int codigoJugador;
    @Basic
    @Column(name = "PuntosPorPartido")
    private Double puntosPorPartido;
    @Basic
    @Column(name = "AsistenciasPorPartido")
    private Double asistenciasPorPartido;
    @Basic
    @Column(name = "TaponesPorPartido")
    private Double taponesPorPartido;
    @Basic
    @Column(name = "RebotesPorPartido")
    private Double rebotesPorPartido;

    public Estadisticas() {

    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public int getCodigoJugador() {
        return codigoJugador;
    }

    public void setCodigoJugador(int codigoJugador) {
        this.codigoJugador = codigoJugador;
    }

    public Double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(Double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    public Double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(Double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    public Double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(Double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    public Double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(Double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadisticas that = (Estadisticas) o;

        if (codigoJugador != that.codigoJugador) return false;
        if (temporada != null ? !temporada.equals(that.temporada) : that.temporada != null) return false;
        if (puntosPorPartido != null ? !puntosPorPartido.equals(that.puntosPorPartido) : that.puntosPorPartido != null)
            return false;
        if (asistenciasPorPartido != null ? !asistenciasPorPartido.equals(that.asistenciasPorPartido) : that.asistenciasPorPartido != null)
            return false;
        if (taponesPorPartido != null ? !taponesPorPartido.equals(that.taponesPorPartido) : that.taponesPorPartido != null)
            return false;
        if (rebotesPorPartido != null ? !rebotesPorPartido.equals(that.rebotesPorPartido) : that.rebotesPorPartido != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = temporada != null ? temporada.hashCode() : 0;
        result = 31 * result + codigoJugador;
        result = 31 * result + (puntosPorPartido != null ? puntosPorPartido.hashCode() : 0);
        result = 31 * result + (asistenciasPorPartido != null ? asistenciasPorPartido.hashCode() : 0);
        result = 31 * result + (taponesPorPartido != null ? taponesPorPartido.hashCode() : 0);
        result = 31 * result + (rebotesPorPartido != null ? rebotesPorPartido.hashCode() : 0);
        return result;
    }

    public Estadisticas(String temporada, int codigoJugador, Double puntosPorPartido, Double asistenciasPorPartido, Double taponesPorPartido, Double rebotesPorPartido) {
        this.temporada = temporada;
        this.codigoJugador = codigoJugador;
        this.puntosPorPartido = puntosPorPartido;
        this.asistenciasPorPartido = asistenciasPorPartido;
        this.taponesPorPartido = taponesPorPartido;
        this.rebotesPorPartido = rebotesPorPartido;
    }
}
