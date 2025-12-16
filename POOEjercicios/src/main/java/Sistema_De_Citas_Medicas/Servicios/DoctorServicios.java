package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.DoctorAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.Cardiologo;
import Sistema_De_Citas_Medicas.Modelos.Dentista;
import Sistema_De_Citas_Medicas.Modelos.Doctor;
import Sistema_De_Citas_Medicas.Utilidades.GeneradorID;

import java.util.Scanner;

public class DoctorServicios {

    Scanner sc = new Scanner(System.in);
    //Objeto para llamar a la clase de DoctorAlmacenamiento
    DoctorAlmacenamiento almacenDoctor;

    GeneradorID generarID = new GeneradorID();

    public DoctorServicios(DoctorAlmacenamiento almacen) {
        almacenDoctor = almacen;
    }


    //============================ MENU PARA DOCTORES ================================
    public void menuDoctores() {
        System.out.println("==== Seccion Doctores. =====");
        boolean existenDoctores = almacenDoctor.validarExistencia();
        System.out.print("""
                ¿Qué deseas hacer?
                1.Mostrar Doctores.
                2.Agregar Doctores.
                3.Actualizar Doctores.
                4.Eliminar Doctores.
                """);
        int opcionD = sc.nextInt();
        switch (opcionD) {
            case 1 -> menuMostrar(existenDoctores);
            case 2 -> menuAgregar();
            case 3 -> {
            }
            case 4 -> {
            }
            default -> System.out.println("Ingrese una opcion correcta.\n");
        }
    }

    //===================== MOSTRAR DOCTORES ========================
    public void menuMostrar(boolean existenDocs) {
        if (existenDocs) {
            System.out.println("==== VISTA DOCTORES ====");
            System.out.println("""
                    ¿Comó deseas ver a los doctores?
                    1.Mostrar Todos.
                    2.Por ID.
                    3.Cardiologia.
                    4.Dentistas.
                    5.Pediatria.
                    6.Medico General.
                    """);
            int opcionMost = sc.nextInt();
            switch (opcionMost) {
                case 1 -> almacenDoctor.todosLosDoctores();
                case 2 -> {
                }
                case 3 -> {
                }
            }
        } else {
            System.out.println("No hay doctores para mostrar.\n");
        }
    }

    //===================== AGREGAR DOCTORES ========================
    public void menuAgregar(){
        System.out.print("¿Cuantos Doctores quieres agregar? ");
        int cantidad = sc.nextInt();
        for(int i =0; i < cantidad; i++){
            sc.nextLine();
            agregarDoctores();
        }
    }
    public void agregarDoctores() {
        sc.nextLine();
        System.out.println("==== Ingrese los datos del Doctor. ====");
        System.out.print("Nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Años de experiencia: ");
        int experiencia = sc.nextInt();
        System.out.print("Horario: ");
        String horario = sc.nextLine();
        System.out.print("""
                Ingrese el tipo del area del doctor.
                1.Cardiologo.
                2.Dentista.
                3.Pediatra.
                4.Medico General.
                """);
        int areaD = sc.nextInt();
        //Esta variable sirve para saber el ultimo valor del mapa, si no hay nada guardará un NULL
        Doctor cantidadDoctores = almacenDoctor.ultimoValor();
        String ID = "";
        switch (areaD) {
            //Area Cardiologia.
            case 1 -> {
                //Para generar el ID del empleado es necesario saber si hay empleados.
                //Si el objeto es null entonces generará el primer ID automaticamente.
                ID = validarYGenerarID(cantidadDoctores, "CARDIOLOGIA");
                datosCardiologia(ID, nombres, apellidos, experiencia, horario);
            }
            //Area Dentista.
            case 2 -> {
                ID = validarYGenerarID(cantidadDoctores, "DENTISTA");
                datosDentista(ID, nombres, apellidos, experiencia, horario);
            }
            //Area Pediatría.
            case 3 -> {
                ID = validarYGenerarID(cantidadDoctores, "PEDIATRIA");
            }
            //Area Medico General.
            case 4 -> {
                ID = validarYGenerarID(cantidadDoctores, "MEDICO GENERAL");
            }
            default -> System.out.println("Seleccione una opción correcta.\n");
        }

    }

    //Función para validar y generar el ID del Doctor.
    public String validarYGenerarID(Doctor cantidadDoctores, String area) {
        String ID = "";
        if (cantidadDoctores == null) {
            //Si es null entonces genera el primer ID del mapa.
            ID = generarID.generarID(1, area);
//            System.out.println("Primer ID");
        } else {
            //Si tiene aunque sea un valor, procedera a generar ID automaticos.
            //Se obtienen los 4 ultimos caracteres del último ID en el HashMap.
            String numeros = cantidadDoctores.getID().substring(4, 8);
            ID = generarID.generarID((Integer.parseInt(numeros) + 1), area);
        }
        return ID;
    }

    //Obtener y setear los datos de Cardiologia
    public void datosCardiologia(String ID, String nombres, String apellidos, int experiencia, String horario) {
        System.out.print("""
                Especialidad.
                1.Cardiología Clinica.
                2.Cardiología Intervencionista.
                3.Cardiología Electrofisiológica.
                """);
        int especialidad = sc.nextInt();
        String areaCard = "";
        switch (especialidad) {
            case 1 -> areaCard = "Clinica";
            case 2 -> areaCard = "Intervencionista";
            case 3 -> areaCard = "Electrofisiológica";
            default -> {
                System.out.println("Seleccione una especialidad correcta.\n");
                return;
            }
        }
        System.out.print("""
                ¿Atiende Urgencias?
                1.Si.
                2.No.
                """);
        int opcionUrgencia = sc.nextInt();
        boolean urgencias = false;
        switch (opcionUrgencia) {
            case 1 -> urgencias = true;
            case 2 -> urgencias = false;
            case 3 -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        almacenDoctor.setDoctores(ID, new Cardiologo(ID, nombres, apellidos, experiencia, horario, areaCard, urgencias));
    }

    //Funcion para setear los datos de Dentistas.
    public void datosDentista(String ID, String nombres, String apellidos, int experiencia, String horario) {
        System.out.print("""
                Seleccione la especialidad.
                1.Odontopediatría
                2.Ortodoncia.
                3.Maxilofacial.
                """);
        int opcion = sc.nextInt();
        String especialidad = "";
        switch (opcion) {
            case 1 -> especialidad = "Odontopediatría";
            case 2 -> especialidad = "Ortodoncia";
            case 3 -> especialidad = "Maxilofacial";
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        //Ahora se guarda el valor en el HashMap
        almacenDoctor.setDoctores(ID, new Dentista(ID, nombres, apellidos, experiencia, horario, especialidad));
    }
//===================== EDITAR DOCTORES ========================
//===================== ELIMINAR DOCTORES ========================


//===================== VALIDACIONES EXTRA =====================

}
