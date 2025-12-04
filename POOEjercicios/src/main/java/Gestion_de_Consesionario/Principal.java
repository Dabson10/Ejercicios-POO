package Gestion_de_Consesionario;

import Gestion_de_Consesionario.Vehiculos.Camioneta;
import Gestion_de_Consesionario.Vehiculos.Cuatrimoto;
import Gestion_de_Consesionario.Vehiculos.Deportivo;
import Gestion_de_Consesionario.Vehiculos.Moto;

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

    public static void datosIniciales(HashMap<String, Vehiculo> vehiculos){
        vehiculos.put("F8 Tributo", new Deportivo("Ferrari", "F8 Tributo", 2019, 300000.50f, 2, 320, "Superdeportivo"));
        vehiculos.put("YZF-R6", new Moto("Yamaha", "YZF-R6", 2020, 15500.99f, 15, "600cc", "Trial Bike"));
        vehiculos.put("Ranger", new Camioneta("Ford", "Ranger", 2023, 45000.00f, 8, 5, 1200));
        vehiculos.put("Outlander 650", new Cuatrimoto("Can-Am", "Outlander 650", 2024, 12750.00f, 4, 300, "Utilitaria"));
        vehiculos.put("911 Carrera", new Deportivo("Porsche", "911 Carrera", 2022, 185900.75f, 6, 280, "Deportivo"));

        vehiculos.put("SLS AMG", new Deportivo("Mercedes-Benz", "SLS AMG", 2011, 250000.00f, 3, 317, "Alas de Gaviota"));
        vehiculos.put("Corvette C8", new Deportivo("Chevrolet", "Corvette C8", 2021, 85000.50f, 7, 312, "Superdeportivo"));
        vehiculos.put("Supra MK5", new Deportivo("Toyota", "Supra MK5", 2020, 55000.00f, 10, 250, "Coupe Deportivo"));
        vehiculos.put("GT-R Nismo", new Deportivo("Nissan", "GT-R Nismo", 2023, 210000.99f, 2, 330, "Superdeportivo"));

        vehiculos.put("Ninja 400", new Moto("Kawasaki", "Ninja 400", 2022, 6099.00f, 20, "400cc", "Deportiva"));
        vehiculos.put("GSX-R1000", new Moto("Suzuki", "GSX-R1000", 2023, 16500.99f, 5, "1000cc", "Superbike"));
        vehiculos.put("Africa Twin", new Moto("Honda", "Africa Twin", 2021, 14500.50f, 12, "1100cc", "Aventura"));
        vehiculos.put("Monster", new Moto("Ducati", "Monster", 2024, 13000.00f, 8, "937cc", "Naked"));

        vehiculos.put("Silverado 1500", new Camioneta("Chevrolet", "Silverado 1500", 2024, 58000.00f, 6, 6, 1500));
        vehiculos.put("Tacoma", new Camioneta("Toyota", "Tacoma", 2023, 42500.75f, 10, 4, 800));
        vehiculos.put("F-150", new Camioneta("Ford", "F-150", 2022, 65000.99f, 9, 5, 1360));
        vehiculos.put("Ram 1500", new Camioneta("Ram", "1500", 2021, 55000.50f, 11, 5, 1050));

        vehiculos.put("Raptor 700R", new Cuatrimoto("Yamaha", "Raptor 700R", 2023, 9500.00f, 14, 200, "Deportiva"));
        vehiculos.put("Polaris RZR", new Cuatrimoto("Polaris", "RZR Pro R", 2024, 38000.00f, 3, 400, "Side-by-Side"));
        vehiculos.put("FourTrax", new Cuatrimoto("Honda", "FourTrax Recon", 2022, 4800.99f, 18, 150, "Recreativa"));
        vehiculos.put("Maverick X3", new Cuatrimoto("Can-Am", "Maverick X3", 2021, 25000.50f, 7, 350, "Deportiva"));

    }

    //Funciones CRUD
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
                default -> System.out.println("Ingresa una opcion correcta.\n");
            }
        }else{
            System.out.println("No hay datos guardados.\n");
        }
    }
    //SubFuncion para mostrar datos.
    public static void procesoDeDatos(int opcionBusqueda, HashMap<String, Vehiculo> vehiculos, Scanner sc){
        /**
         * La siguiente seccion es para tener los datos ordenados mediante un arraylist unico.
         * Todo esto para no reescribir tanto codigo. en el if y else
         */
        ArrayList<HashMap<String, Vehiculo>> conjuntoVehiculos = new ArrayList<>();
        HashMap<String, Vehiculo> camioneta = new HashMap<>(), deportivo = new HashMap<>();
        HashMap<String, Vehiculo> cuatrimoto = new HashMap<>(), moto = new HashMap<>();

        conjuntoVehiculos.add(camioneta);
        conjuntoVehiculos.add(deportivo);
        conjuntoVehiculos.add(cuatrimoto);
        conjuntoVehiculos.add(moto);

        //Ahora lo que se realizara es un bucle for el cual recorrerá todo el HashMap y si encuentra
        //un objeto con una clase especifica lo guardara en cierto arraylist, esto dependiendo de la
        //clase y array.
        for(Map.Entry<String, Vehiculo> vehiculo : vehiculos.entrySet()){
            //Obtener el valor de la clase Camioneta.
            if(vehiculo.getValue() instanceof Camioneta){
                camioneta.put("Camioneta", vehiculo.getValue());
            }
            //Obtener el valor de la clase Deportivo
            if(vehiculo.getValue() instanceof Deportivo){
                deportivo.put("Deportivo", vehiculo.getValue());
            }
            //Obtener el valor de la clase Cuatrimoto
            if(vehiculo.getValue() instanceof Cuatrimoto){
                cuatrimoto.put("Cuatrimoto", vehiculo.getValue());
            }
            //Obtener el valor de la clase Moto
            if(vehiculo.getValue() instanceof Moto){
                moto.put("Moto", vehiculo.getValue());
            }
        }
        //Esta opcion es para mostrar los datos ordenados.
        if(opcionBusqueda == 2){
            System.out.println("====== Datos Ordenados ======");
            busquedaOrdenada(conjuntoVehiculos);
            /**
             * El siguiente codigo no lo borraré, ya que me sirvio para simplificar 4 if en una
             * funcion que se encarga de mostrar los datos. busquedaOrdenada()conjuntoVehiculos;
             */
//            if(!camioneta.isEmpty()){
//                System.out.println("====== Camioneta ======");
//                camioneta.forEach(dato ->{
//                    System.out.println(dato.mostrarDatos());
//                });
//            }else{
//                System.out.println("====== Camioneta ======");
//                System.out.println("No hay disponibles actualmente");
//            }
//            if(!deportivo.isEmpty()){
//                System.out.println("====== Deportivo ====== ");
//                deportivo.forEach(dato ->{
//                    System.out.println(dato.mostrarDatos());
//                });
//            }else{
//                System.out.println("====== Deportivo ======");
//                System.out.println("No hay disponibles actualmente");
//            }
//
//            if(!cuatrimoto.isEmpty()){
//                System.out.println("====== Cuatrimoto ======");
//                cuatrimoto.forEach(dato ->{
//                    System.out.println(dato.mostrarDatos());
//                });
//            }else{
//                System.out.println("====== Cuatrimoto ======");
//                System.out.println("No hay disponibles actualmente");
//            }
//
//            if(!moto.isEmpty()){
//                System.out.println("====== Motos ======");
//                moto.forEach(dato -> System.out.println(dato.mostrarDatos()));
//            }else{
//                System.out.println("====== Moto ======");
//                System.out.println("No hay disponibles actualmente");
//            }
        }else{
            //Esta opcion es para categorias especificas.
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
                //y despues se recorre el arraylist
                System.out.println("======= " + categoria + " =======");
                for(int i = 0; i < conjuntoVehiculos.size(); i++){
                    //Ahora entraremos en el HashMap ubicado en i

                    for(Map.Entry<String, Vehiculo> vehiculo : conjuntoVehiculos.get(i).entrySet()){
                        //Ahora se hace la comparacion entre la opcion que selecciono el usuario y la clave
                        System.out.println("Llave: " + vehiculo.getKey() + " categoria: " + categoria );
                        if(categoria.equals(vehiculo.getKey())){
                            //Si encuentra un valor lo imprime.
                            System.out.println(vehiculo.getValue().mostrarDatos());
                        }
                    }
                }
            }else{
                System.out.println("Favor de seleccionar una opcion correcta.");
            }
        }
    }


    //Función que simplifica los 4 if que recorren
    public static void busquedaOrdenada(ArrayList<HashMap<String, Vehiculo>> categorias){
        //Para recorrer cada categoria accederemos cada espacio del array y despues
        // cambiamos cosas dentro del HashMap
        //Este primer for es para recorrer la lista de al menos 4 espacios
        for(int i = 0; i < categorias.size(); i++){
            //Este if, valida que existan valores en el hashmap
            if(!categorias.get(i).isEmpty()){
                //Si no esta vacio entonces pasamos al siguiente for
                //El siguiente for es para recorrer el hashmap y obtener los datos correctamente.
                System.out.println("=======" + categorias.get(i).keySet() + " =======");
                for(Map.Entry<String, Vehiculo> vehiculo : categorias.get(i).entrySet()){
//                    System.out.println("====== " +vehiculo.getKey() + "======");
                    System.out.println(vehiculo.getValue().mostrarDatos());
                }
            }
        }
    }


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

        //Si el hashMap está vacío entonces cambia el valor, provocando otra situación de búsqueda.
        if (vehiculos.isEmpty()) {
            esVacia = true;
        }

        /**
         * El if anterior y el siguiente si estan bien mas que nada para no repetir codigo, pero la verdar estoy muy tonto al
         * no darme cuenta que el primer dato guardado ocupa la misma forma de guardar que cuando ya existen otros registros.
         * No negare que es un buen codigo simple y detallado, pero muy redundante
         */
