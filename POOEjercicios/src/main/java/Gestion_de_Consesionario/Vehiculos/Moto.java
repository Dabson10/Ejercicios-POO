package Gestion_de_Consesionario.Vehiculos;

import Gestion_de_Consesionario.Vehiculo;

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
    public String mostrarDatos(){
        return "\nMoto" +
                "\nMarca: " + getMarca() +
                "\nModelo" + getModelo() +
                "\nAño: " +  getYear() +
                "\nCilindrada: " + cilindrada +
                "\nTipo: " + tipoDeMoto +
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