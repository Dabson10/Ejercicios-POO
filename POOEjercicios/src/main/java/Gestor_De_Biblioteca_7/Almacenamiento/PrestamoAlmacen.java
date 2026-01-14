package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Prestamo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PrestamoAlmacen {
    private Map<String, Prestamo> prestamoAlmacen;

    public PrestamoAlmacen() {
        this.prestamoAlmacen = new LinkedHashMap<>();
    }

    //Getter y setter del atributo prestamoAlmacen
    public void setPrestamoAlmacen(String llave, Prestamo valor){
        if(valor != null){
            //Si es diferente a null, entonces procedemos a guardar.
            prestamoAlmacen.put(llave, valor);
        }else{
            System.out.println("Ingrese una opción correcta.");
        }
    }
    public Prestamo getPrestamoAlmacen(String ID){
        return prestamoAlmacen.get(ID);
    }

    //Función para saber si el mapa tiene o no datos. true si esta vacía, false si tiene algún dato
    public boolean existenciaEnMapa(){return prestamoAlmacen.isEmpty();}

    public Prestamo obtenerUltimo(){
        Prestamo prestamo = null;
        for(Map.Entry<String, Prestamo>lista : prestamoAlmacen.entrySet()){
            prestamo = lista.getValue();
        }
        return prestamo;
    }

    public void mostrarTodos(){
        for(Map.Entry<String, Prestamo> lista: prestamoAlmacen.entrySet()){
            System.out.println("\n=============================");
            System.out.println(lista.getValue().mostrarDatos());
            System.out.println("=============================");
        }
    }

    /**
     * En esta función se mostrarán los préstamos con respecto al estado que se ingresó por
     * parametro.
     *
     * @param estado : Si recibe un {@code true} es un préstamo activo, si recibe un false es un
     *               préstamo pendiente.
     */
    public void mostrarPorSeparado(boolean estado){
        prestamoAlmacen.values().stream()
                .filter(Objects::nonNull)
                .filter(pr -> pr.getActivo() == estado)
                .map(Prestamo::mostrarDatos)
                .forEach(System.out::println);
    }
}
