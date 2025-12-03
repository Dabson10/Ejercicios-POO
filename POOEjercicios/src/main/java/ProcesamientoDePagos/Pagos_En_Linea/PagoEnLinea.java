package ProcesamientoDePagos.Pagos_En_Linea;

import ProcesamientoDePagos.MetodoDePago;

import java.time.LocalDate;

public abstract class PagoEnLinea extends MetodoDePago{

    protected String correoDeValidacion;

    public PagoEnLinea(String nombreCliente,float totalAPagar, String correoDeValidacion ){
        super(nombreCliente, totalAPagar);
        this.correoDeValidacion = correoDeValidacion;
    }

    public String getCorreoDeValidacion(){
        return correoDeValidacion;
    }

}
