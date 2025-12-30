package Otros_Aprendizajes.interfaces.ejemplo3.Vehiculo;

import Otros_Aprendizajes.interfaces.ejemplo3.Conducible;

public class Auto extends Vehiculo implements Conducible {
    //Metodo heredado de la clase Vehiculo
    public Auto(String marca){
        super(marca);
    }

    //Contrato necesario al momento de implementar el interface Conducible
    @Override
    public void conducir(){
        System.out.println("El auto " + marca + ", se conduce bien.");
    }

}
