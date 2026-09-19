import java.util.List;
import java.util.ArrayList;

public class Cliente{
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private List<Turno> turnos = new ArrayList<>();
    public Cliente(int dni,String nombre,String apellido,int telefono,String direccion)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public int dniC(){
        return dni;
    }
    public String nombreC(){
        return nombre;
    }
    public String apellidoC(){
        return apellido;
    }
    public int telefonoC(){
        return telefono;
    }
    public String direccionC(){
        return direccion;
    }
    public void agregarTurno(Turno turno){
        this.turnos.add(turno);
    }
    public int cantidadTurnos(){
        return this.turnos.size();
    }
    public void verIDturnos(){
          for(Turno c : this.turnos){
                   System.out.println("ID del turno:"+c.idT());
              }
          }
    
    public void verDatosCliente(){
        System.out.println("DNI:"+dni);
        System.out.println("Nombre y Apellido:"+nombre+" "+apellido);
        System.out.println("Telefono:"+telefono);
        System.out.println("Direccion:"+direccion);
    }
}