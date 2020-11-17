package jogasa.simarro.actividad13fragments.pojo;

import java.io.Serializable;

public class Cancion implements Serializable {
    private String nomCancion;
    private String duracion;
    private String tipo;


    public Cancion(String nomCancion, String duracion, String tipo) {
        this.nomCancion = nomCancion;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getNomCancion() {
        return nomCancion;
    }

    public void setNomCancion(String nomCancion) {
        this.nomCancion = nomCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nomCancion='" + nomCancion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
