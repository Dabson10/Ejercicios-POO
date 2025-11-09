package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dabson
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    //Funciones para mostrar, agregar, editar y eliminar tareas.
    public static void mostrarTareas(ArrayList<Tarea> lista) {
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + "." + lista.get(i).toString());
            }

        } else {
            System.out.println("No hay tareas registradas.");
        }
    }

    public static void agregarTareas(ArrayList<Tarea> lista) {
        sc.nextLine();
        String estado = "", prioridad;
        int existe = 0, urgencia;
        System.out.print("Ingrese la cantidad de tareas que desea agregar: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {

            sc.nextLine();
            System.out.println("Ingrese los datos de la tarea " + (i + 1));
            System.out.println("Ingrese el nombre de la tarea: ");
            String nombre = sc.nextLine().trim();
            /*El siguiente bucle sirve para primeramente entrar objeto por objeto existente
            en el arraylist, para despues hacer una validacion, la cual compara el nombre de la tarea
            y si esta ya existe entonces no la agrega y si no entonces la agrega*/
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getNombre().equals(nombre)) {
                    existe = 1;
                    break;
                } else {
                    existe = 0;
                }
            }
            //Si es 0 entonces agrega el dato
            if (existe == 0) {
                //Aqui se agregara el otro dato del To-Do list.
                System.out.println("""
                                   Cual es la prioridad de su tarea.
                                   1.No muy importante.
                                   2.Importante.
                                   3.Urgente.
                                   """);
                urgencia = sc.nextInt();
                switch (urgencia) {
                    case 1 -> {
                        prioridad = "No muy importante";
                        lista.add(new Tarea(nombre, "Pendiente", prioridad));
                    }
                    case 2 -> {
                        prioridad = "Importante";
                        lista.add(new Tarea(nombre, "Pendiente", prioridad));
                    }
                    case 3 -> {
                        prioridad = "Urgente";
                        lista.add(new Tarea(nombre, "Pendiente", prioridad));
                    }

                    default -> {
                        System.out.println("Ingrese una opcion correcta");
                    }
                }
            } else {
                System.out.println("No se agregara una tarea repetida.");
            }

        }
    }

    public static void editarTarea(ArrayList<Tarea> lista) {
        sc.nextLine();
        //Ahora se debe de editar la lista, pero primero se debe de validar si hay productos.
        if (!lista.isEmpty()) {
            //ahora se debe de buscar una coincidencia entre las tareas de la lista y la ingresada.
            System.out.println("Ingresa el nombre de la tarea.");
            String nombre = sc.nextLine();
            lista.forEach(tarea -> {
                if (tarea.getNombre().equals(nombre)) {
                    //Ahora si la tarea es igual entonces procedemos a editar y obtener la tarea
                    System.out.println("La tarea " + tarea.getNombre() + ", tiene el estado de: " + tarea.getEstadoTarea());

                    //Ahora se hace un cambio rapido y estatico, en donde el cambio de estado sera
                    //progresivo si tienes el estado 1 avanzas al segundo, del 2 al tercero 
                    //y en el tercero solo mostrara un mensaje simple
                    switch (tarea.getEstadoTarea()) {
                        case "Pendiente" -> {
                            tarea.setEstadoTarea("En progreso");
                            System.out.println("Se actualizo el estado de la tarea a: 'En progreso'");
                        }
                        case "En progreso" -> {
                            tarea.setEstadoTarea("Completada");
                            System.out.println("Se actualizo el estado de la tarea a: 'Completada'");
                        }
                        case "Completada" -> {
                            System.out.println("La tarea ya se completo.");
                        }
                        default -> {
                            System.out.println("Error, se encontro un estado diferente.");
                        }
                    }

                }
            });
        } else {
            System.out.println("No hay tareas para editar.");
        }

    }

    public static void eliminarTarea(ArrayList<Tarea> lista) {
        //Ahora se eliminara una tarea, sin antes validar que existan tareas u objetos.
        sc.nextLine();
        if (!lista.isEmpty()) {
            System.out.print("Ingrese el nombre de la tarea: ");
            String nombre = sc.nextLine();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombre().equals(nombre)) {
                    //Si el valor en la posicion i de la lista es igual al nombre, 
                    //entonces se removera el objeto en la posicion del arrayList
                    System.out.println("La tarea " + lista.get(i).getNombre()
                            + ", con el estado: " + lista.get(i).getEstadoTarea()
                            + ", se eliminara.");
                    lista.remove(i);

                }
            }
        } else {
            System.out.println("No hay tareas para eliminar.");
        }
    }

}
