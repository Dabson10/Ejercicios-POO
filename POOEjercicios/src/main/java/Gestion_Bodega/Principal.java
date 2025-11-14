package Gestion_Bodega;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Dabson
 */
//Ejercicio
/**
 * Necesito un sistema para gestionar el inventario de mi bodega. Quiero poder
 * agregar productos con su código, nombre, categoría, cantidad, precio y
 * ubicación. Necesito buscar productos por código o nombre, modificar su
 * información (especialmente cantidad y precio), y eliminar productos cuando ya
 * no los maneje. Es importante que me muestre reportes como: productos con poco
 * stock (menos de 10 unidades), el valor total de todo mi inventario, y que me
 * agrupe los productos por categoría. También quiero que me avise si intento
 * agregar un producto con un código que ya existe, y que no me deje poner
 * cantidades o precios negativos. Sería genial que al inicio me muestre una
 * alerta si hay productos con stock bajo para estar al pendiente. El sistema
 * debe ser fácil de usar desde un menú con opciones numeradas.
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Menu de opciones
        boolean acceso = true;
        //ArrayList de la clase Producto
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Refrigerador", "P_0001", "Linea blanca", 15, 13532, "A_1"));
        productos.add(new Producto("Lavadora", "P_0002", "Linea blanca", 0, 6532, "A_1"));
        productos.add(new Producto("Laptop HP Victus 15P", "P_0003", "Laptop", 12, 11532, "A_2"));
        productos.add(new Producto("Laptop Mac", "P_0004", "Laptop", 0, 22435, "A_2"));
        productos.add(new Producto("Perro Chihuahua", "P_0005", "Perros", 7, 5000, "A_3"));
        productos.add(new Producto("Perro Galgo", "P_0006", "Perros", 15, 7000, "A_3"));
        productos.add(new Producto("Xbox One S", "P_0007", "VideoJuego", 13, 11000, "A_4"));

        int opcion;
        while (acceso) {
            try {
                System.out.println("""
                                   Bienvenido a la Bodega.
                                   Ingrese la opcion que desea hacer.
                                   1.Mostrar productos.
                                   2.Agregar productos.
                                   3.Editar productos.
                                   4.Eliminar productos.
                                   5.Salir.
                                   """);
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("==== Productos en Bodega ====");
                        mostrarProductos(productos);
                    }
                    case 2 -> {
                        System.out.println("==== Agregar Productos ====");
                        agregarProductos(productos);
                    }
                    case 3 -> {
                        System.out.println("==== Editar Productos ====");
                        editarProductos(productos);
                    }
                    case 4 -> {
                        System.out.println("==== Eliminar Productos ====");
                        eliminarProductos(productos);
                    }
                    case 5 -> {
                        System.out.println("Hasta luego");
                        acceso = false;
                        sc.close();
                    }
                    default -> {
                        System.out.println("Ingrese un valor correcto");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error del tipo: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    //Funciones CRUD
    //Mostrar productos.
    public static void mostrarProductos(ArrayList<Producto> producto) {
        sc.nextLine();
        int opcionBusqueda = 0;
        String categoriaBus = "", ubicacionBus = "";
        //Validacion sobre si esta o no vacia la lista
        if (!producto.isEmpty()) {
            //Preguntara como se desean ver los productos, ya sea todo de una, por categoria o ubicacion.
            System.out.print("""
                             Ingrese la opcion de busqueda.
                             1.Mostrar todos.
                             2.Por categoria.
                             3.Por ubicación.
                             4.Poco Stock.
                             5.Valor total.
                               """);
            opcionBusqueda = sc.nextInt();
            sc.nextLine();
            switch (opcionBusqueda) {
                case 1 -> {
                    //Si no esta vacia entonces recorrera la lista objeto por objeto y mostrara los datos
                    producto.forEach(produ -> {
                        System.out.println(produ.toString());
                    });
                }
                case 2 -> {
                    System.out.print("Ingrese la categoria que desea buscar: ");
                    categoriaBus = sc.nextLine();
                    buscarCategoria(categoriaBus, producto);
                }
                case 3 -> {
                    System.out.print("Ingrese la ubicación que desea buscar: ");
                    ubicacionBus = sc.nextLine();
                    buscarUbicacion(ubicacionBus, producto);
                }
                case 4 -> {
                    //Esta opcion es para mostrar a los productos que tengan una cantidad menor a 10.
                    producto.forEach(produ -> {
                        if (produ.getCantidad() < 10) {
                            System.out.println(produ.toString());
                        }
                    });
                }
                case 5 -> {
                    //Esta opcion es para mostrar el valor total por todos los productos
                    float valorTot = valorTotal(producto);
                    System.out.println("El valor total de los productos en la boveda es: $" + valorTot);
                }
                default -> {
                    System.out.println("Ingrese una opcion correcta.\n");
                }
            }

        } else {
            System.out.println("No hay productos en existencia.\n");
        }
        opcionBusqueda = 0;
    }

    //Funciones para las dos distintas formas de buscar productos.
    public static void buscarCategoria(String categoria, ArrayList<Producto> producto) {
        //Como ya hicimos una validacion antes sobre si esta llena o vacia solamente toca buscar esa categoria,
        //Obviamente convertiremos ambas cadenas en minusculas para que no existan fallas en la busqueda.
        boolean existeCategoria = false;
        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                //Si encuentra alguna similitud entonces imprime valores.
                existeCategoria = true;
                break;
            } else {
                existeCategoria = false;
            }
        }
        if (existeCategoria) {
            //Si aparece con true entonces es por que existe una categoria
            producto.forEach(produ -> {
                if (produ.getCategoria().equalsIgnoreCase(categoria)) {
                    //Si encuentra alguna similitud entonces imprime valores.
                    System.out.println(produ.toString());
                }
            });
        }else{
            System.out.println("No se encontraron productos con esa categoria.\n");
        }
    }

    //Funcion para buscar mediante la ubicacion.
    public static void buscarUbicacion(String ubicacion, ArrayList<Producto> producto) {
        //Como ya hicimos una validacion antes sobre si esta llena o vacia solamente toca buscar esa ubicación,
        //Obviamente convertiremos ambas cadenas en minusculas para que no existan fallas en la busqueda.
        boolean existeUbicacion = true;
        int posicionUbicacion = 0;
        
        for(int i = 0; i < producto.size(); i++){
            if(producto.get(i).getUbicacion().equalsIgnoreCase(ubicacion)){
                existeUbicacion = true;
                posicionUbicacion =i;
                break;
            }else{
                existeUbicacion = false;
                posicionUbicacion =0;
            }
        }
        if(existeUbicacion){
            //Si encuentra una ubicacion entonces muestra los datos, ahora mediante una posicion exacta
            producto.forEach(produ ->{
                if(produ.getUbicacion().equalsIgnoreCase(ubicacion)){
                    //Si la encuentra entonces lo imprime.
                    System.out.println(produ.toString());
                }
            });
        }else{
            System.out.println("No existe un producto en esa ubicacion.\n");
        }
    }

    //Funcion para ver el valor total de la lista de productos.
    public static float valorTotal(ArrayList<Producto> producto) {
        float valorTotal = 0;
        for (Producto produ : producto) {
            valorTotal += (produ.getPrecio() * produ.getCantidad());
        }
        return valorTotal;
    }

    //Agregar productos
    public static void agregarProductos(ArrayList<Producto> producto) {
        sc.nextLine();

        int cantidad;
        int controlAcceso = 0, existeCategoria = 0;

        //Variables que se agregaran en el constructor del objeto
        String codigo = "", categoria, ubicacion = "", nuevaUbicacion = "";
        int cantidadProductos;
        float precio;

        //Se pedira la cantidad de productos que se agregaran
        System.out.print("¿Cuantos productos agregara? ");
        cantidad = sc.nextInt();

        //Este for realizara las repeticiones para agregar nuevos productos.
        for (int i = 0; i < cantidad; i++) {

            //Si la lista producto no esta vacio entonces procede a otra validacion,
            //en donde buscara si existe algun producto con ese nombre
            if (!producto.isEmpty()) {
                sc.nextLine();
                //Ahora como existen productos es necesario validar que no exista un nombre similar,
                //por esto mismo es necesario comparar el nombre de entrada con nombres de productos
                //previamente registrados.
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = sc.nextLine().trim();

                for (int j = 0; j < producto.size(); j++) {
                    if (producto.get(j).getNombre().equalsIgnoreCase(nombre)) {
                        //Si hay un producto igual entoces termina el bucle.
                        controlAcceso = 1;
                        break;
                    }
                }

                //Ahora se tiene que realizar el if para ver si se agrega o no el producto.
                if (controlAcceso == 0) {
                    //Como ya esta validado que no existe un producto con el mismo nombre entonces,
                    //solemente toca pedir y modificar uno que otro dato.
                    /*Por ejemplo el codigo del producto es uno de los que se modificaran, 
                    el codigo del producto si o si debe de ser incremental, por lo tanto si se ingreso un producto con codigo
                    [ P_0005] cuando se agregue otro el codigo sera [ P_0006] en automatico, para esto es la siguiente funcionalidad.
                     */
                    int ultimoValor = producto.size() - 1;
                    String ultimoCodigo = producto.get(ultimoValor).getCodigo();
                    //Para simplificar variables se realizara la conversion de un String a un int en una misma linea
                    //String cadenaRecortada = ultimoCodigo.substring(2, ultimoCodigo.length());
                    int cadenaRecortada = Integer.parseInt(ultimoCodigo.substring(2, ultimoCodigo.length()));
                    int longCadena = (ultimoCodigo.substring(2, ultimoCodigo.length())).length();

                    //En base a cadenaRecortada se realizara el switch para la asignacion de codigo nuevo.
                    /*
                    ====================
                    El error esta aca, ya que como tal guarda y no el codigo del producto, 
                    esto esta en que tal ves necesites usar un if con else if mas que nada para
                    condicionales de cadenaRecortada < 10 ... <100 .... < 1000
                    =======================================================================
                     */
                    if (cadenaRecortada < 10) {
                        //Esta opcion es para cuando el numero esta en un rango de 1 a 9, por lo que se le agregaran 3 ceros.
                        cadenaRecortada += 1;
                        codigo = "P_000" + cadenaRecortada;
//                            System.out.println("El nuevo codigo es: " + codigo);
                    } else if (cadenaRecortada < 100) {
                        //Esta opcion es para cuando el numero esta en un rango de 10 a 99, por lo que se le agregaran 2 ceros.
                        cadenaRecortada += 1;
                        codigo = "P_00" + cadenaRecortada;
//                            System.out.println("El nuevo codigo es: " + codigo);
                    } else if (cadenaRecortada < 1000) {
                        //Esta opcion es para cuando el numero esta en un rango de 1000 a 9999, no se agregan ceros.
                        cadenaRecortada += 1;
                        codigo = "P_" + cadenaRecortada;
//                            System.out.println("El nuevo codigo es: " + codigo);
                    } else {
                        System.out.println("Ya no hay espacio para guardar mas productos.");
                    }

                    System.out.println("""
                                       Ingrese la categoria a la que pertenece.
                                       Si ingresas una categoria que previamente existe, 
                                       se guardara el producto en una misma ubicación.
                                       """);
                    categoria = sc.nextLine().trim();
                    /*Como dice el mensaje si la categoria es existente entonces se agregara
                    en la misma ubicacion por ejemplo [' A_1 '], por esto mismo es necesario
                    especificar al usuario su uso.
                     */
                    //Se repetira el uso del bucle for en donde buscara la categoria, asi como el nombre.
                    for (int p = 0; p < producto.size(); p++) {
                        if (producto.get(p).getCategoria().equalsIgnoreCase(categoria)) {
                            String ubicacionProdu = producto.get(p).getUbicacion();
                            System.out.println("Producto existente, su ubicacion estara en: " + ubicacionProdu);
                            existeCategoria = 1;
                            //Si existe el producto es mejor asignar la ubicacion directamente aca.
                            ubicacion = producto.get(p).getUbicacion();
                            break;

                        }
                    }
                    if (existeCategoria == 0) {
                        //Si no existe esta categoria entonces se procede a agregar una nueva ubicación.
                        /*De igual manera la asignacion de una nueva ubicacion es con respecto a la ubicacion 
                        no mas reciente mas bien la mas grande, por ejemplo {[A_1],[A_2].....[A_8]},
                        entonces el valor mas grande en este caso [A_8] es el ultimo valor por lo que la nueva 
                        ubicacion sera [A_9].*/
                        ubicacion = ubicacionMayor(producto);
                    }
                    System.out.println("La ubicacion del producto anterior es: " + ubicacion);
                    System.out.println("Ingrese el precio unitario del producto");
                    precio = sc.nextFloat();
                    System.out.println("Ingrese la cantidad de productos que agregaras.");
                    cantidadProductos = sc.nextInt();
                    //Se agregan los datos en el objeto.
                    producto.add(new Producto(nombre, codigo, categoria, cantidadProductos, precio, ubicacion));
                    //Salto de linea entre productos.
                    System.out.println("");
                    //Limpieza de valores como guardados en el objeto para que no exista ningun problema
                    nombre = "";
                    codigo = "";
                    categoria = "";
                    cantidadProductos = 0;
                    precio = 0;
                    ubicacion = "";
                    existeCategoria = 0;
                    controlAcceso = 0;
                } else {
                    sc.nextLine();
                    System.out.println("No se agregaran productos existente.");
                }

            } else {
                //Si la lista esta vacia entonces se salta el paso de validar existencias.
                //Este else solo funcionara una vez
                sc.nextLine();
                System.out.print("Agregue el nombre del producto: ");
                String nombre = sc.nextLine().trim();
                codigo = "P_0001";
                System.out.print("Ingrese la categoria a la que pertenece: ");
                categoria = sc.nextLine().trim();
                System.out.print("Ingrese el precio unitario del producto: ");
                precio = sc.nextFloat();
                System.out.print("Ingrese la cantidad de productos que agregara: ");
                cantidadProductos = sc.nextInt();
                //La parte de la ubicacion tendra una forma diferente de agregar, 
                //por esto mismo debes de ser mas especifico despues
                ubicacion = "A_1";
                //Y ya con esto se agregara un producto directamente sin la necesidad de validar si 
                //existe otro.
                producto.add(new Producto(nombre, codigo, categoria, cantidadProductos, precio, ubicacion));
                sc.nextLine();
                System.out.println("");
            }
        }
    }

    //Funcion para encontrar la ubicación mayor dentro de la lista de objetos.
    public static String ubicacionMayor(ArrayList<Producto> producto) {

        int numMayor = 0;
        for (int i = 0; i < producto.size(); i++) {
            int longCadena = producto.get(i).getUbicacion().length();
            int cadenaRecortada = Integer.parseInt(producto.get(i).getUbicacion().substring(2, longCadena));
            if (cadenaRecortada > numMayor) {
                //Si la cadena obtenida es mayor entonces se asigna este valor, se recorrera asi de 
                //uno en uno obteniendo las diferentes areas que existen, pero hasta que recorra toda la lista de
                //objetos y asigne el valor mas grande entonces ahi se usara numMayor para poder aumentar
                //o cambiar de letra.
                numMayor = cadenaRecortada;
            }
        }
        //Ahora solamente se aumentara en uno el numero
        return "A_" + (numMayor + 1);
    }

    //Editar productos
    public static void editarProductos(ArrayList<Producto> producto) {
        sc.nextLine();
        //Si no esta vacio entonces procedemos a editar o buscar el producto
        int existeProducto = 0, ubicacionProduct = 0, opcionEdit = 0;
        String productoEdit = "";
        int cantidadNueva = 0;
        float precioNuevo = 0;

        if (!producto.isEmpty()) {
            System.out.print("¿Cual producto deseas editar?: ");
            productoEdit = sc.nextLine().trim();
            //Recorremos la lista buscando el producto.
            for (int i = 0; i < producto.size(); i++) {
                //Este if busca dentro de la lista y obtiene el nombre del objeto y lo compara con el nombre del producto
                if (producto.get(i).getNombre().equalsIgnoreCase(productoEdit)) {
                    existeProducto = 1;
                    //A la variable le pasamos la ubicacion del for, mas que nada para obtener su ubicación.
                    ubicacionProduct = i;
                    break;
                } else {
                    existeProducto = 0;
                }
            }
            //Ahora que sabemos que existe el producto 
            if (existeProducto == 1) {
                //Esta seccion es por que el producto existe.
                System.out.println(producto.get(ubicacionProduct).toString());
                System.out.print("""
                                 ¿Qué deseas editar del producto?
                                 1.Cantidad.
                                 2.Precio.
                                   """);
                opcionEdit = sc.nextInt();

                switch (opcionEdit) {
                    case 1 -> {
                        //Actualizar la cantidad del producto.
                        System.out.print("Ingresa la cantidad por la que deseas cambiar: ");
                        cantidadNueva = sc.nextInt();
                        if (producto.get(ubicacionProduct).getCantidad() != cantidadNueva && cantidadNueva > 0) {
                            //Si es diferente a cantidadNueva y es mayor a cero o es positiva entonces procede a guardar.

                            producto.get(ubicacionProduct).setCantidad(cantidadNueva);
                            System.out.println("EL producto se actualizo: \n"
                                    + producto.get(ubicacionProduct).toString());
                        } else {
                            System.out.println("Por favor ingresa una cantidad positiva o diferente a la cantidad antigua.");
                        }
                    }
                    case 2 -> {
                        //Actualizar el precio del producto.
                        System.out.print("Ingrese el nuevo precio unitario del producto: ");
                        precioNuevo = sc.nextFloat();

                        if (producto.get(ubicacionProduct).getPrecio() != precioNuevo && precioNuevo > 0) {
                            //Ahora si guardamos el valor en el objeto
                            producto.get(ubicacionProduct).setPrecio(precioNuevo);
                            System.out.println("El producto se actualizo\n"
                                    + producto.get(ubicacionProduct).toString());
                        } else {
                            System.out.println("Por favor ingresa una precio positiva o diferente a la precio antigua.");
                        }

                    }
                    default -> {
                        System.out.println("Seleccione una opcion correcta.");
                    }
                }
            } else {
                //El producto no existe o no se encontro
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("No hay productos guardados.\n");
        }
    }

    //Eliminar productos.
    public static void eliminarProductos(ArrayList<Producto> producto) {
        sc.nextLine();
        String codigoDelete;
        int ubicacionCodigo = 0, existeCodigo = 0, confirmacionDel;
        int contProductos = 0;
        //Primero validamos que existan productos en la lista
        if (!producto.isEmpty()) {
            //Si existen objetos en la lista entonces procedemos a eliminarlos
            System.out.println("""
                               Para borrar productos es necesario que sus cantidades esten en 0 
                               ya que no se pueden borrar productos con cantidades disponibles.
                               Los siguientes productos pueden ser eliminados.
                               """);

            for (int j = 0; j < producto.size(); j++) {
                if (producto.get(j).getCantidad() == 0) {
                    System.out.println(producto.get(j).toString());
                    contProductos += 1;
                }
            }

            if (contProductos != 0) {
                //Si el valor no es igual a cero entonces se procede a eliminar
                System.out.println("Ingrese el codigo del producto para eliminarlo. Ejemplo 'P_0675' ");
                codigoDelete = sc.nextLine();
                for (int i = 0; i < producto.size(); i++) {
                    if ((producto.get(i).getCodigo().equalsIgnoreCase(codigoDelete)) && producto.get(i).getCantidad() == 0) {
                        //Si encuentra un codigo igual entonces procede a obtener su ubicacion en la lista y valida que exista tambien
                        existeCodigo = 1;
                        ubicacionCodigo = i;
                        break;
                    } else {
                        existeCodigo = 0;
                        ubicacionCodigo = 0;
                    }
                }

                //Aqui como tal es la validacion en donde si es igual a uno es por que se encotro el producto.
                if (existeCodigo == 1) {
                    System.out.println("Usted eliminara el siguiente producto.\n"
                            + producto.get(ubicacionCodigo).toString());

                    System.out.println("""
                                       ¿Esta seguro de eliminarlo?
                                       1.Si.
                                       2.No.
                                       """);
                    confirmacionDel = sc.nextInt();
                    switch (confirmacionDel) {
                        case 1 -> {
                            producto.remove(ubicacionCodigo);
                            System.out.println("El producto se ha eliminado.");
                        }
                        case 2 -> {
                            System.out.println("No se eliminara el objeto");
                        }
                        default -> {
                            System.out.println("Seleccione una opción correcta");
                        }
                    }
                } else {
                    //El valor es 0 no se encontro ningun valor con el mismo codigo en la lista de objetos.
                    System.out.println("No se encontro el producto");
                }

            } else {
                //Si el valor es igual a cero entonces se muestra el siguiente mensaje.
                System.out.println("No hay productos listos para eliminar.\n");
            }

        } else {
            System.out.println("No hay productos guardados, favor de agregar productos.\n");
        }
    }

}
