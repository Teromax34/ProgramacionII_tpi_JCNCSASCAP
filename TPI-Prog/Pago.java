public class Pago{
    private int id;
    private double montoAdicional;
    private double descuento;
    private String fecha;
    private String medioPago;
    private String estado;
    private Turno turnos;
    public Pago(int id,double montoAdicional,double descuento,String fecha,String medioPago,
    String estado,Turno turno)
    {
        this.id = id;
        this.montoAdicional=montoAdicional;
        this.descuento = descuento;
        this.fecha=fecha;
        this.medioPago=medioPago;
        this.turnos=turno;
    }
    
    public double montoTotal(){
            return montoAdicional + turnos.verServicio().precioS();
    }
    public double aplicarDescuentos(){
        return montoTotal() * descuento;
    }
    public Turno verTurno(){
        return this.turnos;
    }
    public void Factura(){
        System.out.println("Dni:" + turnos.verCliente().dniC());
        System.out.println("Nombre y Apellido:" + turnos.verCliente().nombreC()+" "+turnos.verCliente().apellidoC());
        System.out.println("Direccion:" + turnos.verCliente().direccionC());
        System.out.println("Fecha:"+fecha);
        System.out.println("Medio de Pago:"+medioPago);
        System.out.println("Monto Total:" + montoTotal());
        System.out.println("Monto Total con Descuento:" + aplicarDescuentos());
    }
}