package Gestor_De_Biblioteca_7.servicios;

import Gestor_De_Biblioteca_7.Almacenamiento.BibliotecarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Almacenamiento.UsuarioAlmacenamiento;
import Gestor_De_Biblioteca_7.Excepciones.CorreoIncorrecto;
import Gestor_De_Biblioteca_7.Modelos.Personas.Bibliotecario;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Estudiante;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Profesor;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.PublicoGeneral;
import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;
import Gestor_De_Biblioteca_7.Utilidades.GeneradorID;
import Gestor_De_Biblioteca_7.Utilidades.ValidarCorreo;
import Gestor_De_Biblioteca_7.enums.IdentificadorIDs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonaServicios {
    Scanner sc = new Scanner(System.in);
    //Atributo para obtener los datos de la clase "UsuarioAlmacenamiento"
    private UsuarioAlmacenamiento usuarioAlmacen;
    private BibliotecarioAlmacenamiento biblioAlmacen;

    //Generador de ID
    GeneradorID generarID = new GeneradorID();
    //Validador de correo
    ValidarCorreo validarCorreo = new ValidarCorreo();

    public PersonaServicios(UsuarioAlmacenamiento personasAlmacen, BibliotecarioAlmacenamiento almacenBiblio) {
        this.usuarioAlmacen = personasAlmacen;
        this.biblioAlmacen = almacenBiblio;
    }

    //==================== MENU PERSONAS ===========================
    public void menuPersonas() {
        try {
            System.out.print("""
                    ¿A que sección de Personas quieres acceder?
                    1.Bibliotecarios.
                    2.Usuarios(Alumnos, Profesores, Publico).
                    3.Inicio
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> menuBibliotecario();
                case 2 -> menuUsuarios();
                case 3 -> System.out.println("\nRegresando al inicio\n");
                default -> System.out.println("Ingrese una opción existente.");
            }
        } catch (InputMismatchException tipo) {
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
        }
    }

    //========================== MENU BIBLIOTECARIOS ==========================
    public void menuBibliotecario() {
        try {
            boolean existencia = biblioAlmacen.validarExistencias();
            System.out.print("""
                    ¿Que opción deseas realizar?
                    1.Mostrar Bibliotecarios.
                    2.Agregar Bibliotecarios.
                    3.Salir al inicio.
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    if (!existencia) {
                        //Si es diferente a true entonces procedemos a mostrar a los usuarios.
                        int opcionMostrar = queSeMostrara("bibliotecarios");
                        switch (opcionMostrar) {
                            case 1 -> biblioAlmacen.mostrarTodos();
                            case 2 -> buscarBibliotecario();
                            case 3 -> System.out.println("Regresando al inicio");
                            default -> System.out.println("Ingrese una opción correcta.");
                        }
                    } else {
                        System.out.println("Aun no hay bibliotecarios.");
                    }
                }
                //Opción para agregar nuevos bibliotecarios.
                case 2 -> agregarBiblio();
                case 3 -> System.out.println("Regresando al menu");
                default -> System.out.println("Ingrese una opción existente");
            }
        } catch (InputMismatchException tipo) {
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
            sc.nextLine();
        }
    }
    //========================== MOSTRAR BIBLIOTECARIOS ==========================

    /**
     *
     */
    public void buscarBibliotecario() {
        String ID = buscarPersona("bibliotecario");
        if (!ID.isEmpty()) {
            //Si tiene algún dato entonces procedemos a buscar eh imprimir.
            Bibliotecario biblioUsu = null;
            biblioUsu = biblioAlmacen.getBiblioAlmacen(ID);
            if (biblioUsu != null) {
                //Si es diferente a null, entonces existe el usuario o como tal el objeto
                System.out.println(biblioUsu.mostrarDatos());
            } else {
                System.out.println("No se encontró al usuario.");
            }
        }
    }
    //========================== AGREGAR BIBLIOTECARIOS ==========================

    /**
     * Esta función sirve para guardar los datos del usuario, utilizamos en esta función funciones externas para poder
     * llenar el formulario de datos.
     * Por ejemplo:
     * <br>
     * {@code validarCorreo} : Este se usó para validar si el correo contenía {@code "@"} y terminaba en {@code .com}
     * <br>
     * {@code buscarCorreo} : Esta funcionalidad sirve para buscar algún correo similar, si lo encuentra entonces procede a
     * terminar el formulario en caso de que exista algún correo igual
     * <br>
     * {@code obtenerUltimoDato} : Para obtener ya sea un valor nulo o el último valor guardado.
     * <br>
     * --{@code NullPointerException} : Se buscó agregar filtros para que este error no suceda, pero se pone por seguridad.
     * <br>
     * --{@code CorreoIncorrecto} : Excepcion personalizada para cuando el correo no tiene los requerimientos mínimos como
     * {@code "@"} y termina en {@code .com}
     */
    public void agregarBiblio() {
        try {
            sc.nextLine();
            String biblioID = "";
            System.out.println("\n=====| Agregar Bibliotecario |=====");
            System.out.println("En esta sección agregara los datos personales del bibliotecario\n");
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese los apellidos: ");
            String apellido = sc.nextLine();
            System.out.print("Ingrese el correo: ");
            String correo = sc.nextLine();
            System.out.print("Ingrese la contraseña: ");
            String contra = sc.nextLine();
            String prefijoArea = IdentificadorIDs.BIB.toString();

            if (!validarCorreo.validarCorreo(correo.trim())) {
                //Si es false entonces regresa y no procede a guardar nada
                return;
            }

            if (biblioAlmacen.buscarCorreo(correo)) {
                //Como encontró el correo entonces uso return para que no se guarde algún correo.
                return;
            }
            //La siguiente validación saber generar ID, pero se validará que el objeto sea null o no
            Bibliotecario bibliotecario = biblioAlmacen.obtenerUltimoDato();
            if (bibliotecario != null) {
                //Si es diferente a null entonces procedemos a obtener el ultímo ID
                int ultimoID = Integer.parseInt(bibliotecario.getPersonaID().substring(4, 8));
                biblioID = generarID.generarID(prefijoArea, (ultimoID + 1));
            } else {
                //Se encontró algún valor nulo por lo que se crea el ID
                //Termina de ajustar la generación del primer ID
                biblioID = generarID.generarID(prefijoArea, 1);
            }
            //Esta validación es para saber si se generó correctamente el ID del usuario
            if (!biblioID.isEmpty()) {
                System.out.println();
                //El ID se generó correctamente, por lo que ahora se guardaran los datos del nuevo bibliotecario
                biblioAlmacen.setBiblioAlmacen(biblioID, new Bibliotecario(biblioID, nombre, apellido, correo, contra));
                //Entonces ahora se avisará que se guardó correctamente al bibliotecario.
                System.out.println("Se guardarón los datos del bibliotecario. \n" + biblioAlmacen.getBiblioAlmacen(biblioID).mostrarDatos());

            }
        } catch (CorreoIncorrecto correo) {
            System.out.println(correo.getMessage());
        } catch (InputMismatchException tipo) {
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
        } catch (NullPointerException nulo) {
            System.out.println("Error del tipo: " + nulo.getMessage());
            System.out.println("Se obtuvo un valor nulo de Bibliotecario");
        }
    }


    //========================== MENU USUARIOS ================================


    public void menuUsuarios(){
        try{
            System.out.println("""
                Bienvenido a la sección usuarios
                ¿Que acción deseas realizar
                1.Mostrar Usuarios.
                2.Agregar Usuarios.
                3.Regresar al inicio.
                """);
            int opcion = sc.nextInt();
            switch(opcion){
                //Opción para mostrar a los usuarios.
                case 1 ->{
                    //De aquí se obtiene de que forma se buscara a los usuarios
                    int opcionMostrar = queSeMostrara("usuarios");
                    switch(opcionMostrar){
                        case 1 -> todosLosUsuarios();
                        //Opción para buscar un usuario en específico.
                        case 2 -> obtenerUsuario();
                        case 3 -> System.out.println("Regresando al menu de inicio.");
                        default -> System.out.println("Ingrese una opción correcta.");
                    }
                }
                //Opción para agregar un nuevo Usuario.
                case 2 -> agregarUsuarios();
                //Opción para regresar al menu principal
                case 3 -> System.out.println("Regresando al menu de inicio.");
                default -> System.out.println("Ingrese una opción correcta.");
            }
        }catch (InputMismatchException tipo ){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese un tipo correcto.");
        }
    }
    //========================== MOSTRAR USUARIOS ==============================

    /**
     *
     */
    public void todosLosUsuarios(){
        usuarioAlmacen.mostrarPorTipo("Estudiantes", IdentificadorIDs.EST.toString());
        usuarioAlmacen.mostrarPorTipo("Profesores", IdentificadorIDs.PRO.toString());
        usuarioAlmacen.mostrarPorTipo("Usuarios Generales", IdentificadorIDs.GEN.toString());
    }

    /**
     *
     */
    public void obtenerUsuario(){
        //Se obtiene el ID del usuario
        String ID = buscarPersona("usuario");
        Usuario usuario = usuarioAlmacen.getUsuariosAlmacen(ID);
        if(usuario != null){
            //Si es diferente a null es por qué encontró al usuario.
            System.out.println(usuario.mostrarDatos());
        }else{
            System.out.println("No se encontró al usuario.");
        }
    }
    //========================== AGREGAR USUARIOS ==============================
    public void agregarUsuarios(){
        try{
            System.out.println("""
                ==============| Agregar Usuario |====================
                En esta sección se agregaran los datos del usuario.
                favor de rellenar los datos correctamente
                """);
            System.out.println("""
                ¿Qué tipo de usuario sera?
                1.Estudiante.
                2.Profesor.
                3.Publico General
                """);
            int identificador = sc.nextInt();
            sc.nextLine();
            String prefijo = IdentificadorIDs.identificarNumero(identificador).toString();
            String ID = "";
            System.out.println("El prefijo es: " + prefijo);
            System.out.print("Ingrese sus nombres: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese sus apellidos: ");
            String apellido = sc.nextLine();
            System.out.print("Ingrese su correo: ");
            String correo = sc.nextLine().trim();
            System.out.print("Ingrese su credencial valida: ");
            String credencial = sc.nextLine();
            //Validaciones extra
            //*En todo el Map buscara si hay alguna coincidencia, para asi agregar en caso de que no existe alguno.
            if(usuarioAlmacen.buscarCorreo(correo.trim())){
                return;
            }
            //Valída que el correo esté bien escrito, con su @ y con él".com"
            if(!validarCorreo.validarCorreo(correo.trim())){
                return;
            }
            Usuario usuario = usuarioAlmacen.obtenerUltimo();
            if(usuario != null){
                //Si el usuario u objeto existe entonces procedemos con la generación del ID
                int numero = Integer.parseInt(usuario.getPersonaID().substring(4, 8));
                 ID = generarID.generarID(prefijo, (numero + 1));
            }else{
                ID = generarID.generarID(prefijo, 1);
            }
            if(!ID.isEmpty()){
                //Si no esta vacío entonces procedemos a guardar los datos del usuario
                guardarDatos(prefijo, ID, nombre, apellido, correo, credencial);
                //Ahora validamos que se guardara el usuario.
                usuario = usuarioAlmacen.getUsuariosAlmacen(ID);
                if(usuario != null){
                    System.out.println();
                    System.out.println("Se agrego correctamente al usuario.");
                    System.out.println(usuario.mostrarDatos());
                }else{
                    System.out.println("No se guardo al usuario");
                }
            }
        }catch(InputMismatchException tipo){
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese los datos que se solicitan.");
        }catch(CorreoIncorrecto correo){
            System.out.println(correo.getMessage());
        }
    }

    /**
     *
     * @param prefijo
     * @param ID
     * @param nombre
     * @param apellido
     * @param correo
     * @param credencial
     */
    public void guardarDatos(String prefijo,String ID, String nombre, String apellido,
                             String correo, String credencial){
        switch(prefijo){
            case "EST" -> usuarioAlmacen.setPersonasAlmacen(ID, new Estudiante(ID, nombre, apellido, correo, credencial));
            case "PRO" -> usuarioAlmacen.setPersonasAlmacen(ID, new Profesor(ID, nombre, apellido, correo, credencial));
            case "GEN" -> usuarioAlmacen.setPersonasAlmacen(ID, new PublicoGeneral(ID, nombre, apellido, correo, credencial));
        }

    }
    //===================== OTRAS FUNCIONALIDADES. =====================

    /**
     * Esta función mostrará un menu que se repetirá en la sección de mostrar bibliotecarios
     * y mostrar Usuarios, por lo que sería mejor ahorrar código
     *
     * @return : Regresará solamente la opción seleccionada.
     */
    public int queSeMostrara(String area) {
        int opcion = 0;
        try {
            System.out.println("¿Como deseas ver a los " + area + "?\n" +
                    "1.Mostrar Todos.\n" +
                    "2.Buscar por ID.\n" +
                    "3.Menu inicio.");
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException tipo) {
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingrese el dato que le solicitan.");
            sc.nextLine();
        }
        return opcion;
    }

    public String buscarPersona(String area) {
        String ID = "";
        try {
            System.out.print("Ingresa el ID del " + area + " que deseas buscar: ");
            ID = sc.nextLine();
        } catch (InputMismatchException tipo) {
            System.out.println("Error del tipo: " + tipo.getMessage());
            System.out.println("Ingresa los datos correctamente");
        }
        return ID;
    }
}
