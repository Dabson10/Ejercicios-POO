package Gestor_De_Biblioteca_7.servicios;

import Gestor_De_Biblioteca_7.Almacenamiento.EjemplarAlmacen;
import Gestor_De_Biblioteca_7.Almacenamiento.LibroAlmacen;
import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Libro;
import Gestor_De_Biblioteca_7.Utilidades.GeneradorID;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibroServicios {
    //Atributo de la clase Ejemplar y Libro Almacen
    private EjemplarAlmacen ejemplarAlmacen;
    private LibroAlmacen libroAlmacen;
    private Scanner sc = new Scanner(System.in);
    //Generador de ID
    GeneradorID generarID = new GeneradorID();

    public LibroServicios(EjemplarAlmacen ejemplarAlmacen, LibroAlmacen libroAlmacen){
        this.ejemplarAlmacen = ejemplarAlmacen;
        this.libroAlmacen = libroAlmacen;
    }

    public void menuLibros(){
        try{
            System.out.print("""
                    Bienvenido a la sección Libros y Ejemplares
                    ¿Qué acción deseas realizar?
                    1.Mostrar Libros.
                    2.Agregar Libros.
                    3.Regresar al inicio.
                    Seleccione su opción: """);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 ->menuMostrar();
                case 2 ->agregarLibros();
                case 3 -> System.out.println("Regresando al inicio.");
                default -> System.out.println("Ingrese una opción correcta.");
            }
        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese los datos correctamente.");
        }
    }
    //======================== MOSTRAR LIBROS ===================================
    public void menuMostrar(){
        boolean mapaVacio = libroAlmacen.existenLibros();
        if(!mapaVacio){
            //Si mapa tiene algún dato entonces mostramos la opcion del menu
            int mostrarOpc = menuSeleccion("Mostrar", "Mostrar", "todos", "específicos", "Regresar al inicio");
            switch(mostrarOpc){
                //Opción para mostrar todos
                case 1 -> ejemplarAlmacen.recuentoEjemplares();
                case 2 -> mostrarPorID();
                case 3 -> System.out.println("Regresando al inicio.");
                default -> System.out.println("Ingrese una opción correcta.");
            }
        }else{
            System.out.println("No existen valores que mostrar.");
        }
    }

    /**
     * Lo que hace esta función inicialmente es llamar a {@link #obtenerID(String, String)},
     * después de esto usa la función {@link EjemplarAlmacen#obtenerEjemplar(String)},
     * que con base al prefijo buscara similitudes y contara cuantas existen o se repiten,
     * mostrando los datos del libro y cuantos existen.
     */
    public void mostrarPorID(){
        String ID = obtenerID("Libro", "ISBN");
        Libro libro = libroAlmacen.getLibroAlmacen(ID);
        if(libro != null){
            //Si es diferente entonces existe por lo que obtenemos el nombre y sacamos el ID
            String nombre = libro.getTitulo().substring(0, 3);
            ejemplarAlmacen.obtenerEjemplar(nombre.toUpperCase());
        }else{
            System.out.println("No se encontró al usuario.");
        }
    }

    // =========================| AGREGAR LIBROS |=======================

    /**
     *
     */
    public void agregarLibros(){
        try{
            System.out.println("""
                    |====| Agregar nuevo libro |====|
                    En esta sección tendrás que poner los datos del libro.
                    Y la cantidad que deseas guardar.""");
            System.out.print("Nombre del libro: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Nombre del autor: ");
            String autor = sc.nextLine().trim();
            System.out.print("ISBN: ");
            String ISBN = sc.nextLine().trim();
            System.out.print("Nombre de la categoria: ");
            String categoria = sc.nextLine().trim();
            System.out.print("Cantidad de ejemplares: ");
            int cantidad = sc.nextInt();
            Libro libro = libroAlmacen.getLibroAlmacen(ISBN);
            //Primera validación sobre valores nulos o no.
            if(libro != null){
                //Si es diferente entonces no agregamos el libro y retornamos.
                System.out.println("No puedes guardar un libro existente.");
                return;
            }
            //Validamos que el usuario no agregue valores negativos y guardamos un valor fijo.
            if(cantidad <= 0){
                System.out.println("No puedes guardar ejemplares con esa cantidad." +
                        "\nSe creara el libro con 1 ejemplar.");
                cantidad = 1;
            }
            //Ahora que ya tenemos los datos fundamentales, guardamos el objeto de Libro en su lugar

            libroAlmacen.setLibroAlmacen(ISBN, new Libro(nombre, autor, ISBN, categoria));
            //Ahora validamos que se guardara correctamente.
            libro = libroAlmacen.getLibroAlmacen(ISBN);
            //Volvemos a validar, pero con intención de guardar los ejemplares.
            if(libro != null){
                System.out.println("Se guardo correctamente el Libro.");
                System.out.println(libro.mostrarDatos());
                guardarEjemplares(nombre.toUpperCase().substring(0, 3), libro, cantidad);
            }


        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getCause());
            System.out.println("Favor de ingresar correctamente los datos.");
        }
    }

    public void guardarEjemplares(String prefijo, Libro libro, int cantidad){
        for(int i = 0; i< cantidad; i ++){
            //Generar ID del ejemplar.
            String ID = generarID.generarID(prefijo, (i + 1));
            ejemplarAlmacen.setEjemplarAlmacen(ID, new Ejemplar(ID, libro));
        }
    }


    //====================| FUNCIONES UTÍLES |========================
    public int menuSeleccion(String area, String accion, String mot1, String mot2, String salida){
        int opcion = 0;
        try{
            List<String> opciones = Arrays.asList(mot1,mot2, salida);
            System.out.println( area + " libros y ejemplares");
            for(int i = 0; i< opciones.size() ; i++){
                if(i == (opciones.size() -1)  ){
                    System.out.println((i + 1) + "." + opciones.get(i));
                }else{
                    System.out.println((i + 1) + "." +accion + " " + opciones.get(i));
                }

            }
            System.out.print("Seleccione lo que quiera realizar: ");
            opcion = sc.nextInt();
        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            sc.nextLine();
        }
        sc.nextLine();
        return opcion;
    }
    public String obtenerID(String busqueda , String objetivo){
        String ID = "";
        System.out.print("Ingrese el" + objetivo + " del " + busqueda + ": ");
        ID = sc.nextLine();
        return ID;
    }

}
