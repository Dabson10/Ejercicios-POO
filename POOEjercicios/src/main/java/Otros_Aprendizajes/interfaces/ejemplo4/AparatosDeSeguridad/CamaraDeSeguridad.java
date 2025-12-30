package Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad;

public class CamaraDeSeguridad extends SistemaSeguridad{
    public CamaraDeSeguridad(String ID, String ubicacion){
        super(ID, ubicacion);
    }
    public void grabar(){
        System.out.println("Grabacion en curso: " + ID +", Ubicación: " + ubicacion);
    }
    @Override
    public void ejecutarProtocolo(){
        grabar();
    }
}
