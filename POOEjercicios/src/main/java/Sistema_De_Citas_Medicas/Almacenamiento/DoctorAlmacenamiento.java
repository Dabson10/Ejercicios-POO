package Sistema_De_Citas_Medicas.Almacenamiento;

import Sistema_De_Citas_Medicas.Modelos.Cardiologo;
import Sistema_De_Citas_Medicas.Modelos.Doctor;
import Sistema_De_Citas_Medicas.Modelos.Pediatra;

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
    public void mostrarDoctores(int opcion){
        //Un switch para buscar diferentes tipos de doctores.
        switch(opcion){
            //Muestra a todos los empleados, sin filtro.
            case 1 -> mostrarTodos();
            //Muestra solo a un empleado
            //Muestra solo a los doctores de Cardiología.
            case 3 -> obtenerPorArea("CAR");
            //Muestra solo a los doctores de Dentista
            case 4 -> obtenerPorArea("DEN");
            //Muestra solo a los doctores de Pediatría.
            case 5 -> obtenerPorArea("PED");
            //Muestra solo a los doctores de Medíco General
            case 6 -> obtenerPorArea("MED");
            default ->{
                System.out.println("No se encontro opción.\n");
                return;
            }
        }
    }
    public void mostrarTodos(){
        for(Map.Entry<String, Doctor> lista : doctores.entrySet()){
            System.out.println(lista.getValue().mostrarDatos());
        }
    }

    public void seleccionDoctor(String ID){
        System.out.println(getDoctores(ID).mostrarDatos());
    }

    //Funcion que obtienes a todos los doctores de ciertas areas, esto depende totalmente del ID.
    public void obtenerPorArea(String area){
        boolean existe = false;
        for(Map.Entry<String, Doctor>lista : doctores.entrySet()){
            if(lista.getKey().contains(area) && !lista.getKey().contains("DEL")){
                //Si el doctor contiene alguno de los 4 subfijos "PED", "CAR", "MED", "DEN" y no contienen "DEL"
                //entonces lo mostrará.
                System.out.println(lista.getValue().mostrarDatos());
                existe = true;
            }
        }
        if(!existe){
            //Si el valor es false osea que no se encontro ningun doctor, entonces muestra una alerta
            System.out.println("No se encontrarón doctores de esa area");
        }
    }

    //================= FUNCIONES PARA BUSCAR DOCTORES ESPECIFICOS ===================

    /**
     * Esta funcion buscara a todos los doctores que cumplan con ciertos requisitos.
     * esta se utilizara en dos funcionalidades o areas diferentes, servira para los cardiologos y
     * los pediatras.
     * @param area : Este parametro servira para seleccionar cierta area entre "CAR" y "PED"
     * @param urgencia : valor booleano que obtendra a los doctores que atiendan o no urgencias medicas.
     * @param especialidad : Servira para obtener los doctores que atienden cierta especialidad.
     */
    public void buscarDoctores(String area, boolean urgencia, String especialidad){
        String ID = "";
        boolean doctorUrgencia = false;
        String especialidadDoctor ="";
        //Diferenciara
        if (area.contains("CAR")) {
            //Si contiene cardiologia entonces buscara algo especifico.
            Cardiologo cardiologo = null;
            for(Map.Entry<String, Doctor>lista : doctores.entrySet()){
                ID = lista.getValue().getID();
                //Buscara a los cardiologos y obtendra el objeto de cardiologo, pero aun no se mostraran los datos.
                if(ID.contains("CAR") && !ID.contains("DEL")){
                    cardiologo = (Cardiologo) lista.getValue();
                    //Con los datos listos entonces procedemos a mostrar los datos solamente cuando
                    //tenemos al doctor con las especificaciones necesarias.
                    especialidadDoctor = cardiologo.getEspecialidad();
                    doctorUrgencia = cardiologo.getAtiendeUrgencias();
                    //Ahora si se compara y muestra
                    if(doctorUrgencia == urgencia && especialidadDoctor.equals(especialidad)){
                        System.out.println(cardiologo.mostrarDatos());
                    }
                }
            }
        }
        //Buscar un cardiologo

    }




    //=============== VALIDACIONES ====================
    public boolean validarExistencia(){
        //Si es vacia regresara TRUE, si tiene datos False;
        return !doctores.isEmpty();
    }
}
