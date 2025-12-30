/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sistema_empleados_3;

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
    
    public EmpleadoTiempoCompleto(String nombre, String ID, float salarioBase, float bono, String seguro){
        super(nombre, ID, salarioBase);
        if(bono > 0 || salarioBase > 0){
            this.bono = bono;
            this.seguro = seguro;
        }else{
            System.out.println("Ingrese un sueldo base o bono con valores positivos.");
        }
    }

    @Override
    public float total(){
        return getSalarioBase() + bono;
    }

    public float getBono(){
        return bono;
    }
    public String getSeguro(){
        return seguro;
    }

        @Override
    public String mostrarDatos() {
        return "--------------------------------\n"
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nBono: " + bono
                + "\nSeguro: " + seguro
                + "\nSueldo + Bono: " + (getSalarioBase() + bono)
                + "\n--------------------------------"
                ;
    }
}
