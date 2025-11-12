/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Bodega;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author Dabson
 */
//Ejercicio
/*
    Necesito un sistema para gestionar el inventario de mi bodega. 
Quiero poder agregar productos con su código, nombre, categoría, cantidad, 
precio y ubicación. Necesito buscar productos por código o nombre, 
modificar su información (especialmente cantidad y precio), y 
eliminar productos cuando ya no los maneje. 
Es importante que me muestre reportes como: 
productos con poco stock (menos de 10 unidades), 
el valor total de todo mi inventario, y que me agrupe los productos 
por categoría. También quiero que me avise si intento agregar un 
producto con un código que ya existe, y que no me deje poner cantidades o
precios negativos. Sería genial que al inicio me muestre una alerta si hay 
productos con stock bajo para estar al pendiente. 
El sistema debe ser fácil de usar desde un menú con opciones numeradas.
 */
public class Principal {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args){
        //Menu de opciones
        boolean acceso = true;
        //ArrayList de la clase Producto
        ArrayList<Producto> productos = new ArrayList<>();
        int opcion;
        while(acceso){
            try{
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
                switch(opcion){
                    case 1 ->{
                        System.out.println("==== Productos en Bodega ====");
                        mostrarProductos(productos);
                    }
                    case 2 -> {
                        System.out.println("==== Agregar Productos ====");
                        agregarProductos(productos);
                    }
                    case 3 ->{
                        System.out.println("==== Editar Productos ====");
                        editarProductos(productos);
                    }
                    case 4 ->{
                        System.out.println("==== Eliminar Productos ====");
                        eliminarProductos(productos);
                    }
                    case 5 ->{
                        System.out.println("Hasta luego");
                        acceso = false;
                    }
                    default ->{System.out.println("Ingrese un valor correcto");}
                }
            }catch(Exception e){
                System.out.println("Error del tipo: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
    
    //Funciones CRUD
    
    //Mostrar productos.
    public static void mostrarProductos(ArrayList<Producto> producto){
        //Validacion sobre si esta o no vacia la lista
        if(!producto.isEmpty()){
            //Si no esta vacia entonces recorrera la lista objeto por objeto y mostrara los datos
            producto.forEach(produ ->{
                System.out.println(produ.toString());
            });
        }else{
            System.out.println("No hay productos en existencia.");
        }
    }
    
    //Agregar productos
    public static void agregarProductos(ArrayList<Producto> producto){
        sc.nextLine();
        int cantidad;
        int controlAcceso = 0;
        
        //Variables que se agregaran en el constructor del objeto
        String  codigo, categoria,ubicacion;
        int cantidadProductos;
        float precio;
        
        //Se pedira la cantidad de productos que se agregaran
        System.out.print("¿Cuantos productos agregara? ");
        cantidad = sc.nextInt();
        
        //Este for realizara las repeticiones para agregar nuevos productos.
        for(int i = 0; i < cantidad; i++){
            //Si la lista producto no esta vacio entonces procede a otra validacion,
            //en donde buscara si existe algun producto con ese nombre
            if(!producto.isEmpty()){
                //Ahora como existen productos es necesario validar que no exista un nombre similar,
                //por esto mismo es necesario comparar el nombre de entrada con nombres de productos
                //previamente registrados.
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = sc.nextLine().trim();
                
                for(int j = 0; j < producto.size(); j++){
                    if(producto.get(j).getNombre().equalsIgnoreCase(nombre)){
                        //Si hay un producto igual entoces termina el bucle.
                        controlAcceso = 1;
                        break;
                    }
                }
                
                //Ahora se tiene que realizar el if para ver si se agrega o no el producto.
                if(controlAcceso ==0){
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
                   int cadenaRecortada = Integer.parseInt(ultimoCodigo.substring(2, ultimoCodigo.length()) );
                   System.out.println("La cadena recortada es: " + cadenaRecortada);
                    System.out.println("El ultimo codigo es: " + ultimoCodigo);
                    //En base a cadenaRecortada se realizara el switch para la asignacion de codigo nuevo.
                }else{
                    System.out.println("No se agregaran productos existente.");
                }
                
                    
                
            }else{
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
            }
        }
    }
    
    //Editar productos
    public static void editarProductos(ArrayList<Producto> producto){
        
    }
    
    //Eliminar productos.
    public static void eliminarProductos(ArrayList<Producto> producto){
        
    }
    
    
}
