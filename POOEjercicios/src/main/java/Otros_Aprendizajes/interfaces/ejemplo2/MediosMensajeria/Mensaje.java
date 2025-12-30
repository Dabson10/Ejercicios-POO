package Otros_Aprendizajes.interfaces.ejemplo2.MediosMensajeria;

public abstract class Mensaje {
     String emisor;
     Mensaje(String emisor){
        this.emisor = emisor;
    }

    public abstract void mostrarMensaje();
}
