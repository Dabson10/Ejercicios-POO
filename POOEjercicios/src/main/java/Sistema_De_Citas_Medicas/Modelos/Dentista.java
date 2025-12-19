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
            //Si no esta vacia entonces se guarda el dato
            this.especialidad = especialidad;
        }else{
            System.out.println("Ingrese un valor valido.\n");
        }
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
