package Gestor_De_Biblioteca_7.enums;

/**
 * Esta clase enum servira para guardar los prefijos que se utilizaran en el generador
 * de ID, aparte de esto servira para no escribir mal un valor al realizar alguna busqueda.
 */
public enum IdentificadorIDs {
    BIB(0), EST(1), PRO(2), GEN(3), LIB(4), EJE(5), PED(6);

    private final int codigo;
    IdentificadorIDs( int codigo) {
        this.codigo = codigo;
    }
    public static IdentificadorIDs identificarNumero(int num){
        for(IdentificadorIDs id : IdentificadorIDs.values()){
            if(id.codigo == num){
                //Si es igual entonces regresa el identificador
                return id;
            }
        }
        return GEN;
    }

    @Override
    public String toString(){
        return switch(this){
            case BIB -> "BIB";
            case EST -> "EST";
            case PRO -> "PRO";
            case GEN -> "GEN";
            case LIB -> "LIB";
            case EJE -> "EJE";
            case PED -> "PED";
        };
    }
}
