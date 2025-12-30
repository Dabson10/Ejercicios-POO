package Otros_Aprendizajes.interfaces.ejemplo2;

import Otros_Aprendizajes.interfaces.ejemplo2.MediosMensajeria.PalomaMensajera;
import Otros_Aprendizajes.interfaces.ejemplo2.MediosMensajeria.WhatsApp;
import Otros_Aprendizajes.interfaces.ejemplo2.paqueteria.Enviable;

public class Main {

    public static void main(String [] args){
        Enviable enviar = new PalomaMensajera();
        enviar.enviar();
        enviar = new WhatsApp("Telefono");
        enviar.enviar();

    }

}
