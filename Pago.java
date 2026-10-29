import java.time.LocalDate;
public class Pago{
    private int id;
    private double montoAdicional;
    private double descuento;
    private LocalDate fecha;
    private String medioPago;
    private String estado;
    private Turno turnos;
    public Pago(int id,double montoAdicional,double descuento,LocalDate fecha,String medioPago,
    String estado,Turno turno)
    {
        this.id = id;
        this.montoAdicional=montoAdicional;
        this.descuento = descuento;
        this.fecha=fecha;
        this.medioPago=medioPago;
        this.estado = estado;
        this.turnos=turno;
    }
    
    public double montoTotal(){
        if (turnos == null || turnos.verServicio() == null) {
            throw new IllegalStateException("El pago no tiene un turno asociado con un servicio válido.");
        }
        return montoAdicional + turnos.verServicio().precioS();
    }
    public double montoFinalDescuento(){
        return montoTotal() * (1-(descuento / 100));
    }
    public Turno verTurno(){
        return this.turnos;
    }
    public void cambiarTurno(Turno turno){
        this.turnos = turno;
    }
    public int idP(){
        return  id;
    }

    public void cambiarMontoAdicional(double montoAdicional){
        this.montoAdicional = montoAdicional;
    }
    public void cambiarDescuento(double descuento){
        this.descuento = descuento;
    }
    public void cambiarMedioPago(String medioPago){
        this.medioPago = medioPago;
    }
    public void cambiarEstado(String estado){
        this.estado = estado;
    }

    
    public void Factura(){
        if (turnos == null || turnos.verCliente() == null) {
            throw new IllegalStateException("El pago no tiene un turno asociado con un cliente válido.");
        }
        System.out.println("------------------\nFACTURA DE PAGO\nDni:" + turnos.verCliente().dni());
        System.out.println("Nombre y Apellido:" + turnos.verCliente().nombreCompleto());
        System.out.println("Direccion:" + turnos.verCliente().direccion());
        System.out.println("Fecha:"+fecha);
        System.out.println("Medio de Pago:"+medioPago);
        System.out.println("Monto Total:" + montoTotal());
        System.out.println("Monto Total con Descuento:" + montoFinalDescuento()+"\n------------------");
    }
    public String convertirALineaArchivo() {
        return id + ";" + montoAdicional + ";" + descuento + ";" + fecha.toString() + ";" + medioPago + ";" + estado + ";" + turnos.idT();
    }
    public static Pago crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int id = Integer.parseInt(datos[0]);
        double montoAdicional = Double.parseDouble(datos[1]);
        double descuento = Double.parseDouble(datos[2]);
        LocalDate fecha = LocalDate.parse(datos[3]);
        String medioPago = datos[4];
        String estado = datos[5];
        int idTurno = Integer.parseInt(datos[6]);
        Turno turno = new Turno(idTurno);
    
        return new Pago(id, montoAdicional, descuento, fecha,medioPago,estado,turno);
    }
    @Override
    public String toString() {
        return id + ";" + montoAdicional + ";" + descuento + ";" + fecha.toString() + ";" + medioPago + ";" + estado + ";" + turnos.idT();
    }
}