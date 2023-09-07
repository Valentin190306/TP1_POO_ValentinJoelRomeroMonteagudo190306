package ar.edu.unlu.poo;

import java.util.concurrent.ThreadLocalRandom;

public class Password {
    private Integer longitud;
    private String contrasenia = null;

    public Password () {
        this.longitud = 8;
        this.contrasenia = generarContrasenia("", this.longitud);
    }

    public Password (Integer longitud) {
        this.longitud = LongitudAbsoluta(longitud);
        this.contrasenia = generarContrasenia("", longitud);
    }

    private String generarContrasenia (String base, Integer longitud) {
        String contrasenia = null, auxiliar = "";
        String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        if (this.contrasenia == null) {
           for (int i = 0 ; i < longitud ; i++) {
               int indice = ThreadLocalRandom.current().nextInt(0, CARACTERES_PERMITIDOS.length());
               char caracter = CARACTERES_PERMITIDOS.charAt(indice);
               auxiliar += caracter;
           }
           contrasenia = auxiliar;
        } else if (base.length() < longitud) {
            int faltantes = base.length() - longitud;
            for (int i = 0 ; i < faltantes ; i++) {
                int indice = ThreadLocalRandom.current().nextInt(0, CARACTERES_PERMITIDOS.length());
                char caracter = CARACTERES_PERMITIDOS.charAt(indice);
                base += caracter;
            }
            contrasenia = base;
        } else if (base.length() > longitud && longitud > 8) {
            this.longitud = longitud;
            contrasenia = base.substring(0, longitud);
        }

        return contrasenia;
    }

    public String regenerarContrasenia () {
        String regenerada;
        int mayusculas = 0, minusculas = 0, numeros = 0;

        do {
            regenerada = generarContrasenia("", this.longitud);
            for (int i = 0 ; i < regenerada.length() ; i++) {
                char caracter = regenerada.charAt(i);
                if (Character.isUpperCase(caracter))
                    mayusculas++;
                else if (Character.isLowerCase(caracter))
                    minusculas++;
                else if (Character.isDigit(caracter))
                    numeros++;
            }
        } while (mayusculas > 2 && minusculas > 1 && numeros <= 2);

        this.contrasenia = regenerada;
        return contrasenia;
    }

    public boolean esFuerte () {
        int mayusculas = 0, minusculas = 0, numeros = 0;

        for (int i = 0 ; i < this.contrasenia.length() ; i++) {
            char caracter = this.contrasenia.charAt(i);
            if (Character.isUpperCase(caracter))
                mayusculas++;
            else if (Character.isLowerCase(caracter))
                minusculas++;
            else if (Character.isDigit(caracter))
                numeros++;
        }

        if (mayusculas > 2 && minusculas > 1 && numeros >= 2)
            return true;
        else return false;
    }

    private Integer LongitudAbsoluta (Integer longitud) {
        if (Math.abs(longitud) >= 8)
            return Math.abs(longitud);
        else return null;
    }

    public String cambiarLongitud (int nuevaLongitud) {
        if (Math.abs(longitud) >= 8) {
            String ajustada = generarContrasenia(this.contrasenia, nuevaLongitud);
            this.contrasenia = ajustada;
            return ajustada;
        } else return null;
    }
    public Integer getLongitud () {
        return longitud;
    }

    public String getContrasenia () {
        return contrasenia;
    }
    
}
