import java.util.ArrayList;
import java.util.List;

public class GestionEmpresa {
    private List<Cliente> clientes= new ArrayList<>();
    private List<Empleado> empleados= new ArrayList<>();
    private List<Pago> pagos= new ArrayList<>();
    private List<Turno> turnos= new ArrayList<>();

    public void agregarCliente(Cliente... clientes){
    for(Cliente c : clientes){
        this.clientes.add(c);
        }
    }
    public void agregarEmpleado(Empleado... empleados){
       for(Empleado e: empleados){
        this.empleados.add(e);
       }
    }
    public void agregarTurno(Turno... turnos){
        for(Turno t: turnos){
            this.turnos.add(t);
        }
    }
    public void agregarPago(Pago... pagos){
        for(Pago p: pagos){
            this.pagos.add(p);
        }
    }

    public void facturacionTotal(){
        double montoFinal = 0;
        for(Pago p: pagos){
            montoFinal += p.montoFinalDescuento();
        }
        System.out.println("El monto total que facturo la empresa es de: "+montoFinal);
    }
    public void pagoMasAlto(){
        double servicioCaro = 0;
        for(Pago p: pagos){
            for(Turno t: turnos){
                if(p.montoFinalDescuento() > servicioCaro){
                servicioCaro = p.montoFinalDescuento();
                t.resumenTurno();
                p.Factura();
                }
            }
        }
    }
    
    public void clientesTotales(){
        int contC = 0;
        for(Cliente c:clientes){
            contC++;
        }
        System.out.println("Clientes Totales: "+contC);
    }
    public void turnosTotales(){
        int contT = 0;
        for(Turno t: turnos){
            contT++;
        }
        System.out.println("Turnos Totales: "+contT);
    }
    
    public void clienteMayorTurnos(){
        int contTotalT = 0;
        for(Cliente c: clientes){
            if(c.cantidadTurnos() > contTotalT){
                contTotalT = c.cantidadTurnos();
                c.verDatosCliente();
                c.verTurnosCliente();
            }
        }
    }
    public void buscarCliente(int buscarDni){
        boolean encontrar = false;
        for(Cliente c: clientes){
            if(c.dni() == buscarDni){
                c.verDatosCliente();
                encontrar = true;
            } 
        }
        if(!encontrar){
            System.out.println("Error,El DNI no fue ingresado correctamente");
        } 
    }

    public void buscarTurno(int numero){
        boolean encontrar = false;
        for(Turno t: turnos){
            if(t.idT() == numero){
                t.resumenTurno();
                encontrar = true;
            }
        }
        if(!encontrar){
            System.out.println("Error,El ID no fue ingresado correctamente");
        } 
    }
    public void buscarEmpleado(int dni){
        boolean encontrar = false;
        for(Empleado e: empleados){
            if(e.dni() == dni){
                e.datosEmpleado();
                encontrar = true;
            }
        }
        if(!encontrar){
            System.out.println("Error,El DNI no fue ingresado correctamente");
        } 
    }

    public void estadosDeTurnos(){
        int contP = 0;
        int contR = 0;
        int contCom = 0;
        int contCan = 0;
        for(Turno t: turnos){
            if(t.estado() == t.estado().PENDIENTE){
                contP++;
            }else if(t.estado() == t.estado().REALIZADO){
                contR++;
            }else if(t.estado() == t.estado().CONFIRMADO){
                contCom++;
            }else if(t.estado() == t.estado().CANCELADO){
                contCan++;
            }
        }
        System.out.println("------------------\nPendiente: "+contP);
        System.out.println("Realizado: "+contR);
        System.out.println("Confirmado: "+contCom);
        System.out.println("Cancelado: "+contCan);
    }
    public void empleadoMasTurnos(){
        int contE = 0;
        for(Empleado e: empleados){
            if(e.cantidadTurnos() > contE){
                contE = e.cantidadTurnos();
                e.datosEmpleado();
                e.verTurnos();
            }
        }
    }
    public void empleadoMenosTurnos(){
        int contE = 0;
        for(Empleado e: empleados){
            if(e.cantidadTurnos() < contE){
                contE= e.cantidadTurnos();
                e.datosEmpleado();
                e.verTurnos();
            }
        }
    }
}

