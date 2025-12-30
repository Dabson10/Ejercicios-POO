package Otros_Aprendizajes.interfaces.ejemplo1;

import Otros_Aprendizajes.interfaces.ejemplo1.Ave.PalomaMensajera;
import Otros_Aprendizajes.interfaces.ejemplo1.Dispositivo.TelefonoMovil;

public class Principal {
    public static void main(String[] args) {
        PartidoDelBuenCodigo PBC = new PartidoDelBuenCodigo();

        PBC.agregarMensajero(new PalomaMensajera());
        PBC.agregarMensajero(new PalomaMensajera());
        PBC.agregarMensajero(new PalomaMensajera());

        PBC.agregarMensajero(new TelefonoMovil());
        PBC.agregarMensajero(new TelefonoMovil());
        PBC.agregarMensajero(new TelefonoMovil());
        System.out.println();
        PBC.hacerCampaña();
    }
}
