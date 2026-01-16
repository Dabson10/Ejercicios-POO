package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Excepciones.UsuarioNoEncontrado;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioAlmacenamiento {

    private Map<String, Usuario> usuariosAlmacen;

    public UsuarioAlmacenamiento(){
        this.usuariosAlmacen = new LinkedHashMap<>();
    }

    /**
     * Este método servirá para obtener el último valor de mapa,
     * iterando sobre cada espacio de este.
     * @return : Regresará un valor tipo {@code Usuario} en este valor de retorno
     * puede haber un null o un objeto, por esto mismo es necesario manejar bien el dato de
     * retorno ya qué si no aparecerá un {@code NullPointerException}
     */
    public Usuario obtenerUltimo(){
        Usuario usuario = null;
        for(Map.Entry<String, Usuario>lista : usuariosAlmacen.entrySet()){
            usuario = lista.getValue();
        }
        return usuario;
    }
    //Setter para guardar un valor en el mapa
    public void setPersonasAlmacen(String llave, Usuario valor){
        if(valor != null){
            //Si el valor es diferente a null entonces procedemos a guardar
            usuariosAlmacen.put(llave, valor);
        }else{
            System.out.println("No se puede guardar al usuario.\n" +
                    "Asegurate que ingresaste correctamente los datos.");
        }
    }
    //Getter para obtener el valor del mapa
    public Usuario getUsuariosAlmacen(String ID){
        return usuariosAlmacen.get(ID);
    }

    public Usuario obtenerUsuario(String ID){
        Usuario usuario = null;
        try{
            usuario = usuariosAlmacen.get(ID);
            validarUsuario(usuario);
        }catch (UsuarioNoEncontrado persona){
            System.out.println(persona.getMessage());
        }
        return usuario;
    }
    public void validarUsuario(Usuario usuario){
        if(usuario == null){
            throw new UsuarioNoEncontrado("No se encontró al usuario");
        }
    }
    /**
     * buscarCorreo(String): Sirve para eso buscar en el mapa si hay
     * algún correo devuelve un true y deja de buscar.
     * @param correo : En base a este parametro se filtrara en el mapa.
     * @return : La función regresara un valor booleano si lo encuentra un {@code true},
     *          si no lo encuentra es un {@code false}.
     */
    public boolean buscarCorreo(String correo){
        return usuariosAlmacen.values().stream()
                .filter(Objects::nonNull)
                .anyMatch( p -> p.getCorreo().equals(correo));
    }

    /**
     * Esta función sirve para mostrar a los usuarios clasificándolos por tipo,
     * por ejemplo mostrará en lista a todos los Estudiantes en grupo,
     * los Profesores por grupo y los Generales por grupo.
     * @param area : Este solo servirá para mostrar un texto por pantalla de que area es.
     * @param prefijo : Este es el importante ya qué con base en este se sabe cuál usuario es cuál,
     *                mediante el prefijo, ya que lo compara con el ID del usuario
     */
    public void mostrarPorTipo(String area, String prefijo){
        System.out.println("\n|===========| Usuarios " + area + "|===========|");
         usuariosAlmacen.values().stream()
                .filter(p -> p.getPersonaID().contains(prefijo))
                .map(Usuario::mostrarDatos)
                .forEach(System.out::println);
    }


}
