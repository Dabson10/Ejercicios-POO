package Gestor_De_Biblioteca_7.Excepciones;

public class UsuarioNoEncontrado extends RuntimeException {
    public UsuarioNoEncontrado(String message) {
        super(message);
    }
}
