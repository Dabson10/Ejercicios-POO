package ProcesamientoDePagos_4.Tarjetas;

import ProcesamientoDePagos_4.MetodoDePago;

import java.util.Scanner;

public class Tarjeta extends MetodoDePago {

    private String nombreDelBanco;
    private int numeroDeCuenta;
    private String tipoDeTarjeta;
    private float saldo;

    public Tarjeta(String nombreCliente, float totalAPagar, String nombreDelBanco,
                   int numeroDeCuenta, String tipoDeTarjeta, float saldo){
        super(nombreCliente, totalAPagar);
        this.nombreDelBanco = nombreDelBanco;
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

    @Override
    public boolean validacionPago(Scanner sc) {
        boolean validacion = false;
        float dineroCliente = 0f;
        int procedio = 0;
        do{
            System.out.println("""
                La tarjeta del cliente procedio al pago
                1.Si.
                2.No.
                """);
            procedio = sc.nextInt();
            if(procedio == 1){
                System.out.println("""
                    El pago se completo con exito.
                    Se agrego un cargo extra por comision.
                    """);
                validacion = true;
            }
        }while(!validacion);

    return validacion;
    }
    @Override
    public float comisiones(){
        System.out.println("Se cobrara una comision del 3.5% a tu compra.");
        return getTotalApagar() * 0.035f;
    }
    @Override
    public String mostrarDatos(){
        return"Pago realizado con:" +
                "\nNombre del cliente: " + getNombreCliente() +
                "\nTotal a pagar: " + getTotalApagar() +
                "\nEstado del pago: " + getEstadoPago() +
                "\nNombre del banco: " + nombreDelBanco +
                "\nTipo de tarjeta: " + tipoDeTarjeta +
                "\nNum de cuenta: " + numeroDeCuenta +
                "\nFecha de pago: " + getFechaDePago() +
                "\n=====================";
    }
}
