package Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad;

import Otros_Aprendizajes.interfaces.ejemplo4.Funcionalidad.AlarmaSeguridad;

public class SensorDeMovimiento extends SistemaSeguridad implements AlarmaSeguridad {
    public SensorDeMovimiento(String ID, String ubicacion){
        super(ID, ubicacion);
    }
    public void detectarPresencia(){
        System.out.print("Una persona paso por: " + ubicacion + ", " + ID);
    }
    @Override
    public void ejecutarProtocolo(){
        sonarAlarma();
        detectarPresencia();
    }
    @Override
    public void sonarAlarma(){
        System.out.print("¡¡¡¡ALERTA SENSOR!!!!!!! " );
    }
}
