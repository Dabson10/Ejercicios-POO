package Sistema_De_Citas_Medicas.Modelos;
//Clase hija de la clase Doctor.
public class Pediatra extends Doctor{
    //Atributos
    private String rangoEdad;
    private boolean atiendeUrgencias;

    //Metodos
    public Pediatra(String ID, String nombres, String apellidos, int experiencia,
                    String horario, String rangoEdad, boolean atiendeUrgencias){
        super(ID, nombres, apellidos, experiencia, horario, 1500.00f);
        this.rangoEdad = rangoEdad;
        this.atiendeUrgencias = atiendeUrgencias;
    }
    //Metodos Getters y Setter de la clase.

    public String getRangoEdad() {
        return rangoEdad;
    }
    public void setRangoEdad(String rangoEdad){
        if(!rangoEdad.isEmpty()){
            //Si no esta vacío entonces se guardan los datos.
            this.rangoEdad = rangoEdad;
        }else{
            System.out.println("Ingrese un rango de edad.\n");
        }
    }

    //Metodo que muestra los datos del doctor.
    @Override
    public String mostrarDatos(){
        String urgencias = (atiendeUrgencias) ? "Si" : "No";
        return "\nDoctor: " + getApellidos().concat(" ").concat(getNombres()) +
                "\nAtiende a niños con edad entre: " + rangoEdad +
                "\nEspecialidad: "+
                "\nEl doctor "  + urgencias + " atiende urgencias" +
                "\nExperiencia: " + getExperiencia() +
                "\nTarifa por consulta: " + getTarifaPorConsulta() +
                "\nHorario: " + getHorario() +
                "\nID: " + getID();
    }

}
