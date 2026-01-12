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

    public void setLibroAlmacen(String llave, Libro valor){
        if(valor != null){
            libroAlmacen.put(llave, valor);
        }else{
            System.out.println("Ingresa un valor existente por favor.");
        }
    }

    public Libro getLLibroAlmacen(String llave){
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
