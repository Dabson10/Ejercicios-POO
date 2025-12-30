package Otros_Aprendizajes.interfaces.ejemplo2.MediosMensajeria;

import Otros_Aprendizajes.interfaces.ejemplo2.paqueteria.Enviable;

public class WhatsApp extends Mensaje implements Enviable {
    public WhatsApp(String emisor){
        super(emisor);
    }
    @Override
    public void mostrarMensaje(){
        System.out.println("Enviado por: " +emisor);
    }
    @Override
    public void enviar(){
        System.out.println("Enviando WhatsApp por Wifi/Datos.....");
    }
}
