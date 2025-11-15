package sistema_empleados;

/**
 *
 * @author Dabson
 */

/**Atributos de la clase requeridos 
 * Gerente (departamento, empleados a cargo, bono extra)
 * */
public class Gerente extends Empleado {

    private String departamento;
    private int empleadosACargo;
    private float bonoExtra;

    public Gerente(String nombre, int ID, float salarioBase, String departamento, int empleadosACargo, float bonoExtra) {
        super(nombre, ID, salarioBase);
        this.departamento = departamento;
        this.empleadosACargo = empleadosACargo;
        this.bonoExtra = bonoExtra;
    }
    
    
        @Override
    public String mostrarDatos() {
        return "========================\n" 
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nDepartamento: " + departamento
                + "\nEmpleados a cargo: " + empleadosACargo
                + "\nBono extra: " + bonoExtra
                + "\n========================"
                ;
    }
}
