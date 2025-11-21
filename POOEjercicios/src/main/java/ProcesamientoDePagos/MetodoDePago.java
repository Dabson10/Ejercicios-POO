package ProcesamientoDePagos;


public abstract class MetodoDePago {
    //Atributos de la clase
    protected String nombreCliente;
    protected String estadoPago = "Pendiente";
    protected float totalApagar;
    protected Float pagaCon = null;

    //Metodo constructos y metodos abstractos de la clase.
    public MetodoDePago(String nombreCliente, float totalApagar){
        if(totalApagar > 0){
            //Si es mayor a cero el totalAPagar entonces procedemos con el guardado de datos.
            this.nombreCliente = nombreCliente;
            this.totalApagar = totalApagar;
        }else{
            System.out.println("Ingrese una cantidad valiada para guardar el historial.");
        }
    }

    //Metodo para validar el pago, con base en este método los siguientes metodos funcionarán y realizaran ciertas acciones.
    public abstract boolean validacionPago();
    //Este metodo retornara y sumara los valores de la comision y con lo que se pagara.
    public abstract float comisiones();
    //Solo servira para mostrar los datos de la venta.
    public abstract String mostrarDatos();




}
