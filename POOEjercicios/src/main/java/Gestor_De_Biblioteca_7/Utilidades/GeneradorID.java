package Gestor_De_Biblioteca_7.Utilidades;

import Gestor_De_Biblioteca_7.Excepciones.LimiteIDs;

public class GeneradorID {

    /**
     * Esta función servira para generar ID a todas las clases que los ocupen, pero sí o si se necesitará
     * contar con el prefijo del área que podria ser BIB, EST, PRO, etc. Y la última posicion
     * del ID del área.
     * @param prefijo : Areá de la clase en la que se usara el ID
     * @param posicion : Ultima posiciono ultimo ID guardado.
     * @return : Regresará el ID compuesto por el área, y la última posición
     */
    public String generarID(String prefijo, int posicion){
        String IDCompleto = "";
        try{
            //Para generar un ID generico ya sea para libros, usuarios, bibliotecarios, etc. Es necesario
            //tener datos relevantes, como el área en el qe se creara el ID y el valor que se guardara.
            String numeroFinal = "";
            validarRangoID(posicion);
            if(posicion < 10){
                //Si es menor a 10 entonces agregaremos 3 ceros
                numeroFinal = "000" + posicion;
            }else if(posicion < 100){
                //Si es menor a 10 entonces agregaremos 3 ceros
                numeroFinal = "00" + posicion;
            }else if(posicion < 1000){
                //Si es menor a 10 entonces agregaremos 3 ceros
                numeroFinal = "0" + posicion;
            }else if(posicion < 10000){
                numeroFinal = String.valueOf(posicion);
            }
            IDCompleto = prefijo + "_" + numeroFinal;
        }catch(LimiteIDs limite){
            System.out.println("No se genero el ID por: " + limite.getMessage());
        }catch(Exception generico){
            System.out.println("Error del tipo: " + generico.getMessage());
        }
        return IDCompleto;
    }
    public void validarRangoID(int posicion){
        if(posicion < 0 || posicion >= 10000){
            throw new LimiteIDs("Posición del ID fuera de rango: " + posicion);
        }
    }
}
