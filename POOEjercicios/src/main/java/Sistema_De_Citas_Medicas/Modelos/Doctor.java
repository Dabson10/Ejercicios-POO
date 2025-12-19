package Sistema_De_Citas_Medicas.Modelos;
//Clase padre de todos los doctores.
public abstract class Doctor extends Persona{
    private int experiencia;
    private String horario;
    private float tarifaPorConsulta;
    /*
     *Para poder guardar el valor por consulta es necesario pasar por el constuctor,
     * pero para simplificar las cosas cada area por ejemplo: Cardiologo, Dentista, Pediatra y
     * medico general tendran un valor por defecto, no significa que tods ganaran 5.000 pesos, no
     * cada area tendra una tarifa default, solamente la especialidad es la que aumentara la tarifa.
     * */
    Doctor(String ID, String nombres, String apellidos, int experiencia, String horario, float tarifaPorConsulta){
        super(ID, nombres, apellidos);
        if(tarifaPorConsulta > 0){
            this.experiencia = experiencia;
            this.horario = horario;
            this.tarifaPorConsulta = tarifaPorConsulta;
        }else{
            System.out.println("Ingrese una tarifa valida");
        }
    }

    //Getters de la clase;
    public int getExperiencia(){ return experiencia; }
    public String getHorario(){ return horario; }
    public float getTarifaPorConsulta(){ return tarifaPorConsulta; }

    //Setters de la clase Doctor.
    //Metodo para asegurar que se guardaran tarifas superiores a cero.
    public void setTarifaPorConsulta(float tarifa){
        if(tarifa > 0){
            this.tarifaPorConsulta = tarifa;
        }else{
            System.out.println("Ingrese una tarifa valida.");
        }
    }

    public void setExperiencia(int experiencia){
        if(experiencia <= this.experiencia){
            //Si no esta vacia la cadena
            this.experiencia = experiencia;
        }else{
            System.out.println("Ingrese una opcion correcta.\n");
        }
    }
    public void setHorario(String horario){
        if(!horario.isEmpty()){
            //Si el horario ingresado no esta vacio entonces lo guarda.
            this.horario = horario;
        }else{
            System.out.println("Ingrese un valor valido.\n");
        }
    }

    //Funcion abstracta para mostrar datos del Doctor
    public abstract String mostrarDatos();

}
