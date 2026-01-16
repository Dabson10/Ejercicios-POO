package Gestor_De_Biblioteca_7;

import Gestor_De_Biblioteca_7.Almacenamiento.*;
import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Libro;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Estudiante;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Profesor;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.PublicoGeneral;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;
import Gestor_De_Biblioteca_7.servicios.LibroServicios;
import Gestor_De_Biblioteca_7.servicios.PersonaServicios;
import Gestor_De_Biblioteca_7.servicios.PrestamoServicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    //Atributos para llamar a las diferentes clases ya sean de almacenamiento o de servicio
    //Usuario y Bibliotecario
    UsuarioAlmacenamiento almacenPersonas = new UsuarioAlmacenamiento();
    BibliotecarioAlmacenamiento almacenBiblio = new BibliotecarioAlmacenamiento();
    PersonaServicios servicioPersonas = new PersonaServicios(almacenPersonas, almacenBiblio);
    //Libro y Ejemplares.
    LibroAlmacen libroAlmacen = new LibroAlmacen();
    EjemplarAlmacen ejemplarAlmacen = new EjemplarAlmacen();
    LibroServicios servicioLibros = new LibroServicios(ejemplarAlmacen, libroAlmacen);
    //Prestamos
    PrestamoAlmacen prestamoAlmacen = new PrestamoAlmacen();
    PrestamoServicios prestamoServicios = new PrestamoServicios(ejemplarAlmacen, almacenPersonas, prestamoAlmacen);
    //Libro
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean acceso = true;
        Principal principal = new Principal();
        principal.agregarDatos();
        while (acceso) {
            try {
                acceso = principal.menuPrincipal(acceso);
            } catch (InputMismatchException tipos) {
                System.out.println("Error del tipo: " + tipos.getMessage());
                System.out.println("Ingrese datos correctamente.");
                principal.sc.nextLine();
            }
        }
    }

    //Otros metodos necesarios para ejecutar correctamente la biblioteca.
    public void validarCorreo() {

    }

    public boolean menuPrincipal(boolean acceso) {
        try {
            System.out.print("""
                    
                    Bienvenido a la biblioteca.
                    ¿Que sección deseas acceder?
                    1.Bibliotecarios o usuarios.
                    2.Libros y Ejemplares.
                    3.Prestamos.
                    4.Salir.
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> servicioPersonas.menuPersonas();
                case 2 -> servicioLibros.menuLibros();
                case 3 -> prestamoServicios.menuPrestamos();
                case 4 -> {
                    System.out.println("Hasta luego.");
                    acceso = false;
                }
                default -> System.out.println("Ingrese una opción correcta.");
            }
        } catch (InputMismatchException tipos) {
            System.out.println("Error del tipo: " + tipos.getMessage());
            System.out.println("Ingrese datos correctamente.\n");
            sc.nextLine();
        }
        return acceso;
    }
    //Esta función servirá para agregar datos iniciales.

    public void agregarDatos() {
        //Datos de libros.
        Libro libro = new Libro("Los juegos del hambre", "Suzanne C", "978-607-400-450", "Fantasia");
        libroAlmacen.setLibroAlmacen("978-607-400-450", new Libro("Los juegos del hambre", "Suzanne C", "978-607-400-450", "Fantasia"));
        ejemplarAlmacen.setEjemplarAlmacen("LOS_0001", new Ejemplar("LOS_0001", libro));
        ejemplarAlmacen.setEjemplarAlmacen("LOS_0002", new Ejemplar("LOS_0002", libro));
        ejemplarAlmacen.setEjemplarAlmacen("LOS_0003", new Ejemplar("LOS_0003", libro));
        ejemplarAlmacen.setEjemplarAlmacen("LOS_0004", new Ejemplar("LOS_0004", libro));
        ejemplarAlmacen.setEjemplarAlmacen("LOS_0005", new Ejemplar("LOS_0005", libro));

        // --- LIBRO 1: Harry Potter y la Piedra Filosofal ---
        libro = new Libro("Harry Potter y la Piedra Filosofal", "J.K. Rowling", "978-847-888-445", "Fantasia");
        libroAlmacen.setLibroAlmacen("978-847-888-445", libro);
        ejemplarAlmacen.setEjemplarAlmacen("HAR_0001", new Ejemplar("HAR_0001", libro));
        ejemplarAlmacen.setEjemplarAlmacen("HAR_0002", new Ejemplar("HAR_0002", libro));
        ejemplarAlmacen.setEjemplarAlmacen("HAR_0003", new Ejemplar("HAR_0003", libro));

// --- LIBRO 2: El Principito ---
        libro = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-970-718-208", "Literatura Infantil");
        libroAlmacen.setLibroAlmacen("978-970-718-208", libro);
        ejemplarAlmacen.setEjemplarAlmacen("PRI_0001", new Ejemplar("PRI_0001", libro));
        ejemplarAlmacen.setEjemplarAlmacen("PRI_0002", new Ejemplar("PRI_0002", libro));

// --- LIBRO 3: 1984 ---
        libro = new Libro("1984", "George Orwell", "978-849-989-094", "Distopía");
        libroAlmacen.setLibroAlmacen("978-849-989-094", libro);
        ejemplarAlmacen.setEjemplarAlmacen("198_0001", new Ejemplar("198_0001", libro));
        ejemplarAlmacen.setEjemplarAlmacen("198_0002", new Ejemplar("198_0002", libro));
        ejemplarAlmacen.setEjemplarAlmacen("198_0003", new Ejemplar("198_0003", libro));

        //Usuarios nuevos
        almacenPersonas.setPersonasAlmacen("EST_0001", new Estudiante("EST_0001", "Pedro Pistolas","Meza","pedro@gmail.com", "7894561"));
        almacenPersonas.setPersonasAlmacen("PRO_0002", new Profesor("PRO_0002", "Hector","Herrera Hernandez","tripleH@gmail.com", "8541236"));
        almacenPersonas.setPersonasAlmacen("GEN_0003", new PublicoGeneral("GEN_0003", "Alvaro","Higüain","alvaro@gmail.com", "12345741"));
        almacenPersonas.setPersonasAlmacen("EST_0004", new Estudiante("EST_0004", "Lucía", "Luna", "lucia.luna@gmail.com", "9512357"));
        almacenPersonas.setPersonasAlmacen("EST_0005", new Estudiante("EST_0005", "Beatriz", "Beltrán", "b_beltran@gmail.com", "7531598"));
        almacenPersonas.setPersonasAlmacen("PRO_0006", new Profesor("PRO_0006", "Carlos", "Casemiro", "carlos_case@gmail.com", "4567891"));
        almacenPersonas.setPersonasAlmacen("PRO_0007", new Profesor("PRO_0007", "Diana", "Duarte", "diana.prof@gmail.com", "1594826"));
        almacenPersonas.setPersonasAlmacen("GEN_0008", new PublicoGeneral("GEN_0008", "Fernando", "Fazio", "fer_fazio@gmail.com", "3578461"));
        almacenPersonas.setPersonasAlmacen("GEN_0009", new PublicoGeneral("GEN_0009", "Gabriela", "Guevara", "gaby_guevara@gmail.com", "2583691"));
        //Proceso para que un usuario solicite algún ejemplar
        Usuario estudiante = almacenPersonas.getUsuariosAlmacen("EST_0001");
        Ejemplar ejemplar1 = ejemplarAlmacen.getEjemplar("198_0003");
        ejemplar1.disponibilidad();
        Ejemplar ejemplar2 = ejemplarAlmacen.getEjemplar("HAR_0001");
        ejemplar2.disponibilidad();
        Ejemplar ejemplar3 = ejemplarAlmacen.getEjemplar("PRI_0002");
        ejemplar3.disponibilidad();

        estudiante.setLibrosPrestados(ejemplar1);
        estudiante.setLibrosPrestados(ejemplar2);
        estudiante.setLibrosPrestados(ejemplar3);

    }
}
