package Otros_Aprendizajes.interfaces.ejemplo4;

import Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad.CamaraDeSeguridad;
import Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad.SensorDeMovimiento;
import Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad.SirenaDeEmergencia;
import Otros_Aprendizajes.interfaces.ejemplo4.AparatosDeSeguridad.SistemaSeguridad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<SistemaSeguridad> seguridadObj = new ArrayList<>();
            seguridadObj.add(new SensorDeMovimiento("SEN_0001", "Piso_1"));
            seguridadObj.add(new SirenaDeEmergencia("SIR_0001", "Piso_1"));
            seguridadObj.add(new CamaraDeSeguridad("CAM_0001", "Piso_1"));
            seguridadObj.add(new SensorDeMovimiento("SEN_0002", "Piso_2"));
            seguridadObj.add(new SirenaDeEmergencia("SIR_0002", "Piso_2"));
            seguridadObj.add(new CamaraDeSeguridad("CAM_0002", "Piso_2"));
            for (SistemaSeguridad objeto : seguridadObj) {
                objeto.ejecutarProtocolo();
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error del tipo: " + e.getMessage());
        }
    }
}
