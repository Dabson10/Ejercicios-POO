package Gestion_de_Consesionario.Vehiculos;

import Gestion_de_Consesionario.Vehiculo;

public class Cuatrimoto extends Vehiculo {

    private String tipoCuatrimoto;
    private int pesoMaximo;

    public Cuatrimoto(String marca, String modelo, int year, float precio, int disponibles, int pesoMaximo, String tipoCuatrimoto){
        super(marca, modelo, year, precio, disponibles);
        this.pesoMaximo = pesoMaximo;
        this.tipoCuatrimoto = tipoCuatrimoto;
    }

    @Override
    public String mostrarDatos(){
        return "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nTipo de deportivo: " + tipoCuatrimoto +
                "\nTipo: " + pesoMaximo+
                "\nPrecio: " + getPrecio()
                + "\n";
    }

    @Override
    public String mostrarTotal(){
        return "Valor total Motos." +
                "\nCantidad: " + getDisponibles() +
                "\nPrecio unitario: " + getPrecio() +
                "\nPrecio totalitario: " + calcularTotal();
    }

}
