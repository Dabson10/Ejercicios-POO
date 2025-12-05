package Gestion_de_Concesionario.Vehiculos;

import Gestion_de_Concesionario.Vehiculo;

public class Cuatrimoto extends Vehiculo {

    private String tipoCuatrimoto;
    private int pesoMaximo;

    public Cuatrimoto(String marca, String modelo, int year, float precio, int disponibles, int pesoMaximo, String tipoCuatrimoto){
        super(marca, modelo, year, precio, disponibles);
        this.pesoMaximo = pesoMaximo;
        this.tipoCuatrimoto = tipoCuatrimoto;
    }
    @Override
    public float impuesto(){
        return getPrecio() * .10f;
    }

    @Override
    public String mostrarDatos(){
        return "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nTipo de deportivo: " + tipoCuatrimoto +
                "\nTipo: " + pesoMaximo+
                "\nPrecio: " + getPrecio() +
                "\nPrecio con impuestos: "+ (impuesto() + getPrecio()) +
                "\nDisponibles: " + getDisponibles() +
                "\nPrecio totalitario: " + calcularTotal() +
                "\n";
    }
}
