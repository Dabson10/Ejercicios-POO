package sistema_empleados;

/**
 *
 * @author Dabson
 */
public class Empleado {

    //Atributos de la clase Empleado
    protected String nombre;
    protected int ID;
    protected float salarioBase;

    //Constructor de la clase
    public Empleado(String nombre, int ID, float salarioBase) {
        //Si el salario base es menor a cero entonces no agregamos nada
        if (salarioBase < 0) {
            System.out.println("Ingrese un valor positivo");
        } else {
            this.nombre = nombre;
            this.ID = ID;
            this.salarioBase = salarioBase;
        }
    }
    //Metodos getter y setter en base a los atributos.

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    //Metodo para mostrar los datos del empleado.
    public String mostrarDatos() {
        return "========================\n"
                + "El empleado es: "
                + "\nNombre: " + nombre
                + "\nID: " + ID
                + "\nSalario base: " + salarioBase
                + "\n========================"
                ;
    }

}
