package Gestion_de_Consesionario;

import Gestion_de_Consesionario.Vehiculos.Camioneta;
import Gestion_de_Consesionario.Vehiculos.Cuatrimoto;
import Gestion_de_Consesionario.Vehiculos.Deportivo;
import Gestion_de_Consesionario.Vehiculos.Moto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        List<Vehiculo> vehiculos = new ArrayList<>();
        HashMap<String, Vehiculo> vehiculos = new HashMap<>();
        boolean acceso = true;
        int opcion = 0;
        while (acceso) {
            try {
                System.out.print("""
                        ¿Cual opción deseas realizar?
                        1.Mostrar vehiculos.
                        2.Agregar Vehiculos.
                        3.Actualizar vehiculos.
                        4.Eliminar vehiculos.
                        5.salir.
                        """);
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                        //Opcion para mostrar los vehiculos
                        mostrarVehiculos(sc, vehiculos);
                    }
                    case 2 -> {
                        //Opcion para agregar vehiculos
                        agregarVehiculos(sc, vehiculos);
                    }
                    case 3 -> {
                        //Opcion para actualizar vehiculos
                        actualizarVehiculos(sc, vehiculos);
                    }
                    case 4 -> {
                        //Opcion para eliminar vehiculos
                        eliminarVehiculos(sc, vehiculos);
                    }
                    case 5 -> {
                        //Opcion para salir del programa.
                        acceso = false;
                        sc.close();
                        System.out.println("Hasta luego");
                    }
                    default -> System.out.println("Favor de ingresar una opcion existente.");
                }
            } catch (Exception e) {
                System.out.println("Error del tipo: " + e.getMessage());
            }
        }

    }

    //Funciones CRUD
    public static void mostrarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {

    }

    public static void agregarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {
        int cantidadVehiculos = 0;
        boolean esVacia = false;
        String marca = "", modelo = "";
        //Variables para poder guardar datos, no todas se usarán.
        int tipoDeVehiculo = 0, fechaSalida = 0, disponibles = 0;
        float precio = 0f;

        System.out.println("========= Agregar vehículos =========");
        System.out.print("¿Cuantos vehiculos desea agregar?: ");
        cantidadVehiculos = sc.nextInt();

        //Si el hashMap está vacío entonces cambia el valor, provocando otra situación de búsqueda.
        if (vehiculos.isEmpty()) {
            esVacia = true;
        }

        if (esVacia) {
            //Aqui puede existir un error si no se maneja algún tipo de bucle, por esto mismo,
            //es necesario manejar un tipo de excepcion para que te regrese a la parte en la que fue el error,
            //obviamente acompañado de un bucle while, como en el inicio.
            boolean registroValido = true;
            while (registroValido) {
                try {
                    //Aquí agrego el codigo de agregar datos. Y resto en uno la cantidad total
                    System.out.println("Ingrese la marca: ");
                    marca = sc.nextLine().trim();
                    System.out.print("Ingrese el modelo: ");
                    modelo = sc.nextLine().trim();
                    System.out.println("Ingrese la fecha de lanzamiento: ");
                    fechaSalida = sc.nextInt();
                    System.out.println("Ingrese el precio unitario: ");
                    precio = sc.nextFloat();
                    System.out.println("Cantidades disponibles: ");
                    disponibles = sc.nextInt();
                    System.out.print("""
                            ¿Qué tipo de vehiculo agregaras?
                            1.Camioneta.
                            2.Deportivo.
                            3.Cuatrimoto.
                            4.Moto.
                            """);
                    tipoDeVehiculo = sc.nextInt();
                    agregarPrimerVehiculo(tipoDeVehiculo, marca, modelo, fechaSalida, precio, disponibles, vehiculos, sc);
                    //Switch con opciones que mandan a las otras funciones, que recibiran de parametro los datos antes solicitados.
                    cantidadVehiculos--;
                } catch (Exception e) {
                    System.out.println("Error al agregar el primer vehiculo: " + e.getMessage());
                }
            }
        }

        //Prosigo con el guardado de datos.
        for (int i = 0; i < cantidadVehiculos; i++) {
            //Aquí usare lambdas con foreach y asi comparar, se usarán más de una vez
            System.out.println("Agregaras el vehiculo: " + i);
        }
    }
    //Sub funciones de agregarVehiculos, en este se agregaran los vehiculos de una forma d

    //Funcion para cuando es el primer registro, solo se usa una vez
    public static void agregarPrimerVehiculo(int tipoDeVehiculo, String marca, String modelo,
                                             int fechaSalida, float precio, int disponibles,
                                             HashMap<String, Vehiculo> vehiculos, Scanner sc) {

        /**
         * No se te olvide en pensar sobre cambiar esta funcion a booleana, mas que nada para evitar
         * errores y que el bucle no se haga infinito.
         * ==========================================
         * Tambien puedes crear una sola variable llamada opcionVehiculo, en la que guardaras que tipo
         * es ya sea una moto, una cuatrimoto, deportivo sin la necesidad de andar creando variables por crear.
         */
        switch (tipoDeVehiculo) {
            case 1 -> {
                //Camioneta
                int limiteDePasajeros = 0, pesoMaximo = 0;
                System.out.print("Limite de pasajeros: ");
                limiteDePasajeros = sc.nextInt();
                System.out.print("Limite de carga o peso: ");
                pesoMaximo = sc.nextInt();

                vehiculos.put(marca, new Camioneta(marca, modelo, fechaSalida, precio, disponibles, limiteDePasajeros, pesoMaximo));
            }
            case 2 -> {
                //Deportivo.
                int limiteKM = 0, opcionDeportivo = 0;
                String tipoDeportivo = "";
                System.out.print("Ingrese el limite de kilometro por hora: ");
                System.out.print("""
                        Selecciona que tipo de deportivo es.
                        1.Deportivo.
                        2.Superdeportivo.
                        """);
                opcionDeportivo = sc.nextInt();
                //Operador ternario tipo if-elseif-else, esto para simplificar ya sea un if o un switch solamente
                //para asignar una cadena
                tipoDeportivo = (opcionDeportivo == 1) ? "Deportivo" : (opcionDeportivo == 2)? "Superdeportivo": "ninguno";
                //Hay 3 opciones de cadena y si guarda "ninguno", entonces podemos tomar de ancla para
                //dirigirnos a guardar la info o mostrar una alerta
                if(!tipoDeportivo.equals("ninguno")){
                    //Si es diferente a ninguno entonces procedemos a guardar los datos.
                    vehiculos.put(marca, new Deportivo(marca, modelo, fechaSalida, precio, disponibles, limiteKM, tipoDeportivo));
                }else{
                    System.out.println("Seleccione una opción correcta.");
                }

            }
            case 3 -> {
                //Cuatrimoto
                int pesoMaximo = 0, opcionCuatrimoto = 0;
                String tipoCuatrimoto = "";
                System.out.print("Limite de carga o peso: ");
                System.out.print("""
                        Selecciona que tipo de cuatrimoto es.
                        1.Deportiva.
                        2.Utilitaria.
                        """);
                opcionCuatrimoto = sc.nextInt();

                tipoCuatrimoto = (opcionCuatrimoto == 1)? "Deportiva" : (opcionCuatrimoto == 2)? "Utilitaria" : "ninguno";

                if(!tipoCuatrimoto.equals("ninguno")){
                    //Si es diferente a ninguno entonces procedemos a guardar datos.
                    vehiculos.put(marca, new Cuatrimoto(marca, modelo, fechaSalida, precio, disponibles,pesoMaximo,tipoCuatrimoto));
                }else{
                    System.out.println("Seleccione una opcion correcta.");
                }
            }//Fin opción 3
            case 4 -> {
                //Moto
                String cilindrada = "", tipoDeMoto = "";
                int opcionMoto = 0;
                System.out.print("Ingrese la cilindrada: ");
                System.out.print("""
                        Selecciona que tipo de moto es.
                        1.Chopper.
                        2.Trial Bike.
                        """);
                opcionMoto = sc.nextInt();
                //Asignados un tipo de moto con respecto a la opción.
                tipoDeMoto = (opcionMoto == 1) ? "Chopper" : (opcionMoto == 2) ? "Trial Bike" : "ninguno";
                //Ahora se valida
                if(!tipoDeMoto.equals("ninguno")){
                    //Como es alguno de las opciones, ahora se guarda.
                    vehiculos.put(marca, new Moto(marca, modelo, fechaSalida, precio, disponibles, cilindrada, tipoDeMoto));
                }
            }
            //Posible error aca, ya que si no ingresa una opcion sigue al bucle y si no hay valores, no podra agregar
            //un valor continuo
            default -> System.out.println("Ingrese una opcion valida.");
        }
    }

    //Esta funcion se usara dentro del bucle for, por lo que no repetira la condicion de vehiculos.isEmpty()
    public static void agregarMasValores() {

    }


    public static void actualizarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {

    }

    public static void eliminarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {

    }

}
