package Gestion_de_Concesionario_5.Vehiculos;

import Gestion_de_Concesionario_5.Vehiculo;

public class Moto extends Vehiculo {

    private String cilindrada;
    private String tipoDeMoto;

    //Metodos
    public Moto(String marca, String modelo, int year, float precio, int disponibles, String cilindrada, String tipoDeMoto){
        super(marca, modelo, year, precio, disponibles);
        this.cilindrada = cilindrada;
        this.tipoDeMoto = tipoDeMoto;
    }
    @Override
    public float impuesto(){
        return getPrecio() * .15f;
    }

    @Override
    public String mostrarDatos(){
        return "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nCilindrada: " + cilindrada +
                "\nTipo: " + tipoDeMoto +
                "\nPrecio sin impuestos: " + getPrecio() +
                "\nPrecio con impuestos: "+ (impuesto() + getPrecio()) +
                "\nDisponibles: " + getDisponibles() +
                "\nPrecio totalitario: " + calcularTotal() +
                "\n";

    }
}