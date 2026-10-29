public class Persona {
    private int dni;
    private String nombreCompleto;
    private String telefono;

    public Persona(int dni,String nombreCompleto,String telefono){
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }
    public int dni(){
        return dni;
    }
    public String nombreCompleto(){
        return nombreCompleto;
    }

    public String telefono(){
        return telefono;
    }
    public Persona(int dni) {
    this.dni = dni;
    }


    public void cambiarTelefono(String nuevoTelefono){
        this.telefono = nuevoTelefono;
    }
    public void cambiarNombre(String nuevoNombre){
        this.nombreCompleto = nuevoNombre;
    }

    public void cambiarDni(int nuevoDni){
        this.dni = nuevoDni;
    }
    
    public void verDatosCliente(){
        System.out.println("------------------\nDATOS DEL CLIENTE\nDNI:"+dni);
        System.out.println("Nombre y Apellido:"+nombreCompleto);
        System.out.println("Telefono:"+telefono);
    }
}