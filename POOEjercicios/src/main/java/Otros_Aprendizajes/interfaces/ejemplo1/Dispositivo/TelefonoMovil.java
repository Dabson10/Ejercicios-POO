package Otros_Aprendizajes.interfaces.ejemplo1.Dispositivo;

import Otros_Aprendizajes.interfaces.ejemplo1.EnviadorDeMensaje;

public class TelefonoMovil extends Dispositivo implements EnviadorDeMensaje {
    public void llamar(){
        System.out.print("Llamando..... ");
    }


    @Override
    public void enviarMensaje(String mensaje){
        encender();
        llamar();
        System.out.println("Se llamo y envio el mensaje de: " + mensaje);
    }

}
