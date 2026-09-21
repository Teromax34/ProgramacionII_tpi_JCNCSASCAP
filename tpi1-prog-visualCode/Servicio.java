public class Servicio{
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int duracionEstimada;
    public Servicio(int id,String nombre,String descripcion,double precio,int duracionEstimada)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracionEstimada = duracionEstimada;
    }
    
    public int idS(){
        return id;
    }
    public double precioS(){
        return precio;
    }
}
