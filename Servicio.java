public class Servicio{
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int duracionEstimada;
    private Dispositivo dispositivos;
    
    public Servicio(int id,String nombre,String descripcion,double precio,int duracionEstimada,Dispositivo dispositivo)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracionEstimada = duracionEstimada;
        this.dispositivos = dispositivo;
    }
    public void verServicio(){
        System.out.println("ID: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Precio: "+precio);
        System.out.println("Duracion Estimada: "+duracionEstimada);
        System.out.println("ID Dispositivo: "+dispositivos.idD());
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