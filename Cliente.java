import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String direccion;
    private List<Turno> turnos = new ArrayList<>();
    //private List<Dispositivo> dispositivos = new ArrayList<>();
    public Cliente(int dni,String nombreCompleto,String telefono,String direccion)
    {
        super(dni,nombreCompleto, telefono);
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
    public Cliente(int dni) {
    super(dni);
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
        System.out.println("Nombre y Apellido:"+nombreCompleto());
        System.out.println("Telefono:"+telefono());
        System.out.println("Direccion:"+direccion);
        System.out.println("El cliente tiene: "+cantidadTurnos()+" Turnos"+"\n------------------");

    }
    public String convertirALineaArchivo() {
        return dni() + ";" + nombreCompleto() + ";" + telefono() + ";" + direccion;
    }
    public static Cliente crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int dni = Integer.parseInt(datos[0]);
        String nombreC = datos[1];
        String telefono = datos[2];
        String direccion = datos[3];
        
        return new Cliente(dni, nombreC, telefono, direccion);
    }
    @Override
    public String toString() {
        return dni() + ";" + nombreCompleto() + ";" + telefono() + ";" + direccion;
    }
}