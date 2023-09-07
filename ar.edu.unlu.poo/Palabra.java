package ar.edu.unlu.poo;

public class Palabra {
    private String palabraValida;
    private Integer puntaje;

    public Palabra (String palabraValida) {
        setPalabraValida(palabraValida);
    }

    public void setPalabraValida (String palabra) {
        this.palabraValida = palabra;

        int puntaje = palabraValida.length();
        String caracteresBonus = "kzxywq";

        for (int i = 0 ; i < caracteresBonus.length() ; i++)
            if (palabraValida.indexOf(caracteresBonus.charAt(i)) != -1)
                puntaje++;

        this.puntaje = puntaje;
    }

    public String getPalabraValida () {
        return palabraValida;
    }

    public Integer getPuntaje() {
        return puntaje;
    }
}
