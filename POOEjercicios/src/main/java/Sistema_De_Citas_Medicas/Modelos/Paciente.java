package Sistema_De_Citas_Medicas.Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Clase estatica para las clases hijas.
public class Paciente extends Persona{
    //Atributos de la clase
    private int numeroDeTelefono;
    private String correo;
    private List<String> historialConsultas = new ArrayList<>();
    //Metodos de la clase
    public Paciente(String ID, String nombres, String apellidos, int numeroDeTelefono, String correo){
        super(ID, nombres, apellidos);
        this.numeroDeTelefono = numeroDeTelefono;
        this.correo = correo;
    }

    public void mostrarFechas(){
        for(int i = 0; i < this.historialConsultas.size(); i ++ ){
            System.out.println("Asistio en la fecha: " + historialConsultas.get(i));
        }
    }

    @Override
    public String mostrarDatos(){
        String mostrar = "";
        if(!historialConsultas.isEmpty()){
            //Si no esta vacia entonces se muestran los datos con fechas en las que el
            //paciente asistio.
            mostrar = "\nPaciente: " + getApellidos().concat(" ").concat(getNombres()) +
                      "\nTelefono: " + numeroDeTelefono +
                      "\nCorreo: " + correo ;
//                      mostrarFechas();
        }else{

        }
        return mostrar;
    }

}
