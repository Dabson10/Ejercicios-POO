package Sistema_De_Citas_Medicas.Modelos;

public class MedicoGeneral extends Doctor{
    public MedicoGeneral(String ID, String nombres, String apellidos, int experiencia,
                         String horario){
        super(ID, nombres, apellidos, experiencia, horario, 1000.00f);
    }

    @Override
    public String mostrarDatos(){
        return "\nDoctor: " + getApellidos().concat(" ").concat(getNombres()) +
                "\nExperiencia: " + getExperiencia() +
                "\nTarifa por consulta: " + getTarifaPorConsulta() +
                "\nHorario: " + getHorario() +
                "\nID: " + getID();
    }
}
