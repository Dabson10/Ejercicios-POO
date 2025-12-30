package Sistema_De_Citas_Medicas_6.Almacenamiento;

import Sistema_De_Citas_Medicas_6.Modelos.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class DoctorAlmacenamiento {
    private Map<String, Doctor> doctores = new LinkedHashMap<>();


    //======== SET doctores =============

    public void setDoctores(String llave, Doctor valor) {
        if (!llave.isEmpty() || valor != null) {
            //Si llave tiene caracteres y valor tiene un objeto entonces se guardarán los datos.
            doctores.put(llave, valor);
        } else {
            System.out.println("No se pudieron guardar los datos.\n");
        }
    }

    //======== GET Doctores =========
    public Doctor getDoctores(String ID) {
        return doctores.get(ID);
    }


    //Obtener el último valor del mapa
    public Doctor ultimoValor() {
        Doctor ultimoDoctor = null;
        for (Map.Entry<String, Doctor> lista : doctores.entrySet()) {
            ultimoDoctor = lista.getValue();
        }
        return ultimoDoctor;
    }

    //================ MOSTRAR TODOS LOS DOCTORES ====================
    public void mostrarDoctores(int opcion) {
        //Un switch para buscar diferentes tipos de doctores.
        switch (opcion) {
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
            default -> {
                System.out.println("No se encontro opción.\n");
                return;
            }
        }
    }

    public void mostrarTodos() {
        for (Map.Entry<String, Doctor> lista : doctores.entrySet()) {
            System.out.println(lista.getValue().mostrarDatos());
        }
    }

    public void seleccionDoctor(String ID) {
        System.out.println(getDoctores(ID).mostrarDatos());
    }

    //Función que obtienes a todos los doctores de ciertas áreas, esto depende totalmente del ID.
    public void obtenerPorArea(String area) {
        boolean existe = false;
        for (Map.Entry<String, Doctor> lista : doctores.entrySet()) {
            if (lista.getKey().contains(area) && !lista.getKey().contains("DEL")) {
                //Si el doctor contiene alguno de los 4 sub fijos "PED", "CAR", "MED", "DEN" y no contienen "DEL"
                //entonces lo mostrará.
                System.out.println(lista.getValue().mostrarDatos());
                existe = true;
            }
        }
        if (!existe) {
            //Si el valor es false o sea que no se encontró ningún doctor, entonces muestra una alerta
            System.out.println("No se encontrarón doctores de esa area");
        }
    }

    //================= FUNCIONES PARA BUSCAR DOCTORES ESPECIFICOS ===================

    /**
     * Esta funcion buscará a todos los doctores que cumplan con ciertos requisitos.
     * Está se utilizará en dos funcionalidades o áreas diferentes, servira para los cardiologos y
     * los pediatras.
     *
     * @param urgencia     : valor booleano que obtendra a los doctores que atiendan o no urgencias medicas.
     * @param especialidad : Servira para obtener los doctores que atienden cierta especialidad.
     */
    public void buscarCardiologo(boolean urgencia, String especialidad) {
        String ID;
        boolean doctorUrgencia;
        String especialidadDoctor;
        boolean existe = false;
        //Si contiene cardiologia entonces buscara algo especifico.
        Cardiologo cardiologo;
        for (Map.Entry<String, Doctor> lista : doctores.entrySet()) {
            ID = lista.getValue().getID();
            //Buscará a los cardiólogos y obtendrá el objeto de cardiologo, pero aún no se mostrarán los datos.
            if (ID.contains("CAR") && !ID.contains("DEL")) {
                //Ahora que si encontramos un cardiologo, con confiaza usamos Drowncasting
                //para acceder a la clase hija.
                cardiologo = (Cardiologo) lista.getValue();
                //Con los datos listos entonces procedemos a mostrar los datos solamente cuando
                //tenemos al doctor con las especificaciones necesarias.
                especialidadDoctor = cardiologo.getEspecialidad();
                doctorUrgencia = cardiologo.getAtiendeUrgencias();
                //Ahora si se compara y muestra
                if (doctorUrgencia == urgencia && especialidadDoctor.equals(especialidad)) {
                    System.out.println(cardiologo.mostrarDatos());
                    existe = true;
                }
            }
        }
        if(!existe){
            //Si él existe es diferente a true significa que no se encontraron doctores con esas especificaciones.
            System.out.println("No se encontraron doctores que cumplan los requerimientos.\n");
        }
    }

    //Función para buscar un dentista en específico.
    public void buscarDentistas(String especialidad){
        //Buscaremos a todos los dentistas que cumplan con la especialidad que se busca.
        //Recorreremos todo el linked hashmap buscando todos aquellos que contengan ID en "DEN"
        String doctorID ="";
        String areaDoc = "";
        boolean existe = false;
        for(Map.Entry<String, Doctor>lista : doctores.entrySet()){
            doctorID = lista.getKey();
            if(doctorID.contains("DEN") && !doctorID.contains("DEL")){
                //Si contiene en el ID "DEN" y no contiene "DEL" entonces procedemos.
                Dentista dentista = (Dentista) lista.getValue();
                areaDoc = dentista.getEspecialidad();
                if(areaDoc.equals(especialidad)){
                    //Si el dentista tiene la misma especialidad que se busca entonces se imprimen los datos del doctor
                    System.out.println(dentista.mostrarDatos());
                    existe = true;
                }
            }
        }
        if(!existe){
            //Si no existe ningun dentista entonces muestra un mensaje.
            System.out.println("No hay doctores con esa especialidad.\n");
        }
    }

    //Funcion para buscar un Pediatra en especifíco.
    public void buscarPediatras(int edad, boolean urgencias){
        String doctorID = "";
        String[] rangoEdad;
        boolean doctorUrgencias;
        boolean existe = false;
        //Recorreremos el linkedHashmap
        for(Map.Entry<String, Doctor>lista : doctores.entrySet()){
            doctorID = lista.getKey();
            if(doctorID.contains("PED") && !doctorID.contains("DEL")){
                //Si contiene de ID el areá de "PED" y no contiene "DEL" entonces lo guardamos
                Pediatra pediatra = (Pediatra) lista.getValue();
                rangoEdad = pediatra.getRangoEdad().split(" a ");
                int edad1 = Integer.parseInt(rangoEdad[0]);
                int edad2 = Integer.parseInt(rangoEdad[1]);
                doctorUrgencias = pediatra.getAtiendeUrgencias();
                //Ahora el siguiente if valorará si el paciente entra en la edad.
                if((edad >= edad1 && edad <= edad2) && doctorUrgencias == urgencias){
                    //Si la edad ingresada es mayor o igual a la edad minima y a su vez, es menor o igual a la
                    //edad maxima entonces procedemos con la valoración.
                    //Por otro ladó si el doctor atiende urgencias se comparará con la necesidad de la cita.
                    System.out.println(pediatra.mostrarDatos());
                    existe = true;
                }
            }
        }
        if(!existe){
            //Si existe sigue en "false" significa que no encontró ningún pediatra
            System.out.println("No se encontraron pediatras con esas especificaciones.\n");
        }
    }

    //Función para buscar un MedicoGeneral en especifíco.
    public void buscarMedicosGen(boolean urgencia){
        boolean existe = false;
        boolean medicoUrgencia;
        String medicoID = "";
        for(Map.Entry<String, Doctor>lista : doctores.entrySet()){
            medicoID = lista.getKey();
            if(medicoID.contains("MED") && !medicoID.contains("DEL")){
                //Si él, id contiene "MED" y no contiene "DEL", entonces procedemos
                MedicoGeneral medico = (MedicoGeneral) lista.getValue();
                medicoUrgencia = medico.getAtiendeUrgencias();
                if(medicoUrgencia == urgencia){
                    //Si coinciden entonces imprimimos los datos del médico.
                    System.out.println(medico.mostrarDatos());
                }
            }
        }
    }

    //=============== VALIDACIONES ====================
    public boolean validarExistencia() {
        //Si es vacia regresara TRUE, si tiene datos False;
        return !doctores.isEmpty();
    }
}
