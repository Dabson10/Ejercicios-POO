package Gestor_De_Biblioteca_7.Modelos.Personas;

public class Bibliotecario extends Persona{
    private String contrasena;

    //Metodos de la clase bibliotecario
    //Constructor
    public Bibliotecario(String personaID, String nombres, String apellidos,
                         String correo, String contrasena){
        super(personaID, nombres, apellidos, correo);
        this.contrasena = contrasena;
    }

    @Override
    public String mostrarDatos(){
        return "";
    }
}
