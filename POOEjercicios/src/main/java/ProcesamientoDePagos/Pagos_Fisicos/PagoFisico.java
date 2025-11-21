package ProcesamientoDePagos.Pagos_Fisicos;

import ProcesamientoDePagos.MetodoDePago;

public abstract class PagoFisico extends MetodoDePago{
    protected String nombreSucursal;
    public PagoFisico(String nombreCliente, float totalAPagar, String nombreSucursal){
        super(nombreCliente, totalAPagar);
        this.nombreSucursal = nombreSucursal;
    }
    //Faltan los metodos abstractos pero cuando se herede a la clase efectivo ahi si los pedira obligatoriamente
    //Aqui tengo duda, por que en mi diagrama de clases tengo en la clase PagoFisico el metodo de validar,
    //pero esta ya viene heredada de la clase MetodoDePago.
}
