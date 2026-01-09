package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Personas.Bibliotecario;
import sistema_empleados_3.Empleado;

import java.util.LinkedHashMap;
import java.util.Map;

public class BibliotecarioAlmacenamiento {
    private Map<String, Bibliotecario> biblioAlmacen;
    public BibliotecarioAlmacenamiento(){
        this.biblioAlmacen = new LinkedHashMap<>();
    }

    /**
     * Esta función será simple solo validará si existen bibliotecarios.
     * @return : regresará un valor booleano depende del caso este el mapa vacio o no.
     */
    public boolean validarExistencias(){
        return biblioAlmacen.isEmpty();
    }

    /**
     * Esta función servira para obtener el ultímo objeto en el mapa, para asi obtener el ID del ultímo,
     * pero si no hay ningun objeto regresará un null, y es importante para poder crear el primer ID de esta areá.
     * -----Es necesario realizar una validación al usar esta función ya qué puede salir un "NPE"
     * @return : Este regresará un valor null o del tipo Bibliotecario.
     */
    public Bibliotecario obtenerUltimoDato(){
        Bibliotecario ultimo = null;
        for(Map.Entry<String, Bibliotecario> lista : biblioAlmacen.entrySet()){
            ultimo = lista.getValue();
        }
        return ultimo;
    }

    /**
     * Esta funcion es simple sirve para guardar valores nuevos en el Mapa.
     * @param llave : Sera el identificador que se guardara en el Mapa.
     * @param valor : El valor es un objeto de la clase Bibliotecario
     */
    public void setBiblioAlmacen(String llave, Bibliotecario valor){
        try{
            if(valor != null){
                biblioAlmacen.put(llave, valor);
            }else{
                System.out.println("Ingrese un bibliotecario correcto.");
            }
        }catch(NullPointerException nulo){
            System.out.println("Error del tipo: " + nulo.getMessage());
            System.out.println("Ingrese un valor que no se nulo.");
        }
    }

    /**
     * Esta funcion será para obtener algín bibliotecario mediante el ID, esta
     * funcion debera ser validada con el valor de retorno ya qué puede salir algún valor null
     * y generar una excepción que facil se podria capturar.
     * @param llave : Este será el ID del bibliotecario para poder buscar en el Map
     * @return : Regresará un valor tipo Bibliotecario, pero si no encuentra
     *          al usuario entonces regresará un null "CUIDADO CON ESO"
     */
    public Bibliotecario getBiblioAlmacen(String llave){
        return biblioAlmacen.get(llave);
    }

}
