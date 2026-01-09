package Gestor_De_Biblioteca_7.servicios;

import Gestor_De_Biblioteca_7.Almacenamiento.BibliotecarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Almacenamiento.UsuarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Excepciones.CorreoIncorrecto;
import Gestor_De_Biblioteca_7.Modelos.Personas.Bibliotecario;
import Gestor_De_Biblioteca_7.Utilidades.GeneradorID;
import Gestor_De_Biblioteca_7.Utilidades.ValidarCorreo;
import Gestor_De_Biblioteca_7.enums.IdentificadorIDs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonaServicios {
    Scanner sc = new Scanner(System.in);
    //Atributo para obtener los datos de la clase "UsuarioAlmacenamiento"
    private UsuarioAlmacenamiento personasAlmacen;
    private BibliotecarioAlmacenamiento biblioAlmacen;

    //Generador de ID
    GeneradorID generarID = new GeneradorID();
    //Validador de correo
    ValidarCorreo validarCorreo = new ValidarCorreo();
    //Enums
    IdentificadorIDs area = IdentificadorIDs.BIB; //Área de la persona "Bibliotecario"

    public PersonaServicios(UsuarioAlmacenamiento personasAlmacen, BibliotecarioAlmacenamiento almacenBiblio){
        this.personasAlmacen = personasAlmacen;
        this.biblioAlmacen = almacenBiblio;
    }

    //==================== MENU PERSONAS ===========================
    public void menuPersonas(){
        try{
            System.out.print("""
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
            System.out.print("""
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

    /**
     * Esta funcion sirve para guardar los datos del usuario, utilizamos en esta función funciones externas para poder
     * llenar el formulario de datos.
     * Por ejemplo:
     * <br>
     *  {@code validarCorreo} : Este se usó para validar si el correo contenia {@code "@"} y terminaba en {@code .com}
     *  <br>
     * {@code buscarCorreo} : Esta funcionalidad sirve para buscar algún correo similar, si lo encuentra entonces procede a
     *                      terminar el formulario en caso de que exista algún correo igual
     * <br>
     * {@code obtenerUltimoDato} : Para obtener ya sea un valor nulo o el último valor guardado.
     *
     * @exception {@code NullPointerException} : Se buscó agregar filtros para que este error no suceda, pero se pone por seguridad.
     * @exception {@code CorreoIncorrecto} : Excepcion personalizada para cuando el correo no tiene los requerimienfos minimos como
     *                                      {@code "@"} y terminaba en {@code .com}
     */
    public void agregarBiblio(){
        try{
            sc.nextLine();
            String biblioID = "";
            System.out.println("\n=====| Agregar Bibliotecario |=====");
            System.out.println("En esta sección agregara los datos personales del bibliotecario\n");
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese los apellidos: ");
            String apellido = sc.nextLine();
            System.out.print("Ingrese el correo: ");
            String correo = sc.nextLine();
            System.out.print("Ingrese la contraseña: ");
            String contra = sc.nextLine();
            String prefijoArea = area.toString();

            if(!validarCorreo.validarCorreo(correo.trim())){
                //Si es false entonces regresa y no procede a guardar nada
                return;
            }

            if(biblioAlmacen.buscarCorreo(correo)){
                //Como encontró el correo entonces uso return para que no se guarde algún correo.
                return;
            }
            //La siguiente validación saber generar ID, pero se validará que el objeto sea null o no
            Bibliotecario bibliotecario = biblioAlmacen.obtenerUltimoDato();
            if(bibliotecario != null){
                //Si es diferente a null entonces procedemos a obtener el ultímo ID
                int ultimoID = Integer.parseInt(bibliotecario.getPersonaID().substring(4, 8));
                biblioID = generarID.generarID(prefijoArea, (ultimoID + 1));
            }else{
                //Se encontró algún valor nulo por lo que se crea el ID
                //Termina de ajustar la generación del primer ID
                biblioID = generarID.generarID(prefijoArea, 1);
            }
            //Esta validación es para saber si se generó correctamente el ID del usuario
            if(!biblioID.isEmpty()){
                System.out.println();
                //El ID se generó correctamente, por lo que ahora se guardaran los datos del nuevo bibliotecario
                biblioAlmacen.setBiblioAlmacen(biblioID, new Bibliotecario(biblioID, nombre, apellido, correo, contra));
                //Entonces ahora se avisará que se guardó correctamente al bibliotecario.
                System.out.println("Se guardarón los datos del bibliotecario. \n" + biblioAlmacen.getBiblioAlmacen(biblioID).mostrarDatos());

            }
        }catch(CorreoIncorrecto correo){
            System.out.println(correo.getMessage());
        }
        catch(InputMismatchException tipo){
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
