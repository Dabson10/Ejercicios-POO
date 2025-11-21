package ProcesamientoDePagos.Pagos_Fisicos;

import java.util.Scanner;

public class Efectivo extends PagoFisico {
    private float pagaCon;

    //Metodos

    public Efectivo(String nombreCliente, float totalAPagar, String nombreSucursal, float pagaCon){
        super(nombreCliente, totalAPagar, nombreSucursal);
        if(pagaCon >= totalAPagar){
            //Si es mayor entonces procedemos con el pago
            this.pagaCon = pagaCon;
        }else{
            System.out.println("Ingrese una cantidad correcta");
            this.pagaCon = 0f;
        }

    }


    static Scanner scanner = new Scanner(System.in);


    //Metodos para validar el metodo de pago.
    public boolean validacionPago(){
        boolean validacion = false;
        int opcion =0;
        do{
            System.out.println("""
                    ¿Ya recibio el pago del cliente?
                    1.Si.
                    2.No.
                    """);
            opcion = scanner.nextInt();

            if(opcion == 1 ){
                validacion = true;
            }
        }while(opcion != 1);

        return validacion;
    }

    //Metodo para generar una comision sobre el tipo de metodo de pago
    public float comisiones(){
        System.out.println("El pago no generara comisión ya que es en efectivo.");
        return 0f;
    }
    public String mostrarDatos(){
        return "";
    }

}

