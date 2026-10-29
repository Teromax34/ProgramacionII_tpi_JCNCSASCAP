import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoPago{
    private String guardarM = "pago.csv";

    public void guardar(Pago pago) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
        
            writer.write(pago.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Pago> cargarPago() {
        ArrayList<Pago> pagos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Pago p = Pago.crearDesdeLinea(linea);
                pagos.add(p);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return pagos;
    }
}