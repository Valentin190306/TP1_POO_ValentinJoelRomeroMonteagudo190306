package ar.edu.unlu.poo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Libro> lista_de_libros = new ArrayList<>();
    private Integer cant_prestamos = 0;

    public boolean agregarLibro (Libro libro) {
        if (lista_de_libros.indexOf(libro) == -1) {
            lista_de_libros.add(libro);
            return true;
        } else return false;
    }

    public Libro buscarPorLibro (Libro libro) {
        return lista_de_libros.get(lista_de_libros.indexOf(libro));
    }

    public List buscarPorTitulo (String titulo) {
         return lista_de_libros.stream().filter(libro -> libro.getTitulo().startsWith(titulo)).collect(Collectors.toList());
    }

    public List busccarPorAutor (String autor) {
        return lista_de_libros.stream().filter(libro -> libro.getAutor().startsWith(autor)).collect(Collectors.toList());
    }

    public List buscar (String titulo, String autor) {
        List<Libro> lista_encontrados_autor = lista_de_libros.stream().filter(libro -> libro.getAutor().startsWith(autor)).collect(Collectors.toList());
        List<Libro> lista_encontrados_titulo = lista_de_libros.stream().filter(libro -> libro.getTitulo().startsWith(titulo)).collect(Collectors.toList());
        return lista_encontrados_titulo;
    }

    public Integer cantidadTotalDePrestamos () {
        if (lista_de_libros.isEmpty()) return 0;
        Integer acumulador = 0;
        Libro libro;
        for (int i = 0 ; i < lista_de_libros.size() ; i++){
            libro = lista_de_libros.get(i);
            acumulador += libro.getNum_ejemplares_prestados();
        }
        cant_prestamos = acumulador;
        return acumulador;
    }
}
