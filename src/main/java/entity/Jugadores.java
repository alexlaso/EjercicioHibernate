package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores", schema = "nba")
public class Jugadores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Codigo")
    private int codigo;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Procedencia")
    private String procedencia;
    @Basic
    @Column(name = "Altura")
    private String altura;
    @Basic
    @Column(name = "Peso")
    private Integer peso;
    @Basic
    @Column(name = "Posicion")
    private String posicion;
    @Basic
    @Column(name = "NombreEquipo")
    private String nombreEquipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugadores that = (Jugadores) o;

        if (codigo != that.codigo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (procedencia != null ? !procedencia.equals(that.procedencia) : that.procedencia != null) return false;
        if (altura != null ? !altura.equals(that.altura) : that.altura != null) return false;
        if (peso != null ? !peso.equals(that.peso) : that.peso != null) return false;
        if (posicion != null ? !posicion.equals(that.posicion) : that.posicion != null) return false;
        if (nombreEquipo != null ? !nombreEquipo.equals(that.nombreEquipo) : that.nombreEquipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (procedencia != null ? procedencia.hashCode() : 0);
        result = 31 * result + (altura != null ? altura.hashCode() : 0);
        result = 31 * result + (peso != null ? peso.hashCode() : 0);
        result = 31 * result + (posicion != null ? posicion.hashCode() : 0);
        result = 31 * result + (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
        return result;
    }
}
