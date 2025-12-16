package Sistema_De_Citas_Medicas.Almacenamiento;

import Sistema_De_Citas_Medicas.Modelos.Doctor;

import java.util.LinkedHashMap;
import java.util.Map;

public class DoctorAlmacenamiento {
    private Map<String, Doctor> doctores = new LinkedHashMap<>();


    //======== SET doctores =============

    public void setDoctores(String llave, Doctor valor){
        if(!llave.isEmpty() || valor != null){
            //Si llave tiene caracteres y valor tiene un objeto entonces se guardaran los datos.
            doctores.put(llave, valor);
        }else{
            System.out.println("No se pudieron guardar los datos.\n");
        }
    }


    //Obtener el ultimo valor del mapa
    public Doctor ultimoValor(){
        Doctor ultimoDoctor = null;
        for(Map.Entry<String, Doctor> lista : doctores.entrySet()){
            ultimoDoctor = lista.getValue();
        }
        return ultimoDoctor;
    }

    //================ MOSTRAR TODOS LOS DOCTORES ====================
    public void todosLosDoctores(){
        for(Map.Entry<String, Doctor> lista : doctores.entrySet()){
            System.out.println(lista.getValue().mostrarDatos());
        }
    }


    //=============== VALIDACIONES ====================
    public boolean validarExistencia(){
        //Si es vacia regresara TRUE, si tiene datos False;
        return !doctores.isEmpty();
    }
}
