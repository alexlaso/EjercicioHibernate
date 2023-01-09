package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos", schema = "nba")
public class Equipos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic
    @Column(name = "Conferencia")
    private String conferencia;
    @Basic
    @Column(name = "Division")
    private String division;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipos that = (Equipos) o;

        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (ciudad != null ? !ciudad.equals(that.ciudad) : that.ciudad != null) return false;
        if (conferencia != null ? !conferencia.equals(that.conferencia) : that.conferencia != null) return false;
        if (division != null ? !division.equals(that.division) : that.division != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (conferencia != null ? conferencia.hashCode() : 0);
        result = 31 * result + (division != null ? division.hashCode() : 0);
        return result;
    }
}
