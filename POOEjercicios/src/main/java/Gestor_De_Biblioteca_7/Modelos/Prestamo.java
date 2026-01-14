package Gestor_De_Biblioteca_7.Modelos;

import Gestor_De_Biblioteca_7.Modelos.Personas.Usuario.Usuario;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Prestamo {
    private String prestamoID;
    private Ejemplar ejemplarPrestado;
    private Usuario solicitoElUsuario;
    private LocalDate fechaPrestamo;
    private LocalDate seEntregaraEn;
    private boolean activo;

    public Prestamo(String prestamoID, Ejemplar ejemplarPrestado, Usuario solicitoElUsuario,
                    LocalDate fechaPrestamo, LocalDate seEntregaraEn) {
        try {
            if (ejemplarPrestado != null && solicitoElUsuario != null) {
                this.prestamoID = prestamoID;
                this.ejemplarPrestado = ejemplarPrestado;
                this.solicitoElUsuario = solicitoElUsuario;
                this.fechaPrestamo = fechaPrestamo;
                this.seEntregaraEn = seEntregaraEn;
                this.activo = true;
            } else {
                System.out.println("No se puede crear un préstamo, verifique que los datos estén bien puestos.");
            }
        } catch (NullPointerException ex) {
            System.out.println("Error del tipo: " + ex.getMessage());
            System.out.println("Error al momento de crear un préstamo.");
        } catch (DateTimeException time) {
            System.out.println("Error del tipo: " + time.getMessage());
            System.out.println("Error con las fechas ingresadas.");
        }
    }

    public boolean getActivo(){
        return this.activo;
    }
    /**
     * Esta función es necesaria para cuando se cambia el estado de un prestamo,
     * inicialmente aparecerá en {@code true} lo que significa que el libro prestado aún
     * no se devuelve. Si el valor es false, el libro se devolvió por lo que el prestamo ya termino.
     * Lo que realiza esta función es hacer el cambio, de true a {@code false} y viceversa, logrando asi que
     * los préstamos sean fáciles de actualizar sin mucho código.
     *
     */
    public void cambiarEstado(){
        if(this.activo){
            //Significa que el libro se devolvió
            activo = false;
        }else{
            //Significa que el libro aún no se ha devuelto.
            activo = true;
        }
    }
    public String mostrarDatos(){
        String estado = (activo)? "Prestado" : "Devuelto";
        return "ID: " + prestamoID +
                "\nUsuario: " + solicitoElUsuario.mostrarDatos() +
                "\nLibro prestado: " + ejemplarPrestado.mostrarDatos() +
                "\nFecha del préstamo: " + fechaPrestamo +
                "\nSe entregara: : " + seEntregaraEn +
                "\nEstado préstamo: " + estado;
    }

}
