import java.util.ArrayList;
import java.util.List;
public class Empleado extends Persona{
    private String especialidad;
    private List<Turno> turnos = new ArrayList<>();

    public Empleado(int dni,String nombre,String apellido,int telefono,String especialidad){
        super(dni, nombre, apellido, telefono);
        this.especialidad = especialidad;
    }
    public void agregarTurno(Turno... turnos){
        for(Turno t: turnos){
            this.turnos.add(t);
        }
    }
    public void verTurnos(){
        for(Turno t: turnos){
            System.out.println("ID del turno: "+t.idT() +" - Estado: "+t.estado());
        }
    }
    public int cantidadTurnos(){
        return this.turnos.size();
    }
    
    public String especialidadE(){
        return especialidad;
    }


    public void cambiarEspecialidad(String nuevaEspecialidad){
        this.especialidad = nuevaEspecialidad;
    }
    public void datosEmpleado(){
        System.out.println("------------------\nDni: "+dni());
        System.out.println("Nombre y Apellido:"+nombre()+" "+apellido());
        System.out.println("Telefono: "+telefono());
        System.out.println("Especialidad: "+especialidad);
        System.out.println("Cantidad de Turnos: "+cantidadTurnos());
    }

    
}