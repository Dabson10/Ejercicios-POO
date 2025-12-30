package Gestion_de_Concesionario_5.Vehiculos;

import Gestion_de_Concesionario_5.Vehiculo;

public class Camioneta extends Vehiculo {
    private int limiteDePasajeros;
    private int pesoMaximo;

    public Camioneta(String marca, String modelo, int year, float precio, int disponibles, int limiteDePasajeros, int pesoMaximo){
        super(marca, modelo, year, precio, disponibles);
        this.limiteDePasajeros = limiteDePasajeros;
        this.pesoMaximo = pesoMaximo;

    }
    @Override
    public float impuesto(){
        return getPrecio() * .30f;
    }
    @Override
    public String mostrarDatos(){
        return  "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nLimite de pasajeros: " + limiteDePasajeros +
                "\nTipo: " + pesoMaximo +
                "\nPrecio: " + getPrecio() +
                "\nPrecio con impuestos: "+ (impuesto() + getPrecio()) +
                "\nDisponibles: " + getDisponibles() +
                "\nPrecio totalitario: " + calcularTotal() +
                "\n";
    }
}
