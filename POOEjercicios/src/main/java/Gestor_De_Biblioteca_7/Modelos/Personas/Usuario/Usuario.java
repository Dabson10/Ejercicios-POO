package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Personas.Persona;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario extends Persona {
    private String credencialVigente;
    private List<Ejemplar> librosPrestados = new ArrayList<>();
    private float multas;

    public Usuario(String personaID, String nombres, String apellidos, String correo, String credencialVigente){
        super(personaID, nombres, apellidos, correo);
        this.credencialVigente = credencialVigente;
    }

    public abstract String mostrarDatos();
}
