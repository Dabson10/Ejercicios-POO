package sistema_empleados_3;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Dabson
 */

/**
 * Objetivo del proyecto Requisitos: - Clase base: Empleado (nombre, ID, salario
 * base) - Clases hijas: EmpleadoTiempoCompleto (bonos, seguro)
 * EmpleadoMedioTiempo (horas trabajadas, pago por hora).
 * Gerente (departamento, empleados a cargo, bono extra).
 *
 * Funcionalidades: 1. Calcular salario total (diferente para cada tipo) 2.
 * Mostrar información completa 3. Listar todos los empleados 4. Buscar por tipo
 * de empleado
 *
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean acceso = true;

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoTiempoCompleto("Juan Martin", "TC_1", 15000, 5, "Todo"));
        empleados.add(new Gerente("Patricia Ramos", "GR_2", 45000, "Ventas", 15, 8000));
        empleados.add(new EmpleadoMedioTiempo("Juan David", "MT_3", 15000, 5, 1000));
        empleados.add(new EmpleadoTiempoCompleto("Ana Torres", "TC_4", 30000, 4500, "Premium"));
        empleados.add(new EmpleadoMedioTiempo("Brenda Gómez", "MT_5", 12000, 25, 450));
        empleados.add(new Gerente("Kevin Tadeo", "GR_6", 15000, "Programadores", 1, 5400));
        empleados.add(new EmpleadoTiempoCompleto("Sofía García", "TC_7", 22000, 2000, "Básico"));
        empleados.add(new EmpleadoMedioTiempo("Natalia Vargas", "MT_8", 14500, 20, 600));
        empleados.add(new Gerente("Laura Nieto", "GR_9", 55000, "Finanzas", 12, 10000));
        empleados.add(new EmpleadoTiempoCompleto("Ricardo López", "TC_10", 18500, 1000, "Vida"));
        empleados.add(new EmpleadoMedioTiempo("Eduardo Ruiz", "MT_11", 9800, 30, 350));
        empleados.add(new Gerente("Carlos Días", "GR_12", 38000, "Soporte", 7, 4000));
        empleados.add(new EmpleadoTiempoCompleto("Pablo Pérez", "TC_13", 16200, 1500, "Todo"));


        while (acceso) {
            try {
                int opcion = 0;
                System.out.println("====| Bienvenido al gestor de empleados. |====");
                System.out.print("""
                        ¿Qué opción desea realizar?
                        1.Mostrar colaboradores.
                        2.Agregar colaboradores.
                        3.A pagar por categoria.
                        4.Salir
                        """);
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                        //Esta opcion es para mostrar a los colaboradores.
                        System.out.println("===== Colaboradores =====");
                        mostrarColaboradores(empleados);

                    }
                    case 2 -> {
                        //Opcion para agregar colaboradores.
                        System.out.println("===== Agregar colaboradores =====");
                        agregarColaboradores(empleados);
                    }
                    case 3 -> {
                        //En esta seccion se mostrará lo que se pagara en conjunto, por ejemplo, el total a pagar de gerentes.
                        totalAPagar(empleados);
                    }
                    case 100 ->{
                        //Upcasting de objetos.
                        //Mostrar usuarios, en donde se itera en dowCasting
                        for(Empleado emp : empleados){
                            System.out.println(emp.mostrarDatos());
                            System.out.println("Total a pagar: " + emp.total());

                            //Ahora se verifica o atraen los datos de cada seccion si es que corresponde a esta
                            if(emp instanceof Gerente){
                                Gerente gerente = (Gerente) emp;
                                System.out.println("Detalles del gerente.");
                                System.out.println("Departamento: " + gerente.getDepartamento());
                                System.out.println("Bono extra: " + gerente.getBonoExtra());
                                System.out.println("Empleados a cargo: " + gerente.getEmpleadosACargo());
                            }
                            //Obtener solo los datos del objeto ETC
                            if(emp instanceof EmpleadoTiempoCompleto){
                                EmpleadoTiempoCompleto etc = (EmpleadoTiempoCompleto) emp;
                                System.out.println("Detalles del empleado de tiempo completo");
                                System.out.println("Detalles de Tiempo Completo:");
                                System.out.println("- Bono: " + etc.getBono());
                                System.out.println("- Seguro: " + etc.getSeguro());
                            }

                            if(emp instanceof EmpleadoMedioTiempo){
                                EmpleadoMedioTiempo emt = (EmpleadoMedioTiempo) emp;
                                System.out.println("Detalles de Medio Tiempo:");
                                System.out.println("- Tarifa por hora: " + emt.getPagoPorHora());
                                System.out.println("- Horas trabajadas: " + emt.getHorasTrabajadas());
                                System.out.println("- Total calculado: " + (emt.getPagoPorHora() * emt.getHorasTrabajadas()));

                            }


                        }
                    }
                    case 4 -> {
                        System.out.println("Hasta luego.");
                        acceso = false;
                        sc.close();
                    }

                    default -> {
                        System.out.println("Ingrese una opcion correcta.");
                        sc.nextLine();
                    }
                }

            } catch (Exception e) {
                System.out.println("Error del tipo: " + e.getMessage());
            }
        }

    }

    //Funcionalidades del programa
    //Funcion que mostrara a los colaboradores.
    public static void mostrarColaboradores(ArrayList<Empleado> empleados) {
        sc.nextLine();
        //Ahora toca mostrar a los usuarios. Sin antes una validacion de datos.
        if (!empleados.isEmpty()) {
            //Si no está vacia entonces busca y muestra a los empleados.
            int opcion =0;
            System.out.print("""
                    Que tipo de trabajadro buscas
                    1.Todos.
                    2.Tiempo completo.
                    3.Medio tiempo.
                    4.Gerentes
                    """);
            opcion = sc.nextInt();
            switch(opcion){
                case 1 ->{
                    /**Vamos a mostrar a los trabajadores separados por area, por lo que
                     * necesitaremos tres arreglos, todos del tipo entero en donde se guardara la ubicación
                     * y cuando se encuentre un trabajador con un ID con respecto a una área lo separará y guardará en un arreglo
                     **/
                    ArrayList<Integer> ubicacionMT = new ArrayList<>();
                    ArrayList<Integer> ubicacionTC = new ArrayList<>();
                    ArrayList<Integer> ubicacionG = new ArrayList<>();
                    for(int i = 0; i < empleados.size(); i++){
                        //La primera opcion estara ubicada en tiempoCompleto, medioTiempo y Gerente
                        if(empleados.get(i).getID().contains("TC_")){
                            //Si contiene "TC_" entonces guarda el espacio en el arrayList
                            ubicacionTC.add(i);
                        }else if(empleados.get(i).getID().contains("MT_")){
                            ubicacionMT.add(i);
                        }else if(empleados.get(i).getID().contains("GR_")){
                            ubicacionG.add(i);
                        }
                    }

                    //If para mostrar por separado a los trabajadores de tiempo completo y si no hay un alerta
                    if(!ubicacionTC.isEmpty()){
                        System.out.println("===== Empleados Tiempo Completo (" + ubicacionTC.size() + ") =====");
                        ubicacionTC.forEach(ubi ->{
                            System.out.println(empleados.get(ubi).mostrarDatos());
                        });
                    }
                    else{
                        System.out.println("""
                                ===== Empleados Tiempo Completo =====
                                
                                No hay empleados en tiempo completo
                                
                                =====================================
                                """);
                    }
                    //If para mostrar por separado a los trabajadores de medio tiempo y si no hay un alerta
                    if(!ubicacionMT.isEmpty()){
                        //Si ubicacionMT no está vacio entonces procedemos
                        System.out.println("========= Empleados Medio Tiempo (" + ubicacionMT.size() +") =========");
                        ubicacionMT.forEach(ubi ->{
                            System.out.println(empleados.get(ubi).mostrarDatos());
                        });
                    }
                    else{
                        System.out.println("""
                                ===== Empleados Medio Completo =====
                                
                                No hay empleados en tiempo completo
                                
                                ====================================
                                """);
                    }
                    //If para mostrar por separado a los gerentes y si no hay un alerta
                    if(!ubicacionG.isEmpty()){
                        //Si no está vacia la lista de los gerentes entonces mostramos los datos de esta
                        System.out.println("======= Gerentes (" + ubicacionG.size() +") =======");
                        ubicacionG.forEach(ubi -> {
                            System.out.println(empleados.get(ubi).mostrarDatos());
                        });
                    }
                    else{
                        System.out.println("""
                                ========== Gerentes ==========
                                
                                No hay Gerentes en el sistema
                                
                                ==============================
                                """);
                    }

                }
                case 2 ->{
                    //Buscar trabajadores de tiempo completo.
                    boolean existe = false;
                    for(int i =0; i < empleados.size(); i++){
                        if(empleados.get(i).getID().contains("TC_")){
                            existe =true;
                        }
                    }
                    //if para mostrar o no los datos del area especificada.
                    if(existe){
                        System.out.println("===== Empleados Tiempo Completo =====");
                        empleados.forEach(empleado -> {
                            if(empleado.getID().contains("TC_")){
                                System.out.println(empleado.mostrarDatos());
                            }
                        });
                    }else{
                        System.out.println("No se encontraron empleados de tiempo completo en el sistema.");
                    }

                }
                case 3 ->{
                    //Trabajadores de medio tiempo
                    boolean existe = false;
                    for(int i = 0; i< empleados.size(); i++){
                        if(empleados.get(i).getID().contains("MT_")){
                            existe = true;
                        }
                    }
                    if(existe){
                        System.out.println("========= Medio Tiempo =========");
                        empleados.forEach(empleado -> {
                            if(empleado.getID().contains("MT_")){
                                System.out.println(empleado.mostrarDatos());
                            }
                        });
                    }else{
                        System.out.println("No se encontraron trabajadores de medio tiempo en el sistema.");
                    }
                }
                case 4 ->{
                    //Gerentes
                    boolean existe = false;
                    for(int i = 0; i < empleados.size(); i++){
                        if(empleados.get(i).getID().contains("GR_")){
                            existe = true;
                        }
                    }
                    if(existe){
                        System.out.println("======= Gerentes =======");
                        empleados.forEach(empleado -> {
                            if(empleado.getID().contains("GR_")){
                                System.out.println(empleado.mostrarDatos());
                            }
                        });
                    }else{
                        System.out.println("No se encontraron gerentes en el sistema.");
                    }
                }
                default ->{
                    System.out.println("Ingrese una opcion correcta.");
                }
            }
        } else {
            System.out.println("No hay trabajadores, favor de agregar.\n");
        }
    }

    //Funcion para agregar colaboradores.
    public static void agregarColaboradores(ArrayList<Empleado> empleados) {
        sc.nextLine();
        //Lo primero que se debe de hacer es validar si hay objetos en el araylist 
        int cantidadEmp = 0;

        //Variables para guardar en el objeto.
        String nombre = "";
        float sueldoBase = 0;

        System.out.print("Cuantos colaboradores desea agregar?");
        cantidadEmp = sc.nextInt();
        //Ahora se recorrera la cantidad de empleados que se agregaran.
        for (int i = 0; i < cantidadEmp; i++) {
            sc.nextLine();
            //Pero antes de agregar primero existira una validacion simple, que es saber si la lista de objetos esta vacia.
            if (!empleados.isEmpty()) {
                //Si la lista no esta vacia significa que al menos hay un registro, entonces procede a hacer varios registros.
                //Ahora si toca registrar a los trabajadores de manera continua, separando su ID y ubicacion, aunque ahora esta mas facil
                System.out.print("Ingrese su nombre: ");
                nombre = sc.nextLine();
                System.out.print("Ingrese su sueldo base: ");
                sueldoBase = sc.nextFloat();
                System.out.println("""
                        ¿Qué tipo de trabajo tienes?
                        1.Tiempo completo.
                        2.Medio tiempo.
                        3.Gerente.
                        """);
                int tipoHorario = sc.nextInt();
                tipoDeTrabajo(empleados, tipoHorario, nombre, sueldoBase);
                System.out.println();
            } else {
                //Significa que no existen objetos en el arraylist. Por lo que agregaremos el primer valor 
                //Inicialmente se pediran dos datos escenciales, que es nombre y saldo base, ya que el ID se generará automaticamente.
                //Este se generará dependiendo de qué área o tipo de empleado es.
                System.out.print("Ingrese su nombre: ");
                nombre = sc.nextLine();
                System.out.print("Ingrese su sueldo base: ");
                sueldoBase = sc.nextFloat();

                System.out.println("""
                        ¿Qué tipo de trabajo tienes?
                        1.Tiempo completo.
                        2.Medio tiempo.
                        3.Gerente.
                        """);
                int tipoHorario = sc.nextInt();
                tipoDeTrabajo(empleados, tipoHorario, nombre, sueldoBase);
                System.out.println();
            }
        }

    }

    //Funcion para agregar el tipo de trabajo y no repetir codigo.
    public static void tipoDeTrabajo(ArrayList<Empleado> empleados, int tipoTrab, String nombre, float sueldoBase) {
        //Para diferenciar entre una lista vacio o no solamente comparamos.
        sc.nextLine();
        //Variables para tiempoCompleto
        String ID = "";
        float bonoTC = 0;
        String seguroTC = "";
        //Variables para medio tiempo
        int horasTrabajadasMT = 0;
        float pagoXHoraMT = 0;
        //Variables para gerente.
        String departamento = "";
        int empleadoACargo = 0;
        float bonoExtra = 0;
        if (!empleados.isEmpty()) {
            //Si no está vacía entonces mostramos la primera parte.
            switch (tipoTrab) {
                case 1 -> {
                    //Empleado de tiempo completo.
                    //Generador de ID del empleado 
                    //Para generar el ID del empleado primero debemos obtener el último valor de la lista para asi
                    //Poder ir en aumento de uno en uno 
                    int limiteLista = empleados.size() - 1;
                    String ultimoEmpleado = empleados.get(limiteLista).getID();
                    int ultimoNumeroCad = Integer.parseInt(ultimoEmpleado.substring(3, ultimoEmpleado.length()));
                    //Teniendo ya el numero del id ahora toca aumentarlo en uno y agregar la cadena por default.
                    ultimoNumeroCad += 1;
                    ID = "TC_" + ultimoNumeroCad;
                    System.out.print("Ingrese el bono su bono: ");
                    bonoTC = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("¿Usteded cuenta con seguro?.\nIngrese que tipo de bono.");
                    seguroTC = sc.nextLine();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new EmpleadoTiempoCompleto(nombre, ID, sueldoBase, bonoTC, seguroTC));
                }
                case 2 -> {
                    //Medio tiempo.
                    int limiteLista = empleados.size() - 1;
                    String ultimoEmpleado = empleados.get(limiteLista).getID();
                    int ultimoNumeroCad = Integer.parseInt(ultimoEmpleado.substring(3, ultimoEmpleado.length()));
                    //Teniendo ya el numero del id ahora toca aumentarlo en uno y agregar la cadena por default.
                    ultimoNumeroCad += 1;
                    ID = "MT_" + ultimoNumeroCad;
                    System.out.print("Ingrese cuantas horas trabaja:");
                    horasTrabajadasMT = sc.nextInt();
                    System.out.print("Ingrese cuanto se le paga por hora:");
                    pagoXHoraMT = sc.nextFloat();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new EmpleadoMedioTiempo(nombre, ID, sueldoBase, horasTrabajadasMT, pagoXHoraMT));
                }
                case 3 -> {
                    //Gerente.
                    int limiteLista = empleados.size() - 1;
                    String ultimoEmpleado = empleados.get(limiteLista).getID();
                    int ultimoNumeroCad = Integer.parseInt(ultimoEmpleado.substring(3, ultimoEmpleado.length()));
                    //Teniendo ya el numero del id ahora toca aumentarlo en uno y agregar la cadena por default.
                    ultimoNumeroCad += 1;
                    ID = "GR_" + ultimoNumeroCad;
                    System.out.print("Ingrese su departamento a cargo: ");
                    departamento = sc.nextLine();
                    System.out.print("Ingrese a cuantos empleados tiene a cargo: ");
                    empleadoACargo = sc.nextInt();
                    System.out.print("Ingrese cuanto recibe de bono: ");
                    bonoExtra = sc.nextFloat();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new Gerente(nombre, ID, sueldoBase, departamento, empleadoACargo, bonoExtra));
                }
                default -> {
                    System.out.println("Ingrese una opción correcta.\n");
                }
            }
        } else {
            //Si esta vacia solo agregamos a un usuario.
            switch (tipoTrab) {
                case 1 -> {
                    //Empleado de tiempo completo.
                    //Generador de ID del empleado 
                    ID = "TC_1";
                    System.out.print("Ingrese el bono su bono: ");
                    bonoTC = sc.nextFloat();
                    System.out.print("¿Usteded cuenta con seguro?.\nIngrese que tipo de seguro.");
                    seguroTC = sc.nextLine();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new EmpleadoTiempoCompleto(nombre, ID, sueldoBase, bonoTC, seguroTC));
                }
                case 2 -> {
                    //Medio tiempo.
                    ID = "MT_1";
                    System.out.print("Ingrese cuantas horas trabaja:");
                    horasTrabajadasMT = sc.nextInt();
                    System.out.print("Ingrese cuanto se le paga por hora:");
                    pagoXHoraMT = sc.nextFloat();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new EmpleadoMedioTiempo(nombre, ID, sueldoBase, horasTrabajadasMT, pagoXHoraMT));
                }
                case 3 -> {
                    //Gerente.
                    ID = "GR_1";
                    System.out.print("Ingrese su departamento a cargo: ");
                    departamento = sc.nextLine();
                    System.out.print("Ingrese a cuantos empleados tiene a cargo: ");
                    empleadoACargo = sc.nextInt();
                    System.out.print("Ingrese cuanto recibe de bono: ");
                    bonoExtra = sc.nextFloat();
                    //Ahora toca guardar los datos del trabajador en su respectiva clase.
                    empleados.add(new Gerente(nombre, ID, sueldoBase, departamento, empleadoACargo, bonoExtra));
                }
                default -> {
                    System.out.println("Ingrese una opción correcta.\n");
                }
            }
        }
    }

    //Funcion para mostrar por categoria cuanto se debe de pagar.
    public static void totalAPagar(ArrayList<Empleado> empleados){
        sc.nextLine();
        if(!empleados.isEmpty()){
            //Como se hizo en la seccion de mostrar empleados por tipo de empleo hare lo mismo solo que agregare la seccion de
            //sumar la cantidad total.
            float totalTC = 0, totalMT = 0, totalGR = 0;
            for(int i = 0; i < empleados.size(); i ++){
                if(empleados.get(i).getID().contains("TC_")){
                    //Si es medio tiempo entonces aumento y guardo el valor en la variable de total.
                    totalTC += empleados.get(i).total();
                }
                else if(empleados.get(i).getID().contains("MT_")){
                    totalMT += empleados.get(i).total();
                }
                else if(empleados.get(i).getID().contains("GR_")){
                    totalGR += empleados.get(i).total();
                }
            }

            System.out.println("\n===== Total a pagar ====="
                    + "\nTrabajadores Tiempo Completo: " + totalTC
                    + "\nTrabajadores Medio Tiempo: " + totalMT
                    + "\nGerentes: " + totalGR
            );

        }else{
            System.out.println("No hay empleados en la lista.");
        }
    }
}
