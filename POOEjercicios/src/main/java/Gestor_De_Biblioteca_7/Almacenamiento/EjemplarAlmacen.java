package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Ejemplar;

import java.util.*;
import java.util.stream.Collectors;

public class EjemplarAlmacen {
    private Map<String, Ejemplar> ejemplarAlmacen;

    public EjemplarAlmacen() {
        this.ejemplarAlmacen = new LinkedHashMap<>();
    }

    public void setEjemplarAlmacen(String llave, Ejemplar valor) {
        if (valor != null) {
            this.ejemplarAlmacen.put(llave, valor);
        } else {
            System.out.println("Ingrese un valor existente por favor.");
        }
    }
    //* Obtener el valor del mapa en base a un ID
    public Ejemplar getEjemplar(String ID) {return this.ejemplarAlmacen.get(ID);}

    //Esta función es sencilla y requerida, ya que si el mapa esta vació entonces regresa un true, si no un false,
    //logrando asi saber si podemos mostrar usuarios y limitar acceso en caso de que no existan.
    public boolean mapaVacio(){return ejemplarAlmacen.isEmpty();}
    /**
     * Esta función es la mas importante de todo el código.
     * Lo que esta función hace es mostrar 1 solo ejemplar de un libro,
     * pero a su vez cuenta la cantidad total.
     * Pero si esta compleja de leer, asi que la desglosare
     * <br>
     * Primer {@code for()} : lo que hace es recorrer el mapa principal
     * {@code ejemplarAlmacen}, y guardara en el mapa {@code conteo} un solo ejemplar,
     * <br>
     * Segundo {@code for()} : Se recorrerá el mapa de conteo y en cada recorrido se realiza un conteo con base al
     *                      mapa principal y este conteo se guardará en un arraylist de tipo Long para asi tener bien
     *                      posicionado el conteo de cada libro.
     * <br>
     * Tercer {@code for()} : Este bucle es el más sencillo, ya que en este solo recorremos el mapa que tiene 1 solo ejemplar
     *      Y mostramos los datos del objeto y el contador
     */
    public void recuentoEjemplares() {
        //Este mapa servirá para guardar un ejemplar de cada uno.
        Map<String, Ejemplar> conteo = new LinkedHashMap<>();
        List<Long> contador = new ArrayList<>();
        for(Map.Entry<String, Ejemplar>lista : ejemplarAlmacen.entrySet()){
            conteo.put(lista.getKey().substring(0, 3), lista.getValue());
        }

        for(Map.Entry<String, Ejemplar>lista : conteo.entrySet() ){
             contador.add(ejemplarAlmacen.values().stream()
                     .filter(Objects::nonNull)
                     .filter(ej -> ej.getEjemplarID().contains(lista.getKey()))
                     .count());
        }
        int limite = contador.size();
        int count = 0;
        System.out.println(limite);
        for(Map.Entry<String, Ejemplar>lista : conteo.entrySet()){
            System.out.println("--------------------------");
            System.out.println(lista.getValue().mostrarDatos());
            if(count < limite){
                System.out.println("Ejemplares: " +contador.get(count));
                System.out.println("--------------------------");

            }
            count++;
        }
    }

    public void obtenerEjemplar(String prefijo){
        Ejemplar ejemplar = null;
        for(Map.Entry<String, Ejemplar>lista : ejemplarAlmacen.entrySet()){
            if(lista.getValue().getEjemplarID().contains(prefijo)){
                ejemplar = lista.getValue();
                break;
            }
        }
        if(ejemplar != null ){
            //Si es diferente a null, entonces procedemos con el conteo de ejemplares.
            Long cantidad = ejemplarAlmacen.values().stream()
                    .filter(Objects::nonNull)
                    .filter( ej -> ej.getEjemplarID().contains(prefijo))
                    .count();
            System.out.println("|=========| Ejemplar encontrado |=========|");
            System.out.println(ejemplar.mostrarDatos());
            System.out.println("Ejemplares totales: " + cantidad);
            System.out.println("|=========================================|");
        }
    }

    /**
     * Esta función es requerida para saber en cuál ha sido el último título de un libro en específico.
     * Con este sabemos cúal es la cantidad de ejemplares existentes.
     *
     * @param prefijo : El prefijo servirá para tener en cuenta cúales ejemplares buscamos.
     * @return : Puede que regrese dos datos, uno cuando no encuentra ninguna coincidencia,
     *          el otro será ultímo objeto con la coincidencia del prefijo.
     */
    public Ejemplar obtenerUltimo(String prefijo){
        Ejemplar ejemplar = null;
        for(Map.Entry<String, Ejemplar>lista : ejemplarAlmacen.entrySet() ){
            if(lista.getValue().getEjemplarID().contains(prefijo)){
                ejemplar = lista.getValue();
            }
        }
        return ejemplar;
    }

}
