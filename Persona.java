public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;

    public Persona(int dni,String nombre,String apellido,int telefono){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public int dni(){
        return dni;
    }
    public String nombre(){
        return nombre;
    }
    public String apellido(){
        return apellido;
    }
    public int telefono(){
        return telefono;
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
    
    public void verDatosCliente(){
        System.out.println("------------------\nDATOS DEL CLIENTE\nDNI:"+dni);
        System.out.println("Nombre y Apellido:"+nombre+" "+apellido);
        System.out.println("Telefono:"+telefono);
        //System.out.println("Direccion:"+direccion);

    }
}
