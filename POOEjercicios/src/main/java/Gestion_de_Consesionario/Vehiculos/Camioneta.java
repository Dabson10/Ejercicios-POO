package Gestion_de_Consesionario.Vehiculos;

import Gestion_de_Consesionario.Vehiculo;

public class Camioneta extends Vehiculo {
    private int limiteDePasajeros;
    private int pesoMaximo;

    public Camioneta(String marca, String modelo, int year, float precio, int disponibles, int limiteDePasajeros, int pesoMaximo){
        super(marca, modelo, year, precio, disponibles);
        this.limiteDePasajeros = limiteDePasajeros;
        this.pesoMaximo = pesoMaximo;

    }
    @Override
    public String mostrarDatos(){
        return "\nDeportivo" +
                "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nLimite de pasajeros: " + limiteDePasajeros +
                "\nTipo: " + pesoMaximo +
                "\nPrecio: " + getPrecio();
    }

    @Override
    public String mostrarTotal(){
        return "Valor total Motos." +
                "\nCantidad: " + getDisponibles() +
                "\nPrecio unitario: " + getPrecio() +
                "\nPrecio totalitario: " + calcularTotal();
    }

}
