package Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad;

import Otros_Aprendizajes.interfaces.ejemplo4.Funcionalidad.AlarmaSeguridad;

public class SirenaDeEmergencia extends SistemaSeguridad implements AlarmaSeguridad {
    public SirenaDeEmergencia(String ID, String ubicacion){
        super(ID, ubicacion);
    }
    //Metodo propio de la clase
    public void sonarMuyFuerte(){
        System.out.print("La alarma sonó muy fuerte");
    }
    //Union de ambos metodos
    @Override
    public void ejecutarProtocolo(){
        sonarAlarma();
        sonarMuyFuerte();
    }
    //Metodo de implements
    @Override
    public void sonarAlarma(){
        System.out.print("¡¡¡¡ALERTA SIRENA DE EMERGENCIA.!!!!!!!");
    }
}
