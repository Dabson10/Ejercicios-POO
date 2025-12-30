package ProcesamientoDePagos_4.Pagos_Fisicos;

import java.util.Scanner;

public class Efectivo extends PagoFisico {
    private float pagaCon;

    //Metodos

    public Efectivo(String nombreCliente, float totalAPagar, String nombreSucursal, float pagaCon) {
        super(nombreCliente, totalAPagar, nombreSucursal);
        this.pagaCon = pagaCon;


    }


//    static Scanner scanner = new Scanner(System.in);


    //Metodos para validar el metodo de pago.
    @Override
    public boolean validacionPago(Scanner sc) {
        boolean validacion = false;
        float pagoCon = 0f;
        do {
            System.out.println("¿Con cuanto paga el cliente?");
            pagoCon = sc.nextFloat();

            if (pagoCon >= getTotalApagar()) {
                comisiones();
                System.out.println("El cambio es de: $" + (pagoCon - getTotalApagar()));
                validacion = true;
            } else {
                System.out.println("Ingrese una cantidad correcta");
            }
        } while (!validacion);

        return validacion;
    }



    //Metodo para generar una comision sobre el tipo de metodo de pago
    public float comisiones() {
        System.out.println("El pago no generara comisión ya que es en efectivo.");
        return 0f;
    }

    public String mostrarDatos() {

        return "La venta fue exitosa" +
                "\nCliente: " + getNombreCliente() +
                "\nFecha: " + getFechaDePago() +
                "\nPago con: " + pagaCon +
                "\nTotal a pagar: " + getTotalApagar() +
                "\nEstado: " + getEstadoPago() +
                "\nPago exitosamente.";
    }

}

