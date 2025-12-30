package Sistema_De_Citas_Medicas_6.Almacenamiento;

import Sistema_De_Citas_Medicas_6.Modelos.Cita;

import java.util.LinkedHashMap;
import java.util.Map;

public class CitaAlmacenamiento {

    private Map<String, Cita> citas = new LinkedHashMap<>();

    //Función para mostrar todas las citas medícas.
    public void mostrarTodas(){
        if(!citas.isEmpty()){
            //Si no esta vacía entonces procedemos.
            for(Map.Entry<String, Cita>lista : citas.entrySet()){
                System.out.println(lista.getValue().mostrarCita());
            }
        }else{
            System.out.println("No ha citas registradas.");
        }
    }
    //Obtener una cita en específico.
    //Este get puede retornar un null en vez de un objeto si es que no existe o no encuentra el ID.
    public Cita getCita(String ID){
        return citas.get(ID);
    }
    public void setCitas(String llave, Cita valor){
        if(!llave.isEmpty() && valor != null ){
            //Si la llave tiene un valor y el valor o el objeto non es null entonces se guarda
            citas.put(llave, valor);
        }
    }

    //Función para obtener el último objeto del linkedHashMap
    public Cita ultimaCita(){
        Cita cita = null;
        for(Map.Entry<String, Cita>lista : citas.entrySet()){
            cita = lista.getValue();
        }
        return cita;
    }

    //Función para obtener una cita en específico.
    public boolean encontrarCita(String ID){
        Cita cita = citas.get(ID);
        return (cita != null);
    }

    //Función para saber si está vacío o no el Map
    public boolean existenCitas(){
        //Si no esta vacío regresara un true, si esta vacío regresa un false;
        return !citas.isEmpty();
    }
}
