import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoServicio {
    private String guardarM = "servicio.csv";

    public void guardar(Servicio servicio) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
        
            writer.write(servicio.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Servicio> cargarServicio() {
        ArrayList<Servicio> servicios = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Servicio s = Servicio.crearDesdeLinea(linea);
                servicios.add(s);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return servicios;
    }
}
