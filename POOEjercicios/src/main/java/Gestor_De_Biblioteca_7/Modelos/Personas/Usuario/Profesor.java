package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

public class Profesor extends Usuario {
    public Profesor(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
        super(personaID, nombres, apellidos, correo, credencialVigente);
    }

    @Override
    public boolean aumentarDiaPrestamo(){
        return false;
    }

    @Override
    public boolean validarLimiteLibros(){
        boolean prestar = false;
        if((obtenerCantidadLibros()) >= 5){
            prestar = true;
        }
        return prestar;
    }
}
