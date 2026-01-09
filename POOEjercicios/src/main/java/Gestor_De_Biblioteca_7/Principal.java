package Gestor_De_Biblioteca_7;

import Gestor_De_Biblioteca_7.Almacenamiento.BibliotecarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Almacenamiento.UsuarioAlmacenamiento;
import Gestor_De_Biblioteca_7.servicios.PersonaServicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    //Atributos para llamar a las diferentes clases ya sean de almacenamiento o de servicio
    //Usuario y Bibliotecario
    UsuarioAlmacenamiento almacenPersonas = new UsuarioAlmacenamiento();
    BibliotecarioAlmacenamiento almacenBiblio = new BibliotecarioAlmacenamiento();
    PersonaServicios servicioPersonas = new PersonaServicios(almacenPersonas, almacenBiblio);
    //Libro
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean acceso = true;
        Principal principal = new Principal();
        while(acceso){
            try{
                acceso = principal.menuPrincipal(acceso);
            }catch(InputMismatchException tipos){
                System.out.println("Error del tipo: " + tipos.getMessage());
                System.out.println("Ingrese datos correctamente.");
                principal.sc.nextLine();
            }
        }
    }
    //Otros metodos necesarios para ejecutar correctamente la biblioteca.
    public void validarCorreo(){

    }
    public boolean menuPrincipal(boolean acceso){
        try{
            System.out.print("""
                
                Bienvenido a la biblioteca.
                ¿Que sección deseas acceder?
                1.Bibliotecarios o usuarios.
                2.Libros y Ejemplares.
                3.Prestamos.
                4.Salir.
                """);
            int opcion = sc.nextInt();
            switch(opcion){
                case 1 -> servicioPersonas.menuPersonas();
                case 2 ->{}
                case 3 ->{}
                case 4 ->{
                    System.out.println("Hasta luego.");
                    acceso = false;
                }
                default -> System.out.println("Ingrese una opción correcta.");
            }
        }catch(InputMismatchException tipos){
            System.out.println("Error del tipo: " + tipos.getMessage());
            System.out.println("Ingrese datos correctamente.\n");
            sc.nextLine();
        }
        return acceso;
    }

}
