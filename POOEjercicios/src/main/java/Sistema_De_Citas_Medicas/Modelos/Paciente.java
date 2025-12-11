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

    public String mostrarFechas(){
        StringBuilder fechas = new StringBuilder();
        for(int i = 0; i < this.historialConsultas.size(); i ++ ){
            fechas.append("Asistio en la fecha: ").append(historialConsultas.get(i)).append("\n");
        }
        return fechas.toString();
    }

    //Agregar fechas nuevas
    public void setHistorialConsultas(String fecha){
        if(!fecha.trim().isEmpty()){
            //Si no esta vacia, entonces agregamos la fecha a la lista
            historialConsultas.add(fecha);
        }else{
            System.out.println("Agrega una fecha correcta.");
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
                      "\nCorreo: " + correo +
                      mostrarFechas();
        }else{
            mostrar = "\nPaciente: " + getApellidos().concat(" ").concat(getNombres()) +
                    "\nTelefono: " + numeroDeTelefono +
                    "\nCorreo: " + correo +
                    "\nEl paciente es nuevo.";
        }
        return mostrar;
    }




}
