import java.time.LocalDate;

public class Pago{
    private int id;
    private double monto;
    private LocalDate fecha;
    private String medioPago;
    private String estado;
    private Turno turnos;
    public Pago(int id,double monto,LocalDate fecha,String medioPago,
    String estado,Turno turno)
    {
        this.id = id;
        this.monto=monto;
        this.fecha=fecha;
        this.medioPago=medioPago;
        this.turnos=turno;
    }
    
    

}