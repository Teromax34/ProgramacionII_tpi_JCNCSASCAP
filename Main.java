public class Main {
        public static void main(String[] args) {
        Cliente c = new Cliente(123, "Juan", "Perez", 1111, "Calle 1");
        Cliente c2 = new Cliente(344, "robe", "sdsds", 4344, "aaaaa 1");
        Cliente c3 = new Cliente(589, "dfdss", "fgfdsd", 4344, "ghfhh 1");

        Dispositivo d = new Dispositivo(
            1, "Notebook", "Lenovo", "ThinkPad", "ABC123", "No enciende"
        );
        Dispositivo d2 = new Dispositivo(
            2, "Notebook", "Lenovo", "ThinkPad", "ABC123", "No enciende"
        );

        Servicio s = new Servicio(
            1, "Reparacion", "Reparacion general", 100, 3,d
        );
        Servicio s2 = new Servicio(
            2, "romper", "general", 3000, 3,d2
        );

        Empleado e = new Empleado(
            10, "Ana", "Gomez", 2222, "Tecnica"
        );
        Empleado e2 = new Empleado(
            10, "lop", "Gomez", 344, "Reparar"
        );
        Cadete ca1 = new Cadete(30, "juan","aass", 12330, 2330, "SanJuan");

        Turno t1 = new Turno(
            200, "20/09/2026", 10, "25/09/2026", 15,
            EstadoTurno.PENDIENTE, c2, d, s, e,true,ca1
        );    
        Turno t2 = new Turno(
            2, "20/09/2026", 10, "25/09/2026", 15,
            EstadoTurno.CONFIRMADO, c2, d, s, e2,false,null
        );    
        Turno t3 = new Turno(
            3, "20/09/2026", 10, "25/09/2026", 15,
            EstadoTurno.CANCELADO, c3, d2, s2, e2,false,null
        );    
    
        Pago p = new Pago(
            1,200,20,"20/200/20","mercadopago","pagado",t1
        );
        Pago p2 = new Pago(
            2,50,20,"20/200/10","mercadopago","pagado",t2
        );
        Pago p3 = new Pago(
            3,200,20,"20/200/30","mercadopago","pagado",t3
        );
        
        GestionEmpresa gestion = new GestionEmpresa();
        gestion.agregarCliente(c,c2,c3);
        gestion.agregarEmpleado(e,e2);
        gestion.agregarPago(p,p2,p3);
        gestion.agregarTurno(t1,t2,t3);
        //c.buscarCliente();
        c2.agregarTurno(t1,t2);
        c3.agregarTurno(t3);
        e.agregarTurno(t1);
        e2.agregarTurno(t2,t3);
        //c.verDatosCliente();
        //c.verTurnosCliente();
        //t1.cambiarEstado("realizado");
        t1.resumenTurno(); 
        //p.Factura();
        //gestion.buscarCliente(344);
        //c3.verTurnosCliente();
        //gestion.clienteMayorTurnos();
        //gestion.facturacionTotal();
        //gestion.pagoMasAlto();
        //gestion.turnosTotales();
        //gestion.clientesTotales();
        //gestion.estadosDeTurnos();
        //gestion.empleadoMasTurnos();
    }
}