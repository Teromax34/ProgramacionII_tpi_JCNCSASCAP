public class Dispositivo{
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String descripcionFalla;
    public Dispositivo(int id,String tipo,String marca,String modelo,String numeroSerie,String descripcionFalla)
    {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.descripcionFalla = descripcionFalla;
    }
    public int idD(){
        return id;
    }
    public String modeloD(){
        return modelo;
    }
    public String fallaD(){
        return descripcionFalla;
    }

    public void NuevaDescripcionFalla(String nuevaFalla){
        this.descripcionFalla = nuevaFalla;
    }
    public void cambiarMarca(String marca){
        this.marca = marca;
    }
    public void cambiarModelo(String modelo){
        this.modelo = modelo;
    }
    public void cambiarNumeroS(String numeroSerie){
        this.numeroSerie = numeroSerie;
    }
    public void cambiarTipo(String tipo){
        this.tipo = tipo;
    }
    public Dispositivo(int id) {
    this.id = id;
        }

    public void verDispositivo(){
        System.out.println("------------------\nID:"+id);
        System.out.println("Tipo:"+tipo);
        System.out.println("Marca:"+marca);
        System.out.println("Modelo:"+modelo);
        System.out.println("Numero de Serie:"+numeroSerie);
        System.out.println("Descripcion de la Falla:"+descripcionFalla+"\n------------------");
    }

    public String convertirALineaArchivo() {
        return id + ";" + tipo + ";" + marca + ";" + modelo + ";" + numeroSerie + ";" + descripcionFalla;
    }
    public static Dispositivo crearDesdeLinea(String linea) {
        String[] datos = linea.split(";");
        int id = Integer.parseInt(datos[0]);
        String tipo = datos[1];
        String marca = datos[2];
        String modelo = datos[3];
        String numeroSerie = datos[4];
        String descripcionF = datos[5];
        
        
    
        return new Dispositivo(id, tipo, marca, modelo,numeroSerie,descripcionF);
    }
    @Override
    public String toString() {
        return id + ";" + tipo + ";" + marca + ";" + modelo + ";" + numeroSerie + ";" + descripcionFalla;
    }
}