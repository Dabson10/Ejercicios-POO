package Sistema_De_Citas_Medicas_6.Modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Clase estática para las clases hijas.
public class Paciente extends Persona{
    //Atributos de la clase
    private String numeroDeTelefono;
    private String correo;
    private List<String> historialConsultas = new ArrayList<>();
    //Metodos de la clase
    //Constructor con parametros
    public Paciente(String ID, String nombres, String apellidos, String numeroDeTelefono, String correo){
        super(ID, nombres, apellidos);
        this.numeroDeTelefono = numeroDeTelefono;
        this.correo = correo;
    }
    public String mostrarFechas(){
        StringBuilder fechas = new StringBuilder();
        for (String historialConsulta : this.historialConsultas) {
            fechas.append("Asistió en la fecha: ").append(historialConsulta).append("\n");
        }
        return fechas.toString();
    }

    //Agregar fechas nuevas
    public void setHistorialConsultas(String fecha, String motivo){
        if(!fecha.trim().isEmpty() && !motivo.trim().isEmpty()){
            //Si no esta vacia, entonces agregamos la fecha a la lista
            historialConsultas.add(fecha + " : " + motivo);
        }else{
            System.out.println("Agrega una fecha correcta.");
        }
    }

    //Actualizar correo electronico.
    public void setCorreo(String correo){
        if(correo.trim().contains("@")){
            //Si contiene el @ entonces se guarda
            this.correo = correo;
        }else{
            //Si no lo tiene entonces no procede.
            System.out.println("Ingrese un correo valido.");
        }
    }

    //Actualizar telefono
    public void setNumeroDeTelefono(String numeroDeTelefono){
        try{
            Integer numero = Integer.parseInt(numeroDeTelefono.trim());
            //Si no devuelve error entonces procedera al IF
            if(!Objects.equals(this.numeroDeTelefono, numeroDeTelefono)){
                //Si no es igual entonces se guarda
                this.numeroDeTelefono = numeroDeTelefono;
            }else{
                System.out.println("Ingresaste el mismo telefono.");
            }
        }catch(Exception e){
            System.out.println("El numero de telefono tiene caracteres: " + e.getMessage());
        }
    }

    //Getters
    public String getCorreo() {
        return correo;
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
                      "\nID: " + getID() + "\n" +
                      mostrarFechas();
        }else{
            mostrar = "\nPaciente: " + getApellidos().concat(" ").concat(getNombres()) +
                    "\nTelefono: " + numeroDeTelefono +
                    "\nCorreo: " + correo +
                    "\nID: " + getID() +
                    "\nEl paciente es nuevo.";
        }
        return mostrar;
    }

}
