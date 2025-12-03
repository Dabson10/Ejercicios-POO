package Gestion_de_Consesionario;
//Clase abstracta de vehiculo, esta contendra todas los
//atributos y metodos abstractos
public abstract class Vehiculo {
    //Atributos
    public String marca;
    public String modelo;
    public int year;
    public float precio;
    private int disponibles;

    //Metodos
    public Vehiculo(String marca, String modelo, int year, float precio, int disponibles) {
        if (precio > 0) {
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

    //Metodo que calcula el precio del vehiculo
    public float calcularTotal(){
        return disponibles * precio;
    }

    //Mostrar datos
    public abstract String mostrarDatos();

    //Mostrar el valor total de cada seccion de vehiculos.
    public abstract String mostrarTotal();

}
