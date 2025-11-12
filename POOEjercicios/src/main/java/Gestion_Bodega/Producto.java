/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Gestion_Bodega;

/**
 *
 * @author Dabson
 */
public class Producto {
    /*
        Necesito un sistema para gestionar el inventario de mi bodega. 
Quiero poder agregar productos con su código, nombre, categoría, cantidad, 
precio y ubicación. Necesito buscar productos por código o nombre, 
modificar su información (especialmente cantidad y precio), y 
eliminar productos cuando ya no los maneje. 
    */
    private String nombre;
    private String codigo;
    private String categoria;
    private int cantidad;
    private float precio;
    private String ubicacion;
    
    public Producto(String nombre,String codigo, String categoria, int cantidad,
            float precio, String ubicacion
    ){
        this.nombre = nombre.trim();
        this.codigo = codigo.trim();
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.ubicacion = ubicacion.trim();
        
    }
    //Solo se buscara mediante nombre o codigo de producto.
    public String getNombre(){
        return nombre;
    }
    public String getCodigo(){
        return codigo;
    }
    
    //Este getCategoria es para poder definir una ubicacion a productos similares, por ejemplos
    //A_1 a la categoria electronicos, A_2 a la categoria 
    //Personalmente quiero obtener la ubicacion de los productos, para algo que yo quiero implementar.
    public String getUbicacion(){
        return ubicacion;
    }
   
    //Solo se modificara el precio y la cantidad
   public void setPrecio(float precio){
       this.precio = precio;
   }
   public void setCantidad(int cantidad){
       this.cantidad = cantidad;
   }
   
   //Se mostraran los datos para el almacen
   public String toString(){
       return "[ " + codigo + " ] " + nombre+ 
               "\nCategoria: " + categoria + " | Stock: " + cantidad + " Unidades |\n" + 
               "Ubicacion: " + ubicacion + " | Valor total: $" + String.format("%.2f",(cantidad * precio)
               ) ;
   }
   
   

    
    
    
    
}
