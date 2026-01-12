package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Libro;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LibroAlmacen {
    private Map<String, Libro> libroAlmacen;

    public LibroAlmacen(){
        this.libroAlmacen = new LinkedHashMap<>();
    }

    //Esta función es sencilla y requerida, ya que si el mapa esta vació entonces regresa un true, si no un false,
    //logrando asi saber si podemos mostrar usuarios y limitar acceso en caso de que no existan.
    public boolean existenLibros(){return libroAlmacen.isEmpty();}
    public void setLibroAlmacen(String llave, Libro valor){
        if(valor != null){
            libroAlmacen.put(llave, valor);
        }else{
            System.out.println("Ingresa un valor existente por favor.");
        }
    }

    // Cuidado con este getter, ya que puede regresar un null si no se encuentra con la llave.
    public Libro getLibroAlmacen(String llave){
        return libroAlmacen.get(llave);
    }

    public void mostrarTodos(){
        libroAlmacen.values().stream()
                .filter(Objects::nonNull)
                .map(Libro::mostrarDatos)
                .forEach(System.out::println);
    }
    public Libro obtenerUltimo(){
        Libro libro = null;
        for(Map.Entry<String, Libro> lista : libroAlmacen.entrySet()){
            libro = lista.getValue();
        }
        return libro;
    }

}
