package Sistema_De_Citas_Medicas.Modelos;
//Clase estática para las citas medícas
public class Cita {
    //Atributos de la clase.
    private String citaID;
    private String estado = "Pendiente";
    private Paciente pacienteID;
    private Doctor doctorID;
    private String fechaYHora;
    private float costoCita;
    private String motivo;
    private float montoExtra = 0;
    private String razonMontoExtra;
    private String razonCancelacion;

    //Metodos de la clase cita.
    public Cita(String citaID, Paciente pacienteID, Doctor doctorID,
                String fechaYHora, float costoCita, String motivo){
        if(costoCita > 0){
            this.citaID = citaID;
            this.pacienteID = pacienteID;
            this.doctorID = doctorID;
            this.fechaYHora = fechaYHora;
            this.costoCita = costoCita;
            this.motivo = motivo;
        }else{
            System.out.println("Ingrese el costo de la cita real.");
        }
    }

    //Bloqueamos cualquier acceso a valores incorrectos al costo de la cita y al montoExtra
    public void setCostoCita(float costoCita){
        if(costoCita > 0){
            this.costoCita = costoCita;
        }else{
            System.out.println("Ingrese un costo valido.");
        }
    }

    public void setMontoExtra(float montoExtra){
        //Si el valor es mayor o igual a cero entonces se guarda,
        //guarda valores solamente de cero en adelante, ya que se pueden guardar valores
        //en cero
        if(montoExtra >= 0){
            this.montoExtra = montoExtra;
        }else{
            System.out.println("Monto extra no valido");
        }
    }

    public void setRazonMontoExtra(String razonMontoExtra) {
        if (!razonMontoExtra.isEmpty()) {
            //Si no esta vacío entonces procedemos a guardar.
            this.razonMontoExtra = razonMontoExtra;
        } else {
            System.out.println("Ingrese un monto valido.");
        }
    }

    public void actualizarMontosExtras(String razonMontoExtra, float montoExtra){
        if(!razonMontoExtra.isEmpty()){
            this.razonMontoExtra = razonMontoExtra;
            this.montoExtra = montoExtra;
        }
    }

    public void setRazonCancelacion(String razonCancelacion){
        if(!razonCancelacion.isEmpty()){
            this.razonCancelacion = razonCancelacion;
        }else{
            System.out.println("No se pudo cancelar la cita medica.");
        }
    }

    public String getCitaID(){
        return citaID;
    }

    //Obtener el total del monto extra y del costo de la cita.
    /**
     * La funcion de calcular total no solo suma el costo de la cita más el monto extra, se
     * calcula el costo de la cita del doctor con un porcentaje con base en la tarifa del doctor.
     */
    public float calcularTotal(){
        return (costoCita + montoExtra);
    }

    //Funciones para cambiar el estado de la cita medíca
    public boolean completarCita(){
        boolean completar = false;
        if(estado.equals("Pendiente")){
            this.estado = "Completada";
            completar = true;
        }else{
            System.out.println("La cita cancelada no puede cambiar de estado.");
        }
        return completar;
    }

    public boolean cancelarCita(){
        boolean cancelar = false;
        if(this.estado.equals("Pendiente")){
            this.estado = "Cancelada";
            cancelar = true;
        }else{
            System.out.println("No se puede cancelar una cita ya completada.");
        }
        return cancelar;
    }


    public String mostrarCita(){
        String motivoExtra = (montoExtra == 0) ? "Sin monto extra." : this.razonMontoExtra;
        return "\nCita: " + citaID +
                "\nPaciente: " + pacienteID.getApellidos().concat(" ").concat(pacienteID.getNombres()) +
                "\nDoctor: " + doctorID.getApellidos().concat(" ").concat(doctorID.getNombres()) +
                "\nFecha y hora: " + fechaYHora +
                "\nCosto cita: " + costoCita +
                "\nMotivo: " + motivo +
                "\nMonto extra: " +motivoExtra +
                "\nTotal a pagar: " + calcularTotal() +
                "\nEstado de la cita: " + estado;
    }

}
