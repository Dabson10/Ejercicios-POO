package ProcesamientoDePagos.Pagos_En_Linea;

import java.util.Scanner;

public class Transferencia extends PagoEnLinea{
    private int numCuentaCliente;

    public Transferencia(String nombreCliente, float totalAPagar,String correoDeValidacion, int numCuentaCliente){
        super(nombreCliente, totalAPagar, correoDeValidacion);
        this.numCuentaCliente = numCuentaCliente;
    }


    @Override
    public boolean validacionPago(Scanner sc){
        boolean validacion = false;
        int opcion = 0;
        do{
            System.out.println("""
                    ¿Ya recibiste el comprobande de transferencia?
                    1.Si.
                    2.No.
                    """);
            opcion =sc.nextInt();
            if(opcion == 1){
                comisiones();
                System.out.println("Se agrego un 5% de comision sobre el producto.");
            }
        }while(!validacion);
        return validacion;
    }
    @Override
    public float comisiones(){
        return getTotalApagar() * 0.5f;
    }
    public String mostrarDatos(){
        return"Pago realizado con:" +
                "\nNombre del cliente: " + getNombreCliente() +
                "\nTotal a pagar: " + getTotalApagar() +
                "\nEstado del pago: " + getEstadoPago() +
                "\nCorreo de validación: " + getCorreoDeValidacion() +
                "\nNum de cuenta: " + numCuentaCliente +
                "\nFecha de pago: " + getFechaDePago() +
                "\n=====================";
    }
}
