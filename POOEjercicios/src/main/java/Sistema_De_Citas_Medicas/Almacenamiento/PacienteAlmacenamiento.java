package Sistema_De_Citas_Medicas.Almacenamiento;

import Sistema_De_Citas_Medicas.Modelos.Paciente;

import java.util.HashMap;
import java.util.Map;

public class PacienteAlmacenamiento {
    //Almacenamiento para los pacientes.
    private  Map<String, Paciente> pacientes = new HashMap<>();

    //Metodos de la clase.

    public void setPacientes(String llave, Paciente valor){
        if(!llave.isEmpty()){
            //Si no esta vacio entonces se procede a guardar el valor.
            pacientes.put(llave, valor);
        }else{
            System.out.println("No se guardo el objeto");
        }
    }
    /**
     * Funcion para obtener el objeto de una ubicacion en especifico
     * @param llave : La ubicacion en el HashMap, este es el ID del paciente.
     * @return : Regresara el objeto guardado en el valor del HashMap.
     */
    public Paciente getPaciente(String llave){
        return pacientes.get(llave);
    }

    //Valída que el Map tenga valores.
    public boolean validarAlmacenamiento(){
        boolean validacion = false;
        if(!pacientes.isEmpty()){
            //Si no está vacia entonces regresa un valor booleano
            validacion = true;
        }
        return validacion;
    }

    //Para saber la longitud del mapa
    public int longitudPacientes(){
        return pacientes.size();
    }

    //=============================== MOSTRAR DATOS DEL PACIENTE ===============================
    //Muestra todos los datos del HashMap.
    public void todosLosPacientes(){
        for(Map.Entry<String, Paciente> pacientesObj : pacientes.entrySet()){
            System.out.println(pacientesObj.getValue().mostrarDatos());
        }
    }
    //Muestra solo el usuario con cierta llave.
    public void buscarPacienteID(String llave){
        Paciente paciente = pacientes.get(llave);
        System.out.println(paciente.mostrarDatos());
    }









}
