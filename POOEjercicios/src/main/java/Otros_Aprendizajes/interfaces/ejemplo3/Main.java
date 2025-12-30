package Otros_Aprendizajes.interfaces.ejemplo3;

import Otros_Aprendizajes.interfaces.ejemplo3.Vehiculo.Auto;
import Otros_Aprendizajes.interfaces.ejemplo3.VideoJuego.VideoJuegoDeCarreras;

public class Main {
    public static void main(String[] args) {
        //Creamos un objeto usando Polimorfismo llamando al interface, pero distanciando a nombre de las clases
        Conducible conducir = new VideoJuegoDeCarreras();
        conducir.conducir();
        conducir = new Auto("Mercedes Benz");
        conducir.conducir();

        /**
         * Una de las cosas que me di cuenta al momento de instanciar diferentes clases sobre el interface
         * es que si quieres acceder a metodos o atributos de una clase en especifico debes de bajar o hacer un
         * Drowncasting sobre una clase especifica y asi poder acceder a la clase que quieres.
         * Obviamente tendras que validar que sea la clase la que buscas usando instanceof o algo diferente
         * en donde sepas que es esa clase.
         */
    }
}
