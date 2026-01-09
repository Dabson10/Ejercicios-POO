package Gestor_De_Biblioteca_7.Modelos;

public class Ejemplar {
    //Atributos
    private String ejemplarID;
    private Libro libroInfo;
    private boolean disponible;

    public Ejemplar(String ejemplarID, Libro libroInfo){
        try{
            if(libroInfo != null){
                //Como el objeto es diferente a null, guardamos los datos en los atributos del constructor
                this.ejemplarID = ejemplarID;
                this.libroInfo = libroInfo;
                this.disponible = true;
            }
        }catch(NullPointerException ex){
            System.out.println("Error del tipo: " + ex.getMessage());
            System.out.println("Error al agregar un nuevo ejemplar.");
        }
    }

    public String mostrarDatos(){
        return "";
    }
}
