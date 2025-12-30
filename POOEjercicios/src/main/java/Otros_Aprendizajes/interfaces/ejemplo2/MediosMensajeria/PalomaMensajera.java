package Otros_Aprendizajes.interfaces.ejemplo2.MediosMensajeria;

import Otros_Aprendizajes.interfaces.ejemplo2.paqueteria.Enviable;

public class PalomaMensajera implements Enviable {

    @Override
    public void enviar(){
        System.out.println("La paloma ha despegado con el papelito.....");
    }

}
