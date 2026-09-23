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


    public void cambiarNombre(String nombre){
        this.nombre = nombre;
    }
    public void cambiarDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void cambiarPecio(double precio){
        this.precio = precio;
    }
    public void cambiarDuracion(int duracionEstimada){
        this.duracionEstimada = duracionEstimada;
    }

    
}