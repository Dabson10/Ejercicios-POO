package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.CitaAlmacenamiento;
import Sistema_De_Citas_Medicas.Almacenamiento.DoctorAlmacenamiento;

import java.util.Scanner;

public class CitaServicios {
    //Objeto para almacenar conectar con la clase CitaAlmacenamiento
    private CitaAlmacenamiento almacenCita;
//    private DoctorAlmacenamiento almacenDoctor;
    Scanner sc = new Scanner(System.in);
    //Objeto para comunicarse con DoctorAlmacenamiento
    private DoctorAlmacenamiento almacenDoctor;

    public CitaServicios(CitaAlmacenamiento almacenCita, DoctorAlmacenamiento almacenDoctor){
        this.almacenCita = almacenCita;
        this.almacenDoctor = almacenDoctor;
    }

    //============ MENU DE CITAS MEDICAS =============
    public void menuCitas(){
        System.out.println("""
                |==== CITAS MEDICAS ====|
                ¿Qué deseas realizar?
                1.Mostrar Citas.
                2.Crear Citas.
                3.Cambiar estado de citas.
                """);
        int opcion = sc.nextInt();
        switch(opcion){
            case 1 ->{}
            case 2 -> crearCitas();
            case 3 ->{}
            default ->{
                System.out.println("Ingrese una opción correcta.");
                return;
            }
        }
    }

    //================ Crear Citas =============
    public void crearCitas(){
        sc.nextLine();
        System.out.print("Ingrese los datos para generar la cita.");
        System.out.println("""
                ¿Para que area sera la cita medica?
                1.Cardiólogos.
                2.Dentistas.
                3.Pediatría.
                4.Medico General.
                """);
        int opcion = sc.nextInt();
        switch (opcion){
            //Función para buscar a los cardiólogos
            case 1->buscarCardiologo();
            //Función para buscar a los dentistas
            case 2 ->buscarDentista();
            //Función para buscar a los pediatras.
            case 3 ->buscarPediatras();
            //Función para buscar a los medicos generales.
            case 4 ->buscarMedicosGen();
            default ->{
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }


//        System.out.println("Ingrese el ID del paciente: ");
//        System.out.println("Ingresa el ID del doctor: ");

    }
    //Funcion para buscar a doctores mediante lo que si y lo que no hace.
    public void buscarCardiologo(){
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

        switch(opcionCard){
            case 1 -> buscaCard = "Cardiología Clinica";
            case 2 -> buscaCard = "Cardiología Intervencionista";
            case 3 -> buscaCard = "Cardiología Electrofisiológica";
            default ->{
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        System.out.print("""
                ¿La cita es urgente?
                1.Si
                2.No. """);
        int opcUrgencia = sc.nextInt();
        urgencia = opcUrgencia == 1;
        //Ahora se buscara un doctor específicamente un cardiólogo que cumpla con las necesidades de la cita.
        almacenDoctor.buscarCardiologo(urgencia, buscaCard);
        //Ahora que se muestra el cardiologo entonces se selecciona uno conforme a su ID y especialidad.
    }
    //Busca a todos los dentiastas.
    public void buscarDentista(){
        String especialidad ;
        System.out.print("""
                ¿Qué especialidad buscas?
                1.Odontopediatría
                2.Ortodoncia.
                3.Maxilofacial.
                """);
        int opcionDent = sc.nextInt();
        switch(opcionDent){
            case 1-> especialidad = "Odontopediatría";
            case 2 -> especialidad = "Ortodoncia";
            case 3 -> especialidad = "Maxilofacial";
            default ->{
                System.out.println("Ingrese una opción correcta.\n");
                return;
            }
        }
        //Se buscan a los doctores en esa area
        almacenDoctor.buscarDentistas(especialidad);
    }
    //Busca a todos los Pediatras
    public void buscarPediatras(){
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
    }
    //Busca a todos los medicos generales.
    public void buscarMedicosGen(){
        boolean urgencias = false;
        System.out.print("""
                ¿Es una cita con urgencias?
                1.Si.
                2.No.
                """);
        int opcion = sc.nextInt();
        urgencias = (opcion == 1);
        almacenDoctor.buscarMedicosGen(urgencias);
    }
}
