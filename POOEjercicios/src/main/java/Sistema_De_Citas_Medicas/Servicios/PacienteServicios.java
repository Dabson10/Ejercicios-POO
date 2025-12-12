package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.PacienteAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.Paciente;
import Sistema_De_Citas_Medicas.Utilidades.GeneradorID;

import java.util.Scanner;

public class PacienteServicios {
    //Esta clase contendra la logica para agregar nuevos usuarios, editar, eliminar, editar y mostrar pacientes.
    private static PacienteAlmacenamiento pacientes;
    private static GeneradorID generadorID;
    private static Scanner sc = new Scanner(System.in);

    public PacienteServicios(){
        this.pacientes = new PacienteAlmacenamiento();
        this.generadorID = new GeneradorID();
    }


    public void opcionesPacientes(){
        //switch con las diferentes acciones a realizar con Pacientes.
        boolean validacionAlmacenamiento = pacientes.validarAlmacenamiento();
        int opcion  = 0;
            //Si es true es por que hay valores guardados.
            System.out.print("""
                ¿Qué deseas realizar?
                1.Mostrar Pacientes.
                2.Agregar Pacientes.
                3.Editar Pacientes.
                4.Eliminar Pacientes.
                """);
            opcion =sc.nextInt();
            sc.nextLine();
            switch(opcion){
                //Mostrar usuarios.
                case 1 ->{
                    mostrarPacientes(validacionAlmacenamiento);
                }
                //Agregar usuarios.
                case 2 ->{menuAgregar();}
                //Editar pacientes.
                case 3 ->{}
                //Eliminar pacientes.
                case 4->{}
                default -> System.out.println("Ingrese una opción correcta.");

            }


    }

    //Función para mostrar pacientes de diferentes formas.
    public static void mostrarPacientes(boolean validacionAlmacenamiento){
        int opcionM = 0;
        validacionAlmacenamiento = pacientes.validarAlmacenamiento();

        //Se realiza la validacion de valores en el HashMap
        if(validacionAlmacenamiento){
            System.out.print("""
                            ¿Comó deseas buscar al paciente?
                            1.Mostrar todos.
                            2.Buscar por ID.
                            """);
            opcionM = sc.nextInt();

            switch (opcionM){
                case 1->pacientes.todosLosPacientes();
                case 2 ->{
                    System.out.print("Ingrese el ID del paciente: ");
                    String pacienteID = sc.nextLine();
                    pacientes.buscarPacienteID(pacienteID);
                }
                default -> System.out.println("Ingrese una opción valida.");
            }
        }else{
            System.out.println("No hay datos registrados.");
        }

    }

    //==================================== AGREGAR PACIENTES ====================================
    //Funcion para agregar nuevos pacientes.
    public static void menuAgregar(){
        System.out.print("¿Cuantos pacientes quieres agregar? ");
        int cantidad = sc.nextInt();
        //Recorrer la cantidad de pacientes que se agregaran
        for (int i = 0; i < cantidad; i++){
            agregarPacientes();
        }
    }
    //Funcion para obtener los datos del paciente.
    public static void agregarPacientes(){
        try{
            System.out.println("=== Ingrese los datos del paciente. ===");
            System.out.println("Nombres: ");
            String nombre = sc.nextLine().trim();
            System.out.println("Apellidos: ");
            String apellidos = sc.nextLine().trim();
            System.out.println("Numero del telefono: ");
            String telefono = sc.nextLine().trim();
            System.out.println("Correo electronico:");
            String correo = sc.nextLine().trim();
            //Se conoce la longitud del arreglo de los pacientes
            int longitudMap = pacientes.longitudPacientes();
            String ID = generadorID.generarID((longitudMap + 1), "PACIENTES");
            Paciente objetoGuardar = new Paciente(ID, nombre, apellidos, telefono, correo);
            pacientes.setPacientes(ID, objetoGuardar);
        }catch(Exception e){
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    //================================= EDITAR PACIENTES ===================================

    //Menu para seleccionar que editar.
    public void menuEditarPaciente(boolean validacionAlmacenamiento){
        if(validacionAlmacenamiento){
            System.out.print("""
                ¿Qué deseas editar?
                1.Correo electronico.
                2.Numero de telefono.
                """);
            int opcionPaciente = sc.nextInt();
            buscarPacientes(opcionPaciente);
        }else{
            System.out.println("No hay pacientes para poder editar.");
        }
    }

    //Funcion para editar un paciente.
    public void buscarPacientes(int opcionPaciente){
            System.out.print("Ingrese el ID del usuario: ");
            String editarID = sc.nextLine();
            Paciente paciente = pacientes.getPaciente(editarID);
            switch(opcionPaciente){
                case 1->{}
                case 2->{}
                default -> System.out.println("Seleccione una opcion valida.\n");
            }
    }




}
