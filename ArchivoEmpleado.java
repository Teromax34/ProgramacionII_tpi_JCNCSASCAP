import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoEmpleado{
    private String guardarM = "empleado.csv";

    public void guardar(Empleado empelado) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
        
            writer.write(empelado.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Empleado> cargarEmpleado() {
        ArrayList<Empleado> empelados = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Empleado e = Empleado.crearDesdeLinea(linea);
                empelados.add(e);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return empelados;
    }
}