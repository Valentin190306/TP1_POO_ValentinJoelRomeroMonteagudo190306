package ar.edu.unlu.poo;
public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private Integer num_pag;
    private Integer num_ejemplares;
    private Integer num_ejemplares_prestados = 0;

    public Libro (String titulo, String autor, String ISBN, Integer num_pag, Integer num_ejemplares) {
        setTitulo(titulo);
        setAutor(autor);
        setISBN(ISBN);
        setNum_pag(num_pag);
        setNum_ejemplares(num_ejemplares);
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setAutor (String autor) {
        this.autor = autor;
    }

    public String getAutor () {
        return autor;
    }

    public void setISBN (String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN () {
        return ISBN;
    }

    public void setNum_pag (Integer num_pag) {
        this.num_pag = num_pag;
    }

    public Integer getNum_pag () {
        return num_pag;
    }

    public void setNum_ejemplares (Integer num_ejemplares) {
        this.num_ejemplares = num_ejemplares;
    }

    public Integer getNum_ejemplares () {
        return num_ejemplares;
    }

    public void setGet_ejemplares_prestados (Integer num_ejemplares_prestados) {
        this.num_ejemplares_prestados = num_ejemplares_prestados;
    }

    public Integer getNum_ejemplares_prestados() {
        return num_ejemplares_prestados;
    }

    public boolean prestar () {
        if (num_ejemplares > 1) {
            num_ejemplares_prestados++;
            num_ejemplares--;
            return true;
        } else {
            return false;
        }
    }
    
    public void devolver () {
        this.num_ejemplares++;
    }

    public String descripcion () {
        return "El libro "+ getTitulo() +" creado por el autor "+ getAutor() +" tiene "+ getNum_pag()
                +" páginas, queda/n "+ getNum_ejemplares() +" disponible/s y se prestaron "+ getNum_ejemplares_prestados();
    }
}
