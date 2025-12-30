
package Gestion_Bodega_2;

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

    public Producto(String nombre, String codigo, String categoria, int cantidad,
            float precio, String ubicacion
    ) {

        if (cantidad < 0 || precio < 0) {
            System.out.println("Ingrese valores positivos.");
        } else {
            this.nombre = nombre.trim();
            this.codigo = codigo.trim();
            this.categoria = categoria.trim();
            this.cantidad = cantidad;
            this.precio = precio;
            this.ubicacion = ubicacion.trim();
        }

    }

    //Solo se buscara mediante nombre o codigo de producto.
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    //Este getCategoria es para poder definir una ubicacion a productos similares, por ejemplos
    public String getCategoria() {
        return categoria;
    }

    //A_1 a la categoria electronicos, A_2 a la categoria 
    //Personalmente quiero obtener la ubicacion de los productos, para algo que yo quiero implementar.
    public String getUbicacion() {
        return ubicacion;
    }
    //El uso de getCantidad es para comparar la nueva cantidad con la antigua y asi no se guarde el mismo valor.
    public int getCantidad(){
        return cantidad;
    }
    public float getPrecio(){
        return precio;
    }

    //Solo se modificara el precio y la cantidad
    public void setPrecio(float precio) {
        if(precio < 0){
            System.out.println("Ingrese un precio valido.");
        }else{
            this.precio = precio;
        }
    }

    public void setCantidad(int cantidad) {
        if(cantidad < 0){
            System.out.println("Ingrese una cantidad valida");
        }else{
            this.cantidad = cantidad;
        }
    }

    //Se mostraran los datos para el almacen
    public String toString() {
        String mensaje = "";
        if (cantidad < 10) {
            mensaje = "\n==========\n"
                    + "[ " + codigo + " ] " + nombre
                    + "\nCategoria: " + categoria + " | Stock: " + cantidad + " Unidades | Precio: " + precio
                    + "\nUbicacion: " + ubicacion + " | Valor total: $" + String.format("%.2f", (cantidad * precio))
                    + "\nAlerta, productos con minima cantidad"
                    + "\n==========\n";
        } else {
            mensaje = "\n==========\n[ " + codigo + " ] " + nombre
                    + "\nCategoria: " + categoria + " | Stock: " + cantidad + " Unidades | Precio: " + precio
                    + "\nUbicacion: " + ubicacion + " | Valor total: $" + String.format("%.2f", (cantidad * precio))
                    + "\n==========\n";
        }
        return mensaje;
    }

}
