package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

public class PublicoGeneral extends Usuario{
    public PublicoGeneral(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
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

    @Override
    public String mostrarDatos(){
        return "";
    }
}
