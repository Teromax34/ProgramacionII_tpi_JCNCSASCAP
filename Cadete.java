public class Cadete extends Persona{
    private double pesoPaquete;
    private Cliente clientes;
    
    public Cadete(int dni,String nombre,String apellido,int telefono,double pesoPaquete,Cliente cliente){
        super(dni,nombre,apellido,telefono);
        this.pesoPaquete = pesoPaquete;
        this.clientes = cliente;
        
    }

    public double pesoPaquete(){
        return pesoPaquete;
    }
    public void datoDeEnvio(){
        System.out.println("CLIENTE\nNombre:"+clientes.nombre()+" "+clientes.apellido()+"\n Telefono:"+clientes.telefono());
        System.err.println("Entregar el paquete en:"+clientes.direccion());
    }
}