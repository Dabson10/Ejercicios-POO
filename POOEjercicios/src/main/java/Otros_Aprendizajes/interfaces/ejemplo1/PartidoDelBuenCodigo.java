package Otros_Aprendizajes.interfaces.ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class PartidoDelBuenCodigo {
    private List<EnviadorDeMensaje> mensajeros;

    public PartidoDelBuenCodigo(){
        mensajeros = new ArrayList<>();
    }
    public void agregarMensajero(EnviadorDeMensaje mensajero){
        mensajeros.add(mensajero);
    }
    public void hacerCampaña(){
        for(EnviadorDeMensaje mensajero : mensajeros){
            mensajero.enviarMensaje("Vote por el partido del buen código.");
        }
    }
}
