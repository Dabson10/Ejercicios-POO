/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ToDoList_1;

/**
 *
 * @author Dabson
 */
public class Tarea {

    private String nombre;
    private String estadoTarea;
    private String prioridad;

    public Tarea(String nombre, String estadoTarea, String prioridad) {
        this.nombre = nombre;
        this.estadoTarea = estadoTarea;
        this.prioridad = prioridad;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + ", Estado de la tarea: " + estadoTarea + ", Prioridad: " + prioridad;
    }
}
