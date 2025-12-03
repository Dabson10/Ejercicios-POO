package ProcesamientoDePagos.Pagos_En_Linea;

import java.util.Scanner;

public class PayPal extends PagoEnLinea{

    private String correoCliente;

    public PayPal(String nombreCliente, float totalAPagar, String correoDeValidacion, String correoCliente){
        super(nombreCliente, totalAPagar, correoDeValidacion);
        this.correoCliente = correoCliente;
    }

    //Metodos abstractos.

    @Override
    public boolean validacionPago(Scanner sc){
        return false;
    }
    @Override
    public float comisiones(){
        return 0f;
    }
    @Override
    public String mostrarDatos(){
        return "";
    }
}
