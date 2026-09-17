public class Dispositivo{
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String descripcionFalla;
    public Dispositivo(int dni,String tipo,String marca,String modelo,String numeroSerie,String descripcionFalla)
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
}