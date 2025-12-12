package Sistema_De_Citas_Medicas;

import Sistema_De_Citas_Medicas.Servicios.PacienteServicios;

import java.util.Scanner;

public class Principal {
    //Acceso a las diferentes clases de servicios.
    static PacienteServicios pacientes = new PacienteServicios();
    //Menu principal para la generacion de citas medícas, agregar pacientes y doctores
    public static void main(String [] args){
        boolean acceso = true;
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while(acceso){
            try{
                System.out.print("""
                        Bienvenido al hospital.
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
                    case 2 -> {}
                    case 3 -> {pacientes.opcionesPacientes();}
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
}
