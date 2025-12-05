package Gestion_de_Concesionario;

import Gestion_de_Concesionario.Vehiculos.Camioneta;
import Gestion_de_Concesionario.Vehiculos.Cuatrimoto;
import Gestion_de_Concesionario.Vehiculos.Deportivo;
import Gestion_de_Concesionario.Vehiculos.Moto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Vehiculo> vehiculos = new HashMap<>();

        //Datos pre creados
        datosIniciales(vehiculos);

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
    //=================================== Datos Iniciales ======================================
    public static void datosIniciales(HashMap<String, Vehiculo> vehiculos){

        vehiculos.put("f8 tributo", new Deportivo("Ferrari", "F8 Tributo", 2019, 300000.50f, 2, 320, "Superdeportivo"));
        vehiculos.put("yzf-r6", new Moto("Yamaha", "YZF-R6", 2020, 15500.99f, 15, "600cc", "Trial Bike"));
        vehiculos.put("ranger", new Camioneta("Ford", "Ranger", 2023, 45000.00f, 8, 5, 1200));
        vehiculos.put("outlander 650", new Cuatrimoto("Can-Am", "Outlander 650", 2024, 12750.00f, 4, 300, "Utilitaria"));

        vehiculos.put("911 carrera", new Deportivo("Porsche", "911 Carrera", 2022, 185900.75f, 6, 280, "Deportivo"));
        vehiculos.put("sls amg", new Deportivo("Mercedes-Benz", "SLS AMG", 2011, 250000.00f, 3, 317, "Alas de Gaviota"));
        vehiculos.put("corvette c8", new Deportivo("Chevrolet", "Corvette C8", 2021, 85000.50f, 7, 312, "Superdeportivo"));
        vehiculos.put("supra mk5", new Deportivo("Toyota", "Supra MK5", 2020, 55000.00f, 10, 250, "Coupe Deportivo"));
        vehiculos.put("gt-r nismo", new Deportivo("Nissan", "GT-R Nismo", 2023, 210000.99f, 2, 330, "Superdeportivo"));

        vehiculos.put("ninja 400", new Moto("Kawasaki", "Ninja 400", 2022, 6099.00f, 20, "400cc", "Deportiva"));
        vehiculos.put("gsx-r1000", new Moto("Suzuki", "GSX-R1000", 2023, 16500.99f, 5, "1000cc", "Superbike"));
        vehiculos.put("africa twin", new Moto("Honda", "Africa Twin", 2021, 14500.50f, 12, "1100cc", "Aventura"));
        vehiculos.put("monster", new Moto("Ducati", "Monster", 2024, 13000.00f, 8, "937cc", "Naked"));

        vehiculos.put("silverado 1500", new Camioneta("Chevrolet", "Silverado 1500", 2024, 58000.00f, 6, 6, 1500));
        vehiculos.put("tacoma", new Camioneta("Toyota", "Tacoma", 2023, 42500.75f, 10, 4, 800));
        vehiculos.put("f-150", new Camioneta("Ford", "F-150", 2022, 65000.99f, 9, 5, 1360));
        vehiculos.put("ram 1500", new Camioneta("Ram", "1500", 2021, 55000.50f, 11, 5, 1050));

        vehiculos.put("raptor 700r", new Cuatrimoto("Yamaha", "Raptor 700R", 2023, 9500.00f, 14, 200, "Deportiva"));
        vehiculos.put("polaris rzr", new Cuatrimoto("Polaris", "RZR Pro R", 2024, 38000.00f, 3, 400, "Side-by-Side"));
        vehiculos.put("fourtrax", new Cuatrimoto("Honda", "FourTrax Recon", 2022, 4800.99f, 18, 150, "Recreativa"));
        vehiculos.put("maverick x3", new Cuatrimoto("Can-Am", "Maverick X3", 2021, 25000.50f, 7, 350, "Deportiva"));
    }

    //Funciones CRUD
    //=================================== Mostrar Datos ======================================
    public static void mostrarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {
        //Opción para mostrar datos.
        System.out.println("===== Mostrar Datos =====");
        if(!vehiculos.isEmpty()){
            int opcionBusqueda = 0;
            //Si no está vacía entonces mostramos los datos.
            System.out.print("""
                    ¿Como deseas ver los datos?
                    1.Todos los productos.
                    2.Ordenados.
                    3.Por categoria.
                    4.Por modelo.
                    """);
            opcionBusqueda = sc.nextInt();
            switch(opcionBusqueda){
                case 1 -> {
                    for(Map.Entry<String, Vehiculo> vehiculo : vehiculos.entrySet()){
                        String modelo = vehiculo.getKey();
                        Vehiculo objeto = vehiculo.getValue();
                        System.out.println(objeto.mostrarDatos());
                    }
                }
                case 2, 3 -> procesoDeDatos(opcionBusqueda, vehiculos, sc);
                case 4 ->{
                    sc.nextLine();
                    String modelo = "";
                    System.out.println("====== Modelos ======");
                    System.out.println("Ingresa el modelo del vehiculo: ");
                    modelo = sc.nextLine();
                    Vehiculo vehiculo = vehiculos.get(modelo.toLowerCase());
                    if(vehiculo != null){
                        //Si es diferente a null, entonces lo mostramos.
                        System.out.println(vehiculo.mostrarDatos());
                    }else{
                        System.out.println("Ingrese un modelo correcto.");
                    }
                }
                default -> System.out.println("Ingresa una opcion correcta.\n");
            }
        }else{
            System.out.println("No hay datos guardados.\n");
        }
    }
    //SubFuncion para mostrar datos.
    public static void procesoDeDatos(int opcionBusqueda, HashMap<String, Vehiculo> vehiculos, Scanner sc){

        HashMap<String, ArrayList<Vehiculo>> conjuntoVehiculos = new HashMap<>();
        ArrayList<Vehiculo> camioneta = new ArrayList<>(), deportivo = new ArrayList<>();
        ArrayList<Vehiculo> cuatrimoto = new ArrayList<>(), moto = new ArrayList<>();

        conjuntoVehiculos.put("Camioneta", camioneta);
        conjuntoVehiculos.put("Deportivo", deportivo);
        conjuntoVehiculos.put("Cuatrimoto", cuatrimoto);
        conjuntoVehiculos.put("Moto", moto);

        //Ahora lo que se realizara es un bucle for el cual recorrerá todo el HashMap y si encuentra
        //un objeto con una clase especifica lo guardara en cierto arraylist, esto dependiendo de la
        //clase y array.
        for(Map.Entry<String, Vehiculo> vehiculo : vehiculos.entrySet()){
            //Obtener el valor de la clase Camioneta.
            if(vehiculo.getValue() instanceof Camioneta){
                camioneta.add( vehiculo.getValue());
            }else if(vehiculo.getValue() instanceof Deportivo){
                //Obtener el valor de la clase Deportivo
                deportivo.add( vehiculo.getValue());
            }else if(vehiculo.getValue() instanceof Cuatrimoto){
                //Obtener el valor de la clase Cuatrimoto
                cuatrimoto.add( vehiculo.getValue());
            }else if(vehiculo.getValue() instanceof Moto){
                //Obtener el valor de la clase Moto
                moto.add( vehiculo.getValue());
            }
        }
        //Esta opcion es para mostrar los datos ordenados.
        if(opcionBusqueda == 2){
            System.out.println("====== Datos Ordenados ======");
            busquedaOrdenada(conjuntoVehiculos);

        }else{
            //Esta opcion es para categorias específicas.
            System.out.println("""
                    ¿Cual categoria quiere ver?
                    1.Camionetas.
                    2.Deportivos.
                    3.Cuatrimotos.
                    4.Motos.
                    """);

            int opcionVehiculo = sc.nextInt();
            String categoria = "";
            switch(opcionVehiculo){
                case 1 ->categoria = "Camioneta";
                case 2 ->categoria = "Deportivo";
                case 3 ->categoria = "Cuatrimoto";
                case 4 ->categoria = "Moto";
                default -> categoria = "ninguno";
            }

            if(!categoria.equals("ninguno")){
                //Si no es ninguno.
                //Para mostrar los datos primero tenemos que recorrer el arraylist.
                //y después se recorre el arraylist
                System.out.println("======= " + categoria + " =======");
                //Recorreremos el HashMap de conjuntoVehiculos
                for(Map.Entry<String, ArrayList<Vehiculo>> categorias : conjuntoVehiculos.entrySet()){
                    //Para encontrar el array que pidio el usuario, solamente debemos comparar el que quiere con
                    //la llave de cada array, hasta que lo encuentre.
                    if(categorias.getKey().equals(categoria)){
                        //Si es igual se recorre.
                        categorias.getValue().forEach(vehiculo ->{
                            System.out.println(vehiculo.mostrarDatos());
                        });
                        //Cuando se terminen de imprimir todos los datos entonces hacemos que el bucle termine,
                        //para que no siga buscando algo que ya encontro.
                        break;
                    }
                }

            }else{
                System.out.println("Favor de seleccionar una opcion correcta.");
            }
        }
    }


    //Función que simplifica los 4 if que recorren
    public static void busquedaOrdenada(HashMap<String, ArrayList<Vehiculo>> categorias){
        //Para mostrar todos los productos por categoria primero debemos de recorrer el HashMap para acceder a cada espacio.
        for(Map.Entry<String, ArrayList<Vehiculo>> categoria : categorias.entrySet()){
            //Teniendo el valor del HashMap ahora tomaremos value para obtener la lista, y si la lista no esta vacia,
            //entonces recorremos la lista mostrando cada dato.
            if(!categoria.getValue().isEmpty()){
                System.out.println("======= " + categoria.getKey() + " =======");
                categoria.getValue().stream()
                        .map(Vehiculo::mostrarDatos)
                        .forEach(System.out::println);
            }
        }
    }

    //=================================== Agregar Datos ======================================
    public static void agregarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {
        int cantidadVehiculos = 0, contadorBucle = 0;
        boolean esVacia = false;
        //Variables para poder guardar datos, no todas se usarán.
        String marca = "", modelo = "";
        int tipoDeVehiculo = 0, fechaSalida = 0, disponibles = 0;
        float precio = 0f;

        System.out.println("========= Agregar vehículos =========");
        System.out.print("¿Cuantos vehiculos desea agregar?: ");
        cantidadVehiculos = sc.nextInt();
        //Prosigo con el guardado de datos.
        sc.nextLine();
        for (int i = contadorBucle; i < cantidadVehiculos; i++) {
            //Si se llegara a equivocar entonces reinicia, por lo que si pide agregar 5 y se equivoca en 2
            //no se guardaran 3, tendra que escribirlos si o si para
            try{
                System.out.println("Agregaras el vehiculo: " + (i + 1));
                i = agregarMasValores(vehiculos, sc, i);
            }catch(Exception e){
                System.out.println("Error en guardar datos F: " + e.getMessage());
                i--;
            }
//            sc.nextLine();
        }
    }
    //Esta funcion se usará dentro del bucle for, por lo que no repetira la condicion de vehiculos.isEmpty()
    public static int agregarMasValores(HashMap<String, Vehiculo> vehiculos, Scanner sc, int contador) {
        int tipoDeVehiculo = 0, fechaSalida = 0, disponibles = 0;
        String marca = "", modelo = "";
        float precio = 0f;
        boolean existe = false;
        //Codigo para agregar los datos del vehículo a agregar.
        System.out.print("Ingrese el modelo: ");
        modelo = sc.nextLine().trim();
//        sc.nextLine();
        //Se tiene que realizar una validación para que no existan vehiculos repetidos.
        for(Map.Entry<String, Vehiculo> vehiculo : vehiculos.entrySet()){
            //Se compara la llave del HashMap con el modelo del vehiculo
            if(vehiculo.getKey().equalsIgnoreCase(modelo)){
                //Si se encontro el vehículo entonces usamos existe para hacer un if fuera del for.
                existe = true;
                //Se cierra el bucle para que no gaste memoria.
                break;
            }
        }

        if(!existe){
            //Si no existe entonces procedemos a guardar
            System.out.print("Ingrese la marca: ");
            marca = sc.nextLine().trim();
            System.out.print("Ingrese la fecha de lanzamiento: ");
            fechaSalida = sc.nextInt();
            sc.nextLine();
            System.out.print("Ingrese el precio unitario: ");
            precio = sc.nextFloat();
            sc.nextLine();
            System.out.print("Cantidades disponibles: ");
            disponibles = sc.nextInt();
            sc.nextLine();
            System.out.print("""
                            ¿Qué tipo de vehiculo agregaras?
                            1.Camioneta.
                            2.Deportivo.
                            3.Cuatrimoto.
                            4.Moto.
                            """);
            tipoDeVehiculo = sc.nextInt();
            int opcionVehiculo = 0;
            sc.nextLine();
            switch (tipoDeVehiculo) {
                case 1 -> {
                    //Camioneta
                    int limiteDePasajeros = 0, pesoMaximo = 0;
                    System.out.print("Limite de pasajeros: ");
                    limiteDePasajeros = sc.nextInt();
                    System.out.print("Limite de carga o peso: ");
                    pesoMaximo = sc.nextInt();

                    vehiculos.put(modelo.toLowerCase(), new Camioneta(marca, modelo, fechaSalida, precio, disponibles, limiteDePasajeros, pesoMaximo));
                }//Opcion Camioneta
                case 2 -> {
                    //Deportivo.
                    int limiteKM = 0, opcionDeportivo = 0;
                    String tipoDeportivo = "";
                    System.out.print("Ingrese el limite de kilometro por hora: ");
                    limiteKM = sc.nextInt();
                    System.out.print("""
                        Selecciona que tipo de deportivo es.
                        1.Deportivo.
                        2.Superdeportivo.
                        """);
                    opcionVehiculo = sc.nextInt();
                    //Operador ternario tipo if-elseif-else, esto para simplificar ya sea un if o un switch solamente
                    //para asignar una cadena
                    tipoDeportivo = (opcionVehiculo == 1) ? "Deportivo" : (opcionVehiculo == 2)? "Superdeportivo": "ninguno";
                    //Hay 3 opciones de cadena y si guarda "ninguno", entonces podemos tomar de ancla para
                    //dirigirnos a guardar la info o mostrar una alerta
                    if(!tipoDeportivo.equals("ninguno")){
                        //Si es diferente a ninguno entonces procedemos a guardar los datos.
                        vehiculos.put(modelo.toLowerCase(), new Deportivo(marca, modelo, fechaSalida, precio, disponibles, limiteKM, tipoDeportivo));
                    }else{
                        System.out.println("Seleccione una opción correcta.");
                    }

                }//Opcion Deportivo
                case 3 -> {
                    //Cuatrimoto
                    int pesoMaximo = 0;
                    String tipoCuatrimoto = "";
                    System.out.print("Limite de carga o peso: ");
                    pesoMaximo = sc.nextInt();
                    System.out.print("""
                        Selecciona que tipo de cuatrimoto es.
                        1.Deportiva.
                        2.Utilitaria.
                        """);
                    opcionVehiculo = sc.nextInt();

                    tipoCuatrimoto = (opcionVehiculo == 1)? "Deportiva" : (opcionVehiculo == 2)? "Utilitaria" : "ninguno";

                    if(!tipoCuatrimoto.equals("ninguno")){
                        //Si es diferente a ninguno entonces procedemos a guardar datos.
                        vehiculos.put(modelo.toLowerCase(), new Cuatrimoto(marca, modelo, fechaSalida, precio, disponibles,pesoMaximo,tipoCuatrimoto));
                    }else{
                        System.out.println("Seleccione una opcion correcta.");
                    }
                }//Opcion Cuatrimoto
                case 4 -> {
                    //Moto
                    String cilindrada = "", tipoDeMoto = "";
                    System.out.print("Ingrese la cilindrada: ");
                    cilindrada = sc.nextLine();
                    System.out.print("""
                        Selecciona que tipo de moto es.
                        1.Chopper.
                        2.Trial Bike.
                        """);
                    opcionVehiculo = sc.nextInt();

                    //Asignados un tipo de moto con respecto a la opción.
                    tipoDeMoto = (opcionVehiculo == 1) ? "Chopper" : (opcionVehiculo == 2) ? "Trial Bike" : "ninguno";
                    //Ahora se valida
                    if(!tipoDeMoto.equals("ninguno")){
                        //Como es alguno de las opciones, ahora se guarda.
                        vehiculos.put(modelo.toLowerCase(), new Moto(marca, modelo, fechaSalida, precio, disponibles, cilindrada, tipoDeMoto));
                    }else{
                        System.out.println("Selecciona un tipo de moto correcto.");
                    }
                }//Opcion Moto
                default -> System.out.println("Ingrese una opcion valida.");
            }
            sc.nextLine();
        }else{
//            sc.nextLine();
            System.out.println("Marca y Vehiculo existente. Ingrese uno nuevo.");
            contador--;
        }
        return contador;
    }

    //=================================== Actualizar Datos ======================================
    public static void actualizarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {
        sc.nextLine();
        //Variables que se usaran.
        String modelo = "";
        int nuevoDisponible = 0;
        System.out.println("====== Actualizar Datos =======");

        System.out.print("Ingresa el modelo del vehiculo que deseas actualizar: ");
        modelo =sc.nextLine().trim();
        //En base al modelo que ingrese el usuario, lo buscaremos en el hashmap y valoraremos si existe o no.
        Vehiculo vehiculo = vehiculos.get(modelo.toLowerCase());
        //Si existe el valor procedemos a actualizar el valor de la cantidad disponible
        if(vehiculo != null){
            System.out.print("Ingresa la nueva cantidad disponible: ");
            nuevoDisponible = sc.nextInt();

            if(vehiculo.getDisponibles() < 0 || vehiculo.getDisponibles() == nuevoDisponible){
                //Si el valor ingresado es menor a cero o es igual al dato inicial entonces no guarda nada y muestra una alerta.
                System.out.println("Ingresa una cantidad valida.");
            }else{
                System.out.println("===== Datos Iniciales =====\n" +
                        vehiculo.mostrarDatos());

                vehiculo.setDisponibles(nuevoDisponible);

                System.out.println("===== Datos Actualizado =====\n" +
                        vehiculo.mostrarDatos());
            }
        }else{
            System.out.println("No existe ese modelo de vehiculo. Ingresa uno correcto.\n");
        }

    }


    //=================================== Eliminar Datos ======================================
    public static void eliminarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {
        //Variables que se usaran
        sc.nextLine();
        String modelo = "";
        System.out.print("Ingresa el modelo del vehiculo: ");
        modelo = sc.nextLine().trim();

        Vehiculo vehiculo = vehiculos.get(modelo.toLowerCase());

        if(vehiculo != null){
            //Si la variable vehiculo no es null entonces procedemos a eliminar, pero antes hacemos otra validacion necesaria.
            //La validación es borrar solamente datos con disponibilidad de cero.
            if(vehiculo.getDisponibles() == 0){
                //Si es igual a cero entonces si lo eliminamos.
                vehiculos.remove(modelo.toLowerCase());
                System.out.println("Se elimino correctamente el valor.");
            }else{
                System.out.println("Para borrar el vehiculo, no debe tener existencia o disponibilidad.");
            }
        }

    }
}