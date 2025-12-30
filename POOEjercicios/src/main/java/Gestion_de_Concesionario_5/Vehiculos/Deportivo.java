package Gestion_de_Concesionario_5.Vehiculos;

import Gestion_de_Concesionario_5.Vehiculo;

public class Deportivo extends Vehiculo {
    private int limiteKM;
    private String tipoDeportivo;
    public Deportivo(String marca, String modelo,int year, float precio, int disponibles, int limiteKM, String tipoDeportivo){
        super(marca, modelo, year, precio, disponibles);
        this.limiteKM = limiteKM;
        this.tipoDeportivo = tipoDeportivo;
    }
    @Override
    public float impuesto(){
        return getPrecio() * .25f;
    }
    @Override
    public String mostrarDatos(){
        return  "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nLimite de KM: " + limiteKM +
                "\nTipo: " + tipoDeportivo +
                "\nPrecio sin impuestos: " + getPrecio() +
                "\nPrecio con impuestos: "+ (impuesto() + getPrecio()) +
                "\nDisponibles: " + getDisponibles() +
                "\nPrecio totalitario: " + calcularTotal() +
                "\n";
    }
}
