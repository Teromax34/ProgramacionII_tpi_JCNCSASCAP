public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(123, "Juan", "Perez", 1111, "Calle 1");

        Dispositivo dispositivo = new Dispositivo(
            1, "Notebook", "Lenovo", "ThinkPad", "ABC123", "No enciende"
        );

        Servicio servicio = new Servicio(
            1, "Reparacion", "Reparacion general", 5000, 3
        );

        Empleado empleado = new Empleado(
            10, "Ana", "Gomez", 2222, "Tecnica"
        );

        Turno turno = new Turno(
            1, "20/09/2026", 10, "25/09/2026", 15,
            "pendiente", cliente, dispositivo, servicio, empleado
        );

        turno.resumenTurno();
    }
}