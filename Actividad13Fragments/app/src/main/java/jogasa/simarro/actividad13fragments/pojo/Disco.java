package jogasa.simarro.actividad13fragments.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Disco implements Serializable {
    private String nombre;
    private String grupo;
    private ArrayList<Cancion> canciones;

    public Disco(String nombre, String grupo, ArrayList<Cancion> canciones){
        this.nombre=nombre;
        this.grupo=grupo;
        this.canciones=canciones;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
