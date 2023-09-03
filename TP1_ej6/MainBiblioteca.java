import ar.edu.unlu.poo.Biblioteca;
import ar.edu.unlu.poo.Libro;

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
