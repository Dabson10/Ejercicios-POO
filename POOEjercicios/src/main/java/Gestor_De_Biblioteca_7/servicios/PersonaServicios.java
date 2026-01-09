package Gestor_De_Biblioteca_7.servicios;

import Gestor_De_Biblioteca_7.Almacenamiento.BibliotecarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Almacenamiento.UsuarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Modelos.Personas.Bibliotecario;
import Gestor_De_Biblioteca_7.Utilidades.GeneradorID;
import Gestor_De_Biblioteca_7.enums.IdentificadorIDs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonaServicios {
    Scanner sc = new Scanner(System.in);
    //Atributo para obtener los datos de la clase "UsuarioAlmacenamiento"
    private UsuarioAlmacenamiento personasAlmacen;
    private BibliotecarioAlmacenamiento biblioAlmacen;

    //Generador de IDs
    GeneradorID generarID = new GeneradorID();
    private IdentificadorIDs IdentificadorIDs;

    public PersonaServicios(UsuarioAlmacenamiento personasAlmacen, BibliotecarioAlmacenamiento almacenBiblio){
        this.personasAlmacen = personasAlmacen;
        this.biblioAlmacen = almacenBiblio;
    }

    //==================== MENU PERSONAS ===========================
    public void menuPersonas(){
        try{
            System.out.println("""
                    ¿A que sección de Personas quieres acceder?
                    1.Bibliotecarios.
                    2.Usuarios(Alumnos, Profesores, Publico).
                    3.Inicio
                    """);
            int opcion = sc.nextInt();
            switch(opcion){
                case 1 -> menuBibliotecario();
                case 2 ->{}
                case 3 -> System.out.println("\nRegresando al inicio\n");
                default -> System.out.println("Ingrese una opción existente.");
            }
        }catch (InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
        }
    }

    //========= MENU BIBLIOTECARIO ==========
    public void menuBibliotecario(){
        try{
            boolean existencia = biblioAlmacen.validarExistencias();
            System.out.println("""
                    ¿Que opción deseas realizar?
                    1.Mostrar Bibliotecarios.
                    2.Agregar Bibliotecarios.
                    3.Salir.
                    """);
            int opcion = sc.nextInt();
            switch(opcion){
                case 1 -> {
                    if(!existencia){
                        //Si es diferente a true entonces procedemos a mostrar a los usuarios.
                        int opcionMostrar = queSeMostrara();
                    }else{System.out.println("Aun no hay bibliotecarios.");}
                }
                //Opción para agregar nuevos bibliotecarios.
                case 2 -> agregarBiblio();
                case 3 -> System.out.println("Regresando al menu");
                default -> System.out.println("Ingrese una opción existente");
            }
        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
            sc.nextLine();
        }
    }
        //========================== Mostrar BIBLIOTECARIOS ==========================

        //========================== AGREGAR BIBLIOTECARIOS ==========================
    public void agregarBiblio(){
        try{
            String biblioID = "";
            System.out.println("\n=====| Agregar Bibliotecario |=====\n");
            System.out.println("En esta sección agregara los datos personales del bibliotecario");
//            System.out.print("Ingrese el nombre: ");
//            String nombre = sc.nextLine();
//            System.out.print("Ingrese los apellidos: ");
//            String apellido = sc.nextLine();
//            System.out.print("Ingrese el correo: ");
//            String correo = sc.nextLine();
//            System.out.print("Ingrese la contraseña: ");
//            String contra = sc.nextLine();
            Bibliotecario bibliotecario = biblioAlmacen.obtenerUltimoDato();
            if(bibliotecario != null){
                //Si es diferente a null entonces procedemos a obtener el ultímo ID

            }else{
                //Se encontró algún valor nulo por lo que se crea el ID
                //Termina de ajustar la generacion del primer ID
//                biblioID = generarID.generarID(IdentificadorIDs);
            }
        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
        }catch(NullPointerException nulo){
            System.out.println("Error del tipo: " + nulo.getMessage());
            System.out.println("Se obtuvo un valor nulo de Bibliotecario");
        }
    }
    //===================== OTRAS FUNCIONALIDADES. =====================

    /**
     * Esta funcion mostrará un menu que se repetira en la seccion de mostrar bibliotecarios
     * y mostrar Usuarios, por lo que sería mejor ahorrar codigo
     * @return : Regresará solamente la opción seleccionada.
     */
    public int queSeMostrara(){
        int opcion = 0;
        try{
            System.out.println("""
                                ¿Como deseas ver a los Bibliotecarios?
                                1.Mostrar Todos.
                                2.Buscar por ID.
                                3.Menu inicio.
                                """);
            opcion = sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException tipo ){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
            sc.nextLine();
        }
        return opcion;
    }
}
