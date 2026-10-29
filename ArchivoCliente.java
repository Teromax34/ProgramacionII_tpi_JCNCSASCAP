import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoCliente {
    private String guardarM = "cliente.csv";

    public void guardar(Cliente cliente) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(guardarM, true));
        
            writer.write(cliente.convertirALineaArchivo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar");
            }
    }

    public ArrayList<Cliente> cargarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(guardarM));
            String linea;
            String cabecera = reader.readLine();
            while ((linea = reader.readLine()) != null) {
                Cliente c = Cliente.crearDesdeLinea(linea);
                clientes.add(c);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer");
        }
        return clientes;
    }
}
