public class Main {
        public static void main(String[] args) {
        Cliente cliente = new Cliente(123, "Juan", "Perez", 1111, "Calle 1");

        Dispositivo dispositivo = new Dispositivo(
            1, "Notebook", "Lenovo", "ThinkPad", "ABC123", "No enciende"
        );

        Servicio servicio = new Servicio(
            1, "Reparacion", "Reparacion general", 100, 3
        );

        Empleado empleado = new Empleado(
            10, "Ana", "Gomez", 2222, "Tecnica"
        );

        Turno turno1 = new Turno(
            1, "20/09/2026", 10, "25/09/2026", 15,
            "completo", cliente, dispositivo, servicio, empleado
        );    
        Turno turno2 = new Turno(
            2, "20/09/2026", 10, "25/09/2026", 15,
            "pendiente", cliente, dispositivo, servicio, empleado
        );    
    
        Pago pago = new Pago(
            1,200,0.80,"20/200/2000","mercadopago","pagado",turno1
        );
        cliente.verDatosCliente();
        cliente.agregarTurno(turno1);
        cliente.agregarTurno(turno2);
        cliente.verIDturnos();
        //turno.cambiarEstado("realizado");
        turno1.resumenTurno(); 
        pago.Factura();
    }
}