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
    //Esta función lo que hace es cambiar la disponibilidad del
    //ejemplar
    public void disponibilidad(){
        this.disponible = !this.disponible;
    }

    public String mostrarDatos(){
        String dispo = (disponible)? "Disponible" : "Prestado.";
        return "ID Ejemplar: " + ejemplarID +
                "\n" + libroInfo.mostrarDatos() +
                "\nDisponible: " + dispo;
    }
}
