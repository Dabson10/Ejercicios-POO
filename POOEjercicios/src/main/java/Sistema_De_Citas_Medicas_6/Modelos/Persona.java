package Sistema_De_Citas_Medicas_6.Modelos;

public abstract class Persona {
    //Atributos clase Persona
    private String ID;
    private String nombres;
    private String apellidos;

    //Metodos.
    Persona(String ID, String nombres, String apellidos) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    Persona(){

    }
    //Getters de la clase;
    public String getID(){ return ID; }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public abstract String mostrarDatos();

    //Funcion para cambiar el ID ya sea del paciente o del doctor. por lo general solo se editara
    public void setID(String ID){
        if(!ID.isEmpty()){
            //Si no esta vacío o tiene caracteres entonces si se cambiara el ID del doctor.
            this.ID = ID;
        }else{
            System.out.println("No hay ID para cambiar.");
        }
    }
}