package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.PacienteAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.Paciente;
import Sistema_De_Citas_Medicas.Utilidades.GeneradorID;

import java.util.Scanner;

public class PacienteServicios {
    //Esta clase contendra la logica para agregar nuevos usuarios, editar, eliminar, editar y mostrar pacientes.
    private PacienteAlmacenamiento pacientes;
//    private Paciente pacienteModelo;
    private GeneradorID generadorID;
    private final Scanner sc = new Scanner(System.in);

    public PacienteServicios(PacienteAlmacenamiento almacenamiento) {
        pacientes = almacenamiento;
        generadorID = new GeneradorID();
//        pacienteModelo = new Paciente();
    }


    public void opcionesPacientes() {
        //Guarda instantaneamente datos de pacientes.
//        pacientes.datosGuardados();
        //switch con las diferentes acciones a realizar con Pacientes.
        boolean validacionAlmacenamiento = pacientes.validarAlmacenamiento();
        //Si es true es por que hay valores guardados.
        System.out.print("""
                ¿Qué deseas realizar?
                1.Mostrar Pacientes.
                2.Agregar Pacientes.
                3.Editar Pacientes.
                4.Eliminar Pacientes.
                """);
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            //Mostrar usuarios.
            case 1 -> mostrarPacientes(validacionAlmacenamiento);
            //Agregar usuarios.
            case 2 -> menuAgregar();
            //Editar pacientes.
            case 3 -> menuEditarPaciente(validacionAlmacenamiento);
            //Eliminar pacientes.
            case 4 -> buscarPacienteEliminar();
            default -> System.out.println("Ingrese una opción correcta.");

        }


    }

    //Función para mostrar pacientes de diferentes formas.
    public void mostrarPacientes(boolean validacionAlmacenamiento) {
        validacionAlmacenamiento = pacientes.validarAlmacenamiento();

        //Se realiza la validacion de valores en el HashMap
        if (validacionAlmacenamiento) {
            System.out.print("""
                    ¿Comó deseas buscar al paciente?
                    1.Mostrar todos.
                    2.Buscar por ID.
                    """);
            int opcionM = sc.nextInt();
            sc.nextLine();
            switch (opcionM) {
                case 1 -> pacientes.todosLosPacientes();
                case 2 -> {
                    System.out.print("Ingrese el ID del paciente: ");
                    String pacienteID = sc.nextLine();

                    if(validarPaciente(pacienteID)){
                     //Si regresa TRUE entonces procede a mostrar.
                        pacientes.buscarPacienteID(pacienteID);
                    }

                }
                default -> System.out.println("Ingrese una opción valida.");
            }
        } else {
            System.out.println("No hay datos registrados.");
        }

    }

    //==================================== AGREGAR PACIENTES ====================================
    //Funcion para agregar nuevos pacientes.
    public void menuAgregar() {
        System.out.print("¿Cuantos pacientes quieres agregar? ");
        int cantidad = sc.nextInt();
        //Recorrer la cantidad de pacientes que se agregaran
        for (int i = 0; i < cantidad; i++) {
            sc.nextLine();
            agregarPacientes();
        }
    }

    //Funcion para obtener los datos del paciente.
    public void agregarPacientes() {
        try {
            System.out.println("=== Ingrese los datos del paciente. ===");
            System.out.print("Nombres: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine().trim();
            System.out.print("Numero del telefono: ");
            String telefono = sc.nextLine().trim();
            System.out.print("Correo electronico:");
            String correo = sc.nextLine().trim();

            //Se conoce la longitud del arreglo de los pacientes
            //Para poder obtener y generar bien un ID de usario

            Paciente ultimoPaciente = pacientes.getUltimoPaciente();
            String ultimoID = ultimoPaciente.getID();
//            System.out.println("La longitud del ID es: " + limiteCadena);
            int numeroID = Integer.parseInt(ultimoID.substring(4, 8));
//            System.out.println("El numero es: " + numeroID + ", La cadena recortada es: " + ultimoID.substring(4, 8));
            String ID = generadorID.generarID((numeroID + 1), "PACIENTES");
            Paciente objetoGuardar = new Paciente(ID, nombre, apellidos, telefono, correo);
            pacientes.setPacientes(ID, objetoGuardar);
        } catch (Exception e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    //================================= EDITAR PACIENTES ===================================

    //Menu para seleccionar que editar.
    public void menuEditarPaciente(boolean validacionAlmacenamiento) {
        if (validacionAlmacenamiento) {
            System.out.print("""
                    ¿Qué deseas editar?
                    1.Correo electronico.
                    2.Numero de telefono.
                    """);
            int opcionPaciente = sc.nextInt();
            sc.nextLine();
            buscarPacientes(opcionPaciente);
        } else {
            System.out.println("No hay pacientes para poder editar.");
        }
    }

    //Funcion para editar un paciente.
    public void buscarPacientes(int opcionPaciente) {

        System.out.print("Ingrese el ID del usuario: ");
        String editarID = sc.nextLine();
        if(validarPaciente(editarID)) {
            switch (opcionPaciente) {
                case 1 -> actualizarCorreo(editarID);
                case 2 -> actualizarTelefono(editarID);
                default -> System.out.println("Seleccione una opcion valida.\n");
            }
        }
    }

    //Actualizar correo
    public void actualizarCorreo(String ID) {
        System.out.print("Ingresa el nuevo correo para poder registrarlo.");
        String correoNuevo = sc.nextLine();
        //Se valida que el correo ya guardado no sea el mismo.
        String correoAntiguo = pacientes.getPaciente(ID).getCorreo();
//        System.out.println(correoAntiguo);
        if(!correoAntiguo.equals(correoNuevo)){
            //Si el correo es diferente entonces procedemos a guardar los datos.
            Paciente paciente = pacientes.getPaciente(ID);
            paciente.setCorreo(correoNuevo);
            //Al hacer el gett
            System.out.println(paciente.getCorreo());
        }else{
            System.out.println("Ingrese un correo electronico diferente.\n");
        }
    }


    //Actualizar numero de telefono
    public void actualizarTelefono(String ID){

        Paciente pacienteAEditar = pacientes.getPaciente(ID);
        if(pacienteAEditar == null){
            System.out.println("Error, no se encontro al paciente ");
            return;
        }
        System.out.print("Ingresa el nuevo numero de telefono");
        String nuevoTelefono = sc.nextLine();
        pacienteAEditar.setNumeroDeTelefono(nuevoTelefono);
    }

    //========================== ELIMINAR PACIENTES ======================
    public void buscarPacienteEliminar(){
        System.out.print("Ingrese el ID del paciente: ");
        String id = sc.nextLine();
        boolean existe = validarPaciente(id);
        if(existe){
            //Si existe el paciente entonces atraemos los datos.
            Paciente paciente = pacientes.getPaciente(id);
            System.out.println("El paciente que deseas eliminar es: \n" +
                    paciente.mostrarDatos() +
                    "\nSeleccione la opción que quieres hacer." +
                    "\n1.Eliminar." +
                    "\n2.Conservar."
            );
            int accion = sc.nextInt();
            if(accion == 1){
                pacientes.eliminarPaciente(id);
                System.out.println("El paciente se elimino.\n");

            }
        }
    }



    //Funciones pequeñas pero repetitivas.
    /**
     * Funcion para no duplicar la validacion de si existe o no algun paciente.
     * @param pacienteID : Requerimos la llave o ID de algun paciente
     * @return : Regresará un true si es que el ID existe, si no existe el paciente devuelve false;
     */
    public boolean validarPaciente(String pacienteID){
        boolean acceder = false;
        Paciente paciente = pacientes.getPaciente(pacienteID);
        if(paciente != null){
            //Si es diferente entonces procede
            acceder = true;
        }else{
            System.out.print("No se encontro al paciente con ese ID.\n");
        }
        return acceder;
    }
}
