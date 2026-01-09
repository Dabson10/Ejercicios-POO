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
                    LocalDate fechaPrestamo, LocalDate seEntregaraEn){

        try{
            if(ejemplarPrestado != null && solicitoElUsuario != null){
                this.prestamoID = prestamoID;
                this.ejemplarPrestado = ejemplarPrestado;
                this.solicitoElUsuario = solicitoElUsuario;
                this.fechaPrestamo = fechaPrestamo;
                this.seEntregaraEn = seEntregaraEn;
                this.activo = true;
            }else{
                System.out.println("No se puede crear un préstamo, verifique que los datos estén bien puestos.");
            }
        }catch (NullPointerException ex){
            System.out.println("Error del tipo: " + ex.getMessage());
            System.out.println("Error al momento de crear un préstamo.");
        }catch(DateTimeException time){
            System.out.println("Error del tipo: " + time.getMessage());
            System.out.println("Error con las fechas ingresadas.");
        }

    }
}
