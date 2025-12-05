package Gestion_de_Concesionario;
//Clase abstracta de vehiculo, esta contendra todas los
//atributos y metodos abstractos
public abstract class Vehiculo {
    //Atributos
    private String marca;
    private String modelo;
    private int year;
    private float precio;
    private int disponibles;

    //Metodos
    public Vehiculo(String marca, String modelo, int year, float precio, int disponibles) {
        if (disponibles >= 0) {
            //Si el precio es mayor a cero entonces se procede a guardar datos
            this.marca = marca;
            this.modelo = modelo;
            this.year = year;
            this.precio = precio;
            this.disponibles = disponibles;
        } else {
            System.out.println("Ingrese un precio razonable.");
        }
    }

    //Getters
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public int getYear(){
        return year;
    }
    public float getPrecio(){
        return precio;
    }
    public int getDisponibles(){
        return disponibles;
    }

    //Setters
    public void setDisponibles(int disponibles){
        if(this.disponibles != disponibles || disponibles >= 0){
            this.disponibles = disponibles;
        }
    }

    //Metodo que calcula el precio del vehiculo
    public float calcularTotal(){
        return disponibles * precio;
    }
    public abstract float impuesto();
    //Mostrar datos
    public abstract String mostrarDatos();

}
