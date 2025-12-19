package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.DoctorAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.*;
import Sistema_De_Citas_Medicas.Utilidades.GeneradorID;
import org.w3c.dom.ls.LSOutput;

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
            case 3 -> editarDoctores(existenDoctores);
            case 4 -> eliminarDoctores(existenDoctores);
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
                case 2 -> {
                    sc.nextLine();
                    System.out.println("Ingresa el ID del usuario: ");
                    String ID = sc.nextLine();
                    almacenDoctor.seleccionDoctor(ID);
                }
                case 1, 3, 4, 5, 6 -> almacenDoctor.mostrarDoctores(opcionMost);
                default -> System.out.println("Ingrese una opcion correcta.\n");
            }
        } else {
            System.out.println("No hay doctores para mostrar.\n");
        }
    }

    //===================== AGREGAR DOCTORES ========================
    public void menuAgregar() {
        System.out.print("¿Cuantos Doctores quieres agregar? ");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            sc.nextLine();
            agregarDoctores();
        }
    }

    //Funcion que juntara los datos generales de los doctores.
    public void agregarDoctores() {
        sc.nextLine();
        System.out.println("==== Ingrese los datos del Doctor. ====");
        System.out.print("Nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Años de experiencia: ");
        int experiencia = sc.nextInt();
        sc.nextLine();
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
                datosPediatria(ID, nombres, apellidos, experiencia, horario);
            }
            //Area Medico General.
            case 4 -> {
                ID = validarYGenerarID(cantidadDoctores, "MEDICO GENERAL");
                datosMedicoGen(ID, nombres, apellidos, experiencia, horario);
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

    public void datosPediatria(String ID, String nombres, String apellidos, int experiencia, String horario) {
        System.out.print("Atiende a niños entre: ");
        String rangoEdad = sc.nextLine();
        System.out.print("""
                ¿Atiende urgencias?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        boolean urgencias = false;
        switch (opcion) {
            case 1 -> urgencias = true;
            case 2 -> urgencias = false;
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        almacenDoctor.setDoctores(ID, new Pediatra(ID, nombres, apellidos, experiencia, horario, rangoEdad, urgencias));
    }

    //Metodo para obtener y setear los datos de Medico General.
    public void datosMedicoGen(String ID, String nombres, String apellidos, int experiencia, String horario) {
        System.out.print("""
                ¿Atiende urgencias?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        boolean urgencias = false;
        switch (opcion) {
            case 1 -> urgencias = true;
            case 2 -> urgencias = false;
            default -> {
                System.out.println("Seleccione una opción correcta.\n");
                return;
            }
        }
        almacenDoctor.setDoctores(ID, new MedicoGeneral(ID, nombres, apellidos, experiencia, horario, urgencias));
    }

    //===================== EDITAR DOCTORES ========================
    public void editarDoctores(boolean existenDocs) {
        if (existenDocs) {
            sc.nextLine();
            //Si existen doctores entonces lo buscara.
            System.out.print("Ingrese el ID del doctor: ");
            String ID = sc.nextLine();
            Doctor doctorEdit = almacenDoctor.getDoctores(ID);

            if (doctorEdit != null) {
                //Si el valor es diferente a null entonces si existe el doctor.
                System.out.println("Los datos del doctor son: \n" +
                        doctorEdit.mostrarDatos());
                String doctorID = doctorEdit.getID();
                editarDatos(doctorEdit);
            } else {
                System.out.println("No se encontro doctor con ese ID. Ingrese uno correcto\n");
            }
        } else {
            System.out.println("No hay doctores para editar.\n");
        }
    }
    public void editarDatos(Doctor doctorEdit){
        System.out.println("""
                ¿Que tipo de datos quieres editar?
                1.Datos personales.(Nombres, Apellidos, Experiencia, Horario)
                2.Específicos.(Especialidad, Urgencias, Rango edad, etc)
                """);
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 ->editarDatosPersonales(doctorEdit);
            case 2 ->editarDatosEspecificos(doctorEdit);
            default -> System.out.println("Ingrese una opción valida.\n");
        }
    }
    //Menu para editar datos personales
    public void editarDatosPersonales(Doctor doctorEdit){
        System.out.println("""
                ¿Que deseas editar?
                1.Años de experiencia.
                2.Horario.
                """);
        int opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
            case 1 ->{
                System.out.print("Actualización de años de experiencia: ");
                int experiencia = sc.nextInt();
                doctorEdit.setExperiencia(experiencia);
            }
            case 2 ->{
                System.out.print("Nuevo Horario: ");
                String horario = sc.nextLine();
                doctorEdit.setHorario(horario);
            }
            default -> System.out.println("Ingrese una opción valida.\n");
        }

    }
    //Menu para editar datos Específicos.
    public void editarDatosEspecificos(Doctor doctorEdit){
        String IDCompleto = doctorEdit.getID();
        String doctorID = doctorEdit.getID().substring(0,3);
        //Para poder editar cada seccion de cada area debemos obtener las 3 pimeras letras y ahora si dirigir al doctor a su area respectiva.

        switch(doctorID){
            case "CAR" ->cardiologiaEdit(IDCompleto);
            case "DEN" ->dentistaEdit(IDCompleto);
            case "PED" ->pediatriaEdit(IDCompleto);
            case "MED" ->medicoEditar(IDCompleto);
            default ->System.out.println("Area no encontrada.\n");
        }
    }
    //Funciones para editar datos especificos de cada areá.
    public void cardiologiaEdit(String ID){
        Cardiologo doc =(Cardiologo) almacenDoctor.getDoctores(ID);
        String especialidadAntigua = doc.getEspecialidad();
        System.out.print("""
                ¿A que especialidad quieres actualizar?
                1.Cardiología Clinica.
                2.Cardiología Intervencionista.
                3.Cardiología Electrofisiológica.
               """);
        int opcion = sc.nextInt();
        String especialidadNueva = "";
        switch(opcion){
            case 1 -> especialidadNueva = "Cardiología Clinica";
            case 2 -> especialidadNueva = "Cardiología Intervencionista";
            case 3 -> especialidadNueva = "Cardiología Electrofisiológica";
            default ->{
                System.out.println("Ingrese una opción correcta.");
                return;
            }
        }
        if(!especialidadAntigua.equals(especialidadNueva)){
            //Si la especialidad antigua y la nueva son diferentes entonces la guarda.
            doc.setEspecialidad(especialidadNueva);
            System.out.println("El cardiólogo ahora tiene la especialidad de: " + especialidadNueva);
        }else{
            System.out.println("Especialidad existente, no es necesario actualizar.");
        }
    }

    public void dentistaEdit(String ID){
        Dentista doctor = (Dentista) almacenDoctor.getDoctores(ID);
        String especialidadAntigua = doctor.getEspecialidad();
        System.out.print("""
                ¿A que especialidad quieres actualizar?
                1.Odontopediatría
                2.Ortodoncia.
                3.Maxilofacial.
                """);
        int opcionDent = sc.nextInt();
        String especialidadNueva = "";
        switch(opcionDent){
            case 1 -> especialidadNueva = "Odontopediatría";
            case 2 -> especialidadNueva = "Ortodoncia";
            case 3 -> especialidadNueva = "Maxilofacial";
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        //Validamos que la especialidad seleccionada no sea la misma
        if(!especialidadAntigua.equals(especialidadNueva)){
            //Si es diferente entonces se guarda.
            doctor.setEspecialidad(especialidadNueva);
            System.out.println("El dentista ahora tiene la especialidad de: " + especialidadNueva);
        }else{
            System.out.println("Especialidad ya existente.\nNo se guardo, se converso la antigua.");
        }
    }
    //Pediatria
    public void pediatriaEdit(String ID){
        Pediatra doctor = (Pediatra) almacenDoctor.getDoctores(ID);
        sc.nextLine();
        String rangoAntiguo = doctor.getRangoEdad();
        System.out.print("""
                Para poder guardar un nuevo rango de edad debes ingresar\s
                la edad de inicio y la edad final ejemplo:
                edadInicial - edadLimite
               \s""");
        System.out.print("Ingrese el nuevo rango de edad: ");
        String rangoNuevo = sc.nextLine();
        //Ahora se compara de que no sea el mismo valor ingresado.
        if(!rangoAntiguo.equals(rangoNuevo)){
            //Si no es el mismo entonces guardamos
            doctor.setRangoEdad(rangoNuevo);
            System.out.println("El pediatra ahora atiende a niños con edad de: " + rangoNuevo);
        }else{
            System.out.println("Ya cuenta con ese rango de edad.");
        }
    }
    //Medico general.
    public void medicoEditar(String ID){
        MedicoGeneral doctor = (MedicoGeneral) almacenDoctor.getDoctores(ID);
        boolean estadoUrgencias = doctor.getAtiendeUrgencias();
        System.out.print("""
                ¿Quieres cambiar el estado de atender urgencias.?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 ->{
                //Cambiamos el valor de la urgencia
                boolean estadoCambiado = !estadoUrgencias;
                doctor.setAtiendeUrgencias(estadoCambiado);
                String queAtiende = (estadoCambiado) ? "Si" : "No";
                System.out.println("El medico " + queAtiende + " atiende urgencias.\n");
            }
            case 2 -> {
                System.out.println("Se conservara el estado actual.\n");
                return;
            }
            default ->{
                System.out.println("Seleccione una opción correcta.\n");
                return;
            }
        }
    }
//===================== ELIMINAR DOCTORES ========================

    /**
     * Esta funcion es para eliminar los datos del Doctor.
     * Pero como tal no se eliminara solo se cambiara el ID ya si eliminamos el objeto y ubicacion del
     * HashMap borraremos los datos en citas, por lo que es mejor cambiar el ID por uno totalmente diferente
     * o con una referencia especifica.
     * @param existenDocs : Este parametro funciona para validar que existen o no doctores en el HashMap.
     */
    public void eliminarDoctores(boolean existenDocs) {
        if(existenDocs){
            sc.nextLine();
            //Si existen entonces procedemos con eliminar datos.
            System.out.print("Ingrese el ID del doctor: ");
            String ID = sc.nextLine();
            Doctor doctorDatos = almacenDoctor.getDoctores(ID);
            if(doctorDatos != null){
                //Si es diferente a null osea que si es el objeto Doctor entonces seguimos con la eliminación.
                System.out.println("Estas seguro de eliminar al doctor. \n" +
                        doctorDatos.mostrarDatos() +
                        "\nSi lo quieres eliminar presiona.\n" +
                        "1.Eliminar.\n" +
                        "2.Conservar.\n");
                int opcion = sc.nextInt();
                switch(opcion){
                    case 1 ->{
                        String IDCambiado = doctorDatos.getID() + "_DEL";
                        doctorDatos.setID(IDCambiado);
                        System.out.println("El Doctor se ha eliminado.\n");
                    }
                    case 2 -> System.out.println("El doctor se conservara.\n");
                    default ->System.out.println("Ingrese una opcion correcta.\n");
                }
            }else{
                System.out.println("No se encontro doctor con ese ID.\nIngrese uno existente.\n");
            }
        }else{
            System.out.println("No hay datos registrados de doctores.");
        }
    }

//===================== VALIDACIONES EXTRA =====================

}
