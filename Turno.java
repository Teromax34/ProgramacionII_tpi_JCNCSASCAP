import java.time.LocalDate;

public class Turno{
    private int id;
    private LocalDate fechaIngreso;
    private int horaIngreso;
    private LocalDate fechaEntrega;
    private int horaEntrega;
    private EstadoTurno estado;
    private Cliente clientes;
    private Empleado empleados;
    private Dispositivo dispositivos;
    private Servicio servicios;
    
    public Turno(int id,LocalDate fechaIngreso,int horaIngreso,LocalDate fechaEntrega,int horaEntrega,EstadoTurno estado,
    Cliente cliente,Empleado empleado,Dispositivo dispositivo,Servicio servicio)
    {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.clientes = cliente;
        this.empleados = empleado;
        this.dispositivos = dispositivo;
        this.servicios = servicio;

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
    public void cambiarCliente(Cliente cliente){
        this.clientes = cliente;
    }
    public void cambiarEmpleado(Empleado empleado){
        this.empleados = empleado;
    }
    public void cambiarDispositivo(Dispositivo dispositivo){
        this.dispositivos = dispositivo;
    }
    public void cambiarServicio(Servicio servicio){
        this.servicios = servicio;
    }
    public Dispositivo verDispositivo() {
        return dispositivos;
    }
    public Empleado verEmpleado() {
        return empleados;
    }
    public Turno(int id) {
    this.id = id;
    }

    
    public void resumenTurno(){
        if (clientes == null || empleados == null || dispositivos == null || servicios == null) {
            throw new IllegalStateException("El turno " + id + " tiene referencias incompletas.");
        }
        System.out.println("------------------\nTURNO\nDni:" + clientes.dni());
        System.out.println("Nombre y Apellido:" + clientes.nombreCompleto().toUpperCase());
        System.out.println("Empleado que realizo la reparacion:" + empleados.nombreCompleto().toUpperCase());
        System.out.println("Modelo del Dispositivo:" + dispositivos.modeloD());
        System.out.println("Falla:" + dispositivos.fallaD());
        System.out.println("Estado:" + estado);
        System.out.println("ID Dispositivo:" + dispositivos.idD()+" - ID Servicio:"+servicios.idS());
        System.out.println("Fecha de ingreso:"+fechaIngreso+ "\n"+"Fecha Egreso:"+fechaEntrega+"\n------------------");
    }

    public String convertirALineaArchivo() {
        return id + ";" + fechaIngreso.toString() + ";" + horaIngreso + ";" + fechaEntrega.toString() + ";" + horaEntrega + ";" + estado + ";" + clientes.dni() + ";" + empleados.dni() + ";" + dispositivos.idD() + ";" + servicios.idS();
    }
    public static Turno crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int id = Integer.parseInt(datos[0]);
        LocalDate fechaIgreso = LocalDate.parse(datos[1]);
        int horaIngreso = Integer.parseInt(datos[2]);
        LocalDate fechaEntrega = LocalDate.parse(datos[3]);
        int horaEntrega = Integer.parseInt(datos[4]);
        EstadoTurno estado = EstadoTurno.valueOf(datos[5].toUpperCase());
        int dniCliente = Integer.parseInt(datos[6]);
        int dniEmpleado = Integer.parseInt(datos[7]);
        int idDispositivo = Integer.parseInt(datos[8]);
        int idServicio = Integer.parseInt(datos[9]);
        Cliente cliente = new Cliente(dniCliente);
        Dispositivo dispositivo = new Dispositivo(idDispositivo);
        Servicio servicio= new Servicio(idServicio);
        Empleado empelado = new Empleado(dniEmpleado);
    
        return new Turno(id, fechaIgreso, horaIngreso, fechaEntrega,horaEntrega,estado,cliente,empelado,dispositivo,servicio);
    }
    @Override
    public String toString() {
        return id + ";" + fechaIngreso.toString() + ";" + horaIngreso + ";" + fechaEntrega.toString() + ";" + horaEntrega + ";" + estado + ";" + clientes.dni() + ";" + empleados.dni() + ";" + dispositivos.idD() + ";" + servicios.idS();
    }
}