package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;

import java.util.LinkedHashMap;
import java.util.Map;

public class UsuarioAlmacenamiento {

    private Map<String, Usuario> personasAlmacenamiento;

    public UsuarioAlmacenamiento(){
        this.personasAlmacenamiento = new LinkedHashMap<>();
    }
}
