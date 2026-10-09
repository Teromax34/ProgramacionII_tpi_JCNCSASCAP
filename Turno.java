public class Turno{
    private int id;
    private String fechaIngreso;
    private int horaIngreso;
    private String fechaEntrega;
    private int horaEntrega;
    private boolean envio;
    private EstadoTurno estado;
    private Cliente clientes;
    private Dispositivo dispositivos;
    private Servicio servicios;
    private Empleado empleados;
    private Cadete cadete;
    
    public Turno(int id,String fechaIngreso,int horaIngreso,String fechaEntrega,int horaEntrega,EstadoTurno estado,
    Cliente cliente,Dispositivo dispositivo,Servicio servicio, Empleado empleado,boolean envio,Cadete cadete)
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
        this.envio = envio;
        if(this.envio == true){
            this.cadete = cadete;
        }else{
            this.cadete = null;
        }
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
    public void cambiarFechaEntrega(String nuevaFecha){
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
    
    public void resumenTurno(){
        System.out.println("------------------\nTURNO\nDni:" + clientes.dni());
        System.out.println("Nombre y Apellido:" + clientes.nombre()+" "+ clientes.apellido());
        System.out.println("Empleado que realizo la reparacion:" + empleados.nombre()+" "+empleados.apellido());
        System.out.println("Modelo del Dispositivo:" + dispositivos.modeloD());
        System.out.println("Falla:" + dispositivos.fallaD());
        System.out.println("Estado:" + estado);
        System.out.println("ID Dispositivo:" + dispositivos.idD()+" - ID Servicio:"+servicios.idS());
        System.out.println("Envio:"+envio+" | DNI del cadete:"+cadete.dni()+" | Direccion de envio:"+cadete.direccion());
    }
}