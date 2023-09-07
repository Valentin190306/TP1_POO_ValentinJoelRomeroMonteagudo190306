package ar.edu.unlu.poo;

public class Colaborador {
    private String nombre;
    private String apellido;
    private String rol;

    public Colaborador () {
        setNombre(null);
        setApellido(null);
        setRol(null);
    }

    public Colaborador (String nombre, String apellido, String rol) {
        setNombre(nombre);
        setApellido(apellido);
        setRol(rol);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString () {
        String cadena = "["+ getNombre() + " " + getApellido() + " : " + getRol() +"]";
        return cadena;
    }
}


