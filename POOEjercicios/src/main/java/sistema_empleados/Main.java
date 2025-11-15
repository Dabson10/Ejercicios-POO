package sistema_empleados;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Dabson
 */
/**
 * Objetivo del proyecto Requisitos: - Clase base: Empleado (nombre, ID, salario
 * base) - Clases hijas: EmpleadoTiempoCompleto (bonos, seguro)
 * EmpleadoMedioTiempo (horas trabajadas, pago por hora) Gerente (departamento,
 * empleados a cargo, bono extra)
 *
 * Funcionalidades: 1. Calcular salario total (diferente para cada tipo) 2.
 * Mostrar información completa 3. Listar todos los empleados 4. Buscar por tipo
 * de empleado
 *
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean acceso = true;
        int opcion = 0;
        while (acceso) {
            try {
                System.out.println("====| Bienvenido al gestor de empleados. |====");
                System.out.println("""
                                   ¿Qué opción desea realizar?
                                   1.Mostrar colaboradores.
                                   2.Agregar colaboradores.
                                   3.Salir.
                                   """);
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                    }
                    case 2 -> {
                    }
                    case 3 -> {
                        System.out.println("Hasta luego.");
                        sc.close();
                    }
                    default -> {
                        System.out.println("Ingrese una opcion correcta.");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error del tipo: " + e.getMessage());
            }
        }

    }

    //Funcionalidades del programa
    //Funcion que mostrara a los colaboradores.
    public static void mostrarColaboradores() {

    }

    //Funcion para agregar colaboradores.
    public static void agregarColaboradores() {

    }

}
