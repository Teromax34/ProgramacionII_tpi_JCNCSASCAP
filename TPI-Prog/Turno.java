public class Turno{
    private int id;
    private String fechaIngreso;
    private int horaIngreso;
    private String fechaEntrega;
    private int horaEntrega;
    private String estado;
    private Cliente clientes;
    private Dispositivo dispositivos;
    private Servicio servicios;
    private Empleado empleados;
    
    public Turno(int id,String fechaIngreso,int horaIngreso,String fechaEntrega,int horaEntrega,String estado,
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
    public String verificarEstado(){
        return estado;
    }
    public void cambiarEstado(String nuevoEstado){
        switch (nuevoEstado) {
            case "pendiente":
            case "realizado":
            case "confirmado":
            case "cancelado":
                this.estado = nuevoEstado;
                break; 
            default:
                System.out.println("Error");
                break;
        }
    }
    public Cliente verCliente(){
        return this.clientes;
    }
    public Servicio verServicio(){
        return this.servicios;
    }
    public void cambiarFechaEntrega(String nuevaFecha){
                this.fechaEntrega = nuevaFecha;
    }
    public void cambiarHoraEntrega(int nuevaHora){
                this.horaEntrega = nuevaHora;
    }
    public void resumenTurno(){
        System.out.println("Dni:" + clientes.dniC());
        System.out.println("Nombre y Apellido:" + clientes.nombreC()+" "+ clientes.apellidoC());
        System.out.println("Empleado que realizo la reparacion:" + empleados.nombreE()+" "+empleados.apellidoE());
        System.out.println("Modelo del Dispositivo:" + dispositivos.modeloD());
        System.out.println("Falla:" + dispositivos.fallaD());
        System.out.println("Estado:" + estado);
        System.out.println("ID Dispositivo :" + dispositivos.idD()+" ID Servicio :"+servicios.idS());
    }
}