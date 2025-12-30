package Otros_Aprendizajes.excepciones.EjerciciosBasicos;
//Excepciones no verificadas tipo: RunTimeException
public class ExcepcionesNoVerificadas {
    public static void main(String[] args) throws RuntimeException{
        divicionEntreCero();
    }
    public static void divicionEntreCero() throws RuntimeException{
        int num1 = 5, num2 = 0;
        int result = num1 / num2;
        System.out.println("El resultado es: " + result);
    }

}
