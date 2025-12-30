package Sistema_De_Citas_Medicas_6.Modelos;

public class MedicoGeneral extends Doctor {
    private boolean atiendeUrgencias;

    public MedicoGeneral(String ID, String nombres, String apellidos, int experiencia,
                         String horario, boolean atiendeUrgencias) {
        super(ID, nombres, apellidos, experiencia, horario, 1000.00f);
        this.atiendeUrgencias = atiendeUrgencias;
    }
    //Getters y Setters de la clase
    public boolean getAtiendeUrgencias(){
        return atiendeUrgencias;
    }
    public void setAtiendeUrgencias(boolean atiendeUrgencias){
        this.atiendeUrgencias = atiendeUrgencias;
    }

    /**
     * La siguiente función calculará cuanto se cobrara en la cita, con base a un parametro, en este caso si es true or false
     * @param urgencia : Si la cita es con urgencia se cobrara un 5% en base a la tarifa del doctor.
     * @return : Regresara cuanto se le cobrara al paciente.
     */
    @Override
    public float costeCitaExtra(boolean urgencia, String especialidad){
        //Sí es true el valor entonces agregamos un 10% con base a la tarifa del base del Medíco General.
        return ((urgencia) ? (getTarifaPorConsulta() * .05f) : 0f) + getTarifaPorConsulta();
    }

    @Override
    public String mostrarDatos() {
        String urgencias = (atiendeUrgencias) ? "Si" : "No";
        return "\nDoctor: " + getApellidos().concat(" ").concat(getNombres()) +
                "\nExperiencia: " + getExperiencia() +
                "\nTarifa por consulta: " + getTarifaPorConsulta() +
                "\nAtiende urgencias: " + urgencias +
                "\nHorario: " + getHorario() +
                "\nID: " + getID();
    }
}
