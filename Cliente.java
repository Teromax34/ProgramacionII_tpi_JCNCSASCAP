import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String direccion;
    private List<Turno> turnos = new ArrayList<>();
    //private List<Dispositivo> dispositivos = new ArrayList<>();
    public Cliente(int dni,String nombre,String apellido,int telefono,String direccion)
    {
        super(dni, nombre, apellido, telefono);
        this.direccion = direccion;
    }
    /*public List<Turno> getTurno(){
        return turnos;
    }Getter para List*/
    

    /*public void agregarTurno(Turno turno){
        this.turnos.add(turno);
    }*/
    public String direccion(){
        return direccion;
    }
    public void cambiarDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }
    public void agregarTurno(Turno... turnos){
        for(Turno t: turnos){
            this.turnos.add(t);
        }
    }
    /*public void agregarDispositivo(Dispositivo... dispositivos){
        for(Dispositivo d: dispositivos){
            this.dispositivos.add(d);
        }
    }
    public int cantidadDispositivos(){
        return dispositivos.size();
    }*/
    public int cantidadTurnos(){
        return this.turnos.size();
    }

    public void verTurnosCliente(){
          for(Turno t: this.turnos){
                   System.out.println("ID del turno: "+t.idT() +" - Estado: "+t.estado());
              }
    }
    /* 
    public void buscarCliente(int buscarDni){
        if(dni == buscarDni){
            verDatosCliente();
        }
    }*/

    public void verDatosCliente(){
        System.out.println("------------------\nDATOS DEL CLIENTE\nDNI:"+dni());
        System.out.println("Nombre y Apellido:"+nombre()+" "+apellido());
        System.out.println("Telefono:"+telefono());
        System.out.println("Direccion:"+direccion);
        System.out.println("El cliente tiene: "+cantidadTurnos()+" Turnos");

    }
}