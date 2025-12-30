package Otros_Aprendizajes.interfaces.ejemplo1.Ave;

import Otros_Aprendizajes.interfaces.ejemplo1.EnviadorDeMensaje;

public class PalomaMensajera extends Ave implements EnviadorDeMensaje {
    public void volarRapido(){
        System.out.println("Volando....");
    }

    @Override
    public void enviarMensaje(String mensaje){
        volarRapido();
        System.out.print("Lanzado un papel que dice: " + mensaje);
    }
}
