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

    //======== GET Doctores =========
    public Doctor getDoctores(String ID){
        return doctores.get(ID);
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
            if(!lista.getValue().getID().contains("_DEL")){
                //Si el ID tiene valores entonces lo muestra.
                System.out.println(lista.getValue().mostrarDatos());
            }
            //Ya que si no tiene un ID es por que este se elimino, no quiero que ocurra un error de datos.
            //Ya que habran sitas que necesitaran acceder a un ID y si el objeto es eliminado por completo,
            //entonces existira un problema.
        }
    }


    //=============== VALIDACIONES ====================
    public boolean validarExistencia(){
        //Si es vacia regresara TRUE, si tiene datos False;
        return !doctores.isEmpty();
    }
}
