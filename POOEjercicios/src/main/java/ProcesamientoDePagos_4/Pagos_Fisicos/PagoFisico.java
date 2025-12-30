package ProcesamientoDePagos_4.Pagos_Fisicos;

import ProcesamientoDePagos_4.MetodoDePago;

public abstract class PagoFisico extends MetodoDePago{
    protected String nombreSucursal;
    public PagoFisico(String nombreCliente, float totalAPagar, String nombreSucursal){
        super(nombreCliente, totalAPagar);
        this.nombreSucursal = nombreSucursal;
    }
}
