package Gestor_De_Biblioteca_7.Almacenamiento;

import Gestor_De_Biblioteca_7.Modelos.Ejemplar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
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
     * pero a su vez cuenta la cantidad total. Y lo guarda en un mapa, logrando asi
     * guardar mas de 1 ejemplar diferente.
     * Después de esto un bucle for mostrara los datos obtenidos
     *
     */
    public void recuentoEjemplares() {
        Map<String, Long> lista = ejemplarAlmacen.values().stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.groupingBy(
                        Ejemplar::mostrarDatos,
                        Collectors.counting()
                ));
        for (Map.Entry<String, Long> conteo : lista.entrySet()) {
            System.out.println("============|Ejemplar |============");
            System.out.println(conteo.getKey());
            System.out.println("Cantidades existentes: " + conteo.getValue());
        }
    }

    public void obtenerEjemplar(String prefijo){
        Map<String, Long> ejemplarB = ejemplarAlmacen.values().stream()
                .filter(Objects::nonNull)
                .filter( ej -> ej.getEjemplarID().contains(prefijo))
                .collect(Collectors.groupingBy(
                        Ejemplar::mostrarDatos,
                        Collectors.counting()
                ));
        if(!ejemplarB.isEmpty()){
            //Si no esta vació entonces procedemos a mostrar los datos.
            for(Map.Entry<String, Long>lista : ejemplarB.entrySet()){
                System.out.println("===========| Ejemplar |===============");
                System.out.println(lista.getKey() +
                        "\nExistentes." + lista.getValue());
                System.out.println("======================================");
            }
        }else{
            System.out.println("No se encontró el ejemplar.");
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
