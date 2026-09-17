public class Cliente{
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    
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
}