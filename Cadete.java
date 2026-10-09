public class Cadete extends Persona{
    private double pesoPaquete;
    private String direccionEntrega;
    
    public Cadete(int dni,String nombre,String apellido,int telefono,double pesoPaquete,String direcciopnEntrega){
        super(dni,nombre,apellido,telefono);
        this.pesoPaquete = pesoPaquete;
        this.direccionEntrega = direcciopnEntrega;
    }

    public String direccion(){
        return direccionEntrega;
    }
    public double pesoPaquete(){
        return pesoPaquete;
    }
}
