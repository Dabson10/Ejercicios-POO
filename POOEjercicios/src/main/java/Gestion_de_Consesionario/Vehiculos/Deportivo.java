package Gestion_de_Consesionario.Vehiculos;

import Gestion_de_Consesionario.Vehiculo;

public class Deportivo extends Vehiculo {
    private int limiteKM;
    private String tipoDeportivo;
    public Deportivo(String marca, String modelo,int year, float precio, int disponibles, int limiteKM, String tipoDeportivo){
        super(marca, modelo, year, precio, disponibles);
        this.limiteKM = limiteKM;
        this.tipoDeportivo = tipoDeportivo;
    }

    @Override
    public String mostrarDatos(){
        return  "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " +  getYear() +
                "\nLimite de KM: " + limiteKM +
                "\nTipo: " + tipoDeportivo +
                "\nPrecio: " + getPrecio()
                + "\n";
    }
    @Override
    public String mostrarTotal(){
        return "Valor total Deportivo." +
                "\nCantidad: " + getDisponibles() +
                "\nPrecio unitario: " + getPrecio() +
                "\nPrecio totalitario: " + calcularTotal();
    }

}
