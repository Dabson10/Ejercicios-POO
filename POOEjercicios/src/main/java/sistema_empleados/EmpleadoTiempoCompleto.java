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
 * EmpleadoTiempoCompleto (bonos, seguro)
 * */
public class EmpleadoTiempoCompleto extends Empleado{
    private float bono;
    private String seguro;
    
    public EmpleadoTiempoCompleto(String nombre, int ID, float salarioBase, float bono, String seguro){
        super(nombre, ID, salarioBase);
        this.bono = bono;
        this.seguro = seguro;
    }
    
        @Override
    public String mostrarDatos() {
        return "========================\n"
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nBono: " + bono
                + "\nSeguro: " + seguro
                + "\n========================"
                ;
    }
}
