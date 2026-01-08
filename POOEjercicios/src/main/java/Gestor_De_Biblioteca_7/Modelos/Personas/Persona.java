package Gestor_De_Biblioteca_7.Modelos.Personas;

public abstract class Persona {

    private String personaID;
    private String nombres;
    private String apellidos;
    private String correo;

    //Metodos de la clase
    public Persona(String personaID, String nombres, String apellidos, String correo){
        this.personaID = personaID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }
    public abstract String mostrarDatos();

}
