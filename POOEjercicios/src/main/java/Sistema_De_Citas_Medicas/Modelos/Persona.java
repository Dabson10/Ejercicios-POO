package Sistema_De_Citas_Medicas.Modelos;

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
}