//        if (esVacia) {
//            boolean registroValido = true;
//            while (registroValido) {
//                sc.nextLine();
//                try {
//                    //Aquí agrego el codigo de agregar datos. Y resto en uno la cantidad total
//                    System.out.println("Ingrese la marca: ");
//                    marca = sc.nextLine().trim();
//                    System.out.print("Ingrese el modelo: ");
//                    modelo = sc.nextLine().trim();
//                    System.out.println("Ingrese la fecha de lanzamiento: ");
//                    fechaSalida = sc.nextInt();
//                    System.out.println("Ingrese el precio unitario: ");
//                    precio = sc.nextFloat();
//                    System.out.println("Cantidades disponibles: ");
//                    disponibles = sc.nextInt();
//                    System.out.print("""
//                            ¿Qué tipo de vehiculo agregaras?
//                            1.Camioneta.
//                            2.Deportivo.
//                            3.Cuatrimoto.
//                            4.Moto.
//                            """);
//                    tipoDeVehiculo = sc.nextInt();
//                    //En la siguiente linea validamos si continuamos repitiendo el codigo por si el usuario se equivoco
//                    //o terminamos y seguimos con el codigo.
//                    registroValido = agregarPrimerVehiculo(tipoDeVehiculo, marca, modelo, fechaSalida, precio, disponibles, vehiculos, sc);
//                    //Switch con opciones que mandan a las otras funciones, que recibiran de parametro los datos antes solicitados.
//                    contadorBucle++;
//                } catch (Exception e) {
//                    System.out.println("Error al agregar el primer vehiculo: " + e.getMessage());
//                }
//            }
//        }

        //Prosigo con el guardado de datos.

        for (int i = contadorBucle; i < cantidadVehiculos; i++) {
            sc.nextLine();
            //Aquí usare lambdas con foreach y asi comparar, se usarán más de una vez
            try{
                agregarMasValores(vehiculos, sc);
            }catch(Exception e){
                System.out.println("Error en guardar datos F: " + e.getMessage());
            }
            System.out.println("Agregaras el vehiculo: " + (i + 1));
        }
    }
    //Sub funciones de agregarVehiculos, en este se agregaran los vehiculos de una forma d

    //La siguiente funcion es el claro ejemplo de que me gusta escribir codigo sin antes pensar en es realmente necesario
    //Esto por que cuando agregas el primer usuario no haces nada diferente a la manera en que se agregan de mas usuario,
    //dejare esta funcion mas que nada para recordar esto.
    //Funcion para cuando es el primer registro, solo se usa una vez
    public static boolean agregarPrimerVehiculo(int tipoDeVehiculo, String marca, String modelo,
                                             int fechaSalida, float precio, int disponibles,
                                             HashMap<String, Vehiculo> vehiculos, Scanner sc) {

        sc.nextLine();
        boolean salida = true;
        int opcionVehiculo = 0;
        switch (tipoDeVehiculo) {
            case 1 -> {
                //Camioneta
                int limiteDePasajeros = 0, pesoMaximo = 0;
                System.out.print("Limite de pasajeros: ");
                limiteDePasajeros = sc.nextInt();
                System.out.print("Limite de carga o peso: ");
                pesoMaximo = sc.nextInt();

                vehiculos.put(marca, new Camioneta(marca, modelo, fechaSalida, precio, disponibles, limiteDePasajeros, pesoMaximo));
                salida = false;
            }//Fin opcion 1
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
                    vehiculos.put(marca, new Deportivo(marca, modelo, fechaSalida, precio, disponibles, limiteKM, tipoDeportivo));
                    salida = false;
                }else{
                    System.out.println("Seleccione una opción correcta.");
                }

            }//Fin opcion 2
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
                    vehiculos.put(marca, new Cuatrimoto(marca, modelo, fechaSalida, precio, disponibles,pesoMaximo,tipoCuatrimoto));
                    salida = false;
                }else{
                    System.out.println("Seleccione una opcion correcta.");
                }
            }//Fin opción 3
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
                    vehiculos.put(marca, new Moto(marca, modelo, fechaSalida, precio, disponibles, cilindrada, tipoDeMoto));
                    salida = false;
                }else{
                    System.out.println("Selecciona un tipo de moto correcto.");
                }
            }
            //Posible error aca, ya que si no ingresa una opcion sigue al bucle y si no hay valores, no podra agregar
            //un valor continuo
            default -> {
                System.out.println("Ingrese una opcion valida.");
                salida = true;
            }
        }
        return salida;
    }

    //Esta funcion se usará dentro del bucle for, por lo que no repetira la condicion de vehiculos.isEmpty()
    public static void agregarMasValores(HashMap<String, Vehiculo> vehiculos, Scanner sc) {
        int tipoDeVehiculo = 0, fechaSalida = 0, disponibles = 0;
        String marca = "", modelo = "";
        float precio = 0f;
        sc.nextLine();
        //Codigo
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

                vehiculos.put(modelo, new Camioneta(marca, modelo, fechaSalida, precio, disponibles, limiteDePasajeros, pesoMaximo));
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
                    vehiculos.put(modelo, new Deportivo(marca, modelo, fechaSalida, precio, disponibles, limiteKM, tipoDeportivo));
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
                    vehiculos.put(modelo, new Cuatrimoto(marca, modelo, fechaSalida, precio, disponibles,pesoMaximo,tipoCuatrimoto));
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
                    vehiculos.put(modelo, new Moto(marca, modelo, fechaSalida, precio, disponibles, cilindrada, tipoDeMoto));
                }else{
                    System.out.println("Selecciona un tipo de moto correcto.");
                }
            }//Opcion Moto
            default -> System.out.println("Ingrese una opcion valida.");
        }
    }

    public static void actualizarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {

    }

    public static void eliminarVehiculos(Scanner sc, HashMap<String, Vehiculo> vehiculos) {

    }

}
