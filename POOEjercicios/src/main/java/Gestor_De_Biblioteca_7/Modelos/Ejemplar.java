package Gestor_De_Biblioteca_7.Modelos;

public class Ejemplar {
    //Atributos
    private String ejemplarID;
    private Libro libroInfo;
    private boolean disponible;

    public Ejemplar(String ejemplarID, Libro libroInfo){
            if(libroInfo != null){
                //Como el objeto es diferente a null, guardamos los datos en los atributos del constructor
                this.ejemplarID = ejemplarID;
                this.libroInfo = libroInfo;
                this.disponible = true;
            }
    }

    public String getEjemplarID(){
        return this.ejemplarID;
    }

    public String mostrarDatos(){
        String dispo = (disponible)? "Disponible" : "No disponible";
        return "ID Ejemplar: " + ejemplarID +
                "\n" + libroInfo.mostrarDatos() +
                "\nDisponible: " + dispo;
    }
}
