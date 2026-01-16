package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Personas.Persona;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario extends Persona {
    private String credencialVigente;
    private List<Ejemplar> librosPrestados;
    private float multa;

    public Usuario(String personaID, String nombres, String apellidos, String correo, String credencialVigente) {
        super(personaID, nombres, apellidos, correo);
        this.credencialVigente = credencialVigente;
        this.librosPrestados = new ArrayList<>();
        multa = 0f;
    }

    /**
     * Esta función servirá para agregar ejemplares en cada usuario, solo guardará valores
     * diferentes a null, pero se tiene una seguridad para que no cruce algún null.
     *
     * @param ejemplar : ejemplar será el objeto del ejemplar, para asi poder acceder
     *                 a los datos del ejemplar en cuestión
     */
    public void setLibrosPrestados(Ejemplar ejemplar) {
        if (ejemplar != null) {
            //Si el ejemplar es diferente a null entonces lo guardará.
            librosPrestados.add(ejemplar);
        } else {
            System.out.println("Ingrese un ejemplar existente.");
        }
    }
    //Obtener la cantidad de libros que el usuario se le prestaron y no ha devuelto.
    public int obtenerCantidadLibros(){
        return librosPrestados.size();
    }


    public void setMulta(float multa) {
        if (multa >= 0) {
            //Si es mayor a cero o igual entonces no se agregará
            this.multa = multa;
        } else {
            System.out.println("Ingrese una multa valida.");
        }
    }

    public float getMulta() {
        return multa;
    }
    public String obtenerLista(){
        StringBuilder cadena = new StringBuilder();
        for(int i = 0; i < librosPrestados.size(); i++){
            cadena.append(librosPrestados.get(i).mostrarDatos()).append("\n\n\n");
        }
        return cadena.toString();
    }
//Funciones abstractas

    /**
     * Esta función servirá para validar si se podrá hacer un aumento en los días
     * de préstamo, si el libro está apartado entonces no aumenta el día, si no está apartado aumenta el día
     *
     * @return : regresará un true o false, dado sea el caso,  si esta apartado un false, si no lo esta un true
     */
    public abstract boolean aumentarDiaPrestamo();


    /**
     * Esta función servirá para saber si el usuario puede pedir un libro más, ya que el usuario
     * tiene un límite de libros prestados, esta función servirá para saber si el usuario
     * puede o no pedir más libros
     *
     * @return : regresara ya sea un true si la cantidad es menor a la cantidad límite, un false si es igual
     */
    public abstract boolean validarLimiteLibros();

    public String mostrarDatos() {
        return "ID: " + getPersonaID() +
                "\nNombres: " + getNombres() +
                "\nApellidos: " + getApellidos() +
                "\nCorreo: " + getCorreo() +
                "\n Libros prestados: " + obtenerLista();
    }
}
