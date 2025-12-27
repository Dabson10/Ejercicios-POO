package Sistema_De_Citas_Medicas.Modelos;
//Clase hija de la clase Doctor.
public class Dentista extends Doctor{
    //Atributos
    private String especialidad;

    public Dentista(String ID, String nombres, String apellidos, int experiencia,
                    String horario,String especialidad){
        super(ID, nombres, apellidos, experiencia, horario, 1500.00f);
        this.especialidad = especialidad;
    }
    //Getters y Setters de la clase
    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        if(!especialidad.isEmpty()){
            //Si no esta vacía entonces se guarda el dato
            this.especialidad = especialidad;
        }else{
            System.out.println("Ingrese un valor valido.\n");
        }
    }
    /**
     * La siguiente función calculará cuanto se cobrara en la cita, con base a un parametro, en este caso si es true or false
     * @param especialidad : Se cobrará con base a la especialidad, son 3 especialidades y cada una tendra un porcentaje
     *                     más alto la una de la otra
     * @return : Regresara cuanto se le cobrara al paciente.
     */
    @Override
    public float costeCitaExtra(boolean urgencia, String especialidad){
        float montoEspecialidad = 0f;
        switch(especialidad){
            case "Odontopediatría" -> montoEspecialidad = (getTarifaPorConsulta() * 0.05f);
            case "Ortodoncia" -> montoEspecialidad = (getTarifaPorConsulta() * 0.1f);
            case "Maxilofacial" -> montoEspecialidad = (getTarifaPorConsulta() * 0.15f);
            default ->System.out.println("Ingrese una opción correcta.\n");
        }
        return montoEspecialidad + getTarifaPorConsulta();
    }
    //Metodos
    @Override
    public String mostrarDatos(){
        return "\nDoctor: " + getApellidos().concat(" ").concat(getNombres()) +
                "\nEspecialidad: " + especialidad +
                "\nExperiencia: " + getExperiencia() +
                "\nTarifa por consulta: " + getTarifaPorConsulta() +
                "\nHorario: " + getHorario() +
                "\nID: " + getID();
    }
}
