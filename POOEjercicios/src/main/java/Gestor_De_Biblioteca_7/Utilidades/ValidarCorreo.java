package Gestor_De_Biblioteca_7.Utilidades;

import Gestor_De_Biblioteca_7.Excepciones.CorreoIncorrecto;

public class ValidarCorreo {
    public boolean validarCorreo(String correo){
        boolean tieneArroba = correo.contains("@");
        boolean terminaConCom = correo.endsWith(".com");
        if(tieneArroba && terminaConCom){
            return true;
        }else{
            throw new CorreoIncorrecto("El correo: " + correo + ", no tiene un formato valido.");
        }
    }
}