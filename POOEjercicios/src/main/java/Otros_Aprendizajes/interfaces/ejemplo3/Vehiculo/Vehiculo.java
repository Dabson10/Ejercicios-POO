package Otros_Aprendizajes.interfaces.ejemplo3.Vehiculo;

public abstract class Vehiculo {
    String marca;
    Vehiculo (String marca){
        this.marca = marca;
    }
    void marcaAuto(){
        System.out.println("La marca del vehiculo es: " + marca);
    }
}
