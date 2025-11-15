/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sistema_empleados;

/**
 *
 * @author Dabson
 */

/**Atributos de la clase requeridos 
 * EmpleadoMedioTiempo (horas trabajadas, pago por hora)
 * */

public class EmpleadoMedioTiempo extends Empleado{
    //Atributos de la clase EmpleadoMedioTiempo
    private String horasTrabajadas ;
    private float pagoPorHora;
    
    public EmpleadoMedioTiempo(String nombre, int ID, float salarioBase, String horasTrabajadas, float pagoPorHora){
        super(nombre, ID, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }
    @Override
    public String mostrarDatos() {
        return "========================\n"
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nHoras trabajadas: " + horasTrabajadas
                + "\nPago por hora: " + pagoPorHora
                + "\n========================"
                ;
    }
}
