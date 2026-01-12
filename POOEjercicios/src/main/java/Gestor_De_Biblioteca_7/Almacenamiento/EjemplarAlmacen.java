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
    public Ejemplar obtenerEjemplar(String ID) {return this.ejemplarAlmacen.get(ID);}

    /**
     * Esta función es la mas importante de todo el código.
     * Lo que esta función hace es mostrar 1 solo ejemplar de un libro,
     * pero a su vez cuenta la cantidad total.
     * Después de esto un bucle for mostrara los datos obtenidos
     *
     * @param prefijo : El prefijo servirá para tener en claro que se buscara
     */
    public void recuentoEjemplares(String prefijo) {
        Map<String, Long> lista = ejemplarAlmacen.values().stream()
                .filter(Objects::nonNull)
                .filter(ejemplar -> ejemplar.getEjemplarID().contains(prefijo))
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
