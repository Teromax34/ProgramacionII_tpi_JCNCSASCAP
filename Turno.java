import java.time.LocalDate;

public class Turno{
    private int id;
    private LocalDate fechaIngreso;
    private int horaIngreso;
    private LocalDate fechaEntrega;
    private int horaEntrega;
    private EstadoTurno estado;
    private Cliente clientes;
    private Dispositivo dispositivos;
    private Servicio servicios;
    private Empleado empleados;
    
    public Turno(int id,LocalDate fechaIngreso,int horaIngreso,LocalDate fechaEntrega,int horaEntrega,EstadoTurno estado,
    Cliente cliente,Dispositivo dispositivo,Servicio servicio, Empleado empleado)
    {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.clientes = cliente;
        this.dispositivos = dispositivo;
        this.servicios = servicio;
        this.empleados = empleado;

    }
    public int idT(){
        return id;
    }

    public EstadoTurno estado(){
        return this.estado;
    }


    public void cambiarEstado(EstadoTurno nuevoEstado){
        this.estado = nuevoEstado;
    }
    public void cambiarFechaEntrega(LocalDate nuevaFecha){
                this.fechaEntrega = nuevaFecha;
    }
    public void cambiarHoraEntrega(int nuevaHora){
                this.horaEntrega = nuevaHora;
    }

    public Cliente verCliente(){
        return this.clientes;
    }
    public Servicio verServicio(){
        return this.servicios;
    }
    public Dispositivo verDispositivo() {
        return dispositivos;
    }
    public Empleado vetEmpleado() {
        return empleados;
    }

    
    public void resumenTurno(){
        System.out.println("------------------\nTURNO\nDni:" + clientes.dni());
        System.out.println("Nombre y Apellido:" + clientes.nombreCompleto().toUpperCase());
        System.out.println("Empleado que realizo la reparacion:" + empleados.nombreCompleto().toUpperCase());
        System.out.println("Modelo del Dispositivo:" + dispositivos.modeloD());
        System.out.println("Falla:" + dispositivos.fallaD());
        System.out.println("Estado:" + estado);
        System.out.println("ID Dispositivo:" + dispositivos.idD()+" - ID Servicio:"+servicios.idS());
        System.out.println("Fecha de ingreso:"+fechaIngreso+ "\n"+"Fecha Egreso:"+fechaEntrega+"\n------------------");
    }
}