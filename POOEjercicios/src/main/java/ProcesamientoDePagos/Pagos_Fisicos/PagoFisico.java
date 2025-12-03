package ProcesamientoDePagos.Pagos_Fisicos;

import ProcesamientoDePagos.MetodoDePago;

public abstract class PagoFisico extends MetodoDePago{
    protected String nombreSucursal;
    public PagoFisico(String nombreCliente, float totalAPagar, String nombreSucursal){
        super(nombreCliente, totalAPagar);
        this.nombreSucursal = nombreSucursal;
    }
}
