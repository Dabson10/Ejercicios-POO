package Sistema_De_Citas_Medicas;

import Sistema_De_Citas_Medicas.Almacenamiento.CitaAlmacenamiento;
import Sistema_De_Citas_Medicas.Almacenamiento.DoctorAlmacenamiento;
import Sistema_De_Citas_Medicas.Almacenamiento.PacienteAlmacenamiento;
import Sistema_De_Citas_Medicas.Modelos.*;
import Sistema_De_Citas_Medicas.Servicios.CitaServicios;
import Sistema_De_Citas_Medicas.Servicios.DoctorServicios;
import Sistema_De_Citas_Medicas.Servicios.PacienteServicios;

import java.util.Scanner;

public class Principal {
    //Objetos para poder guardar datos desde el incio
    static PacienteAlmacenamiento almacenPacientes = new PacienteAlmacenamiento();
    static DoctorAlmacenamiento almacenDoctores = new DoctorAlmacenamiento();
    static CitaAlmacenamiento almacenCitas = new CitaAlmacenamiento();
    //Acceso a las diferentes clases de servicios.
    static PacienteServicios pacientesServicios = new PacienteServicios(almacenPacientes);
    static DoctorServicios doctoresServicios = new DoctorServicios(almacenDoctores);
    static CitaServicios citasServicios = new CitaServicios(almacenCitas);




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
                    case 1 -> citasServicios.menuCitas();
                    case 2 -> doctoresServicios.menuDoctores();
                    case 3 -> pacientesServicios.opcionesPacientes();
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
        //Objeto para tener diferentes datos de pacientes.
        almacenPacientes.setPacientes("PAC_0001", new Paciente("PAC_0001","Juan David" , "Almaraz Gonzalez", "5540641079", "dabson@gmail.com") );
        almacenPacientes.setPacientes("PAC_0002", new Paciente("PAC_0002","Kevin Tadeo" , "Almaraz Gonzalez", "5559862224", "tadeonegrito@gmail.com"));

        //se guardan diferentes tipos de Doctores.
        // Médicos Generales (MED_0001 a MED_0003)
        almacenDoctores.setDoctores("MED_0001", new MedicoGeneral("MED_0001", "Ana", "López Pérez", 5, "8:00-14:00", true));
        almacenDoctores.setDoctores("MED_0002", new MedicoGeneral("MED_0002", "Roberto", "Gómez Sánchez", 12, "16:00-22:00", false));
        almacenDoctores.setDoctores("MED_0003", new MedicoGeneral("MED_0003", "Carolina", "Díaz Ruiz", 3, "10:00-18:00", true));

        almacenDoctores.setDoctores("PED_0004", new Pediatra("PED_0004", "Miguel", "Torres Castro", 8, "9:00-15:00", "0-14", true));
        almacenDoctores.setDoctores("PED_0005", new Pediatra("PED_0005", "Sofía", "Herrera Mora", 15, "11:00-19:00", "0-18", false));

        almacenDoctores.setDoctores("DEN_0006", new Dentista("DEN_0006", "Juan", "Morales Luna", 10, "14:00-20:00", "Endodoncia"));
        almacenDoctores.setDoctores("DEN_0007", new Dentista("DEN_0007", "Valeria", "Soto Vargas", 6, "7:00-13:00", "Ortodoncia"));


        almacenDoctores.setDoctores("CAR_0008", new Cardiologo("CAR_0008", "Ricardo", "Peña Cruz", 20, "12:00-18:00", "Intervencionista", true));
        almacenDoctores.setDoctores("CAR_0009", new Cardiologo("CAR_0009", "Elena", "Montes Rivas", 9, "9:00-17:00", "Electrofisiología", true));
    }
}
