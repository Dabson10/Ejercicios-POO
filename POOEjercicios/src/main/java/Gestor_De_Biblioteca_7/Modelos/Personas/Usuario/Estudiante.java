package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

public class Estudiante extends Usuario {

    //Metodos de la clase
    //Constructor con atributos
    public Estudiante(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
        super(personaID, nombres, apellidos, correo, credencialVigente);
    }

    @Override
    public boolean aumentarDiaPrestamo(){
        return false;
    }

    @Override
    public boolean validarLimiteLibros(int cantidad){
        return false;
    }
//    @Override
//    public String mostrarDatos(){
//        return "ID: " + getPersonaID() +
//                "\nNombres: " + getNombres() +
//                "\nApellidos: " + getApellidos() +
//                "\nCorreo: " + getCorreo();
//    }
}
