package Gestion_de_Consesionario.Vehiculos;

import Gestion_de_Consesionario.Vehiculo;

public class Cuatrimoto extends Vehiculo {

    private String tipoCuatriMoto;
    private int pesoMaximo;

    public Cuatrimoto(String marca, String modelo, int year, float precio, int disponibles, int pesoMaximo, String tipoCuatriMoto){
        super(marca, modelo, year, precio, disponibles);
        this.pesoMaximo = pesoMaximo;
        this.tipoCuatriMoto = tipoCuatriMoto;
    }

    @Override
    public String mostrarDatos(){
        return "\nDeportivo" +
                "\nMarca: " + getMarca() +
                "\nModelo" + getModelo() +
                "\nAño: " +  getYear() +
                "\nTipo de deportivo: " + tipoCuatriMoto +
                "\nTipo: " + pesoMaximo+
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
