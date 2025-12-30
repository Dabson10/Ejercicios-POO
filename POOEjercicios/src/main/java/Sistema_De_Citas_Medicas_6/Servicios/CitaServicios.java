package Sistema_De_Citas_Medicas_6.Servicios;

import Sistema_De_Citas_Medicas_6.Almacenamiento.CitaAlmacenamiento;
import Sistema_De_Citas_Medicas_6.Almacenamiento.DoctorAlmacenamiento;
import Sistema_De_Citas_Medicas_6.Almacenamiento.PacienteAlmacenamiento;
import Sistema_De_Citas_Medicas_6.Modelos.*;
import Sistema_De_Citas_Medicas_6.Utilidades.GeneradorID;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CitaServicios {
    //Objeto para almacenar conectar con la clase CitaAlmacenamiento
    private CitaAlmacenamiento almacenCita;
    Scanner sc = new Scanner(System.in);
    //Objeto para comunicarse con DoctorAlmacenamiento
    private DoctorAlmacenamiento almacenDoctor;
    //Objeto para comunicarse con PacienteAlmacenamiento
    private PacienteAlmacenamiento almacenPaciente;

    GeneradorID generadorID = new GeneradorID();

    public CitaServicios(CitaAlmacenamiento almacenCita, DoctorAlmacenamiento almacenDoctor, PacienteAlmacenamiento almacenPaciente) {
        this.almacenCita = almacenCita;
        this.almacenDoctor = almacenDoctor;
        this.almacenPaciente = almacenPaciente;
    }

    //============ MENU DE CITAS MEDICAS =============
    public void menuCitas() {
        boolean existenCitas = almacenCita.existenCitas();
        System.out.println("""
                |==== CITAS MEDICAS ====|
                ¿Qué deseas realizar?
                1.Mostrar Citas.
                2.Crear Citas.
                3.Cambiar estado de citas.
                """);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> menuMostrarCitas(existenCitas);
            case 2 -> crearCitas();
            case 3 -> menuEstados(existenCitas);
            default -> {
                System.out.println("Ingrese una opción correcta.");
                return;
            }
        }
    }

    // ================ Mostrar Citas =============
    public void menuMostrarCitas(boolean existen) {
        if (existen) {
            System.out.println("""
                    ¿Comó deseas ver las citas medicas?
                    1.Mostrar todas.
                    2.Buscar por ID.
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> almacenCita.mostrarTodas();
                case 2 -> mostrarPorID();
                default -> {
                    System.out.println("Ingrese una opción correcta.\n");
                    return;
                }
            }
        } else {
            System.out.println("No hay citas medicas guardadas.");
        }
    }

    public void mostrarPorID() {
        sc.nextLine();
        System.out.print("Ingrese el ID de la cita: ");
        String ID = sc.nextLine();
        Cita cita = almacenCita.getCita(ID);
        //Si es diferente entonces muestra los datos de la cita médica.
        if (cita != null) {
            System.out.println(cita.mostrarCita());
        } else {
            System.out.println("Ingrese una cita médica existente.");
        }
    }


    //================ Crear Citas =============
    public void crearCitas() {
        //Variable para la fecha de la cita.
        LocalDate citaFecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = citaFecha.format(formato);
        String motivo = "";
        String ID = "";
        sc.nextLine();
        //======= Obtener ID del paciente
        System.out.print("Ingrese el ID del paciente: ");
        String pacienteID = sc.nextLine();
        Paciente paciente = almacenPaciente.getPaciente(pacienteID);
        //Si el paciente existe procede, si no entonces termina de pedir datos.
        if (paciente != null) {
            System.out.println(paciente.mostrarDatos());
        } else {
            System.out.println("Ingrese un paciente existente.\n");
            return;
        }
        //============== Cuando sera la cita medica.
        System.out.print("""
                ¿Cuando sera la cita medica?
                1.Hoy.
                2.Mañana.
                3.En tres dias.
                """);
        int opcionDay = sc.nextInt();
        switch (opcionDay) {
            case 1 -> fecha = citaFecha.plusDays(1).format(formato);
            case 2 -> fecha = citaFecha.plusDays(2).format(formato);
            case 3 -> fecha = citaFecha.plusDays(3).format(formato);
            default -> {
                System.out.print("Ingrese una opción correcta.\n");
                return;
            }
        }
        System.out.println("La cita sera el dia: " + fecha);

        //========== Motivo de la cita medica.
        sc.nextLine();
        System.out.print("Ingrese el motivo de la cita: ");
        motivo = sc.nextLine();
        //Generación del ID de la cita.
        ID = citaID();
        System.out.println("El ID de la cita es: " + ID);
        //Esta función contendrá todas las áreas médicas.
        seleccionarArea(ID, paciente, fecha, motivo);

    }

    //Para que la función principal no se alargue, esta función servirá para eso, contener una gran parte de esta
    public void seleccionarArea(String citaID, Paciente paciente, String fecha, String motivo) {
        System.out.print("""
                ¿Para que area sera la cita medica?
                1.Cardiólogos.
                2.Dentistas.
                3.Pediatría.
                4.Medico General.
                """);
        int opcion = sc.nextInt();
        switch (opcion) {
            //Función para buscar a los cardiólogos
            case 1 -> buscarCardiologo(citaID, paciente, fecha, motivo);
            //Función para buscar a los dentistas
            case 2 -> buscarDentista(citaID, paciente, fecha, motivo);
            //Función para buscar a los pediatras.
            case 3 -> buscarPediatras(citaID, paciente, fecha, motivo);
            //Función para buscar a los medicos generales.
            case 4 -> buscarMedicosGen(citaID, paciente, fecha, motivo);
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
    }

    //Función para buscar a doctores mediante lo que si y lo que no hace.
    public void buscarCardiologo(String citaID, Paciente paciente, String fecha, String motivo) {
        //Variables que se usaran.
        boolean urgencia;
        String buscaCard;
        System.out.print("""
                ¿Que tipo de cardiólogo buscas?
                1.Cardiología Clinica.
                2.Cardiología Intervencionista.
                3.Cardiología Electrofisiológica.
                """);
        int opcionCard = sc.nextInt();

        switch (opcionCard) {
            case 1 -> buscaCard = "Cardiología Clinica";
            case 2 -> buscaCard = "Cardiología Intervencionista";
            case 3 -> buscaCard = "Cardiología Electrofisiológica";
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        System.out.print("""
                ¿La cita es urgente?
                1.Si
                2.No.
                """);
        int opcUrgencia = sc.nextInt();
        urgencia = opcUrgencia == 1;
        //Ahora se buscará un doctor específicamente un cardiólogo que cumpla con las necesidades de la cita.
        almacenDoctor.buscarCardiologo(urgencia, buscaCard);
        sc.nextLine();
        //Ahora que se muestra el cardiologo entonces se selecciona uno conforme a su ID y especialidad.
        System.out.print("Ingrese el ID del cardiólogo que atenderá: ");
        String ID = sc.nextLine();
        almacenDoctor.getDoctores(ID);
        //======= Obtención del ID del doctor
        //Después que se mostró a los doctores, se seleccionara uno, esto si o si se repetirá por qué se obtendrá cada objeto de cada clase
        boolean existe = validarArea("CAR", ID);
        if (existe) {
            Cardiologo cardiologo = (Cardiologo) almacenDoctor.getDoctores(ID);
            System.out.println(cardiologo.mostrarDatos());
            //===== Se guardan los datos de la cita medica.
            float costoCita = cardiologo.costeCitaExtra(urgencia, buscaCard);
            almacenCita.setCitas(citaID, new Cita(citaID, paciente, cardiologo, fecha, costoCita, motivo));
            //Ahora se realiza una validación para saber si se creó la cita medíca.
            boolean citaCreada = almacenCita.encontrarCita(citaID);
            if (citaCreada) {
                //Si se encontró la cita entonces al paciente le agregamos la fecha en la que asistirá.
                paciente.setHistorialConsultas(fecha, motivo);
                System.out.println("Cita creada correctamente.");
            }


        } else {
            System.out.print("Ingrese un ID de cardiólogo.\n");
        }

    }

    //Busca a todos los dentistas.
    public void buscarDentista(String citaID, Paciente paciente, String fecha, String motivo) {
        String especialidad;
        System.out.print("""
                ¿Qué especialidad buscas?
                1.Odontopediatría
                2.Ortodoncia.
                3.Maxilofacial.
                """);
        int opcionDent = sc.nextInt();
        switch (opcionDent) {
            case 1 -> especialidad = "Odontopediatría";
            case 2 -> especialidad = "Ortodoncia";
            case 3 -> especialidad = "Maxilofacial";
            default -> {
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        //Se buscan a los doctores en esa area
        almacenDoctor.buscarDentistas(especialidad);
        sc.nextLine();
        //Se guarda la cita medica.
        System.out.print("Ingrese el ID del dentista: ");
        String ID = sc.nextLine();
        boolean existe = validarArea("DEN", ID);
        if (existe) {
            Dentista dentista = (Dentista) almacenDoctor.getDoctores(ID);
            float costoCita = dentista.costeCitaExtra(false, especialidad);
            almacenCita.setCitas(citaID, new Cita(citaID, paciente, dentista, fecha, costoCita, motivo));
            boolean citaCreada = almacenCita.encontrarCita(citaID);
            if (citaCreada) {
                //Si se encontró la cita entonces al paciente le agregamos la fecha en la que asistirá.
                paciente.setHistorialConsultas(fecha, motivo);
                System.out.println("Cita creada correctamente.");
            }
        } else {
            System.out.print("Ingreso un ID de Dentista.");
        }
    }

    //Busca a todos los Pediatras
    public void buscarPediatras(String citaID, Paciente paciente, String fecha, String motivo) {
        System.out.print("Ingrese la edad del niño: ");
        int edad = sc.nextInt();
        System.out.print("""
                ¿La cita es una urgencia?
                1.Si.
                2.No.
                """);
        int opcionU = sc.nextInt();
        //Si la opcion es igual a 1 entonces guardara un true, si no un false.
        boolean urgencia = opcionU == 1;
        //Ahora buscamos al paciente.
        almacenDoctor.buscarPediatras(edad, urgencia);
        sc.nextLine();
        System.out.print("Ingrese el ID del doctor: ");
        String ID = sc.nextLine();
        boolean existe = validarArea("PED", ID);

        if (existe) {
            Pediatra pediatra = (Pediatra) almacenDoctor.getDoctores(ID);
            //En la siguiente line solo se ocupa la urgencia para saber cuanto se cobrara, ya que pediatría no tiene
            float costoCita = pediatra.costeCitaExtra(urgencia, "");
            almacenCita.setCitas(citaID, new Cita(citaID, paciente, pediatra, fecha, costoCita, motivo));
            boolean citaCreada = almacenCita.encontrarCita(citaID);
            if (citaCreada) {
                //Si se encontró la cita entonces al paciente le agregamos la fecha en la que asistirá.
                paciente.setHistorialConsultas(fecha, motivo);
                System.out.println("Cita creada correctamente.");
            }
        } else {
            System.out.print("Ingrese un ID de Pediatría.\n");
        }
    }

    //Busca a todos los medicos generales.
    public void buscarMedicosGen(String citaID, Paciente paciente, String fecha, String motivo) {
        boolean urgencias = false;
        System.out.print("""
                ¿Es una cita con urgencias?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        urgencias = (opcion == 1);
        almacenDoctor.buscarMedicosGen(urgencias);
        sc.nextLine();
        System.out.print("Ingrese el ID del medico general: ");
        String ID = sc.nextLine();
        boolean existe = validarArea("MED", ID);
        if (existe) {
            MedicoGeneral medico = (MedicoGeneral) almacenDoctor.getDoctores(ID);
            float costoCita = medico.costeCitaExtra(urgencias, "");
            almacenCita.setCitas(citaID, new Cita(citaID, paciente, medico, fecha, costoCita, motivo));
            boolean citaCreada = almacenCita.encontrarCita(citaID);
            if (citaCreada) {
                //Si se encontró la cita entonces al paciente le agregamos la fecha en la que asistirá.
                paciente.setHistorialConsultas(fecha, motivo);
                System.out.println("Cita creada correctamente.");
            }
        } else {
            System.out.print("Ingrese un ID de un medico general.\n");
        }

    }

    //Esta función sirve para obtener datos fundamentales de la cita y asi poder generarlo,
    //está declarada en la parte de crear cita, se crea para no tener tanto código en la
    //función se crea.
    public String citaID() {
        Cita cita = almacenCita.ultimaCita();
        String IDCita = "";
        if (cita != null) {
            //Si es diferente a null significa que si se obtuvo el objeto de cita, por lo que
            //existe un objeto y podemos tomar el ID de este.
            int numero = Integer.parseInt(cita.getCitaID().substring(4, 8));
            IDCita = generadorID.generarID(numero + 1, "CITA");
        } else {
            IDCita = generadorID.generarID(1, "CITA");

        }
        return IDCita;
    }

    //=========== CAMBIAR ESTADO DE CITAS MEDICAS ===========
    public void menuEstados(boolean existen) {
        if (existen) {
            sc.nextLine();
            System.out.print("Ingrese el ID de la cita medica: ");
            String ID = sc.nextLine();
            Cita citaEdit = almacenCita.getCita(ID);
            if (citaEdit != null) {
                System.out.print("""
                        ¿Que acción deseas hacer con las citas.?
                        1.Completar cita.
                        2.Cancelar cita.
                        """);
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> completarCita(citaEdit);
                    case 2 -> cancelarCita(citaEdit);
                    default -> {
                        System.out.println("Ingrese una opción correcta.\n");
                        return;
                    }
                }
            } else {
                System.out.println("No se encontró la cita medica. Ingrese una existente.");
            }
        } else {
            System.out.println("No hay citas guardadas.\n");
        }
    }

    public void completarCita(Cita cita) {
        System.out.print("""
                ¿Durante la cita medica ocurrieron gastos extras?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        boolean extras = (opcion == 1);
        if (extras) {
            sc.nextLine();
            //Si es true entonces si hubo algún gasto extra.
            System.out.print("Cual es la razón del monto extra: ");
            String razonMontoExtra = sc.nextLine();
            System.out.print("Ingrese el monto extra: ");
            float montoExtra = sc.nextInt();
            //Guardamos el monto extra y cambiamos el estado de la cita medíca.

            if (cita.completarCita()) {
                cita.actualizarMontosExtras(razonMontoExtra, montoExtra);
                System.out.println("La cita medica se completo.");
            } else {
                System.out.println("No se pudo completar la cita medica.");
            }
        } else {
            //No hubo ningún gasto extra.
            if (cita.completarCita()) {
                cita.actualizarMontosExtras("nada", 0);
                System.out.println("Se completo la cita medica.");
            }
        }
    }

    public void cancelarCita(Cita cita) {
        System.out.print("""
                ¿Estas seguro de cancelar la cita?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        boolean acceso = (opcion == 1);
        if (acceso) {
            sc.nextLine();
            //Si es true entonces se cancelará sin antes preguntar ¿por qué?
            System.out.println("¿Cual es la razón de la cancelación?");
            String razonCancelar = sc.nextLine();
            if (cita.cancelarCita()) {
                //Si regresa un true entonces actualizamos
                cita.setRazonCancelacion(razonCancelar);
                System.out.println("Se cancelo la cita medica.");
            } else {
                System.out.println("No se cancelo la cita medica.\n");
                return;
            }
        } else {
            System.out.println("No se cancelo la cita medica.");
        }
    }

    //================= VALIDACIÓN DE Doctores ==============

    /**
     * Esta funcion es necesaria para que no existan errores, o que ingrese un ID incorrecto.
     *
     * @param area : El área será dinamico, ya que cuando se ingrese podra ser "MED", "CAR", "PED", "DEN".
     * @param ID   : El ID sirve para validar que si el ID corresponde a esa área, si no sale un error.
     * @return : regresará un valor booleano con base a la validación del doctor
     */
    public boolean validarArea(String area, String ID) {
        String doctorID = ID.substring(0, 4);
        //Regresará un valor booleano en este caso si el ID del doctor contiene el rasgo especificado ya sea "MED", "CAR", "PED", "DEN".
        return doctorID.contains(area);
    }
}
