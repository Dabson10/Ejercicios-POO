package Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad;

public abstract class SistemaSeguridad {
    String ID ;
    String ubicacion;
    SistemaSeguridad(String ID, String ubicacion){
        this.ID = ID;
        this.ubicacion = ubicacion;
    }
    public abstract void ejecutarProtocolo();
}
