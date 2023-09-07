package ar.edu.unlu.poo;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {
    private static List<String> diccionario = new ArrayList<>();

    public static void agregarPalabra (String palabra) {
        diccionario.add(palabra.toLowerCase());
    }

    public static void eliminarPalabra (String palabra) {
        diccionario.remove(palabra.toLowerCase());
    }

    public static boolean contiene (String palabra) {
        return diccionario.contains(palabra.toLowerCase());
    }

    public static String buscar (String palabra) {
        String palabraMinuscula = palabra.toLowerCase();
        if (diccionario.contains(palabraMinuscula))
            return diccionario.get(diccionario.indexOf(palabraMinuscula));
        else return null;
    }
}

