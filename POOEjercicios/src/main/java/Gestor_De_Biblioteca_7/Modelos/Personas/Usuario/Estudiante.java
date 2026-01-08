package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

public class Estudiante extends Usuario {

    //Metodos de la clase
    //Constructor con atributos
    public Estudiante(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
        super(personaID, nombres, apellidos, correo, credencialVigente);
    }
    @Override
    public String mostrarDatos(){
        return "";
    }
}
