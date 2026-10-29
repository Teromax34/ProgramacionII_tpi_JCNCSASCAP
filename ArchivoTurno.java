import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTurno {
    private String guardarM = "turno.csv";

    public void guardar(Turno turno) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
        
            writer.write(turno.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Turno> cargarTurno() {
        ArrayList<Turno> turnos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Turno t = Turno.crearDesdeLinea(linea);
                turnos.add(t);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return turnos;
    }
}