package Sistema_De_Citas_Medicas;

import Sistema_De_Citas_Medicas.Almacenamiento.DoctorAlmacenamiento;
import Sistema_De_Citas_Medicas.Almacenamiento.PacienteAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.Paciente;
import Sistema_De_Citas_Medicas.Servicios.DoctorServicios;
import Sistema_De_Citas_Medicas.Servicios.PacienteServicios;

import java.util.Scanner;

public class Principal {
    //Objetos para poder guardar datos desde el incio
    static PacienteAlmacenamiento almacenPacientes = new PacienteAlmacenamiento();
    static DoctorAlmacenamiento almacenDoctores = new DoctorAlmacenamiento();
    //Acceso a las diferentes clases de servicios.
    static PacienteServicios pacientesServicios = new PacienteServicios(almacenPacientes);
    static DoctorServicios doctoresServicios = new DoctorServicios(almacenDoctores);




    //Menu principal para la generacion de citas medícas, agregar pacientes y doctores
    public static void main(String [] args){
        guardarPacientes();
        boolean acceso = true;
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(acceso){
            try{
                System.out.print("""
                        \nBienvenido al hospital.
                        ¿Que opción deseas acceder?
                        1.Citas.
                        2.Doctores.
                        3.Pacientes.
                        4.Salir.
                        """);
                opcion = sc.nextInt();
                sc.nextLine();
                switch(opcion){
                    case 1 -> {}
                    case 2 -> doctoresServicios.menuDoctores();
                    case 3 -> {pacientesServicios.opcionesPacientes();}
                    case 4 -> {
                        System.out.println("Hasta luego.");
                        acceso = false;
                        sc.close();
                    }
                    default -> {
                        System.out.println("Ingresa una opción correcta.");
                    }
                }
            }catch(Exception e){
                System.out.println("Error del tipo: " + e.getMessage());
            }
        }
    }

    //Funcion para guardar datos instantaneamente
    public static void guardarPacientes(){
        almacenPacientes.setPacientes("PAC_0001", new Paciente("PAC_0001","Juan David" , "Almaraz Gonzalez", "5540641079", "dabson@gmail.com") );
        almacenPacientes.setPacientes("PAC_0002", new Paciente("PAC_0002","Kevin Tadeo" , "Almaraz Gonzalez", "5559862224", "tadeonegrito@gmail.com"));
    }
}
