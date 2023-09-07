package ar.edu.unlu.poo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private Integer puntajeTotal = 0;
    private List<Palabra> listaDePalabras = new ArrayList<>();

    public Jugador (String nombre) {
        setNombre(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPuntajeTotal () {
        return puntajeTotal;
    }

    public boolean crearPalabra (String palabra) {
        String palabraMinuscula = palabra.toLowerCase();
        if (Diccionario.contiene(palabraMinuscula)) {
            Palabra nuevaPalabra = new Palabra(palabraMinuscula);
            listaDePalabras.add(nuevaPalabra);
            puntajeTotal += nuevaPalabra.getPuntaje();
            return true;
        } else return false;
    }

    public List<Palabra> getListaDePalabras () {
        return listaDePalabras;
    }
}
