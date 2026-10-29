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
        System.out.println("\n------------------"+"ID: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Precio: "+precio);
        System.out.println("Duracion Estimada: "+duracionEstimada);
        System.out.println("ID Dispositivo: "+dispositivos.idD()+"\n------------------");
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
    public Servicio(int id) {
    this.id = id;
    }

    public String convertirALineaArchivo() {
        return id + ";" + nombre + ";" + descripcion + ";" + precio + ";" + duracionEstimada + ";" + dispositivos.idD();
    }
    public static Servicio crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int id = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        String descripcion = datos[2];
        double sueldo = Double.parseDouble(datos[3]);
        int duracionEstimada = Integer.parseInt(datos[4]);
        int idDispositivo = Integer.parseInt(datos[5]);
        Dispositivo dispositivo = new Dispositivo(idDispositivo);
    
        return new Servicio(id, nombre, descripcion, sueldo,duracionEstimada,dispositivo);
    }
    @Override
    public String toString() {
        return id + ";" + nombre + ";" + descripcion + ";" + precio + ";" + duracionEstimada + ";" + dispositivos.idD();
    }
}