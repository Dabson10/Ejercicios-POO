package Sistema_De_Citas_Medicas.Almacenamiento;

import Sistema_De_Citas_Medicas.Modelos.Cita;

import java.util.LinkedHashMap;
import java.util.Map;

public class CitaAlmacenamiento {

    private Map<String, Cita> citas = new LinkedHashMap<>();

    public void setCitas(String llave, Cita valor){
        if(!llave.isEmpty() && valor != null ){
            //Si la llave tiene un valor y el valor o el objeto non es null entonces se guarda
            citas.put(llave, valor);
        }
    }

    //Funcion para obtener el ultimo objeto del linkedHashMap
    public Cita ultimaCita(){
        Cita cita = null;
        for(Map.Entry<String, Cita>lista : citas.entrySet()){
            cita = lista.getValue();
        }
        return cita;
    }

}
