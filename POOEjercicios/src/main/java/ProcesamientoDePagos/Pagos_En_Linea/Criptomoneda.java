package ProcesamientoDePagos.Pagos_En_Linea;

import java.util.Scanner;

public class Criptomoneda extends PagoEnLinea{
    private String correoEmpresa = "empresa@gmail.com";
    private String correoCliente ;

    public Criptomoneda(String nombreCliente,float totalAPagar, String correoDeValidacion, String correoCliente){
        super(nombreCliente, totalAPagar, correoDeValidacion);
        this.correoCliente = correoCliente;
    }
    //Metodos abstractos
    @Override
    public boolean validacionPago(Scanner sc){
        boolean validacion = false, bucle = false;
        int opcion = 0, contador = 0, salida = 0;
        do{
            System.out.println("""
                    ¿Ya recibiste el mensaje de aceptacion de criptos?
                    1.Si.
                    2.No.
                    """);
            opcion = sc.nextInt();
            if(opcion == 1){
                System.out.println("Muchas gracias por pagar con criptos, se cobrara una comision del 8%");
                comisiones();
                validacion = true;
                bucle = true;
            }else{
                if(contador == 3){
                    System.out.println("Si no recibiste una confirmacion y quieres cancelar la venta presiona 1");
                    salida = sc.nextInt();
                    if(salida == 1 ){
                        bucle = true;
                        validacion = false;
                    }
                }
            }
            contador ++;
        }while(!bucle);
        return validacion;
    }
    @Override
    public float comisiones(){
        return getTotalApagar() * 0.08f;
    }
    @Override
    public String mostrarDatos(){
        return"Pago realizado con:" +
                "\nNombre del cliente: " + getNombreCliente() +
                "\nTotal a pagar: " + getTotalApagar() +
                "\nEstado del pago: " + getEstadoPago() +
                "\nCorreo de la empresa: " + correoEmpresa +
                "\nCorre del cliente: " + correoCliente +
                "\nCorreo de validación: " + getCorreoDeValidacion() +
                "\nFecha de pago: " + getFechaDePago() +
                "\n=====================";
    }
}
