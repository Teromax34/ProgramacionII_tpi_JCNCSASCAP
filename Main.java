import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Cliente buscarCliente(ArrayList<Cliente> clientes, int dni) {
        for (Cliente c : clientes) {
            if (c.dni() == dni) {
                return c;
                }
            }
            return null;
        }
    public static Empleado buscarEmpleado(ArrayList<Empleado> empleados, int dni){
        for (Empleado e : empleados) {
           if (e.dni() == dni) {
                return e;
             }
        }
        return null;
    }
    public static Servicio buscarServicio(ArrayList<Servicio> servicios, int id){
        for (Servicio s : servicios) {
            if (s.idS() == id) {
                return s;
                }
            }
            return null;
    }
    public static Dispositivo buscarDispositivo(ArrayList<Dispositivo> dispositivos, int id){
        for (Dispositivo d : dispositivos) {
            if (d.idD() == id) {
                return d;  
            }
        }
        return null;
    }
    public static Turno buscarTurno(ArrayList<Turno> turnos, int id){
        for(Turno  t: turnos){
            if(t.idT() == id){
                return t;
            }
        }
        return null;
    }
    public static void vincular(ArrayList<Cliente> clientes, ArrayList<Empleado> empleados, ArrayList<Dispositivo> dispositivos, ArrayList<Servicio> servicios, ArrayList<Turno> turnos,ArrayList<Pago> pagos) {
        for (Turno turno : turnos) {
            Cliente cliente = turno.verCliente() == null ? null : buscarCliente(clientes, turno.verCliente().dni());
            Empleado empleado = turno.verEmpleado() == null ? null : buscarEmpleado(empleados, turno.verEmpleado().dni());
            Dispositivo dispositivo = turno.verDispositivo() == null ? null : buscarDispositivo(dispositivos, turno.verDispositivo().idD());
            Servicio servicio = turno.verServicio() == null ? null : buscarServicio(servicios, turno.verServicio().idS());

            if (cliente != null) {
                turno.cambiarCliente(cliente);
                cliente.agregarTurno(turno);
            }
            if (empleado != null) {
                turno.cambiarEmpleado(empleado);
                empleado.agregarTurno(turno);
            }
            if (dispositivo != null) {
                turno.cambiarDispositivo(dispositivo);
            }
            if (servicio != null) {
                turno.cambiarServicio(servicio);
            }
        }
        for (Pago pago : pagos) {
            if (pago.verTurno() != null) {
                Turno turno = buscarTurno(turnos, pago.verTurno().idT());
                if (turno != null) {
                    pago.cambiarTurno(turno);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        GestionEmpresa gestion = new GestionEmpresa();
        ArchivoCliente aCliente = new ArchivoCliente();
        ArchivoEmpleado aEmpleado = new ArchivoEmpleado();
        ArchivoTurno aTurno = new ArchivoTurno();
        ArchivoServicio aServicio = new ArchivoServicio();
        ArchivoDispositivo aDispositivo = new ArchivoDispositivo();
        ArchivoPago aPago = new ArchivoPago();
        ArrayList<Cliente> clientes = aCliente.cargarCliente();
        ArrayList<Dispositivo> dispositivos = aDispositivo.cargarDispositivo();
        ArrayList<Servicio> servicios = aServicio.cargarServicio(); 
        ArrayList<Empleado> empleados = aEmpleado.cargarEmpleado();
        ArrayList<Turno> turnos = aTurno.cargarTurno();
        ArrayList<Pago> pagos = aPago.cargarPago();
        vincular(clientes, empleados, dispositivos, servicios, turnos, pagos);
        for (Cliente c : clientes) {
        gestion.agregarCliente(c);
        }
        for (Empleado e : empleados) {
            gestion.agregarEmpleado(e);
        }  
        for(Pago p: pagos){
            gestion.agregarPago(p);
        }
        for(Turno t: turnos){
            gestion.agregarTurno(t);
        }

        /*Cliente c = new Cliente(123, "Juan Perez", 1111, "Calle 1");
        Cliente c2 = new Cliente(344, "robe sdsds", 4344, "aaaaa 1");
        Cliente c3 = new Cliente(589, "dfdss fgfdsd", 4344, "ghfhh 1");*/
        while (opcion != 8){
            try{
                System.out.println("\n------------");
                System.out.println("1: CLIENTE");
                System.out.println("2: DISPOSITIVO");
                System.out.println("3: SERVICIO");
                System.out.println("4: EMPLEADO");
                System.out.println("5: TURNO");
                System.out.println("6: PAGO");
                System.out.println("7: GESTION EMPRESA");
                System.out.println("8: SALIR"+"\n------------------");

                System.out.print("Ingrese una opción: ");
                opcion = sc.nextInt();

                if(opcion == 1){
                    int opcionC = 0;
                    while(opcionC != 5){
                        System.out.println("------------------\n1: Crear cliente");
                        System.out.println("2: Mostrar cliente");
                        System.out.println("3: Ver turnos del cliente");
                        System.out.println("4: Modificar datos del cliente");
                        System.out.println("5: Volver"+"\n------------------");
                        
                        System.out.print("Ingrese una opción: ");
                        opcionC = sc.nextInt();
                        if(opcionC == 1){
                            System.out.println("Dni: ");
                            int dni = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingresar Nombre Completo: ");
                            String nombreCompleto = sc.nextLine();

                            System.out.println("Telefono: ");
                            String telefono = sc.nextLine();
                            System.out.println("Direccion: ");
                            String direccion = sc.nextLine();

                            Cliente cliente = new Cliente(dni,nombreCompleto,telefono,direccion);
                            clientes.add(cliente);
                            gestion.agregarCliente(cliente);
                            aCliente.guardar(cliente);
                        }
                        if(opcionC == 2){
                            System.out.println("Ingresar DNI del cliente: ");
                            int dniBuscar = sc.nextInt();
                            for(Cliente c: clientes){
                                if(c.dni()==dniBuscar){
                                    c.verDatosCliente();
                                }
                            }
                        }
                        if(opcionC == 3){
                            System.out.println("Ingresar DNI del cliente: ");
                            int dniBuscar = sc.nextInt();
                            for(Cliente c: clientes){
                                if(c.dni()==dniBuscar){
                                    c.verTurnosCliente();
                                }else{
                                    System.out.println("Dni incorrecto: ");
                                }
                            }
                        }
                        if (opcionC == 4){
                            System.out.println("Ingresar DNI del cliente: ");
                            int dniBuscar = sc.nextInt();
                            for(Cliente c: clientes){
                                if(c.dni()==dniBuscar){
                                    System.out.println("Ingresar Numero correspondiente");
                                    System.out.println("1: Cambiar DNI");
                                    System.out.println("2: Cambiar NOMBRE");
                                    System.out.println("3: Cambiar TELEFONO");
                                    System.out.println("4: Cambiar DIRECCION");
                                    int inputC = sc.nextInt();
                                    if(inputC == 1){
                                        //c.cambiarDni();
                                    }
                                }
                            }
                        }
                    }
                }
                if(opcion == 2){
                    int opcionD = 0;
                    while (opcionD != 3){
                        System.out.println("------------------\n1: Crear Dispositivo");
                        System.out.println("2: Ver Dispositivo");
                        System.out.println("3: Volver"+"\n------------------");

                        System.out.print("Ingrese una opción: ");
                        opcionD = sc.nextInt();

                        if(opcionD == 1){
                            System.out.println("ID: ");
                            int idD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Tipo: ");
                            String tipo = sc.nextLine();
                            System.out.println("Marca: ");
                            String marca = sc.nextLine();
                            System.out.println("Modelo: ");
                            String modelo = sc.nextLine();
                            System.out.println("Numero de Serie: ");
                            String numeroSerie = sc.nextLine();
                            System.out.println("Descripcion: ");
                            String Descripcion = sc.nextLine();
                            Dispositivo dispositivo = new Dispositivo(idD, tipo, marca, modelo, numeroSerie, Descripcion);
                            dispositivos.add(dispositivo);
                            aDispositivo.guardar(dispositivo);
                            
                        }
                        if(opcionD == 2){
                            System.out.println("Ingresar ID del dispositivo: ");
                            int IdBuscar = sc.nextInt();
                            for(Dispositivo d: dispositivos){
                                if(d.idD()==IdBuscar){
                                    d.verDispositivo();
                                }
                                
                            }
                        }
                    }
                }
                if (opcion == 3){
                    int opcionS = 0;
                    System.out.println("------------------\n1: Crear Servicio");
                    System.out.println("2: Ver Servicio");
                    System.out.println("3: Volver"+"\n------------------");

                    System.out.print("Ingrese una opción: ");
                    opcionS = sc.nextInt();
                    if(opcionS == 1){
                        System.out.println("ID: ");
                        int idS = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nombre: ");
                        String nombreS = sc.nextLine();
                        System.out.println("Descripcion: ");
                        String descripcionS = sc.nextLine();
                        System.out.println("Precio: ");
                        double precioS = sc.nextDouble();
                        System.out.println("Duracion Estimada: ");
                        int duracionS = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese ID del dispositivo: ");
                        int buscarIdDispositivo = sc.nextInt();
                        Dispositivo dispositivo = buscarDispositivo(dispositivos, buscarIdDispositivo);
                        if(dispositivo != null){
                            Servicio servicio = new Servicio(idS, nombreS, descripcionS, precioS, duracionS,dispositivo);
                            servicios.add(servicio);
                            aServicio.guardar(servicio);
                        }else{
                            System.out.println("ID de Dispositivo incorrecto");
                        }
                    }
                    if(opcionS == 2){
                        System.out.println("Ingresar ID del servicio: ");
                        int IdBuscar = sc.nextInt();
                        for(Servicio s: servicios){
                            if(s.idS()==IdBuscar){
                                s.verServicio();
                            }
                        }
                    }
                }
                if(opcion == 4){
                    int opcionE = 0;
                    while(opcionE != 4){
                        System.out.println("------------------\n1: Crear Empleado");
                        System.out.println("2: Ver Empleado");
                        System.out.println("3: Ver Turnos");
                        System.out.println("4: Volver"+"\n------------------");

                        System.out.print("Ingrese una opción: ");
                        opcionE = sc.nextInt();
                        if(opcionE == 1){
                            System.out.println("Dni: ");
                            int dniE = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingresar nombre: ");
                            String nombreCompletoE = sc.nextLine();
                            System.out.println("Telefono: ");
                            String telefonoE = sc.nextLine();
                            
                            System.out.println("Ingrese el numero de la Especialidad del Empleado:");
                            System.out.println("1: MICROELECTRONICA");
                            System.out.println("2: PANTALLA");
                            System.out.println("3: SOFTWARE");
                            System.out.println("4: HARDWARE");

                            int opcionEstado = sc.nextInt();
                            sc.nextLine();
                            EspecialidadEmpleado especialidad = null;
                            if (opcionEstado == 1) {
                                especialidad = EspecialidadEmpleado.MICROELECTRONICA;

                            } else if (opcionEstado == 2) {
                                especialidad = EspecialidadEmpleado.PANTALLA;

                            } else if (opcionEstado == 3) {
                                especialidad = EspecialidadEmpleado.SOFTWARE;

                            } else if (opcionEstado == 4) {
                                especialidad = EspecialidadEmpleado.HARDWARE;
                            }
                            System.out.println("Sueldo: ");
                            double sueldo = sc.nextDouble();

                            Empleado empleado = new Empleado(dniE, nombreCompletoE, telefonoE, especialidad, sueldo);
                            empleados.add(empleado);
                            gestion.agregarEmpleado(empleado);
                            aEmpleado.guardar(empleado);
                        }
                        if(opcionE == 2){
                            System.out.println("Ingresar DNI del empleado: ");
                            int dniBuscar = sc.nextInt();
                            for(Empleado e: empleados){
                                if(e.dni()==dniBuscar){
                                    e.datosEmpleado();
                                }
                            }
                        }
                        if(opcionE == 3){
                            System.out.println("Ingresar DNI del empleado: ");
                            int dniBuscar = sc.nextInt();
                            for(Empleado e: empleados){
                                if(e.dni()==dniBuscar ){
                                    e.verTurnos();
                                }
                            }
                        }
                    }   
                }
                if(opcion == 5){
                    int opcionT = 0;
                    while(opcionT != 3){
                        System.out.println("------------------\n1: Crear Turno");
                        System.out.println("2: Ver Turno");
                        System.out.println("3: Volver"+"\n------------------");

                        System.out.print("Ingrese una opción: ");
                        opcionT = sc.nextInt();
                        if(opcionT == 1){
                            System.out.println("ID: ");
                            int idT = sc.nextInt();
                            sc.nextLine();
                            LocalDate fechaIT = LocalDate.now();
                            System.out.println("Hora de Ingreso: ");
                            int horaIT = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingresar la fecha (AÑO-MES-DIA): ");
                            String fechaET = sc.nextLine();
                            LocalDate fechaE = LocalDate.parse(fechaET);
                            System.out.println("Hora de Entrega: ");
                            int HoraET = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Ingresar el numero correspondiente del Estado del turno:");
                            System.out.println("1. PENDIENTE");
                            System.out.println("2. REALIZADO");
                            System.out.println("3. CONFIRMADO");
                            System.out.println("4. CANCELADO");

                            int opcionEstado = sc.nextInt();
                            sc.nextLine();
                            EstadoTurno estadoT = null;
                            if (opcionEstado == 1) {
                                estadoT = EstadoTurno.PENDIENTE;

                            } else if (opcionEstado == 2) {
                                estadoT = EstadoTurno.REALIZADO;

                            } else if (opcionEstado == 3) {
                                estadoT = EstadoTurno.CONFIRMADO;

                            } else if (opcionEstado == 4) {
                                estadoT = EstadoTurno.CANCELADO;
                            }
                            System.out.print("Ingrese DNI del cliente: ");
                            int buscarDni = sc.nextInt();
                            Cliente cliente = buscarCliente(clientes, buscarDni);

                            System.out.print("Ingrese DNI del empleado: ");
                            int buscarIdEmpleado = sc.nextInt();
                            Empleado empleado = buscarEmpleado(empleados, buscarIdEmpleado);

                            System.out.print("Ingrese ID del dispositivo: ");
                            int buscarIdDispositivo = sc.nextInt();
                            Dispositivo dispositivo = buscarDispositivo(dispositivos, buscarIdDispositivo);

                            System.out.print("Ingrese ID del servicio: ");
                            int buscarIdServicio = sc.nextInt();
                            Servicio servicio =buscarServicio(servicios, buscarIdServicio);

                            if (cliente != null &&
                                empleado != null &&
                                dispositivo != null &&
                                servicio != null) {
                                Turno turno = new Turno(idT, fechaIT, horaIT, fechaE, HoraET, estadoT, cliente, empleado, dispositivo , servicio);
                                turnos.add(turno);
                                gestion.agregarTurno(turno);
                                aTurno.guardar(turno);
                            }
                        }   
                        if(opcionT == 2){
                            System.out.println("Ingresar ID del turno: ");
                            int IdBuscar = sc.nextInt();
                            for(Turno t: turnos){
                                if(IdBuscar == t.idT()){
                                    t.resumenTurno();
                                }
                            }
                        }
                    }
                }
                if(opcion==6){
                    int opcionP = 0;
                    while(opcionP != 3){
                        System.out.println("------------------\n1: Crear Pago");
                        System.out.println("2: Ver datos del PAGO");
                        System.out.println("3: Volver"+"\n------------------");

                        System.out.print("Ingrese una opción: ");
                        opcionP = sc.nextInt();
                        if (opcionP == 1){
                            System.out.println("ID: ");
                            int idP = sc.nextInt();
                            System.out.println("Monto Adicional: ");
                            double montoAP = sc.nextDouble();
                            System.out.println("Descuento: ");
                            double descuentoP = sc.nextDouble();
                            sc.nextLine();
                            LocalDate fechaP = LocalDate.now();
                            System.out.println("Medio de Pago: ");
                            String medioP = sc.nextLine();
                            System.out.println("Estado del Pago: ");
                            String estadoP = sc.nextLine();
                            
                            System.out.print("Ingrese ID del Turno: ");
                            int buscarId = sc.nextInt();
                            Turno turno = buscarTurno(turnos, buscarId);
                            if (turno != null){
                                Pago pago = new Pago(idP, montoAP, descuentoP, fechaP, medioP, estadoP, turno);
                                pagos.add(pago);
                                gestion.agregarPago(pago);
                                aPago.guardar(pago);
                            }else{
                                System.out.println("ID de Turno incorrecto");
                            }
                        }
                        if(opcionP == 2){
                            System.out.print("Ingrese ID de PAGO: ");
                            int idPago = sc.nextInt();
                            for(Pago p: pagos){
                                if(idPago == p.idP()){
                                    p.Factura();
                                }
                            }
                        }
                    }
                }
                if(opcion == 7){
                    int opcionG = 0;
                    while(opcionG != 10){
                        System.out.println("------------------\n1: Facturacion Total");
                        System.out.println("2: Pago mas Alto");
                        System.out.println("3: Gastos en Sueldo");
                        System.out.println("4: Clientes Totales");
                        System.out.println("5: Turnos Totales");
                        System.out.println("6: Cliente con Mayor Turnos");
                        System.out.println("7: Estados De Turnos");
                        System.out.println("8: Empleado Con Mas Turnos");
                        System.out.println("9: Empleado Con Menos Turnos");
                        System.out.println("10: SALIR"+"\n------------------");


                        System.out.print("Ingrese una opción: ");
                        opcionG = sc.nextInt();
                        if(opcionG == 1){
                            gestion.facturacionTotal();
                        }
                        if(opcionG == 2){
                            gestion.pagoMasAlto();
                        }
                        if(opcionG == 3){
                            gestion.gastosEnSueldo();
                        }
                        if(opcionG == 4){
                            gestion.clientesTotales();
                        }
                        if(opcionG == 5){
                            gestion.turnosTotales();
                        }
                        if(opcionG == 6){
                            gestion.clienteMayorTurnos();
                        }
                        if(opcionG == 7){
                            gestion.estadosDeTurnos();
                        }
                        if(opcionG == 8){
                            gestion.empleadoMasTurnos();
                        }
                        if(opcionG == 9){
                            gestion.empleadoMenosTurnos();
                        }
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Ingrese un número para elegir una opcion");
                sc.nextLine();
            }catch (RuntimeException e) {
                System.out.println("error");
                System.out.println("Volviendo al menu principal");
            }
        }
    }       
}