public class Empleado{
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String especialidad;
    public Empleado(int dni,String nombre,String apellido,int telefono,String especialidad)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }
    public int dniE(){
        return dni;
    }
    public String nombreE(){
        return nombre;
    }
    public String apellidoE(){
        return apellido;
    }
    public int telefonoE(){
        return telefono;
    }
    public String especialidadE(){
        return especialidad;
    }
}