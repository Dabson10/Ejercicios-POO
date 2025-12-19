package Sistema_De_Citas_Medicas.Servicios;

import Sistema_De_Citas_Medicas.Almacenamiento.CitaAlmacenamiento;

import java.util.Scanner;

public class CitaServicios {
    private CitaAlmacenamiento almacenCita;
    Scanner sc = new Scanner(System.in);

    public CitaServicios(CitaAlmacenamiento almacenCita){
        this.almacenCita = almacenCita;
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
            case 2 ->{}
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
            case 1->{}
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
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
        boolean urgencia = false;
        String buscaCard = "";
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
        System.out.print("¿La cita es urgente? ");
        int opcUrgencia = sc.nextInt();
        urgencia = opcUrgencia == 1;
        //Ahora se buscara un doctor especificamente un cardiologo que cumpla con las necesidades de la cita.
    }


}
