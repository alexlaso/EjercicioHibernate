package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class EstadisticasPK implements Serializable {
    @Column(name = "Temporada")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String temporada;
    @Column(name = "CodigoJugador")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoJugador;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadisticasPK that = (EstadisticasPK) o;

        if (codigoJugador != that.codigoJugador) return false;
        if (temporada != null ? !temporada.equals(that.temporada) : that.temporada != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = temporada != null ? temporada.hashCode() : 0;
        result = 31 * result + codigoJugador;
        return result;
    }
}
