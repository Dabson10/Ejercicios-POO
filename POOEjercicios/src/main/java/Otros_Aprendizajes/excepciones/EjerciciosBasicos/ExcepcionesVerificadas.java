package Otros_Aprendizajes.excepciones.EjerciciosBasicos;

import java.io.*;

//* En este tipo de error encontramos el tipo IOException
public class ExcepcionesVerificadas {
    public static void main(String[] args) throws IOException{
        //Lectura de un archivo de texto
        archivoDeTexto();
        archivoDeTexto2();
    }

    //Función que avisa que puede lanzar un error tipo IOException
    public static void archivoDeTexto() throws IOException {
        // Forma correcta
        try{
            BufferedReader bf = new BufferedReader(new FileReader("\"C:\\prueba\\texto.txt\""));
            String linea;
            while((linea = bf.readLine()) != null){
                System.out.println(linea);
            }
            bf.close();
        }catch(IOException e){
            System.out.println("Error del tipo : " + e.getLocalizedMessage());

        }
    }
    //Funcion que no avisa si lanzara algun error.
    public static void archivoDeTexto2(){
        File archivo = new File("C:\\prueba\\texto.txt");
//        FileReader fr = new FileReader(archivo);
    }
    /**Para saber que tipo de error hubo durante la ejecucion del codigo ya sea
     * declarando en la función o en utilizando try-catch, la diferencia es que
     * al declararla podemos encontrar cosas como el error y el cierre abrupto
     * de la ejecucion del codigo. Pero si utilizamos try-catch se realiza una
     * captura del error, permitiendonos seguir en la ejecución del codigo.
     *
     */
}
