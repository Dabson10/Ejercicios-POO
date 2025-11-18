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
    private int horasTrabajadas ;
    private float pagoPorHora;
    
    public EmpleadoMedioTiempo(String nombre, String ID, float salarioBase, int horasTrabajadas, float pagoPorHora){
        super(nombre, ID, salarioBase);
        if(pagoPorHora > 0 && horasTrabajadas > 0){
            this.horasTrabajadas = horasTrabajadas;
            this.pagoPorHora = pagoPorHora;
        }else{
            System.out.println("Ingrese una hora valida y un pago valido.");
        }
    }

    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }
    public float getPagoPorHora(){
        return pagoPorHora;
    }


    @Override
    public float total(){
        return getSalarioBase() + (horasTrabajadas * pagoPorHora);
    }

    @Override
    public String mostrarDatos() {
        return "--------------------------------\n"
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nHoras trabajadas: " + horasTrabajadas
                + "\nPago por hora: " + pagoPorHora
                + "\nSalario + PagoxHora: " + (getSalarioBase() + (pagoPorHora * horasTrabajadas))
                + "\n--------------------------------"
                ;
    }
}
