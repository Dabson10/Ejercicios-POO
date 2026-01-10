package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioAlmacenamiento {

    private Map<String, Usuario> usuariosAlmacen;

    public UsuarioAlmacenamiento(){
        this.usuariosAlmacen = new LinkedHashMap<>();
    }

    public Usuario obtenerUltimo(){
        Usuario usuario = null;
        for(Map.Entry<String, Usuario>lista : usuariosAlmacen.entrySet()){
            usuario = lista.getValue();
        }
        return usuario;
    }

    public void setPersonasAlmacen(String llave, Usuario valor){
        if(valor != null){
            //Si el valor es diferente a null entonces procedemos a guardar
            usuariosAlmacen.put(llave, valor);
        }else{
            System.out.println("No se puede guardar al usuario.\n" +
                    "Asegurate que ingresaste correctamente los datos.");
        }
    }

    public void mostrarTodos(){
        usuariosAlmacen.values().stream()
                .map(Usuario::mostrarDatos)
                .forEach(System.out::println);
    }

    public boolean buscarCorreo(String correo){
        return usuariosAlmacen.values().stream()
                .filter(Objects::nonNull)
                .anyMatch( p -> p.getCorreo().equals(correo));
    }

    /**
     *
     */
    public void mostrarPorTipo(String area, String prefijo){
        System.out.println("\n|===========| Usuarios " + area + "|===========|");
         usuariosAlmacen.values().stream()
                .filter(p -> p.getPersonaID().contains(prefijo))
                .map(Usuario::mostrarDatos)
                .forEach(System.out::println);
    }
    public Usuario getUsuariosAlmacen(String ID){
        return usuariosAlmacen.get(ID);
    }

}
