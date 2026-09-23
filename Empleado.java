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


    public void cambiarEspecialidad(String nuevaEspecialidad){
        this.especialidad = nuevaEspecialidad;
    }
    public void cambiarTelefono(int nuevoTelefono){
        this.telefono = nuevoTelefono;
    }
    public void cambiarNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }
    public void cambiarApellido(String nuevoApellido){
        this.apellido = nuevoApellido;
    }
    public void cambiarDni(int nuevoDni){
        this.dni = nuevoDni;
    }

    
}