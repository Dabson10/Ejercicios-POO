package ProcesamientoDePagos_4.Pagos_En_Linea;

import ProcesamientoDePagos_4.MetodoDePago;

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
