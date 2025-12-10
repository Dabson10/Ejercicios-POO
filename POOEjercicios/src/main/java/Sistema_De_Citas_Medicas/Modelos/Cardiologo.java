package Sistema_De_Citas_Medicas.Modelos;
//Clase hija de la clase Doctor.
public class Cardiologo extends Doctor{
    private String especialidad;
    private boolean atiendeUrgencias;

    public Cardiologo(String ID, String nombres, String apellidos, int experiencia,
                      String horario, String especialidad,
                      boolean atiendeUrgencias){
        super(ID, nombres, apellidos, experiencia, horario, 2000.00f);
        this.especialidad = especialidad;
        this.atiendeUrgencias = atiendeUrgencias;
    }

    /**
     *Para saber cuanto cobrara cada cardiologo dependera de su especialidad, para esto mismo
     * se trata la siguiente funcionalidad. En la cual se calculara en base a su especialidad y un
     * porcentaje de lo que gana.
     */
    @Override
    public String mostrarDatos(){
        String atiendeUrgencias = (this.atiendeUrgencias) ? "Si" : "No";
        return  "\nDoctor: " + getApellidos().concat(" ").concat(getNombres()) +
                "\nEspecialidad: " + especialidad +
                "\nExperiencia: " + getExperiencia() +
                "\nAtiende urgencias: " + atiendeUrgencias +
                "\nTarifa por consulta: " + getTarifaPorConsulta() +
                "\nHorario: " + getHorario() +
                "\nID: " + getID();
    }
}
