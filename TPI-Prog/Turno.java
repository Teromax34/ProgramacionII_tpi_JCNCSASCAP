import java.time.LocalTime;
import java.time.LocalDate;

public class Turno{
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private Cliente clientes;
    private Dispositivo dispositivos;
    private Servicio servicios;
    private Empleado empleados;
    
    public Turno(int id,LocalDate fecha,LocalTime hora,String estado,Cliente cliente,Dispositivo dispositivo,
    Servicio servicio, Empleado empleado)
    {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.clientes = cliente;
        this.dispositivos = dispositivo;
        this.servicios = servicio;
        this.empleados = empleado;
    }
    public int idT(){
        return id;
    }
    public String estadoT(){
        return estado;
    }
    

}