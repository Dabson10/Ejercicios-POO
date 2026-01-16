package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

public class PublicoGeneral extends Usuario{
    public PublicoGeneral(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
        super(personaID, nombres, apellidos, correo, credencialVigente);
    }

    @Override
    public boolean aumentarDiaPrestamo(){
        return false;
    }

    //Como tal los usuarios o publico general tiene una cantidad maxima de
    @Override
    public boolean validarLimiteLibros(){
        boolean prestar = false;
        if((obtenerCantidadLibros()) >= 2){
            prestar = true;
        }
        return prestar;
    }
}
