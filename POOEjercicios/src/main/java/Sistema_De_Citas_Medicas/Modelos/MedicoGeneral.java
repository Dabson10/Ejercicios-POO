package Sistema_De_Citas_Medicas.Modelos;

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
