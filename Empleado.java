import java.util.ArrayList;
import java.util.List;
public class Empleado extends Persona{
    private EspecialidadEmpleado especialidad;
    private double sueldo;
    private List<Turno> turnos = new ArrayList<>();

    public Empleado(int dni,String nombreCompleto,String telefono,EspecialidadEmpleado especialidad,double sueldo){
        super(dni, nombreCompleto, telefono);
        this.especialidad = especialidad;
        this.sueldo = sueldo;
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
    
    public EspecialidadEmpleado especialidadE(){
        return especialidad;
    }
    public double sueldoE(){
        return sueldo;
    }
    public Empleado(int dni) {
    super(dni);
    }
    
    public void cambiarSueldo(double nuevoSueldo){
        this.sueldo = nuevoSueldo;
    }


    public void cambiarEspecialidad(EspecialidadEmpleado nuevaEspecialidad){
        this.especialidad = nuevaEspecialidad;
    }
    public void datosEmpleado(){
        System.out.println("------------------\nDni: "+dni());
        System.out.println("Nombre y Apellido:"+nombreCompleto());
        System.out.println("Telefono: "+telefono());
        System.out.println("Especialidad: "+especialidad);
        System.out.println("Cantidad de Turnos: "+cantidadTurnos()+"\n------------------");
    }

    public String convertirALineaArchivo() {
        return dni() + ";" + nombreCompleto() + ";" + telefono() + ";" + especialidad + ";" + sueldo;
    }
    public static Empleado crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int dni = Integer.parseInt(datos[0]);
        String nombreC = datos[1];
        String telefono = datos[2];
        EspecialidadEmpleado especialidad = EspecialidadEmpleado.valueOf(datos[3].toUpperCase());
        double sueldo = Double.parseDouble(datos[4]);
    
        return new Empleado(dni, nombreC, telefono, especialidad,sueldo);
    }
    @Override
    public String toString() {
        return dni() + ";" + nombreCompleto() + ";" + telefono() + ";" + especialidad + ";" + sueldo;
    }
}