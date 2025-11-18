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

    public Gerente(String nombre, String ID, float salarioBase, String departamento, int empleadosACargo, float bonoExtra) {
        super(nombre, ID, salarioBase);
        if(bonoExtra > 0 && empleadosACargo > 0){
            this.departamento = departamento;
            this.empleadosACargo = empleadosACargo;
            this.bonoExtra = bonoExtra;
        }
    }

    public String getDepartamento(){
        return departamento;
    }
    public int getEmpleadosACargo(){
        return empleadosACargo;
    }
    public float getBonoExtra(){
        return bonoExtra;
    }



    //Funcion para sumar el total de bono y salario, mas que nada para solo llamar a la funcion desde el main
    @Override
    public float total(){
        return getSalarioBase() + bonoExtra;
    }

    
        @Override
    public String mostrarDatos() {
        return "--------------------------------\n"
                + "El empleado es: "
                + "\nNombre: " + getNombre()
                + "\nID: " + getID()
                + "\nSalario base: " + getSalarioBase()
                + "\nDepartamento: " + departamento
                + "\nEmpleados a cargo: " + empleadosACargo
                + "\nBono extra: " + bonoExtra
                + "\nSueldo + bono: " + (getSalarioBase() + bonoExtra)
                + "\n--------------------------------"
                ;
    }
}
