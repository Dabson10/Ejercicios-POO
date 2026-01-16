package Gestor_De_Biblioteca_7.servicios;

import Gestor_De_Biblioteca_7.Almacenamiento.EjemplarAlmacen;
import Gestor_De_Biblioteca_7.Almacenamiento.PrestamoAlmacen;
import Gestor_De_Biblioteca_7.Almacenamiento.UsuarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;
import Gestor_De_Biblioteca_7.Modelos.Prestamo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrestamoServicios {
    Scanner sc = new Scanner(System.in);
    //Objeto para almacenamiento
    private PrestamoAlmacen prestamoAlmacen;
    private EjemplarAlmacen ejemplarAlmacen;
    private UsuarioAlmacenamiento usuarioAlmacen;

    public PrestamoServicios(EjemplarAlmacen ejemplarAlmacen, UsuarioAlmacenamiento usuarioAlmacen, PrestamoAlmacen prestamoAlmacen) {
        this.ejemplarAlmacen = ejemplarAlmacen;
        this.usuarioAlmacen = usuarioAlmacen;
        this.prestamoAlmacen = prestamoAlmacen;
    }

    public void menuPrestamos() {
        System.out.println("==========| Bienvenido a la los prestamos |==================");
        int opcion = menuPrestaGen("¿Que acción desear realizar?", "1.Mostrar Prestamos.", "2.Prestar libros.",
                "3.Devolver libro.", "4.Regresar al inicio.");
        switch (opcion) {
            case 1 -> mostrarMenu();
            case 2 -> agregarPrestamo();
            case 3 -> {
            }
            case 4 -> System.out.println("Regresando al menu.");
            default -> System.out.println("Ingrese una opción correcta.");

        }
    }

    //================== MOSTRAR PRESTAMOS ====================

    /**
     * Esta función sirve para poder ver de diferentes formas los tickets de
     * préstamo como obtener los préstamos que ya se devolvieron, los que no y por ID.
     */
    public void mostrarMenu() {
        int mostrarOpc = menuPrestaGen("¿Que prestamos deseas ver?", "1.Deuda de prestamos.", "2.Prestamos cumplidos.",
                "3.Buscar un préstamo.", "4.Regresar al inicio.");
        switch (mostrarOpc) {
            case 1 -> prestamoAlmacen.mostrarPorSeparado(true);
            case 2 -> prestamoAlmacen.mostrarPorSeparado(false);
            case 3 -> mostrarPorID();
            case 4 -> System.out.println("Regresando al inicio.");
            default -> System.out.println("Ingrese una opción correcta.");
        }
    }

    public void mostrarPorID() {
        String ID = obtenerID("préstamo");

        Prestamo prestamo = prestamoAlmacen.getPrestamoAlmacen(ID);
        if(prestamo != null){
            //Si es diferente entonces procedemos a mostrar.
            System.out.println(prestamo.mostrarDatos());
        }else{
            System.out.println("No se encontró el préstamo");
        }
    }

    //=================== AGREGAR PRESTAMOS ===========================\\
    public void agregarPrestamo(){
        sc.nextLine();
        //Obtener el usuario y validar su existencia
        String usuarioID = obtenerID("usuario");
        Usuario usuario = usuarioAlmacen.obtenerUsuario(usuarioID);
        //Valida si el usuario existe
        if(usuario == null){return;}
        //Valída si el usuario puede pedir un libro más.
        if(usuario.validarLimiteLibros()){
            System.out.println("No puedes pedir mas libros." +
                    "\nRegresa los que pediste prestados.");
            return;
        }
        //Valída que el usuario no tenga deudas.

        //Obtener el ejemplar y validación
        String ejemplarID = obtenerID("ejemplar");
        Ejemplar ejemplar = ejemplarAlmacen.getEjemplar(ejemplarID);
        if(ejemplar != null){
            System.out.println("Ejemplar existente");
        }else{
            System.out.println("No se encontró el ejemplar.");
        }


    }

    //=================== DEVOLVER PRESTAMOS ===========================\\

    //=================== Funciones utiles  ===========================
    public int menuPrestaGen(String accion, String opc1, String opc2, String opc3, String opc4) {
        int numero = 0;
        try {
            System.out.println(accion +
                    "\n" + opc1 +
                    "\n" + opc2 +
                    "\n" + opc3 +
                    "\n" + opc4);
            numero = sc.nextInt();
        } catch (InputMismatchException tipos) {
            System.out.println("Ingrese un los datos que le solicitan.");
        }
        return numero;
    }

    public String obtenerID(String area) {
        System.out.print("Ingrese el ID del " + area + ": " );
        return sc.nextLine();
    }


}