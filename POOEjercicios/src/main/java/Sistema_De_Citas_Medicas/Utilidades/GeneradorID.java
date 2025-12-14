package Sistema_De_Citas_Medicas.Utilidades;

public class GeneradorID {
    // Clase para generar el ID ya sea del paciente, doctor o cita medica.

    /**
     * Este metodo es para generar el ID, se busca que se aplique para
     * las diferentes areas en: Paciente, Doctor con sus diferentes ramas y en Citas
     * @param cantidadDatos : Es el tamaño del HashMap obviamente este depende de la area solicitada, pero puede ocurrir errores
     *                      por lo que es necesario al tamaño del HashMap obtener el ultimo dato y saber cual es el ultimo numero o ID
     *                      en base a esto aumentamos en uno la cantidad del ID
     * @param area : la area es cual mapa se usara o referencia, si es paciente, entonces se recortara la cadena a
     *             PAC | Dentista a : DENT y asi dependiendo el area.
     * @return : Regresará el ID ya formateado.
     */
    public String generarID(int cantidadDatos, String area){
        String identificador = area.substring(0,3);
        String identificadorNumero = "";
        if(cantidadDatos < 10){
            identificadorNumero = "000" + cantidadDatos;
        }else if(cantidadDatos < 100){
            identificadorNumero = "00" + cantidadDatos;
        }else if(cantidadDatos < 1000){
            identificadorNumero = "0" + cantidadDatos;
        }else if(cantidadDatos < 10000){
            identificadorNumero =  Integer.toString(cantidadDatos);
        }
        return identificador + "_" + identificadorNumero;
    }
}
