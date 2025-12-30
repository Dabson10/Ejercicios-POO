package Otros_Aprendizajes.interfaces.ejemplo3.VideoJuego;

import Otros_Aprendizajes.interfaces.ejemplo3.Conducible;

public class VideoJuegoDeCarreras implements Conducible {

    @Override
    public void conducir(){
        System.out.println("Se esta conduciendo en el videojuego");
    }
}
