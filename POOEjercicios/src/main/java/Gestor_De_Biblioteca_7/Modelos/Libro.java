package Gestor_De_Biblioteca_7.Modelos;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private String categoria;

    public Libro(String titulo, String autor, String ISBN, String categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.categoria = categoria;
    }

    public int obtenerCantidad(){
        return 0;
    }
    public String mostrarDatos(){
        return  "Titulo: " + titulo +
                "\nAutor: " + autor +
                "\nCategoria: " + categoria +
                "\nISBN: " + ISBN +
                "\nCantidad: " + obtenerCantidad();
    }
}
