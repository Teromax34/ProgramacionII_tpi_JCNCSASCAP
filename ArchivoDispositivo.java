import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoDispositivo {
    private String guardarM = "dispositivo.csv";

    public void guardar(Dispositivo dispositivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
            
            writer.write(dispositivo.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Dispositivo> cargarDispositivo() {
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Dispositivo d = Dispositivo.crearDesdeLinea(linea);
                dispositivos.add(d);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return dispositivos;
    }
}