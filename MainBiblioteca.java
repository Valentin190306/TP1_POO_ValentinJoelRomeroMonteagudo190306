import ar.edu.unlu.poo.Biblioteca;
import ar.edu.unlu.poo.Libro;
/*
Ejercicio 6
Necesitamos implementar la clase Libro para un sistema de administración de bibliotecas y todas las clases relacionadas que correspondan. Generalmente las búsquedas se hacen por Título o Autor, es casi imposible que quieran buscar un libro por ISBN y en ciertos casos no se tiene el dato para completarlo. Si solo queda un Ejemplar disponible, no se puede prestar el libro porque tiene que quedar disponible para consultar dentro de la biblioteca. El sistema debería mostrar la descripción del libro como: El libro <su_titulo> creado por el autor <su_autor> tiene <num_paginas> páginas, quedan <num_ejemplares> disponibles y se prestaron <num_ejemplares_prestados>. También se necesita determinar la cantidad de préstamos realizados, teniendo en cuenta todos los libros disponibles.
Objetivos:

    _ Definir responsabilidad, estructura y comportamiento de las clases.
    _ Crear una clase que utilice a las anteriores y que cree 2 objetos Libro (los valores que se quieran), mostrarlos por pantalla e indique cuál de los 2 tiene más páginas.
    _ Intentar prestar un libro con 10 ejemplares y uno con 1 solo ejemplar.
    _ Mostrar cantidad total hecha de préstamos.
*/
public class MainBiblioteca {
    public static void main (String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("20.000 leguas de viaje en submarino", "Jules Verne", "1234", 230, 10);
        Libro libro2 = new Libro("1984", "George Orwell", "4321", 200, 1);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        System.out.println(" > "+ libro1.descripcion());
        System.out.println(" > "+ libro2.descripcion());

        if (libro1.getNum_pag() > libro2.getNum_pag())
            System.out.println(" _> ISBN "+ libro1.getISBN() +" tiene mas paginas que ISBN "+ libro2.getISBN());
        else if (libro1.getNum_pag() > libro1.getNum_pag())
            System.out.println(" _> ISBN "+ libro2.getISBN() +" tiene mas paginas que ISBN "+ libro1.getISBN());
        else
            System.out.println("ISBN "+ libro1.getISBN() +" e "+ libro2.getISBN() +" tienen la misma cantidad de paginas");

        if (libro1.prestar())
            System.out.println(" >> Se presto un ejemplar del libro ISBN "+ libro1.getISBN() +", cantidad restante: "+ libro1.getNum_ejemplares());
        else
            System.out.println(" >> No se puede prestar el ejemplar del libro ISBN "+ libro1.getISBN() +", cantidad restante: "+ libro1.getNum_ejemplares());

        if (libro2.prestar())
            System.out.println(" >> Se presto un ejemplar del libro ISBN "+ libro1.getISBN() +", cantidad restante: "+ libro1.getNum_ejemplares());
        else
            System.out.println(" >> No se puede prestar el ejemplar del libro ISBN "+ libro2.getISBN() +", cantidad restante: "+ libro2.getNum_ejemplares());

        System.out.println(" _>> Cantidad total de prestamos realizados: "+ biblioteca.cantidadTotalDePrestamos());
    }
}
