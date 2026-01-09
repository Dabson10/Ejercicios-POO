package Gestor_De_Biblioteca_7.Modelos.Personas.Usuario;

import Gestor_De_Biblioteca_7.Modelos.Ejemplar;
import Gestor_De_Biblioteca_7.Modelos.Personas.Persona;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario extends Persona {
    private String credencialVigente;
    private List<Ejemplar> librosPrestados;
    private float multas;

    public Usuario(String personaID, String nombres, String apellidos, String correo, String credencialVigente) {
        super(personaID, nombres, apellidos, correo);
        this.credencialVigente = credencialVigente;
        this.librosPrestados  = new ArrayList<>();
    }

    /**
     * Esta funcion servira para agregar ejemplares en cada usuario, solo guardará valores
     * diferentes a null, pero se tiene una seguridad para que no cruce algún null.
     * @param ejemplar : ejemplar será el objeto del ejemplar, para asi poder acceder
     *                 a los datos del ejemplar en cuestión
     */
    public void setLibrosPrestados(Ejemplar ejemplar) {
        try{
            if (ejemplar != null) {
                //Si el ejemplar es diferente a null entonces lo guardará.
                librosPrestados.add(ejemplar);
            } else {
                System.out.println("Ingrese un ejemplar existente.");
            }
        }catch(NullPointerException ex){
            System.out.println("Error del tipo: " + ex.getMessage());
            System.out.println("Error al agregar libro en el perfil del usuario.");
        }
    }

//Funciones abstractas

    /**
     * Esta función servira para validar si se podra hacer un aumento en los días
     * de prestamo, si el libro está apartado entonces no aumenta el día, si no está apartado aumenta el día
     *
     * @return : regresará un true o false, dado sea el caso,  si esta apartado un false, si no lo esta un true
     */
    public abstract boolean aumentarDiaPrestamo();

    /**
     * Esta función Servira para saber si el usuario puede pedir un libro más, ya que el usuario
     * tiene un límite de libros prestados, esta funcion servira para saber si el usuario
     * puede o no pedir más libros
     *
     * @param cantidad : Este será solo la cantidad de ejemplares de la lista que guarda a los ejemplares
     * @return : regresara ya sea un true si la cantidad es menor a la cantidad límite, un false si es igual
     */
    public abstract boolean validarLimiteLibros(int cantidad);

    public abstract String mostrarDatos();
}
