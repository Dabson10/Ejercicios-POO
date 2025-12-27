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
     * se trata la siguiente funcionalidad. En la cual se calculara con base a su especialidad y un
     * porcentaje de lo que gana.
     */
    //Getters de la clase
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        if(!especialidad.isEmpty()){
            //Si no esta vacío entonces se guarda el valor.
            this.especialidad = especialidad;
        }else{
            System.out.println("Valor no reconocido. Ingrese una opción correcta.\n");
        }
    }
    public boolean getAtiendeUrgencias(){
        return atiendeUrgencias;
    }
    /**
     * @param urgencia : Si la cita es urgente entonces se cobrará un poco más, si no, no aumentara en nada.
     * La siguiente función calculará cuanto se cobrara en la cita, con base a un parametro, en este caso si es true or false
     * @param especialidad : Se cobrará con base a la especialidad, son 3 especialidades y cada una tendra un porcentaje
     *                     más alto la una de la otra.
     * @return : Regresará la suma de lo calculado en urgencia y en especialidad.
     */
    @Override
    public float costeCitaExtra(boolean urgencia, String especialidad){
        float montoUrgente = (urgencia)? (getTarifaPorConsulta()* 0.05f) : 0f;
        float montoEspecialidad = 0f;
        switch(especialidad){
            case "Cardiología Clinica" -> montoEspecialidad = (getTarifaPorConsulta() * 0.05f);
            case "Cardiología Intervencionista" -> montoEspecialidad = (getTarifaPorConsulta() * 0.1f);
            case "Cardiología Electrofisiológica" -> montoEspecialidad = (getTarifaPorConsulta() * 0.15f);
            default -> System.out.println("Ingrese una opción correcta.\n");
        }
        return (montoUrgente + montoEspecialidad) + getTarifaPorConsulta();
    }

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
